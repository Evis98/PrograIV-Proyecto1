package pagina.modelo.dao;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public enum IMEC_Estudiante {

    INSERTAR("INSERT INTO `matricula`.`estudiante`(`usuario_cedula`,`apellidos`, `nombre`,`telefono`,`mail`) "
            + "VALUES(?,?,?,?,?);"),
    CONSULTAR("SELECT * FROM estudiante WHERE usuario_cedula=?; "),
    UBI_ID("SELECT LAST_INSERT_ID() AS ID;"),
    LISTAR("SELECT * FROM estudiante ORDER BY usuario_cedula; ");

    IMEC_Estudiante(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
