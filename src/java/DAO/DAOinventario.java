package DAO;

import Clases.Inventario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOinventario {

    private Connection con;

    public DAOinventario() {
    }

    public boolean agregarInventario(Inventario inv) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_inventario.sp_agregar_inventario(?, ?, ?)}");
            cstmt.setInt(1, inv.getId_articulo());
            cstmt.setInt(2, inv.getId_departamento());
            cstmt.setInt(3, inv.getCantidad());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar el inventario: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<Inventario> obtenerInventario() throws SQLException {
        List<Inventario> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_inventario.sp_listar_inventario(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setId_articulo(rs.getInt("id_articulo"));
                inv.setId_departamento(rs.getInt("id_departamento"));
                inv.setCantidad(rs.getInt("cantidad"));
                inv.setNom_articulo(rs.getString("nombre articulo"));
                lista.add(inv);
            }
        } catch (Exception e) {
            System.out.println("Error al listar el inventario: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public List<Inventario> obtenerInventarioIdDepa(int id_depa) throws SQLException {
        List<Inventario> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_inventario.sp_listar_inventario_por_id(?, ?)}");
            cstmt.setInt(1, id_depa);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setId_articulo(rs.getInt("id_articulo"));
                inv.setId_departamento(rs.getInt("id_departamento"));
                inv.setCantidad(rs.getInt("cantidad"));
                inv.setNom_articulo(rs.getString("nombre articulo"));
                inv.setPrecio(rs.getInt("precio_articulo"));
                lista.add(inv);
            }
        } catch (Exception e) {
            System.out.println("Error al listar el inventario: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public boolean modificarInventario(int id_depa, Inventario inv) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_inventario.sp_actualizar_inventario(?, ?, ?)}");
            cstmt.setInt(1, id_depa);
            cstmt.setInt(2, inv.getId_articulo());
            cstmt.setInt(3, inv.getCantidad());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el inventario: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean eliminarInventario(int id_depa, int id_art) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_inventario.sp_eliminar_inventario(?, ?)}");
            cstmt.setInt(1, id_depa);
            cstmt.setInt(2, id_art);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el elemento del inventario: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
