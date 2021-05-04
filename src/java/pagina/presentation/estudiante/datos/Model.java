package pagina.presentation.estudiante.datos;
import pagina.logica.Estudiante;
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

    Estudiante current;

    public Model() {
        this.current = new Estudiante("", "", "", "", "", new Usuario("", "", 1));
    }

    public Estudiante getCurrent() {
        return current;
    }

    public void setCurrent(Estudiante current) {
        this.current = current;
    }


}
