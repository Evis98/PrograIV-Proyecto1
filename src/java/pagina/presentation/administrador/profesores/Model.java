package pagina.presentation.administrador.profesores;

import java.util.ArrayList;
import java.util.List;
import pagina.logica.Profesor;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public class Model {

    List<Profesor> profesores;
    Profesor seleccionado;

    public Model() {
        this.reset();
    }

    public void reset() {
        List<Profesor> rows = new ArrayList<>();
        seleccionado = null;
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
