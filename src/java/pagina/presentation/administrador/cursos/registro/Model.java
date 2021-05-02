/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package pagina.presentation.administrador.cursos.registro;

/**
 *
 * @author PC
 */


import pagina.logica.Curso;



/**
 *
 * @author jsanchez
 */
public class Model {
    Curso current;

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Curso());        
    }
    
    public Curso getCurrent() {
        return current;
    }

    public void setCurrent(Curso current) {
        this.current = current;
    }
   
}
