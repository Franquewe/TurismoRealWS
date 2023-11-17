package DAO;

import Clases.CheckOut;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOcheckout {

    private Connection con;

    public DAOcheckout() {
    }

    public boolean agregarCheckOut(CheckOut cout) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_check_out.sp_agregar_check_out(?, ?, ?, ?, ?)}");
            cstmt.setInt(1, cout.getMultas());
            cstmt.setInt(2, cout.getPago_cliente());
            cstmt.setString(3, cout.getFirma_cliente());
            cstmt.setInt(4, cout.getId_reserva());
            cstmt.setInt(5, cout.getFuncionario_rut());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar Check Out: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<CheckOut> obtenerCheckOut() throws SQLException {
        List<CheckOut> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_check_out.sp_listar_check_out(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            if (rs.next()) {
                CheckOut cout = new CheckOut();
                cout.setId_check_out(rs.getInt("id_check_out"));
                cout.setHora(rs.getString("hora"));
                cout.setFecha(rs.getDate("fecha"));
                cout.setMultas(rs.getInt("multas_costoreparacion"));
                cout.setPago_cliente(rs.getInt("pago_cliente"));
                cout.setFirma_cliente(rs.getString("firma_cliente"));
                cout.setId_reserva(rs.getInt("reserva_id_reserva"));
                cout.setFuncionario_rut(rs.getInt("funcionario_rut"));
                lista.add(cout);
            }
        } catch (Exception e) {
            System.out.println("Error al listar Check Out: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public boolean modificarCheckOut(int id_cout, CheckOut cout) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_check_out.sp_actualizar_check_out(?, ?, ?, ?)}");
            cstmt.setInt(1, id_cout);
            cstmt.setInt(2, cout.getMultas());
            cstmt.setInt(3, cout.getPago_cliente());
            cstmt.setString(4, cout.getFirma_cliente());
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

    public boolean eliminarCheckOut(int id_cout) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_check_out.sp_eliminar_check_out(?)}");
            cstmt.setInt(1, id_cout);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar Check Out: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
