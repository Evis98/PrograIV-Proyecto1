/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.administrador.grupos.registro;

import java.util.ArrayList;
import java.util.List;
import pagina.logica.Grupo;

/**
 *
 * @author Ivan
 */
public class Model {
    Grupo current;
    List<Grupo> list;

    public Model() {
        this.reset();
    }

    public void reset() {
        List<Grupo> rows = new ArrayList<>();
        this.setList(rows);
        setCurrent(new Grupo());
    }

    public List<Grupo> getList() {
        return list;
    }

    public void setList(List<Grupo> list) {
        this.list = list;
    }

    public Grupo getCurrent() {
        return current;
    }

    public void setCurrent(Grupo current) {
        this.current = current;
    }
}