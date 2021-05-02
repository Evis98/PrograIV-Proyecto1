/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.administrador.profesores;

import java.util.ArrayList;
import java.util.List;
import pagina.logica.Profesor;

/**
 *
 * @author Ivan
 */
public class Model {
   List<Profesor> profesores;
    Profesor seleccionado;

    public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Profesor> rows = new ArrayList<>();        
        seleccionado=null;  
        this.setProfesores(rows);
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Profesor getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Profesor seleccionado) {
        this.seleccionado = seleccionado;
    }
}
    
