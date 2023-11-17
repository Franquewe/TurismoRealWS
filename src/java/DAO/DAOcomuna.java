package DAO;

import Clases.Comuna;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOcomuna {

    private Connection con;

    public DAOcomuna() {
    }

    public List<Comuna> obtenerComunas() throws SQLException {
        List<Comuna> lista = new ArrayList<>();
        byte[] response = null;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_comuna.sp_listar_comunas(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                Comuna com = new Comuna();
                com.setId_comuna(rs.getInt("id_comuna"));
                String input = rs.getString("nombre_comuna");
                String inputLimpio = input.replace("á", "a")
                        .replace("é", "e")
                        .replace("í", "i")
                        .replace("ó", "o")
                        .replace("ú", "u")
                        .replace("ñ", "n")
                        .replace("Ñ", "N");
                com.setNombre_comuna(inputLimpio.replaceAll("[^\\x00-\\x7F]", ""));
                com.setId_region(rs.getInt("region_id_region"));
                lista.add(com);
            }
        } catch (Exception e) {
            System.out.println("Error al listar las comunas: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }
}
