/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.profesor.cursos;

import java.util.ArrayList;
import java.util.List;
import pagina.logica.Curso;
import pagina.logica.Grupo;

/**
 *
 * @author Ivan
 */
public class Model {

   List<Grupo> grupos;
    Curso seleccionado;

    public Model() {
        this.reset();
    }

    public void reset(){ 
    
        List<Grupo> rows1 = new ArrayList<>();
        seleccionado=null;  

        this.setGrupos(rows1);
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    

    public Curso getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Curso seleccionado) {
        this.seleccionado = seleccionado;
    } 
}
