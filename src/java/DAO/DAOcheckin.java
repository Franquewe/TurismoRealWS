package DAO;

import Clases.CheckIn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOcheckin {

    private Connection con;

    public DAOcheckin() {
    }

    public boolean agregarCheckIn(CheckIn cin) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_check_in.sp_agregar_check_in(?, ?, ?, ?)}");
            cstmt.setString(1, cin.getFirma_cliente());
            cstmt.setInt(2, cin.getPago_cliente());
            cstmt.setInt(3, cin.getId_reserva());
            cstmt.setInt(4, cin.getFuncionario_rut());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar Check In: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<CheckIn> obtenerCheckIn() throws SQLException {
        List<CheckIn> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_check_in.sp_listar_check_in(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            if (rs.next()) {
                CheckIn cin = new CheckIn();
                cin.setId_check_in(rs.getInt("id_check_in"));
                cin.setHora(rs.getString("hora"));
                cin.setFecha(rs.getDate("fecha"));
                cin.setFirma_cliente(rs.getString("firma_cliente"));
                cin.setPago_cliente(rs.getInt("pago_cliente"));
                cin.setId_reserva(rs.getInt("reserva_id_reserva"));
                cin.setFuncionario_rut(rs.getInt("funcionario_rut"));
                lista.add(cin);
            }
        } catch (Exception e) {
            System.out.println("Error al listar Check In: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public boolean modificarCheckIn(int id_cin, CheckIn cin) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_check_in.sp_actualizar_check_in(?, ?, ?)}");
            cstmt.setInt(1, id_cin);
            cstmt.setInt(2, cin.getPago_cliente());
            cstmt.setString(3, cin.getFirma_cliente());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar Check In: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean eliminarCheckIn(int id_cin) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_check_in.sp_eliminar_check_in(?)}");
            cstmt.setInt(1, id_cin);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar Check In: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
