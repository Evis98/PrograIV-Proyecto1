/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.logica;

import java.util.Objects;

/**
 *
 * @author Ivan
 */
public class Estudiante {
    String cedula;
    String apellidos;
    String nombre;
    String telefono;
    String mail;
    Usuario usuario;
    Curso historial;
    
    public Estudiante(){
    }
    
    public Estudiante(String cedula, String nombre, Usuario usuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
    }
    
    public Estudiante(String cedula, String apellidos, String nombre, String telefono, String mail, Usuario usuario, Curso historial){
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.usuario = usuario;
        this.historial = historial;
    }
   
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario id_usuario) {
        this.usuario = id_usuario;
    }

    public Curso getHistorial() {
        return historial;
    }
    public void setHistorial(Curso historial) {
        this.historial = historial;
    }  
        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }
}