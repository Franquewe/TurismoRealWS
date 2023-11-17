package Clases;

public class Imagen {

    private String ruta;

    public Imagen() {
    }

    public Imagen(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Imagen{" + "ruta=" + ruta + '}';
    }

}
