package Test;

import Clases.Administrador;
import Clases.Cliente;
import Clases.Comuna;
import Clases.DepaServicioSimple;
import Clases.Departamento;
import Clases.Funcionario;
import Clases.LoginC;
import Clases.Reserva;
//import Clases.Departamento;
import DAO.DAOadministrador;
import DAO.DAOcliente;
import DAO.DAOcomuna;
import DAO.DAOdepaServicio;
import DAO.DAOdepartamento;
import DAO.DAOfuncionario;
//import DAO.DAOdepartamento;
import DAO.DAOlogin;
import DAO.DAOreserva;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        try {
//            DAOlogin login = new DAOlogin();
//            String userType = login.login("juan123", "pass123");
//            if ("cliente".equals(userType)) {
//                System.out.println("Credenciales correctas, bienvenido Cliente");
//            } else if ("funcionario".equals(userType)) {
//                System.out.println("Credenciales correctas, bienvenido Funcionario");
//            } else if ("admin".equals(userType)) {
//                System.out.println("Credenciales correctas, bienvenido Administrador");
//            } else {
//                System.out.println("Credenciales incorrectas");
//            }
//            int rut = 12345678;
            List<Comuna> lista = new DAOcomuna().obtenerComunas();
//            DepaServicioSimple reg1 = new DepaServicioSimple(1, 8);
//            DepaServicioSimple reg2 = new DepaServicioSimple(4, 8);
//            lista.add(reg1);
//            lista.add(reg2);
//            if (new DAOdepaServicio().agregarDepaServicio(lista)) {
//                System.out.println("Servicios agregados correctamente");
//            }
            for (Comuna dep : lista) {
                System.out.println(dep);
            }

//            Date fechaInicio = Date.valueOf("2023-10-02");
//            Date fechaFin = Date.valueOf("2023-10-05");
//            Cliente cli = new Cliente(12345, dv, nombre, apellido_paterno, apellido_materno, correo, usuario, contrasena, telefono);
//            int rut = 12345678;
//            System.out.println(new DAOcliente().obtenerClientePorRut(rut));
//            if (new DAOcliente().obtenerClientePorRut(rut)) {
//                System.out.println("Se agregó la reserva exitosamente");
//            } else {
//                System.out.println("No se agregó la reserva");
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
