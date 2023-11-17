package Clases;

public class DepaServicioSimple {

    private int id_servicio;
    private int id_depa;

    public DepaServicioSimple() {
    }

    public DepaServicioSimple(int id_servicio, int id_depa) {
        this.id_servicio = id_servicio;
        this.id_depa = id_depa;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_depa() {
        return id_depa;
    }

    public void setId_depa(int id_depa) {
        this.id_depa = id_depa;
    }

    @Override
    public String toString() {
        return "DepaServicioSimple{" + "id_servicio=" + id_servicio + ", id_depa=" + id_depa + '}';
    }

}
