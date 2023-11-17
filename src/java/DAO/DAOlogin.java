package DAO;

import Clases.LoginC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

public class DAOlogin {

    private Connection con;

    public String login(String user, String pass) throws SQLException {
        String tuser = null;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{ ? = call pkg_login.sp_login }");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                LoginC log = new LoginC();
                log.setRut(rs.getInt("rut"));
                log.setUsuario(rs.getString("usuario"));
                log.setContrasena(rs.getString("contrasena"));
                log.setTipo_usuario(rs.getString("tipo_usuario"));
                if (user.equals(log.getUsuario()) && pass.equals(log.getContrasena())) {
                    tuser = log.getTipo_usuario();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al realizar el login: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return tuser;
    }
    
    public LoginC loginCompleto(String user, String pass) throws SQLException {
        LoginC log = new LoginC();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{ ? = call pkg_login.sp_login }");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                if (user.equals(rs.getString("usuario")) && pass.equals(rs.getString("contrasena"))) {
                    log.setRut(rs.getInt("rut"));
                    log.setUsuario(rs.getString("usuario"));
                    log.setContrasena(rs.getString("contrasena"));
                    log.setTipo_usuario(rs.getString("tipo_usuario"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al realizar el login: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return log;
    }

}
