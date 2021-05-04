/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.modelo.dao;

/**
 *
 * @author PC
 */
public enum IMEC_Curso {
      INSERTAR("INSERT INTO `matricula`.`curso`(`id_curso`,`nombre`,`tematica`,`costo`,`enOferta`,`abierto`) VALUES(?,?,?,?,?,?);"),
     MODIFICAR("UPDATE curso SET enOferta=? WHERE id_curso=?; "),
//    EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
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
