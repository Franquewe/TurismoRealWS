package Clases;

public class Inventario {

    private int id_articulo;
    private int id_departamento;
    private int cantidad;
    private String nom_articulo;
    private int precio;

    public Inventario() {
    }

    public Inventario(int id_articulo, int id_departamento, int cantidad, String nom_articulo, int precio) {
        this.id_articulo = id_articulo;
        this.id_departamento = id_departamento;
        this.cantidad = cantidad;
        this.nom_articulo = nom_articulo;
        this.precio = precio;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNom_articulo() {
        return nom_articulo;
    }

    public void setNom_articulo(String nom_articulo) {
        this.nom_articulo = nom_articulo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id_articulo=" + id_articulo + ", id_departamento=" + id_departamento + ", cantidad=" + cantidad + ", nom_articulo=" + nom_articulo + ", precio=" + precio + '}';
    }

}
