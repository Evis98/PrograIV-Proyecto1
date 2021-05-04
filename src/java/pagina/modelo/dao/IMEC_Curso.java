package pagina.modelo.dao;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public enum IMEC_Curso {
    INSERTAR("INSERT INTO `matricula`.`curso`(`id_curso`,`nombre`,`tematica`,`costo`,`enOferta`,`abierto`) VALUES(?,?,?,?,?,?);"),
    MODIFICAR("UPDATE curso SET enOferta=? WHERE id_curso=?; "),
    CONSULTAR("SELECT * FROM curso WHERE id_curso=?; "),
    LISTAR("SELECT * FROM curso ORDER BY id_curso; ");

    IMEC_Curso(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
