package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static Connection conexion;
    private String user = "c##portafolio";
    private String pass = "portafolio";
    private String url = "jdbc:oracle:thin:" + user + "/" + pass + "@localhost:1521:xe";

    public Conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            this.conexion = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error de conexion:" + e.getMessage());
        }
    }

    public Connection obtenerConexion() {
        return conexion;
    }
}
