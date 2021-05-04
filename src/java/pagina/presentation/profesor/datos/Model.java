package pagina.presentation.profesor.datos;
import pagina.logica.Profesor;
import pagina.logica.Usuario;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public class Model {

    Profesor current;

    public Model() {
        this.current = new Profesor("", "", "", "", "", new Usuario("", "", 1));
    }

    public Profesor getCurrent() {
        return current;
    }

    public void setCurrent(Profesor current) {
        this.current = current;
    }

}
