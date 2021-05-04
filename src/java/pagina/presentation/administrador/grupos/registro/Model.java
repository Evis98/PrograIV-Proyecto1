package pagina.presentation.administrador.grupos.registro;

import java.util.ArrayList;
import java.util.List;
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

    Grupo current;
    List<Grupo> list;

    public Model() {
        this.reset();
    }

    public void reset() {
        List<Grupo> rows = new ArrayList<>();
        this.setList(rows);
        setCurrent(new Grupo());
    }

    public List<Grupo> getList() {
        return list;
    }

    public void setList(List<Grupo> list) {
        this.list = list;
    }

    public Grupo getCurrent() {
        return current;
    }

    public void setCurrent(Grupo current) {
        this.current = current;
    }
}
