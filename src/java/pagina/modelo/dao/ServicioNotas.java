/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.modelo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import pagina.data.BaseDatos;
import pagina.logica.Notas;

/**
 *
 * @author PC
 */
public class ServicioNotas {


    public void modificarNotas(String idG,String idE,String nota) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_Notas.MODIFICAR.obtenerComando())) {
            stmt.clearParameters();

             stmt.setString(1,nota);
            stmt.setString(2, idG);
            stmt.setString(3, idE);


            stmt.executeUpdate();
            System.out.println(stmt);
             stmt.executeUpdate();
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
public List<Notas> obtenerListaNotasG(String id) {
        List<Notas> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Notas.LISTAR.obtenerComando())) {
            while (rs.next()) {
                
//                (String id_estudiante, String id_grupo, String nota, String id_profesor, String id_curso, String horario)
                Notas g = new Notas(
                        rs.getString("cedula_estudiante"),
                            rs.getString("id_grupo"),
                            rs.getString("nota"),
                            rs.getString("cedula_profesor"),
                            
                        rs.getString("id_curso"),
                        rs.getString("horario")
                );
                if(g.getId_grupo().equals(id)){
                r.add(g);}
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }
     public List<Notas> obtenerNotas(String id) {
        List<Notas> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Notas.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Notas g = new Notas(
                            rs.getString("cedula_estudiante"),
                            rs.getString("id_grupo"),
                            rs.getString("nota"),
                            rs.getString("cedula_profesor"),
                            rs.getString("id_curso"),
                            rs.getString("horario")
                );
                if(g.getId_estudiante().equals(id)){
                r.add(g);}
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }
    
    public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        BaseDatos bd = BaseDatos.obtenerInstancia();
        Connection cnx = bd.obtenerConexion();
        return cnx;
    }
    
     public void insertarNota(Notas nota) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_Notas.INSERTAR.obtenerComando());
              ) {

          
//INSERTAR("INSERT INTO matricula.notas(id_grupo,cedula_estudiante,cedula_profesor,nota,id_curso,horario) VALUES(?,?,?,?,?,?);"),
            // Creacion del Proveedor
            stmt.clearParameters();
            stmt.setString(1, nota.getId_grupo());
            stmt.setString(2, nota.getId_estudiante());
            stmt.setString(3, nota.getId_profesor());
            stmt.setString(4, nota.getNota());
            stmt.setString(5, nota.getId_curso());
            stmt.setString(6, nota.getHorario());
            stmt.executeUpdate();

        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
}

