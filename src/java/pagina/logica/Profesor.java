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
public class Profesor {
    String cedula;
    String apellidos;
    String nombre;
    String mail;
    String especialidad;
    Usuario usuario;

    
    Grupo grupos_a_cargo;
    Curso cursos_a_cargo;
    
    
    public Profesor(String cedula, String apellidos,String nombre, String mail, String especialidad,Usuario usuario) {
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.mail = mail;
        this.especialidad = especialidad;
        this.usuario = usuario;
    }
    
    public Profesor(String cedula, String nombre, Usuario usuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
    }
    public Profesor() {
    }
    
    public Profesor(int id_profesor){
    }
    
    public Profesor(String cedula, String apellidos, String nombre, String mail, String especialidad, Usuario usuario, Grupo grupos_a_cargo, Curso cursos_a_cargo) {
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.mail = mail;
        this.especialidad = especialidad;
        this.usuario = usuario;
        this.grupos_a_cargo = grupos_a_cargo;
        this.cursos_a_cargo = cursos_a_cargo;
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
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Usuario usuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Grupo getGrupos_a_cargo() {
        return grupos_a_cargo;
    }
    public void setGrupos_a_cargo(Grupo grupos_a_cargo) {
        this.grupos_a_cargo = grupos_a_cargo;
    }

    public Curso getCursos_a_cargo() {
        return cursos_a_cargo;
    }
    public void setCursos_a_cargo(Curso cursos_a_cargo) {
        this.cursos_a_cargo = cursos_a_cargo;
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
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }
}
