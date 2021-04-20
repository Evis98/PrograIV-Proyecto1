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
public class Curso {
    int id_curso;
    String nombre;
    String tematica;
    String costo;
    boolean enOferta;
    boolean abierto;

    public Curso() {
    }
    
    public Curso(int id_curso) {
    }
        
    public Curso(int id_curso, String nombre, String tematica, String costo, boolean enOferta, boolean abierto) {
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.tematica = tematica;
        this.costo = costo;
        this.enOferta = enOferta;
        this.abierto = abierto;
        
    }
    
    public int getId_curso() {
        return id_curso;
    }
    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
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
    public void setEnOferta(boolean enOferta) {
        this.enOferta = enOferta;
    }

    public boolean isAbierto() {
        return abierto;
    }
    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }
}
