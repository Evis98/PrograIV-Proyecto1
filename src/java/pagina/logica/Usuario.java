/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.logica;

import java.util.List;
import java.util.Objects;

public class Usuario  implements java.io.Serializable {


     private String cedula;
     private String clave;
     private Integer rol_fk;

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", clave=" + clave + ", tipo=" + rol_fk + '}';
    }
    
    public Usuario() {
    }

	
    public Usuario(String cedula) {
        this.cedula = cedula;
    }
    public Usuario(String cedula, String clave, Integer tipo) {
       this.cedula = cedula;
       this.clave = clave;
       this.rol_fk = tipo;
      
    }

    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public Integer getRol_fk() {
        return this.rol_fk;
    }
    
    public void setRol_fk(Integer rol_fk) {
        this.rol_fk = rol_fk;
    }
}