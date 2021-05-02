/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.logica;

/**
 *
 * @author Ivan
 */
public class Administrador {
    String usuario_cedula;
    String apellidos;
    String nombre;
    Usuario usuario;

    public Administrador() {
    }
    
    public Administrador(String cedula, String apellidos, String nombre, Usuario usuario) {
        this.usuario_cedula = cedula;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.usuario = usuario;
    }
    
     public Administrador(String cedula, String nombre, Usuario usuario) {
        this.usuario_cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
    }
    
    public String getUsuario_cedula() {
        return usuario_cedula;
    }
    public void setUsuario_cedula(String usuario_cedula) {
        this.usuario_cedula = usuario_cedula;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   
}