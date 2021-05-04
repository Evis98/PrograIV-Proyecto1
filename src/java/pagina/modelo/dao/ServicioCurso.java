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

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */

public class ServicioCurso {

    public void modificarOferta(String id, Boolean oferta) {

        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_Curso.MODIFICAR.obtenerComando())) {
            stmt.clearParameters();
            stmt.setBoolean(1, oferta);
            stmt.setString(2, id);

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

    public void insertarCurso(Curso cur) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_Curso.INSERTAR.obtenerComando());) {

            // Creacion del Curso
            stmt.clearParameters();
            stmt.setString(1, cur.getId_curso());
            stmt.setString(2, cur.getNombre());
            stmt.setString(3, cur.getTematica());
            stmt.setString(4, cur.getCosto());
            stmt.setBoolean(5, cur.getEnOferta());
            stmt.setBoolean(6, cur.getAbierto());
            stmt.executeUpdate();

        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public Optional<Curso> obtenerCurso(String identificacion) {
        Optional<Curso> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Curso.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, identificacion);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Curso(
                            rs.getString("id_curso"),
                            rs.getString("nombre"),
                            rs.getString("tematica"),
                            rs.getString("costo"),
                            rs.getBoolean("enOferta"),
                            rs.getBoolean("abierto")
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

    public List<Curso> obtenerListaCursos() {
        List<Curso> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Curso.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Curso e = new Curso(
                        rs.getString("id_curso"),
                        rs.getString("nombre"),
                        rs.getString("tematica"),
                        rs.getString("costo"),
                        rs.getBoolean("enOferta"),
                        rs.getBoolean("abierto")
                );
                r.add(e);
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
