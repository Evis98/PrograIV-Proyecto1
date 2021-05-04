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

//    public List<Notas> obtenerListaNotas(String id) {
//        List<Notas> r = new ArrayList<>();
//        try (Connection cnx = obtenerConexion();
//                Statement stm = cnx.createStatement();
//                ResultSet rs = stm.executeQuery(IMEC_Notas.LISTAR.obtenerComando())) {
//            while (rs.next()) {
//                Notas g = new Notas(
//                            rs.getString("id_grupo"),
//                            rs.getString("id_curso"),
//                            rs.getString("horario"),
//                            rs.getString("cedula_profesor")
//                );
//                if(g.getId_curso().equals(id)){
//                r.add(g);}
//            }
//        } catch (IOException
//                | ClassNotFoundException
//                | IllegalAccessException
//                | InstantiationException
//                | SQLException ex) {
//            System.err.printf("Excepción: '%s'%n", ex.getMessage());
//        }
//        return r;
//    }
    public List<Notas> obtenerListaNotasP(String id) {
        List<Notas> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Notas.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Notas g = new Notas(
                            rs.getString("id_grupo"),
                            rs.getString("cedula_estudiante"),
                            rs.getString("cedula_profesor"),
                            rs.getString("nota")
                );
                if(g.getId_profesor().equals(id)){
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

