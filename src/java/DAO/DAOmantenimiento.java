package DAO;

import Clases.Mantenimiento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOmantenimiento {

    private Connection con;

    public DAOmantenimiento() {
    }

    public boolean agregarMantenimiento(Mantenimiento mant) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_mantenimiento.sp_agregar_mantenimiento(?, ?, ?, ?)}");
            cstmt.setString(1, mant.getDesc_mantenimiento());
            cstmt.setDate(2, (java.sql.Date) mant.getFecha_inicio());
            cstmt.setDate(3, (java.sql.Date) mant.getFecha_termino());
            cstmt.setInt(4, mant.getId_departamento());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar mantenimiento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<Mantenimiento> obtenerMantenimiento() throws SQLException {
        List<Mantenimiento> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_mantenimiento.sp_listar_mantenimiento(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                Mantenimiento mant = new Mantenimiento();
                mant.setId_mantenimiento(rs.getInt("id_mantenimiento"));
                mant.setDesc_mantenimiento(rs.getString("descripcion_mantenimiento"));
                mant.setFecha_inicio(rs.getDate("fecha_inicio"));
                mant.setFecha_termino(rs.getDate("fecha_termino"));
                mant.setId_departamento(rs.getInt("departamento_id_departamento"));
                lista.add(mant);
            }
        } catch (Exception e) {
            System.out.println("Error al listar mantenimiento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public boolean modificarMantenimiento(int id_mant, Mantenimiento mant) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_mantenimiento.sp_actualizar_mantenimiento(?, ?, ?, ?)}");
            cstmt.setInt(1, id_mant);
            cstmt.setString(2, mant.getDesc_mantenimiento());
            cstmt.setDate(3, (java.sql.Date) mant.getFecha_inicio());
            cstmt.setDate(4, (java.sql.Date) mant.getFecha_termino());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar mantenimiento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean eliminarMantenimiento(int id_mant) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_mantenimiento.sp_eliminar_mantenimiento(?)}");
            cstmt.setInt(1, id_mant);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar mantenimiento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
