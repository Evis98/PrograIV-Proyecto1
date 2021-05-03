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


import java.util.ArrayList;
import java.util.List;
import pagina.logica.Curso;



/**
 *
 * @author jsanchez
 */
public class Model {
 Curso current;
    List<Curso> list;

    public Model() {
        this.reset();
    }

    public void reset() {
        List<Curso> rows = new ArrayList<>();
        this.setList(rows);
        setCurrent(new Curso());
    }

    public List<Curso> getList() {
        return list;
    }

    public void setList(List<Curso> list) {
        this.list = list;
    }

    public Curso getCurrent() {
        return current;
    }

    public void setCurrent(Curso current) {
        this.current = current;
    }
   
}
