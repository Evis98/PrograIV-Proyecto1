/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation;

import java.util.ArrayList;
import java.util.List;
import pagina.logica.Curso;
import pagina.logica.Grupo;
import pagina.logica.Notas;

/**
 *
 * @author Ivan
 */
public class Model {
   List<Curso> cursos;
   List<Grupo> grupos;
    Curso seleccionado;
    Notas notaS;

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Curso> rows = new ArrayList<>();
        List<Grupo> rows1 = new ArrayList<>();     
        seleccionado=null;  
        setNotaS(new Notas());
        this.setCursos(rows);
        this.setGrupos(rows1);
    }

    public Notas getNotaS() {
        return notaS;
    }

    public void setNotaS(Notas notaS) {
        this.notaS = notaS;
    }
    
    
    public void setCursos(List<Curso> cursos){
        this.cursos = cursos;    
    }

     public List<Curso> getCursos() {
        return cursos;
    }

    public Curso getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Curso seleccionado) {
        this.seleccionado = seleccionado;
    } 
}
