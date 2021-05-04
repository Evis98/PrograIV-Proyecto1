package pagina.modelo.dao;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public enum IMEC_Administrador {
    
    INSERTAR("INSERT INTO `matricula`.`administrador`(`usuario_cedula`,`apellidos`, `nombre`) "
            + "VALUES(?,?,?);"),
    CONSULTAR("SELECT * FROM administrador WHERE usuario_cedula=?; "),
    UBI_ID("SELECT LAST_INSERT_ID() AS ID;"),
    LISTAR("SELECT * FROM administrador ORDER BY usuario_cedula; ");
    
    IMEC_Administrador(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
