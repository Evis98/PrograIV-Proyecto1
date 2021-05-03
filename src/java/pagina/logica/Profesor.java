/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ivan
 */
public class Profesor {
    String usuario_cedula;
    String apellidos;
    String nombre;
    String mail;
    String especialidad;
    Usuario usuario;

    
    List<Grupo> grupos_a_cargo;
    List<Curso> cursos_a_cargo;
    
    
    public Profesor(String cedula, String apellidos,String nombre, String mail, String especialidad,Usuario usuario) {
        this.usuario_cedula = cedula;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.mail = mail;
        this.especialidad = especialidad;
        this.usuario = usuario;
        grupos_a_cargo = new ArrayList();
        cursos_a_cargo = new ArrayList();
    }
    
    public Profesor(String cedula, String nombre, Usuario usuario) {
        this.usuario_cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
                grupos_a_cargo = new ArrayList();
        cursos_a_cargo = new ArrayList();
    }
    public Profesor() {
        this.usuario_cedula = "";
        this.apellidos = "";
        this.nombre = "";
        this.mail = "";
        this.especialidad = "";
        this.usuario = new Usuario();
        grupos_a_cargo = new ArrayList();
        cursos_a_cargo = new ArrayList();
    }
    
    public Profesor(int id_profesor){
    }
     public Profesor(String nombre){
         this.nombre = nombre;
    }
    
    public Profesor(String cedula, String apellidos, String nombre, String mail, String especialidad, Usuario usuario, List<Grupo> grupos_a_cargo, List<Curso> cursos_a_cargo) {
        this.usuario_cedula = cedula;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.mail = mail;
        this.especialidad = especialidad;
        this.usuario = usuario;
        this.grupos_a_cargo = grupos_a_cargo;
        this.cursos_a_cargo = cursos_a_cargo;
    }
 public Usuario getUsuario() {
        return usuario;
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

    public List<Grupo> getGrupos_a_cargo() {
        return grupos_a_cargo;
    }

    public void setGrupos_a_cargo(List<Grupo> grupos_a_cargo) {
        this.grupos_a_cargo = grupos_a_cargo;
    }

    public List<Curso> getCursos_a_cargo() {
        return cursos_a_cargo;
    }

    public void setCursos_a_cargo(List<Curso> cursos_a_cargo) {
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
        if (!Objects.equals(this.usuario_cedula, other.usuario_cedula)) {
            return false;
        }
        return true;
    }
}
