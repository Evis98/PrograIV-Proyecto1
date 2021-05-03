/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.logica;
import pagina.logica.Usuario;
import pagina.logica.Estudiante;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import pagina.modelo.dao.ServicioAdministrador;
import pagina.modelo.dao.ServicioCurso;
import pagina.modelo.dao.ServicioEstudiante;
import pagina.modelo.dao.ServicioGrupo;
import pagina.modelo.dao.ServicioProfesor;
import pagina.modelo.dao.ServicioUsuario;

/**
 *
 * @author PC
 */
public class Model {
    
     private final ServicioUsuario servUsuario;
    private final ServicioEstudiante servEstudiante;
    private final ServicioProfesor servProfesor;
    private final ServicioAdministrador servAdministrador; 
    private final ServicioCurso servCurso; 
    private final ServicioGrupo servGrupo;
     private static Model uniqueInstance;
        HashMap<String,Usuario> usuarios;
    HashMap<String,Grupo> grupos;
    HashMap<String,Estudiante> estudiantes;
    HashMap<String,Profesor> profesores;
    HashMap<String,Administrador> administradores;
    HashMap<String,Curso> cursos;
    
    List<Usuario> list;


    public static Model getUniqueInstance() {
        return uniqueInstance;
    }

    public static void setUniqueInstance(Model uniqueInstance) {
        Model.uniqueInstance = uniqueInstance;
    }

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    public Model() {
         this.servUsuario = new ServicioUsuario();
        this.servEstudiante = new ServicioEstudiante();
        this.servProfesor = new ServicioProfesor();
        this.servAdministrador = new ServicioAdministrador();
        this.servCurso = new ServicioCurso();
        this.servGrupo = new ServicioGrupo();
        usuarios = new HashMap();
        usuarios.put("111", new Usuario("111","111",1));
        usuarios.put("222", new Usuario("222","222",2));
        usuarios.put("333", new Usuario("333","333",3));
        usuarios.put("444", new Usuario("444","444",1));
    
        estudiantes = new HashMap(); 
//      
        estudiantes.put("111", new Estudiante("111","Perez","Jose","86291832","jperez@gmail.com",usuarios.get("111")));
        estudiantes.put("444", new Estudiante("444","Hernandez","Pedro","87293619","phernand@gmail.com",usuarios.get("444")));
//        estudiantes.put("222", new Estudiante("222","B.Banner",usuarios.get("222")));
//        estudiantes.put("333", new Estudiante("333","L.Kjero",usuarios.get("333")));
        
        profesores = new HashMap(); 
//        profesores.put("111", new Profesor("111","J.Perez",usuarios.get("111")));
        profesores.put("222", new Profesor("222","Banner","Victor","Bbanner@gmail.com","Filosofia",usuarios.get("222")));
//        profesores.put("333", new Profesor("333","L.Kjero",usuarios.get("333")));


        administradores = new HashMap();
        administradores.put("333",new Administrador("333","Kjero","Luis",usuarios.get("333")));
        
        cursos = new HashMap(); 
        cursos.put("1-111-11", new Curso("1-111-11","Vegetales_1","Cocina", "100000", true, true, usuarios.get("111")));
        cursos.put("2-222-22", new Curso("2-222-22","Vegetales_2","Cocina", "100000", true, true, usuarios.get("111")));
        cursos.put("3-333-33", new Curso("3-333-33","Vegetales_3","Cocina", "100000", true, true, usuarios.get("111")));
        cursos.put("4-444-44", new Curso("4-444-44","Frutas_1","Cocina", "100000", true, true, usuarios.get("111")));
        cursos.put("5-555-55", new Curso("5-555-55","Frutas_2","Cocina", "100000", true, true, usuarios.get("111")));
        cursos.put("6-666-66", new Curso("6-666-66","Frutas_3","Cocina", "100000", true, true, usuarios.get("111")));
        
         List<Grupo> grupos1 = new ArrayList();
        /* Grupo g1 = new Grupo("08:00 am", new Profesor("Jose Sanchez"));
         Grupo g2 = new Grupo("10:00 am", new Profesor("Jose Sanchez"));
         Grupo g3 = new Grupo("1:00 pm", new Profesor("Georges"));
        grupos1.add(g1);
        grupos1.add(g2);
        grupos1.add(g3);*/
        
        cursos.get("1-111-11").grupos= grupos1;
        
          List<Grupo> grupos2 = new ArrayList();
      /*   Grupo g4 = new Grupo("08:00 am", new Profesor("Majid"));
         Grupo g5 = new Grupo("10:00 am", new Profesor("Majid"));
         Grupo g6 = new Grupo("1:00 pm", new Profesor("Jose"));
        grupos2.add(g4);
        grupos2.add(g5);
        grupos2.add(g6);*/
        
        cursos.get("2-222-22").grupos= grupos2;
        
    }

    public ServicioGrupo getServGrupo() {
        return servGrupo;
    }
    
public ServicioUsuario getServUsuario() {
        return servUsuario;
    }

    public ServicioEstudiante getServEstudiante() {
        return servEstudiante;
    }

    public ServicioProfesor getServProfesor() {
        return servProfesor;
    }

    public ServicioAdministrador getServAdministrador() {
        return servAdministrador;
    }

    public ServicioCurso getServCurso() {
        return servCurso;
    }

   public Usuario usuarioFind(String cedula,String clave) throws Exception{
        if (usuarios.get(cedula)!=null) return usuarios.get(cedula);
        else throw new Exception("Usuario no existe");
    }

