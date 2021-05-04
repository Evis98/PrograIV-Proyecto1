
package pagina.presentation.administrador.profesores.registro;

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

    Profesor current;

    public Model() {
        this.reset();
    }

    public void reset() {
        setCurrent(new Profesor());
    }

    public Profesor getCurrent() {
        return current;
    }

    public void setCurrent(Profesor current) {
        this.current = current;
    }

}
