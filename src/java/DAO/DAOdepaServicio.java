package DAO;

import Clases.DepaServicio;
import Clases.DepaServicioSimple;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOdepaServicio {

    private Connection con;

    public DAOdepaServicio() {
    }

    public boolean agregarDepaServicio(List<DepaServicioSimple> dep) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_depa_servicio.sp_agregar_depa_servicios(?, ?)}");
            for (DepaServicioSimple depaServicio : dep) {
                cstmt.setInt(1, depaServicio.getId_servicio());
                cstmt.setInt(2, depaServicio.getId_depa());
                if (cstmt.executeUpdate() > 0) {
                    ward = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al agregar servicios de departamentos: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<DepaServicio> obtenerDepaServicio() throws SQLException {
        List<DepaServicio> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_depa_servicio.sp_listar_depa_servicios(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                DepaServicio dep = new DepaServicio();
                dep.setId_servicio(rs.getInt("servicios_id_servicios"));
                dep.setId_depa(rs.getInt("departamento_id_departamento"));
                dep.setNom_servicio(rs.getString("nom_servicio"));
                lista.add(dep);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los servicios de los departamentos: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }
    
    public boolean modificarDepaServicio(int id_serv, int id_depa, DepaServicioSimple depser) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_depa_servicio.sp_actualizar_depa_servicios(?, ?, ?, ?)}");
            cstmt.setInt(1, id_serv);
            cstmt.setInt(2, id_depa);
            cstmt.setInt(3, depser.getId_servicio());
            cstmt.setInt(4, depser.getId_depa());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar servicios de departamentos: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
    
    public boolean eliminarDepaServicio(int id_serv, int id_depa) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_depa_servicio.sp_eliminar_depa_servicios(?, ?)}");
            cstmt.setInt(1, id_serv);
            cstmt.setInt(2, id_depa);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el servicio del departamento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

}
