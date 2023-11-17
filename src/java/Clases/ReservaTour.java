package Clases;

public class ReservaTour {

    private int id_tour;
    private int id_reserva;
    private int cantidad;
    private int pago_cliente;
    private String nom_servicio;

    public ReservaTour() {
    }

    public ReservaTour(int id_tour, int id_reserva, int cantidad, int pago_cliente, String nom_servicio) {
        this.id_tour = id_tour;
        this.id_reserva = id_reserva;
        this.cantidad = cantidad;
        this.pago_cliente = pago_cliente;
        this.nom_servicio = nom_servicio;
    }

    public int getId_tour() {
        return id_tour;
    }

    public void setId_tour(int id_tour) {
        this.id_tour = id_tour;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPago_cliente() {
        return pago_cliente;
    }

    public void setPago_cliente(int pago_cliente) {
        this.pago_cliente = pago_cliente;
    }

    public String getNom_servicio() {
        return nom_servicio;
    }

    public void setNom_servicio(String nom_servicio) {
        this.nom_servicio = nom_servicio;
    }

    @Override
    public String toString() {
        return "ReservaTour{" + "id_tour=" + id_tour + ", id_reserva=" + id_reserva + ", cantidad=" + cantidad + ", pago_cliente=" + pago_cliente + ", nom_servicio=" + nom_servicio + '}';
    }
    
}
