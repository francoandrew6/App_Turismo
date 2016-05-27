package org.emmanuel.app_turismo.bean;

/**
 * Created by ACE on 26/05/2016.
 */
public class Usuario {
    private Integer id_Usuario;
    private String nombre;
    private String correo;
    private String nick;
    private String contraseña;
    private String direccion;
    private Integer telefono;
    private Integer id_Rol;
    private String token;
    private String exp;

    public Usuario() {
    }

    public Usuario(Integer id_Usuario, String nombre, String correo, String nick, String contraseña, String direccion, Integer telefono, Integer id_Rol, String token, String exp) {
        this.id_Usuario = id_Usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.nick = nick;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_Rol = id_Rol;
        this.token = token;
        this.exp = exp;
    }

    public Integer getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Integer id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(Integer id_Rol) {
        this.id_Rol = id_Rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
