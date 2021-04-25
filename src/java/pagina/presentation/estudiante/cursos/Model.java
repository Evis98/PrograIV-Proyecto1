/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.estudiante.cursos;

import java.util.ArrayList;
import java.util.List;
import pagina.logica.Curso;

/**
 *
 * @author Ivan
 */
public class Model {
   List<Curso> cursos;
    Curso seleccionado;

    public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Curso> rows = new ArrayList<>();        
        seleccionado=null;  
        this.setCursos(rows);
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
