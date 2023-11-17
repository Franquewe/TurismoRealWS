package DAO;

import Clases.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.internal.OracleTypes;

public class DAOcliente {

    private Connection con;

    public DAOcliente() {
    }

    public boolean agregarCliente(Cliente cli) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_cliente.sp_agregar_cliente(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setInt(1, cli.getRut());
            cstmt.setString(2, cli.getDv());
            cstmt.setString(3, cli.getNombre());
            cstmt.setString(4, cli.getApellido_paterno());
            cstmt.setString(5, cli.getApellido_materno());
            cstmt.setString(6, cli.getCorreo());
            cstmt.setString(7, cli.getUsuario());
            cstmt.setString(8, cli.getContrasena());
            cstmt.setString(9, cli.getTelefono());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public List<Cliente> obtenerCliente() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_cliente.sp_listar_cliente(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setRut(rs.getInt("rut"));
                cli.setDv(rs.getString("dv"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido_paterno(rs.getString("apellido_paterno"));
                cli.setApellido_materno(rs.getString("apellido_materno"));
                cli.setCorreo(rs.getString("correo"));
                cli.setUsuario(rs.getString("usuario"));
                cli.setContrasena(rs.getString("contrasena"));
                cli.setTelefono(rs.getString("telefono"));
                lista.add(cli);
            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return lista;
    }

    public Cliente obtenerClientePorRut(int rut) throws SQLException {
        Cliente cli = new Cliente();
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_cliente.sp_listar_cliente_por_rut(?, ?)}");
            cstmt.setInt(1, rut);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(2);
            while (rs.next()) {
                cli.setRut(rs.getInt("rut"));
                cli.setDv(rs.getString("dv"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido_paterno(rs.getString("apellido_paterno"));
                cli.setApellido_materno(rs.getString("apellido_materno"));
                cli.setCorreo(rs.getString("correo"));
                cli.setUsuario(rs.getString("usuario"));
                cli.setContrasena(rs.getString("contrasena"));
                cli.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar cliente de rut " + rut + ": " + e.getMessage());
        } finally {
            this.con.close();
        }
        return cli;
    }

    public boolean modificarCliente(int rutcli, Cliente cli) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_cliente.sp_actualizar_cliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setInt(1, rutcli);
            cstmt.setInt(2, cli.getRut());
            cstmt.setString(3, cli.getDv());
            cstmt.setString(4, cli.getNombre());
            cstmt.setString(5, cli.getApellido_paterno());
            cstmt.setString(6, cli.getApellido_materno());
            cstmt.setString(7, cli.getCorreo());
            cstmt.setString(8, cli.getUsuario());
            cstmt.setString(9, cli.getContrasena());
            cstmt.setString(10, cli.getTelefono());
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }

    public boolean eliminarCliente(int rut) throws SQLException {
        boolean ward = false;
        try {
            this.con = new Conexion.Conexion().obtenerConexion();
            CallableStatement cstmt = this.con.prepareCall("{CALL pkg_cliente.sp_eliminar_cliente(?)}");
            cstmt.setInt(1, rut);
            if (cstmt.executeUpdate() > 0) {
                ward = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        } finally {
            this.con.close();
        }
        return ward;
    }
}
