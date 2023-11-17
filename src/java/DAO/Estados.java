package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Estados {

    private Connection con;

    public Estados() {
    }

    public boolean actualizarEstadoDepartamentoDisponibleTerminoReserva(int id_depa) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_estado.actualizar_estado_departamento_disponible_terminoreserva(?)}");
            cstmt.setInt(1, id_depa);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el estado del departamento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean actualizarEstadoDepartamentoDisponibleFinMantenimiento(int id_depa) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_estado.actualizar_estado_departamento_disponible_fin_mantenimiento(?)}");
            cstmt.setInt(1, id_depa);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el estado del departamento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean actualizarEstadoDepartamentoMantenimiento(int id_depa) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_estado.actualizar_estado_departamento_mantenimiento(?)}");
            cstmt.setInt(1, id_depa);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el estado del departamento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean actualizarEstadoDepartamentoOcupado(int id_depa) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_estado.actualizar_estado_departamento_ocupado(?)}");
            cstmt.setInt(1, id_depa);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el estado del departamento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
