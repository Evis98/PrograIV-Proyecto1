package pagina.modelo.dao;
/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public enum IMEC_Usuario {
    INSERTAR("INSERT INTO `matricula`.`usuario`(`cedula`,`clave`,`rol_fk`) VALUES(?,?,?);"),
    CONSULTAR("SELECT * FROM usuario WHERE cedula=?; "),
    LISTAR("SELECT * FROM usuario ORDER BY cedula; ");

    IMEC_Usuario(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
