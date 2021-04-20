package banca.logic;

import java.util.Objects;

public class User  implements java.io.Serializable {


     private String cedula;
     private String clave;
     private Integer tipo;


    public User() {
    }

	
    public User(String cedula) {
        this.cedula = cedula;
    }
    public User(String cedula, String clave, Integer tipo) {
       this.cedula = cedula;
       this.clave = clave;
       this.tipo = tipo;
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
    public Integer getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }
    
    

}


