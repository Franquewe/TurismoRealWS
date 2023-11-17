package DAO;

import Clases.FormaPago;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOformaPago {

    private Connection con;

    public DAOformaPago() {
    }

    public List<FormaPago> obtenerFormaPago() throws SQLException {
        List<FormaPago> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("CALL pkg_forma_pago.sp_listar_forma_pago(?)");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {                
                FormaPago pago = new FormaPago();
                pago.setId_forma_pago(rs.getInt("id_forma_pago"));
                pago.setNombre(rs.getString("nombre"));
                lista.add(pago);
            }
        } catch (Exception e) {
            System.out.println("Error al listar la forma de pago: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }
    
    public FormaPago obtenerFormaPagoPorId(int id_pago) throws SQLException {
        FormaPago pago = new FormaPago();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("CALL pkg_forma_pago.sp_listar_forma_pago_por_id(?, ?)");
            cstmt.setInt(1, id_pago);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                pago.setId_forma_pago(rs.getInt("id_forma_pago"));
                pago.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar la forma de pago: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return pago;
    }
    
    public boolean agregarPago(int monto_pago, int id_reserva, int id_forma_pago) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("CALL pkg_forma_pago.sp_agregar_forma_pago(?, ?, ?)");
            cstmt.setInt(1, monto_pago);
            cstmt.setInt(2, id_reserva);
            cstmt.setInt(3, id_forma_pago);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar el pago: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
