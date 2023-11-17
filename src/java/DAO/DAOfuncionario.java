package DAO;

import Clases.Funcionario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOfuncionario {

    private Connection con;

    public boolean agregarFuncionario(Funcionario fun) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_funcionario.sp_agregar_funcionario(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setInt(1, fun.getRut());
            cstmt.setString(2, fun.getDv());
            cstmt.setString(3, fun.getNombre());
            cstmt.setString(4, fun.getApellido_paterno());
            cstmt.setString(5, fun.getApellido_materno());
            cstmt.setString(6, fun.getCorreo());
            cstmt.setString(7, fun.getUsuario());
            cstmt.setString(8, fun.getContrasena());
            cstmt.setString(9, fun.getTelefono());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar funcionario: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<Funcionario> obtenerFuncionario() throws SQLException {
        List<Funcionario> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_funcionario.sp_listar_funcionario(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                Funcionario fun = new Funcionario();
                fun.setRut(rs.getInt("rut"));
                fun.setDv(rs.getString("dv"));
                fun.setNombre(rs.getString("nombre"));
                fun.setApellido_paterno(rs.getString("apellido_paterno"));
                fun.setApellido_materno(rs.getString("apellido_materno"));
                fun.setCorreo(rs.getString("correo"));
                fun.setUsuario(rs.getString("usuario"));
                fun.setContrasena(rs.getString("contrasena"));
                fun.setTelefono(rs.getString("telefono"));
                lista.add(fun);
            }
        } catch (Exception e) {
            System.out.println("Error al listar funcionarios: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public Funcionario obtenerFuncionarioPorRut(int rut) throws SQLException {
        Funcionario fun = new Funcionario();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_funcionario.sp_listar_funcionario_por_rut(?, ?)}");
            cstmt.setInt(1, rut);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                fun.setRut(rs.getInt("rut"));
                fun.setDv(rs.getString("dv"));
                fun.setNombre(rs.getString("nombre"));
                fun.setApellido_paterno(rs.getString("apellido_paterno"));
                fun.setApellido_materno(rs.getString("apellido_materno"));
                fun.setCorreo(rs.getString("correo"));
                fun.setUsuario(rs.getString("usuario"));
                fun.setContrasena(rs.getString("contrasena"));
                fun.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar funcionarios: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return fun;
    }

    public boolean modificarFuncionario(int rutfun, Funcionario fun) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_funcionario.sp_actualizar_funcionario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setInt(1, rutfun);
            cstmt.setInt(2, fun.getRut());
            cstmt.setString(3, fun.getDv());
            cstmt.setString(4, fun.getNombre());
            cstmt.setString(5, fun.getApellido_paterno());
            cstmt.setString(6, fun.getApellido_materno());
            cstmt.setString(7, fun.getCorreo());
            cstmt.setString(8, fun.getUsuario());
            cstmt.setString(9, fun.getContrasena());
            cstmt.setString(10, fun.getTelefono());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar funcionario: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean eliminarFuncionario(int rut) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_funcionario.sp_eliminar_funcionario(?)}");
            cstmt.setInt(1, rut);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar funcionario: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
