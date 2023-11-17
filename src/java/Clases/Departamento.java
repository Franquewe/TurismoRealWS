package Clases;

import java.util.List;

public class Departamento {

    private int id_departamento;
    private String direccion;
    private String descripcion;
    private int precio;
    private float latitud;
    private float longitud;
    private int capacidad_persona;
    private int cantidad_img;
    private int habitaciones;
    private int id_comuna;
    private int id_estado;

    public Departamento() {
    }

    public Departamento(int id_departamento, String direccion, String descripcion, int precio, float latitud, float longitud, int capacidad_persona, int cantidad_img, int habitaciones, int id_comuna, int id_estado) {
        this.id_departamento = id_departamento;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.capacidad_persona = capacidad_persona;
        this.cantidad_img = cantidad_img;
        this.habitaciones = habitaciones;
        this.id_comuna = id_comuna;
        this.id_estado = id_estado;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public int getCapacidad_persona() {
        return capacidad_persona;
    }

    public void setCapacidad_persona(int capacidad_persona) {
        this.capacidad_persona = capacidad_persona;
    }

    public int getCantidad_img() {
        return cantidad_img;
    }

    public void setCantidad_img(int cantidad_img) {
        this.cantidad_img = cantidad_img;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    @Override
    public String toString() {
        return "Departamento{" + "id_departamento=" + id_departamento + ", direccion=" + direccion + ", descripcion=" + descripcion + ", precio=" + precio + ", latitud=" + latitud + ", longitud=" + longitud + ", capacidad_persona=" + capacidad_persona + ", cantidad_img=" + cantidad_img + ", habitaciones=" + habitaciones + ", id_comuna=" + id_comuna + ", id_estado=" + id_estado + '}';
    }
}
