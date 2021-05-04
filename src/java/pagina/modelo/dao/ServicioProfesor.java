package pagina.modelo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import pagina.data.BaseDatos;
import pagina.logica.Profesor;

import pagina.logica.Usuario;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public class ServicioProfesor {
    public void insertarProfesor(Profesor prof) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_Profesor.INSERTAR.obtenerComando());
                PreparedStatement stmt2 = cnx.prepareStatement(IMEC_Usuario.INSERTAR.obtenerComando());) {

          

            // Creacion del Usuario
            stmt2.clearParameters();
            stmt2.setString(1, prof.getUsuario().getCedula());
            stmt2.setString(2, prof.getUsuario().getClave());
            stmt2.setInt(3, prof.getUsuario().getRol_fk());
            stmt2.executeUpdate();

           


            // Creacion del Profesor
            stmt.clearParameters();
            stmt.setString(1, prof.getUsuario().getCedula());
            stmt.setString(2, prof.getApellidos());
            stmt.setString(3, prof.getNombre());
            stmt.setString(4, prof.getMail());
            stmt.setString(5, prof.getEspecialidad());
            stmt.executeUpdate();

        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public Optional<Profesor> obtenerProfesor(String identificacion) {
        Optional<Profesor> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Profesor.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, identificacion);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    // Creacion del usuario para profesor
                    Optional<Usuario> user = Optional.empty();
                    PreparedStatement stm2 = cnx.prepareStatement(IMEC_Usuario.CONSULTAR.obtenerComando());
                    {
                        stm2.clearParameters();
                        stm2.setString(1, rs.getString("usuario_cedula"));
                        try (ResultSet rs2 = stm2.executeQuery()) {
                            if (rs2.next()) {
                                user = Optional.of(new Usuario(
                                        rs2.getString("cedula"),
                                        rs2.getString("clave"),
                                        rs2.getInt("rol_fk")
                                      
                                ));
                            }
                        }
                    }

                    

                    //Creacion del profesor
                    r = Optional.of(new Profesor(
                            rs.getString("usuario_cedula"),
                            rs.getString("apellidos"),
                            rs.getString("nombre"),
                            rs.getString("mail"),
                            rs.getString("especialidad"),
                            user.get()
                    ));
                }
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

    public List<Profesor> obtenerListaProfesores() {
        List<Profesor> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Profesor.LISTAR.obtenerComando())) {
            while (rs.next()) {

                // Creacion del usuario para proveedor
                Optional<Usuario> user = Optional.empty();
                PreparedStatement stm2 = cnx.prepareStatement(IMEC_Usuario.CONSULTAR.obtenerComando());
                {
                    stm2.clearParameters();
                    stm2.setString(1, rs.getString("usuario_cedula"));
                    try (ResultSet rs2 = stm2.executeQuery()) {
                        if (rs2.next()) {
                            user = Optional.of(new Usuario(
                                        rs2.getString("cedula"),
                                        rs2.getString("clave"),
                                        rs2.getInt("rol_fk")
                                      
                                ));
                        }
                    }
                }

                //Creacion del profesor
                    Profesor e = new Profesor(
                        
                        rs.getString("usuario_cedula"),
                            rs.getString("apellidos"),
                            rs.getString("nombre"),                            
                            rs.getString("mail"),
                            rs.getString("especialidad"),
                        user.get()
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
