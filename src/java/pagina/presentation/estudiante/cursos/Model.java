/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.estudiante.cursos;

import java.util.ArrayList;
import java.util.List;
import pagina.logica.Notas;

/**
 *
 * @author Ivan
 */
public class Model {
   List<Notas> cursos;
    Notas seleccionado;

    public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Notas> rows = new ArrayList<>();        
        seleccionado=null;  
        this.setCursos(rows);
    }
    
    public void setCursos(List<Notas> cursos){
        this.cursos = cursos;    
    }

     public List<Notas> getCursos() {
        return cursos;
    }

    public Notas getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Notas seleccionado) {
        this.seleccionado = seleccionado;
    } 
}
