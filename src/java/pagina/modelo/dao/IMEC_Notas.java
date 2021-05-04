package pagina.modelo.dao;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public enum IMEC_Notas {

    INSERTAR("INSERT INTO `matricula`.`notas`(`id_grupo`,`cedula_estudiante`,`cedula_profesor`,`nota`,`id_curso`,`horario`) VALUES(?,?,?,?,?,?);"),
    MODIFICAR("UPDATE notas SET nota=? WHERE id_grupo=? AND cedula_estudiante=?; "),
    CONSULTAR("SELECT * FROM notas WHERE cedula_profesor=?; "),
    LISTAR("SELECT * FROM notas ORDER BY cedula_profesor; "),
    LISTARP("SELECT * FROM notas ORDER BY cedula_profesor; ");

    IMEC_Notas(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
