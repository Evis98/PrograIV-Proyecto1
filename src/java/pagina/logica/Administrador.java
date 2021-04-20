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
    int id_administrador;
    String apellidos;
    String nombre;
    Usuario tipo_usuario;

    public Administrador() {
    }
    
    public Administrador(int id_administrador) {
    }

    public Administrador(int id_administrador, String apellidos, String nombre, Usuario tipo_usuario) {
        this.id_administrador = id_administrador;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.tipo_usuario = tipo_usuario;
    }
    
    public int getId_administrador() {
        return id_administrador;
    }
    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
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

    public Usuario getTipo_usuario() {
        return tipo_usuario;
    }
    public void setTipo_usuario(Usuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }   
}