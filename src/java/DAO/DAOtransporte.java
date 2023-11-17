package DAO;

import Clases.Transporte;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOtransporte {

    private Connection con;

    public DAOtransporte() {
    }

    public List<Transporte> obtenerTransporte() throws SQLException {
        List<Transporte> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_tour_transporte.listar_transportes(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                Transporte tran = new Transporte();
                tran.setId_transporte(rs.getInt("id_servicio"));
                tran.setNom_empresa(rs.getString("nom_empresa"));
                tran.setHorario(rs.getString("horario"));
                tran.setPatente(rs.getString("patente"));
                tran.setTarifa_adicional(rs.getInt("tarifa_adicional"));
                tran.setRut_chofer(rs.getInt("chofer_rut"));
                lista.add(tran);
            }
        } catch (Exception e) {
            System.out.println("Error al listar los transportes: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }
}
