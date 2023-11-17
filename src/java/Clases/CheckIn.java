package Clases;

import java.util.Date;

public class CheckIn {

    private int id_check_in;
    private String hora;
    private Date fecha;
    private String firma_cliente;
    private int pago_cliente;
    private int id_reserva;
    private int funcionario_rut;

    public CheckIn() {
    }

    public CheckIn(int id_check_in, String hora, Date fecha, String firma_cliente, int pago_cliente, int id_reserva, int funcionario_rut) {
        this.id_check_in = id_check_in;
        this.hora = hora;
        this.fecha = fecha;
        this.firma_cliente = firma_cliente;
        this.pago_cliente = pago_cliente;
        this.id_reserva = id_reserva;
        this.funcionario_rut = funcionario_rut;
    }

    public int getId_check_in() {
        return id_check_in;
    }

    public void setId_check_in(int id_check_in) {
        this.id_check_in = id_check_in;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFirma_cliente() {
        return firma_cliente;
    }

    public void setFirma_cliente(String firma_cliente) {
        this.firma_cliente = firma_cliente;
    }

    public int getPago_cliente() {
        return pago_cliente;
    }

    public void setPago_cliente(int pego_cliente) {
        this.pago_cliente = pago_cliente;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getFuncionario_rut() {
        return funcionario_rut;
    }

    public void setFuncionario_rut(int funcionario_rut) {
        this.funcionario_rut = funcionario_rut;
    }

    @Override
    public String toString() {
        return "CheckIn{" + "id_check_in=" + id_check_in + ", hora=" + hora + ", fecha=" + fecha + ", firma_cliente=" + firma_cliente + ", pago_cliente=" + pago_cliente + ", id_reserva=" + id_reserva + ", funcionario_rut=" + funcionario_rut + '}';
    }

}
