package DAO;

import Clases.Reserva;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOreserva {

    private Connection con;

    public boolean agregarReserva(Reserva res) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva.sp_agregar_reserva(?, ?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setDate(1, (java.sql.Date) res.getInicio_reserva());
            cstmt.setDate(2, (java.sql.Date) res.getTermino_reserva());
            cstmt.setInt(3, res.getCant_personas());
            cstmt.setInt(4, res.getMonto_total());
            cstmt.setInt(5, res.getMonto_abonado());
            cstmt.setInt(6, res.getId_departamento());
            cstmt.setInt(7, res.getCliente_rut());
            cstmt.setInt(8, res.getId_estado());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar la reserva: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<Reserva> obtenerReserva() throws SQLException {
        List<Reserva> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva.sp_listar_reserva(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                Reserva res = new Reserva();
                res.setId_reserva(rs.getInt("id_reserva"));
                res.setInicio_reserva(rs.getDate("inicio_reserva"));
                res.setTermino_reserva(rs.getDate("termino_reserva"));
                res.setCant_personas(rs.getInt("cant_personas"));
                res.setMonto_total(rs.getInt("monto_total"));
                res.setMonto_abonado(rs.getInt("monto_abonado"));
                res.setId_departamento(rs.getInt("departamento_id_departamento"));
                res.setCliente_rut(rs.getInt("cliente_rut"));
                res.setNom_estado(rs.getString("descripcion_estado"));
                lista.add(res);
            }
        } catch (Exception e) {
            System.out.println("Error al listar las reservas: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }
    
    public Reserva obtenerReservaPorId(int id_res) throws SQLException {
        Reserva res = new Reserva();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva.sp_listar_reserva_por_id(?, ?)}");
            cstmt.setInt(1, id_res);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                res.setId_reserva(rs.getInt("id_reserva"));
                res.setInicio_reserva(rs.getDate("inicio_reserva"));
                res.setTermino_reserva(rs.getDate("termino_reserva"));
                res.setCant_personas(rs.getInt("cant_personas"));
                res.setMonto_total(rs.getInt("monto_total"));
                res.setMonto_abonado(rs.getInt("monto_abonado"));
                res.setId_departamento(rs.getInt("departamento_id_departamento"));
                res.setCliente_rut(rs.getInt("cliente_rut"));
                res.setNom_estado(rs.getString("descripcion_estado"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar la reserva: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return res;
    }
    
    public List<Reserva> obtenerReservaPorRut(int rut) throws SQLException {
        List<Reserva> list = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva.sp_listar_reserva_por_rut(?, ?)}");
            cstmt.setInt(1, rut);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                Reserva res = new Reserva();
                res.setId_reserva(rs.getInt("id_reserva"));
                res.setInicio_reserva(rs.getDate("inicio_reserva"));
                res.setTermino_reserva(rs.getDate("termino_reserva"));
                res.setCant_personas(rs.getInt("cant_personas"));
                res.setMonto_total(rs.getInt("monto_total"));
                res.setMonto_abonado(rs.getInt("monto_abonado"));
                res.setId_departamento(rs.getInt("departamento_id_departamento"));
                res.setCliente_rut(rs.getInt("cliente_rut"));
                res.setNom_estado(rs.getString("descripcion_estado"));
                list.add(res);
            }
        } catch (Exception e) {
            System.out.println("Error al listar la reserva: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return list;
    }

    public boolean modificarReserva(int id_res, Reserva res) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva.sp_actualizar_reserva(?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setInt(1, id_res);
            cstmt.setDate(2, (java.sql.Date) res.getInicio_reserva());
            cstmt.setDate(3, (java.sql.Date) res.getTermino_reserva());
            cstmt.setInt(4, res.getCant_personas());
            cstmt.setInt(5, res.getMonto_total());
            cstmt.setInt(6, res.getMonto_abonado());
            cstmt.setInt(7, res.getId_departamento());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar la reserva: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean eliminarReserva(int id_res) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_reserva.sp_eliminar_reserva(?)}");
            cstmt.setInt(1, id_res);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar la reserva: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
