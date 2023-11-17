package Clases;

import java.util.Date;

public class Reserva {

    private int id_reserva;
    private Date inicio_reserva;
    private Date termino_reserva;
    private int cant_personas;
    private int monto_total;
    private int monto_abonado;
    private int id_departamento;
    private int cliente_rut;
    private int id_estado;
    private String nom_estado;

    public Reserva() {
    }

    public Reserva(int id_reserva, Date inicio_reserva, Date termino_reserva, int cant_personas, int monto_total, int monto_abonado, int id_departamento, int cliente_rut, int id_estado, String nom_estado) {
        this.id_reserva = id_reserva;
        this.inicio_reserva = inicio_reserva;
        this.termino_reserva = termino_reserva;
        this.cant_personas = cant_personas;
        this.monto_total = monto_total;
        this.monto_abonado = monto_abonado;
        this.id_departamento = id_departamento;
        this.cliente_rut = cliente_rut;
        this.id_estado = id_estado;
        this.nom_estado = nom_estado;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getInicio_reserva() {
        return inicio_reserva;
    }

    public void setInicio_reserva(Date inicio_reserva) {
        this.inicio_reserva = inicio_reserva;
    }

    public Date getTermino_reserva() {
        return termino_reserva;
    }

    public void setTermino_reserva(Date termino_reserva) {
        this.termino_reserva = termino_reserva;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public int getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(int monto_total) {
        this.monto_total = monto_total;
    }

    public int getMonto_abonado() {
        return monto_abonado;
    }

    public void setMonto_abonado(int monto_abonado) {
        this.monto_abonado = monto_abonado;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getCliente_rut() {
        return cliente_rut;
    }

    public void setCliente_rut(int cliente_rut) {
        this.cliente_rut = cliente_rut;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNom_estado() {
        return nom_estado;
    }

    public void setNom_estado(String nom_estado) {
        this.nom_estado = nom_estado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id_reserva=" + id_reserva + ", inicio_reserva=" + inicio_reserva + ", termino_reserva=" + termino_reserva + ", cant_personas=" + cant_personas + ", monto_total=" + monto_total + ", monto_abonado=" + monto_abonado + ", id_departamento=" + id_departamento + ", cliente_rut=" + cliente_rut + ", id_estado=" + id_estado + ", nom_estado=" + nom_estado + '}';
    }

}
