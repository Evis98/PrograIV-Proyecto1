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
public enum IMEC_Grupo {
      INSERTAR("INSERT INTO `matricula`.`grupo`(`id_grupo`,`id_curso`,`horario`,`cedula_profesor`) VALUES(?,?,?,?);"),
//    MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
//    EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
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
