package ws;

import Clases.Administrador;
import Clases.Articulo;
import Clases.CheckIn;
import Clases.CheckOut;
import Clases.Cliente;
import Clases.Comuna;
import Clases.DepaServicio;
import Clases.DepaServicioSimple;
import Clases.Departamento;
import Clases.DepartamentoDetalle;
import Clases.FormaPago;
import Clases.Funcionario;
import Clases.Inventario;
import Clases.LoginC;
import Clases.Mantenimiento;
import Clases.Reserva;
import Clases.ReservaTour;
import Clases.ReservaTrans;
import Clases.Tour;
import Clases.Transporte;
import DAO.DAOadministrador;
import DAO.DAOarticulo;
import DAO.DAOcheckin;
import DAO.DAOcheckout;
import DAO.DAOcliente;
import DAO.DAOcomuna;
import DAO.DAOdepaServicio;
import DAO.DAOdepartamento;
import DAO.DAOformaPago;
import DAO.DAOfuncionario;
import DAO.DAOinventario;
import DAO.DAOlogin;
import DAO.DAOmantenimiento;
import DAO.DAOreserva;
import DAO.DAOreservaTour;
import DAO.DAOreservaTrans;
import DAO.DAOtour;
import DAO.DAOtransporte;
import DAO.Estados;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WSPortafolio")
public class WSPortafolio {

    DAOlogin daolog = new DAOlogin();
    DAOcliente daocli = new DAOcliente();
    DAOadministrador daoadm = new DAOadministrador();
    DAOfuncionario daofun = new DAOfuncionario();
    DAOdepartamento daodep = new DAOdepartamento();
    DAOreserva daores = new DAOreserva();
    DAOcheckin daocin = new DAOcheckin();
    DAOcheckout daocout = new DAOcheckout();
    DAOmantenimiento daomant = new DAOmantenimiento();
    DAOarticulo daoart = new DAOarticulo();
    DAOdepaServicio daodepser = new DAOdepaServicio();
    DAOinventario daoinv = new DAOinventario();
    DAOreservaTour daorestour = new DAOreservaTour();
    DAOreservaTrans daorestran = new DAOreservaTrans();
    DAOtour daotour = new DAOtour();
    DAOtransporte daotran = new DAOtransporte();
    Estados estados = new Estados();
    DAOcomuna daocom = new DAOcomuna();
    DAOformaPago daopago = new DAOformaPago();

