package Clases;

public class DepaServicio {

    private int id_servicio;
    private int id_depa;
    private String nom_servicio;

    public DepaServicio() {
    }

    public DepaServicio(int id_servicio, int id_depa, String nom_servicio) {
        this.id_servicio = id_servicio;
        this.id_depa = id_depa;
        this.nom_servicio = nom_servicio;
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

    public String getNom_servicio() {
        return nom_servicio;
    }

    public void setNom_servicio(String nom_servicio) {
        this.nom_servicio = nom_servicio;
    }

    @Override
    public String toString() {
        return "DepaServicio{" + "id_servicio=" + id_servicio + ", id_depa=" + id_depa + ", nom_servicio=" + nom_servicio + '}';
    }

}
