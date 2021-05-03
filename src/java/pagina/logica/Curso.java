/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class Curso {
    String id_curso;
    String nombre;
    String tematica;
    String costo;
    boolean enOferta;
    boolean abierto;
    Usuario usuario;
    List<Grupo> grupos;

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    List<Usuario> estudiantes;

    public Curso() {
        this.id_curso = "";
        this.nombre = "";
        this.tematica = "";
        this.costo = "";
        this.enOferta = true;
        this.abierto = true;
        this.usuario = new Usuario();
        this.estudiantes = new ArrayList();
        this.grupos = new ArrayList();
    }
    
    public Curso(int id_curso) {
    }
        
    public Curso(String id_curso, String nombre, String tematica, String costo, boolean enOferta, boolean abierto, Usuario usuario, List<Usuario> estudiantes) {
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.tematica = tematica;
        this.costo = costo;
        this.enOferta = enOferta;
        this.abierto = abierto;
        this.usuario = usuario;
        this.estudiantes = estudiantes;
        this.grupos = new ArrayList();
        
    }

    public Curso(String id_curso, String nombre, String tematica, String costo, boolean enOferta, boolean abierto, Usuario usuario) {
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.tematica = tematica;
        this.costo = costo;
        this.enOferta = enOferta;
        this.abierto = abierto;
        this.usuario = usuario;
        this.grupos = new ArrayList();
    }
    public Curso(String id_curso, String nombre, String tematica, String costo, boolean enOferta, boolean abierto) {
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.tematica = tematica;
        this.costo = costo;
        this.enOferta = enOferta;
        this.abierto = abierto;
        this.estudiantes = new ArrayList();
        this.grupos = new ArrayList();
    }
     public String getId_curso() {
        return id_curso;
    }
    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }
    public Boolean getEnOferta(){
        return enOferta;
    }
     public Boolean getAbierto(){
        return abierto;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTematica() {
        return tematica;
    }
    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getCosto() {
        return costo;
    }
    public void setCosto(String costo) {
        this.costo = costo;
    }

    public boolean isEnOferta() {
        return enOferta;
    }
    public void setEnOferta(String enOferta) {
        if(enOferta == "1"){
        this.enOferta = true;
        }
        if(enOferta == "2"){
        this.enOferta = false;
        }
    }

    public boolean isAbierto() {
        return abierto;
    }
    public void setAbierto(String abierto) {
        if(abierto == "1"){
        this.abierto = true;
        }
        if(abierto == "2"){
        this.abierto = false;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    public List<Usuario> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Usuario> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
}
