/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.registro;

/**
 *
 * @author PC
 */


import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import pagina.logica.Estudiante;


/**
 *
 * @author jsanchez
 */
public class Model {
    Estudiante current;
    String clave;
    Random random;

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Estudiante());
        random = new Random();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String generaClave() {
        return String.format("%04d", random.nextInt(10000));
    }
    
    public Estudiante getCurrent() {
        return current;
    }

    public void setCurrent(Estudiante current) {
        this.current = current;
    }
   
}
