package Clases;

import java.util.List;

public class DepartamentoDetalle {

    private int id_depa;
    private String direccion;
    private String descripcion;
    private int precio;
    private float latitud;
    private float longitud;
    private int cap_personas;
    private int cant_img;
    private int habitaciones;
    private int id_comuna;
    private int id_estado;
    private String desc_estado;
    private String nom_comuna;
    private List<Servicios> servicios;
    private List<Imagen> img;

    public DepartamentoDetalle() {
    }

    public DepartamentoDetalle(int id_depa, String direccion, String descripcion, int precio, float latitud, float longitud, int cap_personas, int cant_img, int habitaciones, int id_comuna, int id_estado, String desc_estado, String nom_comuna, List<Servicios> servicios, List<Imagen> img) {
        this.id_depa = id_depa;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.cap_personas = cap_personas;
        this.cant_img = cant_img;
        this.habitaciones = habitaciones;
        this.id_comuna = id_comuna;
        this.id_estado = id_estado;
        this.desc_estado = desc_estado;
        this.nom_comuna = nom_comuna;
        this.servicios = servicios;
        this.img = img;
    }

    public int getId_depa() {
        return id_depa;
    }

    public void setId_depa(int id_depa) {
        this.id_depa = id_depa;
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

    public int getCap_personas() {
        return cap_personas;
    }

    public void setCap_personas(int cap_personas) {
        this.cap_personas = cap_personas;
    }

    public int getCant_img() {
        return cant_img;
    }

    public void setCant_img(int cant_img) {
        this.cant_img = cant_img;
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

    public String getDesc_estado() {
        return desc_estado;
    }

    public void setDesc_estado(String desc_estado) {
        this.desc_estado = desc_estado;
    }

    public String getNom_comuna() {
        return nom_comuna;
    }

    public void setNom_comuna(String nom_comuna) {
        this.nom_comuna = nom_comuna;
    }

    public List<Servicios> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicios> servicios) {
        this.servicios = servicios;
    }

    public List<Imagen> getImg() {
        return img;
    }

    public void setImg(List<Imagen> img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "DepartamentoDetalle{" + "id_depa=" + id_depa + ", direccion=" + direccion + ", descripcion=" + descripcion + ", precio=" + precio + ", latitud=" + latitud + ", longitud=" + longitud + ", cap_personas=" + cap_personas + ", cant_img=" + cant_img + ", habitaciones=" + habitaciones + ", id_comuna=" + id_comuna + ", id_estado=" + id_estado + ", desc_estado=" + desc_estado + ", nom_comuna=" + nom_comuna + ", servicios=" + servicios + ", img=" + img + '}';
    }

}
