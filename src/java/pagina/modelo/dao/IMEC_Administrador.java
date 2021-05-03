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
