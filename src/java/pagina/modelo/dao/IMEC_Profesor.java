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
public  enum IMEC_Profesor {
    
    INSERTAR("INSERT INTO `matricula`.`profesor`(`usuario_cedula`,`apellidos`, `nombre`,`mail`,`especialidad`) "
            + "VALUES(?,?,?,?,?);"),
   
    CONSULTAR("SELECT * FROM profesor WHERE usuario_cedula=?; "),
    UBI_ID("SELECT LAST_INSERT_ID() AS ID;"),
    LISTAR("SELECT * FROM profesor ORDER BY usuario_cedula; ");
    
    IMEC_Profesor(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
