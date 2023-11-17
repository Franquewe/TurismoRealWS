package Clases;

public class Transporte {

    private int id_transporte;
    private String nom_empresa;
    private String horario;
    private String patente;
    private int tarifa_adicional;
    private int rut_chofer;

    public Transporte() {
    }

    public Transporte(int id_transporte, String nom_empresa, String horario, String patente, int tarifa_adicional, int rut_chofer) {
        this.id_transporte = id_transporte;
        this.nom_empresa = nom_empresa;
        this.horario = horario;
        this.patente = patente;
        this.tarifa_adicional = tarifa_adicional;
        this.rut_chofer = rut_chofer;
    }

    public int getId_transporte() {
        return id_transporte;
    }

    public void setId_transporte(int id_transporte) {
        this.id_transporte = id_transporte;
    }

    public String getNom_empresa() {
        return nom_empresa;
    }

    public void setNom_empresa(String nom_empresa) {
        this.nom_empresa = nom_empresa;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getTarifa_adicional() {
        return tarifa_adicional;
    }

    public void setTarifa_adicional(int tarifa_adicional) {
        this.tarifa_adicional = tarifa_adicional;
    }

    public int getRut_chofer() {
        return rut_chofer;
    }

    public void setRut_chofer(int rut_chofer) {
        this.rut_chofer = rut_chofer;
    }

    @Override
    public String toString() {
        return "Transporte{" + "id_transporte=" + id_transporte + ", nom_empresa=" + nom_empresa + ", horario=" + horario + ", patente=" + patente + ", tarifa_adicional=" + tarifa_adicional + ", rut_chofer=" + rut_chofer + '}';
    }

}
