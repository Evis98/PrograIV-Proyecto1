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
public enum IMEC_Notas {

    INSERTAR("INSERT INTO `matricula`.`notas`(`id_grupo`,`cedula_estudiante`,`cedula_profesor`,`nota`,`id_curso`,`horario`) VALUES(?,?,?,?,?,?);"),
    MODIFICAR("UPDATE notas SET nota=? WHERE id_grupo=? AND cedula_estudiante=?; "),     
//    EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
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