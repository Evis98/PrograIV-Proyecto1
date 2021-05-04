package pagina.presentation.estudiante.cursos;

import java.util.ArrayList;
import java.util.List;
import pagina.logica.Notas;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public class Model {

    List<Notas> cursos;
    Notas seleccionado;

    public Model() {
        this.reset();
    }

    public void reset() {
        List<Notas> rows = new ArrayList<>();
        seleccionado = null;
        this.setCursos(rows);
    }

    public void setCursos(List<Notas> cursos) {
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
