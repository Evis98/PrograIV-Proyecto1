
package pagina.logica;

import java.util.List;
import java.util.Objects;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public class Estudiante {
    String usuario_cedula;
    String apellidos;
    String nombre;
    String telefono;
    String mail;
    Usuario usuario;
    
    List<Curso> cursos;
    
    public Estudiante(){
    }
    public Estudiante(String cedula, String apellidos, String nombre, String telefono, String mail, Usuario usuario) {
        this.usuario_cedula = cedula;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.usuario = usuario;
    }

    
    public Estudiante(String cedula, String apellidos, String nombre, String telefono, String mail, Usuario usuario, List<Curso> cursos){
        this.usuario_cedula = cedula;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.usuario = usuario;
        this.cursos = cursos;
    }
   
    public String getUsuario_cedula() {
        return usuario_cedula;
    }
    public void setUsuario_cedula(String usuario_cedula) {
        this.usuario_cedula = usuario_cedula;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario id_usuario) {
        this.usuario = id_usuario;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
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
        final Estudiante other = (Estudiante) obj;
        if (!Objects.equals(this.usuario_cedula, other.usuario_cedula)) {
            return false;
        }
        return true;
    }
}