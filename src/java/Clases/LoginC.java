package Clases;

public class LoginC {

    private int rut;
    private String usuario;
    private String contrasena;
    private String tipo_usuario;

    public LoginC() {
    }

    public LoginC(int rut, String usuario, String contrasena, String tipo_usuario) {
        this.rut = rut;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo_usuario = tipo_usuario;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    @Override
    public String toString() {
        return "Login{" + "rut=" + rut + ", usuario=" + usuario + ", contrasena=" + contrasena + ", tipo_usuario=" + tipo_usuario + '}';
    }

}
