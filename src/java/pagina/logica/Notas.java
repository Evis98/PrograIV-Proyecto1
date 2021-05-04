package pagina.logica;

/**
 * Proyecto 1 Estudiantes: Crystian Chininin Barrantes 115920081 Eva Durán
 * Escobar 117130031 Miguel Montero Arce 402440709
 *
 */
public class Notas {

    String id_estudiante;
    String id_grupo;
    String nota;
    String id_profesor;
    String id_curso;
    String horario;

    public Notas() {
        id_estudiante = "";
        id_grupo = "";
        nota = "";
        id_profesor = "";
        id_curso = "";
        horario = "";
    }

    public Notas(String id_estudiante, String id_grupo, String nota, String id_profesor, String id_curso, String horario) {
        this.id_estudiante = id_estudiante;
        this.id_grupo = id_grupo;
        this.nota = nota;
        this.id_profesor = id_profesor;
        this.id_curso = id_curso;
        this.horario = horario;
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

    public String getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(String id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public Notas(String id_estudiante, String id_curso, String nota, String id_profesor) {
        this.id_estudiante = id_estudiante;
        this.id_grupo = id_curso;
        this.nota = nota;
        this.id_profesor = id_profesor;
    }
    
    @Override
    public String toString() {
        return " Id: " + id_estudiante + "      Grupo: " + id_grupo + "      Nota: " + nota + "      Profesor: " + id_profesor + "      Curso: " + id_curso + "      Horario: " + horario + '\n';
    }

}
