package pagina.modelo.dao;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public enum IMEC_Grupo {
    INSERTAR("INSERT INTO `matricula`.`grupo`(`id_grupo`,`id_curso`,`horario`,`cedula_profesor`) VALUES(?,?,?,?);"),
    CONSULTAR("SELECT * FROM grupo WHERE id_grupo=?; "),
    LISTAR("SELECT * FROM grupo ORDER BY id_curso; "),
    LISTARP("SELECT * FROM grupo ORDER BY cedula_profesor; ");

    IMEC_Grupo(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
