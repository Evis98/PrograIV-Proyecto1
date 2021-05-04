package pagina.presentation.profesor.cursos;

import java.util.ArrayList;
import java.util.List;
import pagina.logica.Curso;
import pagina.logica.Grupo;
import pagina.logica.Notas;

/**
 * Proyecto 1 Estudiantes: Crystian Chininin Barrantes 115920081 Eva Durán
 * Escobar 117130031 Miguel Montero Arce 402440709
 *
 */
public class Model {

    List<Grupo> grupos;
    Grupo seleccionado;

    public Notas getCurrent() {
        return current;
    }

    public void setCurrent(Notas current) {
        this.current = current;
    }
    Notas current;

    public List<Notas> getNota() {
        return nota;
    }

    public void setNota(List<Notas> notas) {
        this.nota = notas;
    }
    List<Notas> nota;

    public Model() {
        this.reset();
    }

    public void reset() {

        List<Grupo> rows1 = new ArrayList<>();
        seleccionado = null;
        List<Notas> rows = new ArrayList<>();
        this.setNota(rows);
        this.setGrupos(rows1);
        this.current = new Notas(
                "",
                "",
                "",
                "",
                "", ""
        );

    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Grupo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Grupo seleccionado) {
        this.seleccionado = seleccionado;
    }
}
