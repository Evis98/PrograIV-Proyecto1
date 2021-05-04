package pagina.modelo.dao;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public enum IMEC_Profesor {

    INSERTAR("INSERT INTO `matricula`.`profesor`(`usuario_cedula`,`apellidos`, `nombre`,`mail`,`especialidad`) "
            + "VALUES(?,?,?,?,?);"),
    CONSULTAR("SELECT * FROM profesor WHERE usuario_cedula=?; "),
    UBI_ID("SELECT LAST_INSERT_ID() AS ID;"),
    LISTAR("SELECT * FROM profesor ORDER BY usuario_cedula; ");

    IMEC_Profesor(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
