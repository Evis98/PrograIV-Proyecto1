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
import java.util.Optional;
import pagina.data.BaseDatos;
import pagina.logica.Estudiante;
import pagina.logica.Usuario;

/**
 *
 * @author PC
 */
public class ServicioEstudiante {

   
    public void insertarEstudiante(Estudiante est) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_Estudiante.INSERTAR.obtenerComando());
                PreparedStatement stmt2 = cnx.prepareStatement(IMEC_Usuario.INSERTAR.obtenerComando());) {

          

            // Creacion del Usuario
            stmt2.clearParameters();
            stmt2.setString(1, est.getUsuario().getCedula());
            stmt2.setString(2, est.getUsuario().getClave());
            stmt2.setInt(3, est.getUsuario().getRol_fk());
            stmt2.executeUpdate();

           


            // Creacion del Proveedor
            stmt.clearParameters();
            stmt.setString(1, est.getUsuario().getCedula());
            stmt.setString(2, est.getApellidos());
            stmt.setString(3, est.getNombre());
            stmt.setString(4, est.getTelefono());
            stmt.setString(5, est.getMail());
            stmt.executeUpdate();

        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public Optional<Estudiante> obtenerEstudiante(String identificacion) {
        Optional<Estudiante> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Estudiante.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, identificacion);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
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

                    

                    //Creacion del proveedor
                    r = Optional.of(new Estudiante(
                            rs.getString("usuario_cedula"),
                            rs.getString("apellidos"),
                            rs.getString("nombre"),
                            rs.getString("telefono"),
                            rs.getString("mail"),
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

    public List<Estudiante> obtenerListaEstudiantes() {
        List<Estudiante> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Estudiante.LISTAR.obtenerComando())) {
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

                //Creacion del proveedor
                Estudiante e = new Estudiante(
                        
                        rs.getString("usuario_cedula"),
                            rs.getString("apellidos"),
                            rs.getString("nombre"),
                            rs.getString("telefono"),
                            rs.getString("mail"),
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
