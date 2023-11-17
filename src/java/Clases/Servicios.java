package Clases;

public class Servicios {

    private String nom_servicio;

    public Servicios() {
    }

    public Servicios(String nom_servicio) {
        this.nom_servicio = nom_servicio;
    }

    public String getNom_servicio() {
        return nom_servicio;
    }

    public void setNom_servicio(String nom_servicio) {
        this.nom_servicio = nom_servicio;
    }

    @Override
    public String toString() {
        return "Servicios{" + "nom_servicio=" + nom_servicio + '}';
    }

}
