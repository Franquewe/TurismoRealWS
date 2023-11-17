package Clases;

import java.util.Date;

public class Mantenimiento {

    private int id_mantenimiento;
    private String desc_mantenimiento;
    private Date fecha_inicio;
    private Date fecha_termino;
    private int id_departamento;

    public Mantenimiento() {
    }

    public Mantenimiento(int id_mantenimiento, String desc_mantenimiento, Date fecha_inicio, Date fecha_termino, int id_departamento) {
        this.id_mantenimiento = id_mantenimiento;
        this.desc_mantenimiento = desc_mantenimiento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.id_departamento = id_departamento;
    }

    public int getId_mantenimiento() {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
    }

    public String getDesc_mantenimiento() {
        return desc_mantenimiento;
    }

    public void setDesc_mantenimiento(String desc_mantenimiento) {
        this.desc_mantenimiento = desc_mantenimiento;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    @Override
    public String toString() {
        return "Mantenimiento{" + "id_mantenimiento=" + id_mantenimiento + ", desc_mantenimiento=" + desc_mantenimiento + ", fecha_inicio=" + fecha_inicio + ", fecha_termino=" + fecha_termino + ", id_departamento=" + id_departamento + '}';
    }

}
