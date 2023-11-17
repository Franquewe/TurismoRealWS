package DAO;

import Clases.ReservaTour;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOreservaTour {

    private Connection con;

    public DAOreservaTour() {
    }

    public boolean agregarReservaTour(ReservaTour resTour) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva_tour.agregar_reserva_tour(?, ?, ?, ?)}");
            cstmt.setInt(1, resTour.getId_tour());
            cstmt.setInt(2, resTour.getId_reserva());
            cstmt.setInt(3, resTour.getCantidad());
            cstmt.setInt(4, resTour.getPago_cliente());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar la reserva de tour: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<ReservaTour> obtenerReservaTour() throws SQLException {
        List<ReservaTour> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva_tour.listar_reserva_tour(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                ReservaTour resTour = new ReservaTour();
                resTour.setId_tour(rs.getInt("tour_id_servicio"));
                resTour.setId_reserva(rs.getInt("reserva_id_reserva"));
                resTour.setCantidad(rs.getInt("cantidad"));
                resTour.setPago_cliente(rs.getInt("pago_cliente"));
                lista.add(resTour);
            }
        } catch (Exception e) {
            System.out.println("Error al listar las reservas de tour: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public List<ReservaTour> obtenerReservaTourPorParam(int id_reserva) throws SQLException {
        List<ReservaTour> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva_tour.listar_reserva_tour_por_parametro(?, ?)}");
            cstmt.setInt(1, id_reserva);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                ReservaTour resTour = new ReservaTour();
                resTour.setId_tour(rs.getInt("tour_id_servicio"));
                resTour.setId_reserva(rs.getInt("reserva_id_reserva"));
                resTour.setCantidad(rs.getInt("cantidad"));
                resTour.setPago_cliente(rs.getInt("pago_cliente"));
                resTour.setNom_servicio(rs.getString("nombre_servicio"));
                lista.add(resTour);
            }
        } catch (Exception e) {
            System.out.println("Error al listar las reservas de tour: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public boolean modificarReservaTour(int id_reserva, ReservaTour resTour) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva_tour.modificar_reserva_tour(?, ?, ?, ?)}");
            cstmt.setInt(1, id_reserva);
            cstmt.setInt(2, resTour.getId_tour());
            cstmt.setInt(3, resTour.getCantidad());
            cstmt.setInt(4, resTour.getPago_cliente());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar la reserva de tour: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean eliminarReservaTour(int id_reserva) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva_tour.eliminar_reserva_tour(?)}");
            cstmt.setInt(1, id_reserva);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar la reserva de tour: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
