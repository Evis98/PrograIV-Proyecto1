package pagina.presentation.administrador.cursos;

import java.util.ArrayList;
import java.util.List;
import pagina.logica.Curso;
import pagina.logica.Grupo;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public class Model {

    List<Curso> cursos;
    Curso seleccionado;
    List<Grupo> grupos;

    public Model() {
        this.reset();
    }

    public void reset() {
        List<Curso> rows = new ArrayList<>();
        List<Grupo> rows1 = new ArrayList<>();
        seleccionado = null;
        this.setCursos(rows);
        this.setGrupos(rows1);
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Curso> getCursos() {
        return cursos;
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
