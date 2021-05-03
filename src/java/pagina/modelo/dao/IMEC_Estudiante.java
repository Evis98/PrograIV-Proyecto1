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