    //Metodo LoginC
    @WebMethod(operationName = "metodoLogin")
    public LoginC metodoLogin(
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "contrasena") String contrasena) {
        try {
            return daolog.loginCompleto(usuario, contrasena);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "login")
    public String login(
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "contrasena") String contrasena) {
        try {
            return daolog.login(usuario, contrasena);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Metodos para el cliente
    @WebMethod(operationName = "agregarCliente")
    public boolean agregarCliente(
            @WebParam(name = "rut") int rut,
            @WebParam(name = "dv") String dv,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido_paterno") String apellido_paterno,
            @WebParam(name = "apellido_materno") String apellido_materno,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "contrasena") String contrasena,
            @WebParam(name = "telefono") String telefono) {
        try {
            Cliente cli = new Cliente(rut, dv, nombre, apellido_paterno, apellido_materno, correo, usuario, contrasena, telefono);
            return daocli.agregarCliente(cli);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarCliente")
    public List<Cliente> listarCliente() {
        try {
            return daocli.obtenerCliente();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "listarClientePorRut")
    public Cliente listarClientePorRut(
            @WebParam(name = "rut") int rut) {
        try {
            return daocli.obtenerClientePorRut(rut);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarCliente")
    public boolean modificarCliente(
            @WebParam(name = "rut") int rut,
            @WebParam(name = "nrut") int nrut,
            @WebParam(name = "ndv") String ndv,
            @WebParam(name = "nnombre") String nnombre,
            @WebParam(name = "napellido_paterno") String napellido_paterno,
            @WebParam(name = "napellido_materno") String napellido_materno,
            @WebParam(name = "ncorreo") String ncorreo,
            @WebParam(name = "nusuario") String nusuario,
            @WebParam(name = "ncontrasena") String ncontrasena,
            @WebParam(name = "ntelefono") String ntelefono) {
        try {
            Cliente cli = new Cliente(nrut, ndv, nnombre, napellido_paterno, napellido_materno, ncorreo, nusuario, ncontrasena, ntelefono);
            return daocli.modificarCliente(rut, cli);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarCliente")
    public boolean eliminarCliente(
            @WebParam(name = "rut") int rut) {
        try {
            return daocli.eliminarCliente(rut);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Metodos para el administrador
    @WebMethod(operationName = "agregarAdministrador")
    public boolean agregarAdministrador(
            @WebParam(name = "rut") int rut,
            @WebParam(name = "dv") String dv,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido_paterno") String apellido_paterno,
            @WebParam(name = "apellido_materno") String apellido_materno,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "contrasena") String contrasena,
            @WebParam(name = "telefono") String telefono) {
        try {
            Administrador adm = new Administrador(rut, dv, nombre, apellido_paterno, apellido_materno, correo, usuario, contrasena, telefono);
            return daoadm.agregarAdministrador(adm);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarAdministrador")
    public List<Administrador> listarAdministrador() {
        try {
            return daoadm.obtenerAdministrador();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "listarAdministradorPorRut")
    public Administrador listarAdministradorPorRut(@WebParam(name = "rut") int rut) {
        try {
            return daoadm.obtenerAdministradorPorRut(rut);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarAdministrador")
    public boolean modificarAdministrador(
            @WebParam(name = "rut") int rut,
            @WebParam(name = "nrut") int nrut,
            @WebParam(name = "ndv") String ndv,
            @WebParam(name = "nnombre") String nnombre,
            @WebParam(name = "napellido_paterno") String napellido_paterno,
            @WebParam(name = "napellido_materno") String napellido_materno,
            @WebParam(name = "ncorreo") String ncorreo,
            @WebParam(name = "nusuario") String nusuario,
            @WebParam(name = "ncontrasena") String ncontrasena,
            @WebParam(name = "ntelefono") String ntelefono) {
        try {
            Administrador adm = new Administrador(nrut, ndv, nnombre, napellido_paterno, napellido_materno, ncorreo, nusuario, ncontrasena, ntelefono);
            return daoadm.modificarAdministrador(rut, adm);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarAdministrador")
    public boolean eliminarAdministrador(
            @WebParam(name = "rut") int rut) {
        try {
            return daoadm.eliminarAdministrador(rut);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Metodos para el funcionario
    @WebMethod(operationName = "agregarFuncionario")
    public boolean agregarFuncionario(
            @WebParam(name = "rut") int rut,
            @WebParam(name = "dv") String dv,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido_paterno") String apellido_paterno,
            @WebParam(name = "apellido_materno") String apellido_materno,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "contrasena") String contrasena,
            @WebParam(name = "telefono") String telefono) {
        try {
            Funcionario fun = new Funcionario(rut, dv, nombre, apellido_paterno, apellido_materno, correo, usuario, contrasena, telefono);
            return daofun.agregarFuncionario(fun);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarFuncionario")
    public List<Funcionario> listarFuncionario() {
        try {
            return daofun.obtenerFuncionario();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "listarFuncionarioPorRut")
    public Funcionario listarFuncionarioPorRut(
            @WebParam(name = "rut") int rut) {
        try {
            return daofun.obtenerFuncionarioPorRut(rut);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarFuncionario")
    public boolean modificarFuncionario(
            @WebParam(name = "rut") int rut,
            @WebParam(name = "nrut") int nrut,
            @WebParam(name = "ndv") String ndv,
            @WebParam(name = "nnombre") String nnombre,
            @WebParam(name = "napellido_paterno") String napellido_paterno,
            @WebParam(name = "napellido_materno") String napellido_materno,
            @WebParam(name = "ncorreo") String ncorreo,
            @WebParam(name = "nusuario") String nusuario,
            @WebParam(name = "ncontrasena") String ncontrasena,
            @WebParam(name = "ntelefono") String ntelefono) {
        try {
            Funcionario fun = new Funcionario(nrut, ndv, nnombre, napellido_paterno, napellido_materno, ncorreo, nusuario, ncontrasena, ntelefono);
            return daofun.modificarFuncionario(rut, fun);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarFuncionario")
    public boolean eliminarFuncionario(
            @WebParam(name = "rut") int rut) {
        try {
            return daofun.eliminarFuncionario(rut);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Metodos para el Departamento
    @WebMethod(operationName = "agregarDepartamento")
    public boolean agregarDepartamento(
            @WebParam(name = "direccion") String direccion,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "precio") int precio,
            @WebParam(name = "latitud") float latitud,
            @WebParam(name = "longitud") float longitud,
            @WebParam(name = "capacidad_persona") int capacidad_persona,
            @WebParam(name = "cantidad_img") int cantidad_img,
            @WebParam(name = "habitaciones") int habitaciones,
            @WebParam(name = "id_comuna") int id_comuna) {
        try {
            Departamento dep = new Departamento(1, direccion, descripcion, precio, latitud, longitud, capacidad_persona, cantidad_img, habitaciones, id_comuna, 4);
            return daodep.agregarDepartamento(dep);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarDepartamento")
    public List<DepartamentoDetalle> listarDepartamento() {
        try {
            return daodep.obtenerDepartamento();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "listarDepaPorId")
    public DepartamentoDetalle listarDepaPorId(
            @WebParam(name = "id_dep") int id_dep) {
        try {
            return daodep.obtenerDetalleDepa(id_dep);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarDepartamento")
    public boolean modificarDepartamento(
            @WebParam(name = "id_depa") int id_depa,
            @WebParam(name = "ndireccion") String ndireccion,
            @WebParam(name = "ndescripcion") String ndescripcion,
            @WebParam(name = "nprecio") int nprecio,
            @WebParam(name = "latitud") float nlatitud,
            @WebParam(name = "nlongitud") float nlongitud,
            @WebParam(name = "ncapacidad_persona") int ncapacidad_persona,
            @WebParam(name = "ncantidad_img") int ncantidad_img,
            @WebParam(name = "nhabitaciones") int nhabitaciones,
            @WebParam(name = "id_comuna") int nid_comuna) {
        try {
            Departamento ndep = new Departamento(1, ndireccion, ndescripcion, nprecio, nlatitud, nlongitud, ncapacidad_persona, ncantidad_img, nhabitaciones, nid_comuna, 4);
            return daodep.modificarDepartamento(id_depa, ndep);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarDepartamento")
    public boolean eliminarDepartamento(
            @WebParam(name = "id_dep") int id_dep) {
        try {
            return daodep.eliminarDepartamento(id_dep);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Metodos para la Reserva
    @WebMethod(operationName = "agregarReserva")
    public boolean agregarReserva(
            @WebParam(name = "inicio_reserva") String inicio_reserva_str,
            @WebParam(name = "termino_reserva") String termino_reserva_str,
            @WebParam(name = "cant_personas") int cant_personas,
            @WebParam(name = "monto_total") int monto_total,
            @WebParam(name = "monto_abonado") int monto_abonado,
            @WebParam(name = "id_departamento") int id_departamento,
            @WebParam(name = "cliente_rut") int cliente_rut,
            @WebParam(name = "id_estado") int id_estado) {
        try {
            Date inicio_reserva = Date.valueOf(inicio_reserva_str);
            Date termino_reserva = Date.valueOf(termino_reserva_str);
            Reserva res = new Reserva(1, inicio_reserva, termino_reserva, cant_personas, monto_total, monto_abonado, id_departamento, cliente_rut, id_estado, null);
            return daores.agregarReserva(res);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarReserva")
    public List<Reserva> listarReserva() {
        try {
            return daores.obtenerReserva();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "listarReservaPorId")
    public Reserva listarReservaPorId(
            @WebParam(name = "id_reserva") int id_reserva) {
        try {
            return daores.obtenerReservaPorId(id_reserva);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "listarReservaPorRut")
    public List<Reserva> listarReservaPorRut(
            @WebParam(name = "rut_cliente") int rut_cliente) {
        try {
            return daores.obtenerReservaPorRut(rut_cliente);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarReserva")
    public boolean modificarReserva(
            @WebParam(name = "id_reserva") int id_reserva,
            @WebParam(name = "nini_res") String nini_res_str,
            @WebParam(name = "nter_res") String nter_res_str,
            @WebParam(name = "ncant_pers") int ncant_pers,
            @WebParam(name = "nmont_total") int nmont_total,
            @WebParam(name = "nmont_abonado") int nmont_abonado,
            @WebParam(name = "nid_dep") int nid_dep) {
        try {
            Date nini_res = Date.valueOf(nini_res_str);
            Date nter_res = Date.valueOf(nter_res_str);
            Reserva res = new Reserva(1, nini_res, nter_res, ncant_pers, nmont_total, nmont_abonado, nid_dep, 1, 1, null);
            return daores.modificarReserva(id_reserva, res);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarReserva")
    public boolean eliminarReserva(
            @WebParam(name = "id_reserva") int id_reserva) {
        try {
            return daores.eliminarReserva(id_reserva);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Metodos para el Check In
    @WebMethod(operationName = "agregarCheckIn")
    public boolean agregarCheckIn(
            @WebParam(name = "firma") String firma,
            @WebParam(name = "pago") int pago,
            @WebParam(name = "id_reserva") int id_reserva,
            @WebParam(name = "funcionario_rut") int funcionario_rut) {
        try {
            CheckIn cin = new CheckIn(1, null, null, firma, pago, id_reserva, funcionario_rut);
            return daocin.agregarCheckIn(cin);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarCheckIn")
    public List<CheckIn> listarCheckIn() {
        try {
            return daocin.obtenerCheckIn();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarCheckIn")
    public boolean modificarCheckIn(
            @WebParam(name = "id_cin") int id_cin,
            @WebParam(name = "nfirma") String nfirma,
            @WebParam(name = "npago") int npago) {
        try {
            CheckIn cin = new CheckIn(1, null, null, nfirma, npago, 1, 1);
            return daocin.modificarCheckIn(id_cin, cin);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarCheckIn")
    public boolean eliminarCheckIn(
            @WebParam(name = "id_check_in") int id_check_in) {
        try {
            return daocin.eliminarCheckIn(id_check_in);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Metodos Check Out
    @WebMethod(operationName = "agregarCheckOut")
    public boolean agregarCheckOut(
            @WebParam(name = "multa") int multa,
            @WebParam(name = "pago") int pago,
            @WebParam(name = "firma") String firma,
            @WebParam(name = "id_reserva") int id_reserva,
            @WebParam(name = "funcionario_rut") int funcionario_rut) {
        try {
            CheckOut cout = new CheckOut(1, null, null, multa, pago, firma, id_reserva, funcionario_rut);
            return daocout.agregarCheckOut(cout);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarCheckOut")
    public List<CheckOut> listarCheckOut() {
        try {
            return daocout.obtenerCheckOut();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarCheckOut")
    public boolean modificarCheckOut(
            @WebParam(name = "id_cout") int id_cout,
            @WebParam(name = "nmulta") int nmulta,
            @WebParam(name = "npago") int npago,
            @WebParam(name = "nfirma") String nfirma) {
        try {
            CheckOut cout = new CheckOut(1, null, null, nmulta, npago, nfirma, 1, 1);
            return daocout.modificarCheckOut(id_cout, cout);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarCheckOut")
    public boolean eliminarCheckOut(
            @WebParam(name = "id_check_out") int id_check_out) {
        try {
            return daocout.eliminarCheckOut(id_check_out);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "agregarMantenimiento")
    public boolean agregarMantenimiento(
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "fecha_inicio_str") String fecha_inicio_str,
            @WebParam(name = "fecha_termino_str") String fecha_termino_str,
            @WebParam(name = "id_depa") int id_depa) {
        try {
            Date fecha_inicio = Date.valueOf(fecha_inicio_str);
            Date fecha_termino = Date.valueOf(fecha_termino_str);
            Mantenimiento mant = new Mantenimiento(1, descripcion, fecha_inicio, fecha_termino, id_depa);
            return daomant.agregarMantenimiento(mant);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarMantenimiento")
    public List<Mantenimiento> listarMantenimiento() {
        try {
            return daomant.obtenerMantenimiento();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarMantenimiento")
    public boolean modificarMantenimiento(
            @WebParam(name = "id_mant") int id_mant,
            @WebParam(name = "ndescripcion") String ndescripcion,
            @WebParam(name = "nfecha_inicio_str") String nfecha_inicio_str,
            @WebParam(name = "nfecha_termino_str") String nfecha_termino_str) {
        try {
            Date nfecha_inicio = Date.valueOf(nfecha_inicio_str);
            Date nfecha_termino = Date.valueOf(nfecha_termino_str);
            Mantenimiento mant = new Mantenimiento(1, ndescripcion, nfecha_inicio, nfecha_termino, 1);
            return daomant.modificarMantenimiento(id_mant, mant);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarMantenimiento")
    public boolean eliminarMantenimiento(
            @WebParam(name = "id_mant") int id_mant) {
        try {
            return daomant.eliminarMantenimiento(id_mant);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "agregarArticulo")
    public boolean agregarArticulo(
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "stock") int stock,
            @WebParam(name = "precio") int precio) {
        try {
            Articulo art = new Articulo(1, descripcion, stock, precio);
            return daoart.agregarArticulo(art);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarArticulo")
    public List<Articulo> listarArticulo() {
        try {
            return daoart.obtenerArticulo();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "listarArticuloPorId")
    public Articulo listarArticuloPorId(
            @WebParam(name = "id_art") int id_art) {
        try {
            return daoart.obtenerArticuloPorId(id_art);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarArticulo")
    public boolean modificarArticulo(
            @WebParam(name = "id_art") int id_art,
            @WebParam(name = "ndescripcion") String ndescripcion,
            @WebParam(name = "nstock") int nstock,
            @WebParam(name = "nprecio") int nprecio) {
        try {
            Articulo art = new Articulo(1, ndescripcion, nstock, nprecio);
            return daoart.modificarArticulo(id_art, art);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarArticulo")
    public boolean eliminarArticulo(
            @WebParam(name = "id_art") int id_art) {
        try {
            return daoart.eliminarArticulo(id_art);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "agregarDepaServicio")
    public boolean agregarDepaServicio(
            @WebParam(name = "dep") List<DepaServicioSimple> dep) {
        try {
            return daodepser.agregarDepaServicio(dep);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarDepaServicio")
    public List<DepaServicio> listarDepaServicio() {
        try {
            return daodepser.obtenerDepaServicio();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "modificarDepaServicio")
    public boolean modificarDepaServicio(
            @WebParam(name = "id_servicio") int id_servicio,
            @WebParam(name = "id_departamento") int id_departamento,
            @WebParam(name = "dep") DepaServicioSimple depserv) {
        try {
            return daodepser.modificarDepaServicio(id_servicio, id_departamento, depserv);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @WebMethod(operationName = "eliminarDepaServicio")
    public boolean eliminarDepaServicio(
            @WebParam(name = "id_servicio") int id_servicio,
            @WebParam(name = "id_departamento") int id_departamento) {
        try {
            return daodepser.eliminarDepaServicio(id_servicio, id_departamento);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "agregarInventario")
    public boolean agregarInventario(
            @WebParam(name = "id_articulo") int id_articulo,
            @WebParam(name = "id_departamento") int id_departamento,
            @WebParam(name = "cantidad") int cantidad) {
        try {
            Inventario inv = new Inventario(id_articulo, id_departamento, cantidad, null, 0);
            return daoinv.agregarInventario(inv);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarInventario")
    public List<Inventario> listarInventario() {
        try {
            return daoinv.obtenerInventario();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "listarInventarioPorIdDepa")
    public List<Inventario> listarInventarioPorIdDepa(
            @WebParam(name = "id_departamento") int id_departamento) {
        try {
            return daoinv.obtenerInventarioIdDepa(id_departamento);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarInventario")
    public boolean modificarInventario(
            @WebParam(name = "id_depa") int id_depa,
            @WebParam(name = "nid_articulo") int nid_articulo,
            @WebParam(name = "ncantidad") int ncantidad) {
        try {
            Inventario inv = new Inventario(nid_articulo, 0, ncantidad, null, 0);
            return daoinv.modificarInventario(id_depa, inv);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarInventario")
    public boolean eliminarInventario(
            @WebParam(name = "id_departamento") int id_departamento,
            @WebParam(name = "id_articulo") int id_articulo) {
        try {
            return daoinv.eliminarInventario(id_departamento, id_articulo);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "agregarReservaTour")
    public boolean agregarReservaTour(
            @WebParam(name = "id_tour") int id_tour,
            @WebParam(name = "id_reserva") int id_reserva,
            @WebParam(name = "cantidad") int cantidad,
            @WebParam(name = "pago_cliente") int pago_cliente) {
        try {
            ReservaTour resTour = new ReservaTour(id_tour, id_reserva, cantidad, pago_cliente, null);
            return daorestour.agregarReservaTour(resTour);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarReservaTour")
    public List<ReservaTour> listarReservaTour() {
        try {
            return daorestour.obtenerReservaTour();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "listarReservaTourIdReserva")
    public List<ReservaTour> listarReservaTourIdReserva(
            @WebParam(name = "id_reserva") int id_reserva) {
        try {
            return daorestour.obtenerReservaTourPorParam(id_reserva);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarReservaTour")
    public boolean modificarReservaTour(
            @WebParam(name = "id_reserva") int id_reserva,
            @WebParam(name = "nid_tour") int nid_tour,
            @WebParam(name = "ncantidad") int ncantidad,
            @WebParam(name = "npago_cliente") int npago_cliente) {
        try {
            ReservaTour resTour = new ReservaTour(nid_tour, 1, ncantidad, npago_cliente, null);
            return daorestour.modificarReservaTour(id_reserva, resTour);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarReservaTour")
    public boolean eliminarReservaTour(
            @WebParam(name = "id_reserva") int id_reserva) {
        try {
            return daorestour.eliminarReservaTour(id_reserva);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "agregarReservaTransporte")
    public boolean agregarReservaTransporte(
            @WebParam(name = "id_transporte") int id_transporte,
            @WebParam(name = "id_reserva") int id_reserva,
            @WebParam(name = "cantidad") int cantidad,
            @WebParam(name = "pago_cliente") int pago_cliente) {
        try {
            ReservaTrans resTrans = new ReservaTrans(id_transporte, id_reserva, cantidad, pago_cliente, null);
            return daorestran.agregarReservaTransporte(resTrans);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarReservaTransporte")
    public List<ReservaTrans> listarReservaTransporte() {
        try {
            return daorestran.obtenerReservaTransporte();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "listarReservaTransporteIdReserva")
    public ReservaTrans listarReservaTransporteIdReserva(
            @WebParam(name = "id_reserva") int id_reserva) {
        try {
            return daorestran.obtenerReservaTransportePorParam(id_reserva);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "modificarReservaTransporte")
    public boolean modificarReservaTransporte(
            @WebParam(name = "id_reserva") int id_reserva,
            @WebParam(name = "nid_transporte") int nid_transporte,
            @WebParam(name = "ncantidad") int ncantidad,
            @WebParam(name = "npago_cliente") int npago_cliente) {
        try {
            ReservaTrans resTrans = new ReservaTrans(nid_transporte, 1, ncantidad, npago_cliente, null);
            return daorestran.modificarReservaTransporte(id_reserva, resTrans);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminarReservaTransporte")
    public boolean eliminarReservaTransporte(
            @WebParam(name = "id_reserva") int id_reserva) {
        try {
            return daorestran.eliminarReservaTransporte(id_reserva);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarTour")
    public List<Tour> listarTour() {
        try {
            return daotour.obtenerTour();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "listarTransporte")
    public List<Transporte> listarTransporte() {
        try {
            return daotran.obtenerTransporte();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @WebMethod(operationName = "estadoDepaDisponibleTerminoReserva")
    public boolean estadoDepaDisponibleTerminoReserva(
            @WebParam(name = "id_depa") int id_depa) {
        try {
            return estados.actualizarEstadoDepartamentoDisponibleTerminoReserva(id_depa);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "estadoDepaDisponibleFinMantenimiento")
    public boolean estadoDepaDisponibleFinMantenimiento(
            @WebParam(name = "id_depa") int id_depa) {
        try {
            return estados.actualizarEstadoDepartamentoDisponibleFinMantenimiento(id_depa);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "estadoDepaMantenimiento")
    public boolean estadoDepaMantenimiento(
            @WebParam(name = "id_depa") int id_depa) {
        try {
            return estados.actualizarEstadoDepartamentoMantenimiento(id_depa);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "estadoDepaOcupado")
    public boolean estadoDepaOcupado(
            @WebParam(name = "id_depa") int id_depa) {
        try {
            return estados.actualizarEstadoDepartamentoOcupado(id_depa);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "listarComuna")
    public List<Comuna> listarComuna() {
        try {
            return daocom.obtenerComunas();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "listarFormaPago")
    public List<FormaPago> listarFormaPago() {
        try {
            return daopago.obtenerFormaPago();
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "listarFormaPagoPorId")
    public FormaPago listarFormaPagoPorId(
            @WebParam(name = "id_pago") int id_pago) {
        try {
            return daopago.obtenerFormaPagoPorId(id_pago);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "agregarPago")
    public boolean agregarPago(
            @WebParam(name = "monto_pago") int monto_pago,
            @WebParam(name = "id_reserva") int id_reserva,
            @WebParam(name = "id_forma_pago") int id_forma_pago) {
        try {
            return daopago.agregarPago(monto_pago, id_reserva, id_forma_pago);
        } catch (SQLException ex) {
            Logger.getLogger(WSPortafolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
