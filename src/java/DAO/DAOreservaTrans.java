package DAO;

import Clases.ReservaTrans;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOreservaTrans {

    private Connection con;

    public DAOreservaTrans() {
    }

    public boolean agregarReservaTransporte(ReservaTrans resTrans) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva_transporte.agregar_reserva_transporte(?, ?, ?, ?)}");
            cstmt.setInt(1, resTrans.getId_transporte());
            cstmt.setInt(2, resTrans.getId_reserva());
            cstmt.setInt(3, resTrans.getCantidad());
            cstmt.setInt(4, resTrans.getPago_cliente());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar la reserva de transporte: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<ReservaTrans> obtenerReservaTransporte() throws SQLException {
        List<ReservaTrans> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva_transporte.listar_reserva_transporte(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                ReservaTrans resTrans = new ReservaTrans();
                resTrans.setId_transporte(rs.getInt("transporte_id_servicio"));
                resTrans.setId_reserva(rs.getInt("reserva_id_reserva"));
                resTrans.setCantidad(rs.getInt("cantidad"));
                resTrans.setPago_cliente(rs.getInt("pago_cliente"));
                lista.add(resTrans);
            }
        } catch (Exception e) {
            System.out.println("Error al listar las reservas de transporte: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public ReservaTrans obtenerReservaTransportePorParam(int id_reserva) throws SQLException {
        ReservaTrans resTrans = new ReservaTrans();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva_transporte.listar_reserva_transporte_por_parametro(?, ?)}");
            cstmt.setInt(1, id_reserva);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                resTrans.setId_transporte(rs.getInt("transporte_id_servicio"));
                resTrans.setId_reserva(rs.getInt("reserva_id_reserva"));
                resTrans.setCantidad(rs.getInt("cantidad"));
                resTrans.setPago_cliente(rs.getInt("pago_cliente"));
                resTrans.setPatente(rs.getString("patente"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar las reservas de transporte: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return resTrans;
    }

    public boolean modificarReservaTransporte(int id_reserva, ReservaTrans resTrans) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva_transporte.modificar_reserva_transporte(?, ?, ?, ?)}");
            cstmt.setInt(1, id_reserva);
            cstmt.setInt(2, resTrans.getId_transporte());
            cstmt.setInt(3, resTrans.getCantidad());
            cstmt.setInt(4, resTrans.getPago_cliente());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar la reserva de transporte: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean eliminarReservaTransporte(int id_reserva) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva_transporte.eliminar_reserva_transporte(?)}");
            cstmt.setInt(1, id_reserva);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar la reserva de transporte: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
