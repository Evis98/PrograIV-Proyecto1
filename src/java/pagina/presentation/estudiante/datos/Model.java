/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.estudiante.datos;
import pagina.logica.Estudiante;
import pagina.logica.Usuario;

/**
 *
 * @author Escinf
 */
public class Model{
    Estudiante current;

    public Model() {
        this.current = new Estudiante("","","","","",new Usuario("","",1));
    }

    
    public Estudiante getCurrent() {
        return current;
    }

    public void setCurrent(Estudiante current) {
        this.current = current;
    }
    
    
}
