package DAO;

import Clases.Administrador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.internal.OracleTypes;

public class DAOadministrador {

    private Connection con;

    public DAOadministrador() {
    }

    public boolean agregarAdministrador(Administrador adm) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_administrador.sp_agregar_administrador(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setInt(1, adm.getRut());
            cstmt.setString(2, adm.getDv());
            cstmt.setString(3, adm.getNombre());
            cstmt.setString(4, adm.getApellido_paterno());
            cstmt.setString(5, adm.getApellido_materno());
            cstmt.setString(6, adm.getCorreo());
            cstmt.setString(7, adm.getUsuario());
            cstmt.setString(8, adm.getContrasena());
            cstmt.setString(9, adm.getTelefono());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar administrador: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<Administrador> obtenerAdministrador() throws SQLException {
        List<Administrador> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_administrador.sp_listar_administrador(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                Administrador adm = new Administrador();
                adm.setRut(rs.getInt("rut"));
                adm.setDv(rs.getString("dv"));
                adm.setNombre(rs.getString("nombre"));
                adm.setApellido_paterno(rs.getString("apellido_paterno"));
                adm.setApellido_materno(rs.getString("apellido_materno"));
                adm.setCorreo(rs.getString("correo"));
                adm.setUsuario(rs.getString("usuario"));
                adm.setContrasena(rs.getString("contrasena"));
                adm.setTelefono(rs.getString("telefono"));
                lista.add(adm);
            }
        } catch (Exception e) {
            System.out.println("Error al listar administradores: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public Administrador obtenerAdministradorPorRut(int rut) throws SQLException {
        Administrador adm = new Administrador();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_administrador.sp_listar_administrador_por_rut(?, ?)}");
            cstmt.setInt(1, rut);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                adm.setRut(rs.getInt("rut"));
                adm.setDv(rs.getString("dv"));
                adm.setNombre(rs.getString("nombre"));
                adm.setApellido_paterno(rs.getString("apellido_paterno"));
                adm.setApellido_materno(rs.getString("apellido_materno"));
                adm.setCorreo(rs.getString("correo"));
                adm.setUsuario(rs.getString("usuario"));
                adm.setContrasena(rs.getString("contrasena"));
                adm.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar administradores: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return adm;
    }

    public boolean modificarAdministrador(int rutadm, Administrador adm) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_administrador.sp_actualizar_administrador(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setInt(1, rutadm);
            cstmt.setInt(2, adm.getRut());
            cstmt.setString(3, adm.getDv());
            cstmt.setString(4, adm.getNombre());
            cstmt.setString(5, adm.getApellido_paterno());
            cstmt.setString(6, adm.getApellido_materno());
            cstmt.setString(7, adm.getCorreo());
            cstmt.setString(8, adm.getUsuario());
            cstmt.setString(9, adm.getContrasena());
            cstmt.setString(10, adm.getTelefono());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar administrador: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean eliminarAdministrador(int rut) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_administrador.sp_eliminar_administrador(?)}");
            cstmt.setInt(1, rut);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar administrador: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
