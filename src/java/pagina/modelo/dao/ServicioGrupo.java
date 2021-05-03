/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.modelo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pagina.data.BaseDatos;
import pagina.logica.Curso;
import pagina.logica.Grupo;

/**
 *
 * @author PC
 */
public class ServicioGrupo {
    public List<Grupo> obtenerListaGrupos(String id) {
        List<Grupo> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Grupo.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Grupo g = new Grupo(
                            rs.getString("id_grupo"),
                            rs.getString("id_curso"),
                            rs.getString("horario"),
                            rs.getString("cedula_profesor")
                );
                if(g.getId_curso().equals(id)){
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
    public List<Grupo> obtenerListaGruposP(String id) {
        List<Grupo> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Grupo.LISTARP.obtenerComando())) {
            while (rs.next()) {
                Grupo g = new Grupo(
                            rs.getString("id_grupo"),
                            rs.getString("id_curso"),
                            rs.getString("horario"),
                            rs.getString("cedula_profesor")
                );
                if(g.getProfesor_de_curso().equals(id)){
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
}
