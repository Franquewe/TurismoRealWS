package DAO;

import Clases.Departamento;
import Clases.DepartamentoDetalle;
import Clases.Imagen;
import Clases.Servicios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DAOdepartamento {

    private Connection con;

    public boolean agregarDepartamento(Departamento dep) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_departamento.sp_agregar_departamento(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setString(1, dep.getDireccion());
            cstmt.setString(2, dep.getDescripcion());
            cstmt.setInt(3, dep.getPrecio());
            cstmt.setFloat(4, dep.getLatitud());
            cstmt.setFloat(5, dep.getLongitud());
            cstmt.setInt(6, dep.getCapacidad_persona());
            cstmt.setInt(7, dep.getCantidad_img());
            cstmt.setInt(8, dep.getHabitaciones());
            cstmt.setInt(9, dep.getId_comuna());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar departamento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<Imagen> obtenerImagen(int id_dep) throws SQLException {
        List<Imagen> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_departamento.sp_listar_img_por_depa(?, ?)}");
            cstmt.setInt(1, id_dep);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                Imagen img = new Imagen();
                img.setRuta(rs.getString("ruta"));
                lista.add(img);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener las imagenes: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public List<Servicios> obtenerServicios(int id_dep) throws SQLException {
        List<Servicios> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_departamento.sp_listar_serv_por_depa(?, ?)}");
            cstmt.setInt(1, id_dep);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                Servicios serv = new Servicios();
                serv.setNom_servicio(rs.getString("nom_servicio"));
                lista.add(serv);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los servicios: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public List<DepartamentoDetalle> obtenerDepartamento() throws SQLException {
        List<DepartamentoDetalle> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_departamento.sp_listar_departamento(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                DepartamentoDetalle dep = new DepartamentoDetalle();
                dep.setId_depa(rs.getInt("id_departamento"));
                dep.setDireccion(rs.getString("direccion"));
                dep.setDescripcion(rs.getString("descripcion"));
                dep.setPrecio(rs.getInt("precio"));
                dep.setLatitud(rs.getFloat("latitud"));
                dep.setLongitud(rs.getFloat("longitud"));
                dep.setCap_personas(rs.getInt("capacidad_persona"));
                dep.setCant_img(rs.getInt("cantidad_img"));
                dep.setHabitaciones(rs.getInt("habitaciones"));
                dep.setId_comuna(rs.getInt("comuna_id_comuna"));
                dep.setId_estado(rs.getInt("estado_id_estado"));
                dep.setDesc_estado(rs.getString("descripcion_estado"));
                dep.setNom_comuna(rs.getString("nombre_comuna"));
                dep.setServicios(obtenerServicios(dep.getId_depa()));
                dep.setImg(obtenerImagen(dep.getId_depa()));
                lista.add(dep);
            }
        } catch (Exception e) {
            System.out.println("Error al listar departamentos: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public DepartamentoDetalle obtenerDetalleDepa(int id_dep) throws SQLException {
        DepartamentoDetalle dep = new DepartamentoDetalle();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_departamento.sp_listar_departamento_por_id(?, ?)}");
            cstmt.setInt(1, id_dep);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                dep.setId_depa(rs.getInt("id_departamento"));
                dep.setDireccion(rs.getString("direccion"));
                dep.setDescripcion(rs.getString("descripcion"));
                dep.setPrecio(rs.getInt("precio"));
                dep.setLatitud(rs.getFloat("latitud"));
                dep.setLongitud(rs.getFloat("longitud"));
                dep.setCap_personas(rs.getInt("capacidad_persona"));
                dep.setCant_img(rs.getInt("cantidad_img"));
                dep.setHabitaciones(rs.getInt("habitaciones"));
                dep.setId_comuna(rs.getInt("comuna_id_comuna"));
                dep.setId_estado(rs.getInt("estado_id_estado"));
                dep.setDesc_estado(rs.getString("descripcion_estado"));
                dep.setNom_comuna(rs.getString("nombre_comuna"));
                dep.setServicios(obtenerServicios(id_dep));
                dep.setImg(obtenerImagen(id_dep));
            }

        } catch (Exception e) {
            System.out.println("Error al listar departamentos: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return dep;
    }

    public boolean modificarDepartamento(int id_dep, Departamento dep) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_departamento.sp_actualizar_departamento(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setInt(1, id_dep);
            cstmt.setString(2, dep.getDireccion());
            cstmt.setString(3, dep.getDescripcion());
            cstmt.setInt(4, dep.getPrecio());
            cstmt.setFloat(5, dep.getLatitud());
            cstmt.setFloat(6, dep.getLongitud());
            cstmt.setInt(7, dep.getCapacidad_persona());
            cstmt.setInt(8, dep.getCantidad_img());
            cstmt.setInt(9, dep.getHabitaciones());
            cstmt.setInt(10, dep.getId_comuna());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar departamento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean eliminarDepartamento(int id_dep) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_departamento.sp_eliminar_departamento(?)}");
            cstmt.setInt(1, id_dep);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el departamento: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
