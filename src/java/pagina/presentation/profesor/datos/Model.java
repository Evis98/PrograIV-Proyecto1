/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.profesor.datos;
import pagina.logica.Profesor;
import pagina.logica.Usuario;

/**
 *
 * @author PC
 */

public class Model{
    Profesor current;

    public Model() {
        this.current = new Profesor("","",new Usuario("","",1));
    }

    
    public Profesor getCurrent() {
        return current;
    }

    public void setCurrent(Profesor current) {
        this.current = current;
    }
    
    
}
