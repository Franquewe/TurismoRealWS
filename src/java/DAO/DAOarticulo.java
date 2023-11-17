package DAO;

import Clases.Articulo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOarticulo {

    private Connection con;

    public DAOarticulo() {
    }

    public boolean agregarArticulo(Articulo art) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_articulo.sp_agregar_articulo(?, ?, ?)}");
            cstmt.setString(1, art.getDescripcion());
            cstmt.setInt(2, art.getStock());
            cstmt.setInt(3, art.getPrecio());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar articulo: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<Articulo> obtenerArticulo() throws SQLException {
        List<Articulo> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_articulo.sp_listar_articulo(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                Articulo art = new Articulo();
                art.setId_articulo(rs.getInt("id_articulo"));
                art.setDescripcion(rs.getString("descripcion"));
                art.setStock(rs.getInt("stock"));
                art.setPrecio(rs.getInt("precio_articulo"));
                lista.add(art);
            }
        } catch (Exception e) {
            System.out.println("Error al listar articulo: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public Articulo obtenerArticuloPorId(int id_art) throws SQLException {
        Articulo art = new Articulo();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_articulo.sp_listar_articulo_por_id(?, ?)}");
            cstmt.setInt(1, id_art);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                art.setId_articulo(rs.getInt("id_articulo"));
                art.setDescripcion(rs.getString("descripcion"));
                art.setStock(rs.getInt("stock"));
                art.setPrecio(rs.getInt("precio_articulo"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar articulo: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return art;
    }

    public boolean modificarArticulo(int id_art, Articulo art) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_articulo.sp_actualizar_articulo(?, ?, ?, ?)}");
            cstmt.setInt(1, id_art);
            cstmt.setString(2, art.getDescripcion());
            cstmt.setInt(3, art.getStock());
            cstmt.setInt(4, art.getPrecio());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar articulo: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean eliminarArticulo(int id_art) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_articulo.sp_eliminar_articulo(?)}");
            cstmt.setInt(1, id_art);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar articulo: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
