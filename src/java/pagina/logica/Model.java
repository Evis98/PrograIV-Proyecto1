/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.logica;
import pagina.logica.Usuario;
import pagina.logica.Estudiante;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import pagina.modelo.dao.ServicioAdministrador;
import pagina.modelo.dao.ServicioCurso;
import pagina.modelo.dao.ServicioEstudiante;
import pagina.modelo.dao.ServicioGrupo;
import pagina.modelo.dao.ServicioNotas;
import pagina.modelo.dao.ServicioProfesor;
import pagina.modelo.dao.ServicioUsuario;

/**
 *
 * @author PC
 */
public class Model {
    
     private final ServicioUsuario servUsuario;
    private final ServicioEstudiante servEstudiante;
    private final ServicioProfesor servProfesor;
    private final ServicioAdministrador servAdministrador; 
    private final ServicioCurso servCurso; 
    private final ServicioGrupo servGrupo;
     private static Model uniqueInstance;
     private final ServicioNotas servNotas;



    public static Model getUniqueInstance() {
        return uniqueInstance;
    }

    public static void setUniqueInstance(Model uniqueInstance) {
        Model.uniqueInstance = uniqueInstance;
    }

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    public Model() {
         this.servUsuario = new ServicioUsuario();
        this.servEstudiante = new ServicioEstudiante();
        this.servProfesor = new ServicioProfesor();
        this.servAdministrador = new ServicioAdministrador();
        this.servCurso = new ServicioCurso();
        this.servGrupo = new ServicioGrupo();
        this.servNotas = new ServicioNotas();

        
    }

    public ServicioNotas getServNotas() {
        return servNotas;
    }

    public ServicioGrupo getServGrupo() {
        return servGrupo;
    }
    
public ServicioUsuario getServUsuario() {
        return servUsuario;
    }

    public ServicioEstudiante getServEstudiante() {
        return servEstudiante;
    }

    public ServicioProfesor getServProfesor() {
        return servProfesor;
    }

    public ServicioAdministrador getServAdministrador() {
        return servAdministrador;
    }

    public ServicioCurso getServCurso() {
        return servCurso;
    }

   
}