    public Estudiante estudianteFind(Usuario usuario) throws Exception{
        if (estudiantes.get(usuario.getCedula())!=null) return estudiantes.get(usuario.getCedula());
        else throw new Exception("Estudiante no existe");
    }
    public Curso getCurso(String id) {
        if (cursos.get(id)!=null) return cursos.get(id);
        else{
        return new Curso();
        }
    }
    
    
        
    
    public Profesor profesorFind(Usuario usuario) throws Exception{
        if (profesores.get(usuario.getCedula())!=null) return profesores.get(usuario.getCedula());
        else throw new Exception("Profesor no existe");
    }      
    
    public Administrador administradorFind(Usuario usuario) throws Exception{
        if (administradores.get(usuario.getCedula())!=null) return administradores.get(usuario.getCedula());
        else throw new Exception("Administrador no existe");
    } 
    
    public List<Curso> cursosFind(Estudiante estudiante) throws Exception{
        List<Curso> result = new ArrayList();
        for(Curso c: cursos.values()){
            if(c.getUsuario().getCedula().equals(estudiante.getUsuario_cedula())){
                result.add(c);
            }
        }
        return result;
    }
    
        public List<Curso> cursosFind(Profesor profesor) throws Exception{
        List<Curso> result = new ArrayList();
        for(Curso c: cursos.values()){
            if(c.getUsuario().getCedula().equals(profesor.getUsuario_cedula())){
                result.add(c);
            }
        }
        return result;
    }
//---------------Administrador Cursos---------------------------
//    public void cursosAdd (Curso curso) throws Exception{
//        if (cursos.get(curso.getId_curso())==null) cursos.put(curso.getId_curso(), curso);
//        else throw new Exception("Curso ya existe");
//    }
//    
   public List<Curso> cursosList(){
        return new ArrayList<>(cursos.values());
   }
//  
//    public Curso cursosGet(String id_curso)throws Exception{
//        if (cursos.get(id_curso)!=null) return cursos.get(id_curso);
//        else throw new Exception("Curso no existe");
//    }
    
//---------------Administrador Profesores---------------------------
    public void profesoresAdd (Profesor profesor) throws Exception{
        if (profesores.get(profesor.getUsuario_cedula())==null) profesores.put(profesor.getUsuario_cedula(), profesor);
        else throw new Exception("Profesor ya existe");
    }
    
      public void estudianteAdd (Estudiante estudiante) throws Exception{
        if (estudiantes.get(estudiante.getUsuario_cedula())==null) estudiantes.put(estudiante.getUsuario_cedula(), estudiante);
        else throw new Exception("Estudiante ya existe");
    }
      
          
      public void cursoAdd (Curso curso) throws Exception{
        if (cursos.get(curso.getId_curso())==null) cursos.put(curso.getId_curso(), curso);
        else throw new Exception("Curso ya existe");
    }
          public void usuarioAdd (Usuario usuario) throws Exception{
        if (usuarios.get(usuario.getCedula())==null) usuarios.put(usuario.getCedula(), usuario);
        else throw new Exception("usuario ya existe");
    }
    public List<Profesor> profesoresList(){
        return new ArrayList<>(profesores.values());
    }
  
    public Profesor profesoresGet(String cedula)throws Exception{
        if (profesores.get(cedula)!=null) return profesores.get(cedula);
        else throw new Exception("Profesor no existe");
    }
    
//    public List<Cuenta> cuentasFind(Cliente cliente) throws Exception{
//        List<Cuenta> result = new ArrayList();
//        for(Cuenta c: cuentas.values()){
//            if(c.getCliente().equals(cliente)){
//                result.add(c);
//            }
//        }
//        return result;
//    }
//    
//    public List<Cuenta> favoritasFind(Cliente cliente) throws Exception{
//        List<Cuenta> result = new ArrayList();
//        for(String nc: favoritas.get(cliente.getCedula())){
//                result.add(cuentas.get(nc));
//        }
//        return result;
//    }
//
    public void estudianteUpdate(Estudiante estudiante) throws Exception{
        if (estudiantes.get(estudiante.getUsuario_cedula())==null) 
            throw new Exception("Estudiante no existe");
        else{
            estudiantes.get(estudiante.getUsuario_cedula()).setNombre(estudiante.getNombre());
        }
    }
    
    public void profesorUpdate(Profesor profesor) throws Exception{
        if (profesores.get(profesor.getUsuario_cedula())==null) 
            throw new Exception("Profesor no existe");
        else{
            profesores.get(profesor.getUsuario_cedula()).setNombre(profesor.getNombre());
        }
    }
        
    public void administradorUpdate(Administrador administrador) throws Exception{
        if (administradores.get(administrador.getUsuario_cedula())==null) 
            throw new Exception("Administrador no existe");
        else{
            administradores.get(administrador.getUsuario_cedula()).setNombre(administrador.getNombre());
        }
    }
          
    public void cursoUpdate(Curso curso) throws Exception{
        if (cursos.get(curso.getId_curso())==null) 
            throw new Exception("Estudiante no existe");
        else{
            cursos.get(curso.getId_curso()).setNombre(curso.getNombre());
        }
    }
    
    

//    
//    public Cuenta cuentaFind(String numero) throws Exception{
//        if (cuentas.get(numero)!=null) return cuentas.get(numero);
//        else throw new Exception("Cuenta no existe");
//    }  

}


