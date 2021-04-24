/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.administrador.datos;


import pagina.logica.Administrador;
import pagina.logica.Usuario;

/**
 *
 * @author PC
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

