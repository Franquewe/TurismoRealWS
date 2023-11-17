package Clases;

public class ReservaTrans {

    private int id_transporte;
    private int id_reserva;
    private int cantidad;
    private int pago_cliente;
    private String patente;

    public ReservaTrans() {
    }

    public ReservaTrans(int id_transporte, int id_reserva, int cantidad, int pago_cliente, String patente) {
        this.id_transporte = id_transporte;
        this.id_reserva = id_reserva;
        this.cantidad = cantidad;
        this.pago_cliente = pago_cliente;
        this.patente = patente;
    }

    public int getId_transporte() {
        return id_transporte;
    }

    public void setId_transporte(int id_transporte) {
        this.id_transporte = id_transporte;
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

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "ReservaTrans{" + "id_transporte=" + id_transporte + ", id_reserva=" + id_reserva + ", cantidad=" + cantidad + ", pago_cliente=" + pago_cliente + ", patente=" + patente + '}';
    }

}
