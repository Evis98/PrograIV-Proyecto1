package pagina.presentation.administrador.datos;
import pagina.logica.Administrador;
import pagina.logica.Usuario;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public class Model{
    Administrador current;

    public Model() {
        this.current = new Administrador("","","",new Usuario("","",1));
    }

    
    public Administrador getCurrent() {
        return current;
    }

    public void setCurrent(Administrador current) {
        this.current = current;
    }
    
    
}

