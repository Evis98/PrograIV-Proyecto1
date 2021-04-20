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
public class Profesor {
    int id_profesor;
    String apellidos;
    String nombre;
    String mail;
    String especialidad;
    Usuario tipo_usuario;
    Grupo grupos_a_cargo;
    Curso cursos_a_cargo;
    
    public Profesor() {
    }
    
    public Profesor(int id_profesor){
    }
    
    public Profesor(int id_profesor, String apellidos, String nombre, String mail, String especialidad, Usuario tipo_usuario, Grupo grupos_a_cargo, Curso cursos_a_cargo) {
        this.id_profesor = id_profesor;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.mail = mail;
        this.especialidad = especialidad;
        this.tipo_usuario = tipo_usuario;
        this.grupos_a_cargo = grupos_a_cargo;
        this.cursos_a_cargo = cursos_a_cargo;
    }
    
    public int getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
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

    public Usuario getTipo_usuario() {
        return tipo_usuario;
    }
    public void setTipo_usuario(Usuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
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
}
