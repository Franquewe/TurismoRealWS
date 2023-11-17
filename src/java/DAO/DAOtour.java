package DAO;

import Clases.Tour;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOtour {

    private Connection con;

    public DAOtour() {
    }

    public List<Tour> obtenerTour() throws SQLException {
        List<Tour> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_tour_transporte.listar_tours(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                Tour tour = new Tour();
                tour.setId_tour(rs.getInt("id_servicio"));
                tour.setNombre_servicio(rs.getString("nombre_servicio"));
                tour.setDescripcion(rs.getString("descripcion"));
                tour.setDestino(rs.getString("destino"));
                tour.setTarifa_adicional(rs.getInt("tarifa_adicional"));
                lista.add(tour);
            }
        } catch (Exception e) {
            System.out.println("Error al listar los tour: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }
}
