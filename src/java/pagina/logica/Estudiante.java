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
public class Estudiante {
    int id_estudiante;
    String apellidos;
    String nombre;
    String telefono;
    String mail;
    Usuario tipo_usuario;
    Curso historial;
    
    public Estudiante(){
    }
    
    public Estudiante(int id_estudiante){
    }
    
    public Estudiante(int id_estudiante, String apellidos, String nombre, String telefono, String mail, Usuario tipo_usuario, Curso historial){
        this.id_estudiante = id_estudiante;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.tipo_usuario = tipo_usuario;
        this.historial = historial;
    }
   
    public int getId_estudiante() {
        return id_estudiante;
    }
    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public Usuario getTipo_usuario() {
        return tipo_usuario;
    }
    public void setTipo_usuario(Usuario id_usuario) {
        this.tipo_usuario = id_usuario;
    }

    public Curso getHistorial() {
        return historial;
    }
    public void setHistorial(Curso historial) {
        this.historial = historial;
    }  
}