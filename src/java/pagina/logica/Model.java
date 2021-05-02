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
import pagina.modelo.dao.ServicioUsuario;

/**
 *
 * @author PC
 */
public class Model {
     private static Model uniqueInstance;
    private final ServicioUsuario servUsuario;
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
    }


    public ServicioUsuario getServUsuario() {
        return servUsuario;
    }

/*
    private static Model uniqueInstance;
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance; 
    }

    private final ServicioUsuario servUsuario;


    public static Model getUniqueInstance() {
        return uniqueInstance;
    }

    public static void setUniqueInstance(Model uniqueInstance) {
        Model.uniqueInstance = uniqueInstance;
    }




    public ServicioUsuario getServUsuario() {
        return servUsuario;
    }
    
    HashMap<String,Usuario> usuarios;
    HashMap<String,Grupo> grupos;
    HashMap<String,Estudiante> estudiantes;
    HashMap<String,Profesor> profesores;
    HashMap<String,Administrador> administradores;
    HashMap<String,Curso> cursos;
    
    List<Usuario> list;
//    HashMap<String,Cuenta> cuentas;
//    HashMap<String,List<String>> favoritas;
    
    
    public Model(){
        this.servUsuario = new ServicioUsuario();
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
    }
//        cuentas = new HashMap(); 
//        cuentas.put("1-111-11", new Cuenta("1-111-11",100.0,clientes.get("111")));
//        cuentas.put("1-222-22", new Cuenta("1-222-22",200.0,clientes.get("111")));        
//        cuentas.put("2-111-11", new Cuenta("2-111-11",150.0,clientes.get("222")));
//
//        //HashMap<String,List<String>> favoritas;
//        favoritas = new HashMap(); 
//        favoritas.put("111", Arrays.asList(new String[]{"2-111-11"}));
//        favoritas.put("222", Arrays.asList(new String[]{"1-111-11","1-222-22"}));
//    }**/

    public Usuario usuarioFind(String cedula,String clave) throws Exception{
        if (usuarios.get(cedula)!=null) return usuarios.get(cedula);
        else throw new Exception("Usuario no existe");
    }

    public Estudiante estudianteFind(Usuario usuario) throws Exception{
        if (estudiantes.get(usuario.getCedula())!=null) return estudiantes.get(usuario.getCedula());
        else throw new Exception("Estudiante no existe");
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
            if(c.getUsuario().getCedula().equals(estudiante.getCedula())){
                result.add(c);
            }
        }
        return result;
    }
    
        public List<Curso> cursosFind(Profesor profesor) throws Exception{
        List<Curso> result = new ArrayList();
        for(Curso c: cursos.values()){
            if(c.getUsuario().getCedula().equals(profesor.getCedula())){
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
        if (profesores.get(profesor.getCedula())==null) profesores.put(profesor.getCedula(), profesor);
        else throw new Exception("Profesor ya existe");
    }
    
      public void estudianteAdd (Estudiante estudiante) throws Exception{
        if (estudiantes.get(estudiante.getCedula())==null) estudiantes.put(estudiante.getCedula(), estudiante);
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
        if (estudiantes.get(estudiante.getCedula())==null) 
            throw new Exception("Estudiante no existe");
        else{
            estudiantes.get(estudiante.getCedula()).setNombre(estudiante.getNombre());
        }
    }
    
    public void profesorUpdate(Profesor profesor) throws Exception{
        if (profesores.get(profesor.getCedula())==null) 
            throw new Exception("Profesor no existe");
        else{
            profesores.get(profesor.getCedula()).setNombre(profesor.getNombre());
        }
    }
        
    public void administradorUpdate(Administrador administrador) throws Exception{
        if (administradores.get(administrador.getCedula())==null) 
            throw new Exception("Administrador no existe");
        else{
            administradores.get(administrador.getCedula()).setNombre(administrador.getNombre());
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

