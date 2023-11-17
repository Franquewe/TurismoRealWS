package Clases;

import java.util.Date;

public class CheckOut {

    private int id_check_out;
    private String hora;
    private Date fecha;
    private int multas;
    private int pago_cliente;
    private String firma_cliente;
    private int id_reserva;
    private int funcionario_rut;

    public CheckOut() {
    }

    public CheckOut(int id_check_out, String hora, Date fecha, int multas, int pago_cliente, String firma_cliente, int id_reserva, int funcionario_rut) {
        this.id_check_out = id_check_out;
        this.hora = hora;
        this.fecha = fecha;
        this.multas = multas;
        this.pago_cliente = pago_cliente;
        this.firma_cliente = firma_cliente;
        this.id_reserva = id_reserva;
        this.funcionario_rut = funcionario_rut;
    }

    public int getId_check_out() {
        return id_check_out;
    }

    public void setId_check_out(int id_check_out) {
        this.id_check_out = id_check_out;
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

    public int getMultas() {
        return multas;
    }

    public void setMultas(int multas) {
        this.multas = multas;
    }

    public int getPago_cliente() {
        return pago_cliente;
    }

    public void setPago_cliente(int pago_cliente) {
        this.pago_cliente = pago_cliente;
    }

    public String getFirma_cliente() {
        return firma_cliente;
    }

    public void setFirma_cliente(String firma_cliente) {
        this.firma_cliente = firma_cliente;
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
        return "CheckOut{" + "id_check_out=" + id_check_out + ", hora=" + hora + ", fecha=" + fecha + ", multas=" + multas + ", pago_cliente=" + pago_cliente + ", firma_cliente=" + firma_cliente + ", id_reserva=" + id_reserva + ", funcionario_rut=" + funcionario_rut + '}';
    }

}
