package pagina.presentation.administrador.cursos.registro;

import java.util.ArrayList;
import java.util.List;
import pagina.logica.Curso;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public class Model {

    Curso current;
    List<Curso> list;

    public Model() {
        this.reset();
    }

    public void reset() {
        List<Curso> rows = new ArrayList<>();
        this.setList(rows);
        setCurrent(new Curso());
    }

    public List<Curso> getList() {
        return list;
    }

    public void setList(List<Curso> list) {
        this.list = list;
    }

    public Curso getCurrent() {
        return current;
    }

    public void setCurrent(Curso current) {
        this.current = current;
    }

}
