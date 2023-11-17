package Clases;

public class Tour {

    private int id_tour;
    private String nombre_servicio;
    private String descripcion;
    private String destino;
    private int tarifa_adicional;

    public Tour() {
    }

    public Tour(int id_tour, String nombre_servicio, String descripcion, String destino, int tarifa_adicional) {
        this.id_tour = id_tour;
        this.nombre_servicio = nombre_servicio;
        this.descripcion = descripcion;
        this.destino = destino;
        this.tarifa_adicional = tarifa_adicional;
    }

    public int getId_tour() {
        return id_tour;
    }

    public void setId_tour(int id_tour) {
        this.id_tour = id_tour;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTarifa_adicional() {
        return tarifa_adicional;
    }

    public void setTarifa_adicional(int tarifa_adicional) {
        this.tarifa_adicional = tarifa_adicional;
    }

    @Override
    public String toString() {
        return "Tour{" + "id_tour=" + id_tour + ", nombre_servicio=" + nombre_servicio + ", descripcion=" + descripcion + ", destino=" + destino + ", tarifa_adicional=" + tarifa_adicional + '}';
    }

}
