/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package pagina.presentation.administrador.profesores.registro;

/**
 *
 * @author PC
 */




import pagina.logica.Profesor;



/**
 *
 * @author jsanchez
 */
public class Model {
    Profesor current;

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Profesor());        
    }
    
    public Profesor getCurrent() {
        return current;
    }

    public void setCurrent(Profesor current) {
        this.current = current;
    }
   
}