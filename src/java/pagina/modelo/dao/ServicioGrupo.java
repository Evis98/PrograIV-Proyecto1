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
import pagina.logica.Curso;
import pagina.logica.Grupo;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */

public class ServicioGrupo {
    
    
    public void insertarGrupo(Grupo gru) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_Grupo.INSERTAR.obtenerComando());
              ) {

          

            // Creacion del Grupo
            stmt.clearParameters();
            stmt.setString(1, gru.getId_grupo());
            stmt.setString(2, gru.getId_curso());
            stmt.setString(3, gru.getHorario());
            stmt.setString(4, gru.getProfesor_de_curso());
            stmt.executeUpdate();

        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepci贸n: '%s'%n", ex.getMessage());
        }
    }
    
    public Optional<Grupo> obtenerGrupo(String identificacion) {
        Optional<Grupo> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Grupo.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, identificacion);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Grupo(
                       rs.getString("id_grupo"),
                            rs.getString("id_curso"),
                            rs.getString("horario"),
                            rs.getString("cedula_profesor")

                    ));
                }
            }
        } catch (IOException
                | NoSuchElementException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }
    
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
