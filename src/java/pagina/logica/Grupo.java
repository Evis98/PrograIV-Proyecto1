/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.logica;

/**
 *
 * @author Ivan
 */
public class Grupo {
    int id_grupo;
    int id_curso_de_grupo;
    String horario;
    Profesor profesor_de_curso;

    public Grupo() {
    }
    
    public Grupo(int id_grupo) {
    }

    public Grupo(int id_grupo, int id_curso_de_grupo, String horario, Profesor profesor_de_curso) {
        this.id_grupo = id_grupo;
        this.id_curso_de_grupo = id_curso_de_grupo;
        this.horario = horario;
        this.profesor_de_curso = profesor_de_curso;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getId_curso_de_grupo() {
        return id_curso_de_grupo;
    }

    public void setId_curso_de_grupo(int id_curso_de_grupo) {
        this.id_curso_de_grupo = id_curso_de_grupo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Profesor getProfesor_de_curso() {
        return profesor_de_curso;
    }

    public void setProfesor_de_curso(Profesor profesor_de_curso) {
        this.profesor_de_curso = profesor_de_curso;
    }
}
