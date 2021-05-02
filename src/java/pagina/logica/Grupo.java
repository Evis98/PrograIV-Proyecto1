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
    int id_curso;
    String horario;
    Profesor profesor_de_curso;

    public Grupo() {
    }
    
    public Grupo(String horario, Profesor profesorDeCurso) {
        this.horario = horario;
        this.profesor_de_curso = profesorDeCurso;
    }
    
        public Grupo(String horario, int id) {
        this.horario = horario;
        this.id_grupo = id;
    }

    public Grupo(int id_grupo, int id_curso_de_grupo, String horario, Profesor profesor_de_curso) {
        this.id_grupo = id_grupo;
        this.id_curso = id_curso_de_grupo;
        this.horario = horario;
        this.profesor_de_curso = profesor_de_curso;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
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
