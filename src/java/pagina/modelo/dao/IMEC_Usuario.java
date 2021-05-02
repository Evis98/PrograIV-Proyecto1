package pagina.modelo.dao;

public enum IMEC_Usuario {
    INSERTAR("INSERT INTO `matricula`.`usuario`(`cedula`,`clave`,`rol_fk`) VALUES(?,?,?);"),
//    MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
//    EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
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
