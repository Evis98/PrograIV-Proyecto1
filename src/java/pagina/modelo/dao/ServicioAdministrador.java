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
import pagina.logica.Administrador;
import pagina.logica.Usuario;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */
public class ServicioAdministrador {

    public void insertarAdministrador(Administrador adm) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_Administrador.INSERTAR.obtenerComando());
                PreparedStatement stmt2 = cnx.prepareStatement(IMEC_Usuario.INSERTAR.obtenerComando());) {

            // Creacion del Usuario
            stmt2.clearParameters();
            stmt2.setString(1, adm.getUsuario().getCedula());
            stmt2.setString(2, adm.getUsuario().getClave());
            stmt2.setInt(4, adm.getUsuario().getRol_fk());
            stmt2.executeUpdate();

            // Creacion del Administrador
            stmt.clearParameters();
            stmt.setString(1, adm.getUsuario().getCedula());
            stmt.setString(2, adm.getApellidos());
            stmt.setString(3, adm.getNombre());
            stmt.executeUpdate();

        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public Optional<Administrador> obtenerAdministrador(String identificacion) {
        Optional<Administrador> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Administrador.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, identificacion);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    // Creacion del usuario para administrador
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

                    //Creacion del administrador
                    r = Optional.of(new Administrador(
                            rs.getString("usuario_cedula"),
                            rs.getString("apellidos"),
                            rs.getString("nombre"),
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

    public List<Administrador> obtenerListaAdministrador() {
        List<Administrador> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Administrador.LISTAR.obtenerComando())) {
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

                //Creacion del administrador
                Administrador e = new Administrador(
                        rs.getString("usuario_cedula"),
                        rs.getString("apellidos"),
                        rs.getString("nombre"),
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
