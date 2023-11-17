package Clases;

public class Articulo {

    private int id_articulo;
    private String descripcion;
    private int stock;
    private int precio;

    public Articulo() {
    }

    public Articulo(int id_articulo, String descripcion, int stock, int precio) {
        this.id_articulo = id_articulo;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id_articulo=" + id_articulo + ", descripcion=" + descripcion + ", stock=" + stock + ", precio=" + precio + '}';
    }

}
