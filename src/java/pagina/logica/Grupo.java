package pagina.logica;

/**
 * Proyecto 1 Estudiantes: Crystian Chininin Barrantes 115920081 Eva Durán
 * Escobar 117130031 Miguel Montero Arce 402440709
 *
 */
public class Grupo {

    String id_grupo;
    String id_curso;
    String horario;
    String profesor_de_curso;

    public Grupo() {
    }

    public Grupo(String horario, String profesorDeCurso) {
        this.horario = horario;
        this.profesor_de_curso = profesorDeCurso;
    }
    public Grupo(String id_grupo, String id_curso_de_grupo, String horario, String profesor_de_curso) {
        this.id_grupo = id_grupo;
        this.id_curso = id_curso_de_grupo;
        this.horario = horario;
        this.profesor_de_curso = profesor_de_curso;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getProfesor_de_curso() {
        return profesor_de_curso;
    }

    public void setProfesor_de_curso(String profesor_de_curso) {
        this.profesor_de_curso = profesor_de_curso;
    }
}
