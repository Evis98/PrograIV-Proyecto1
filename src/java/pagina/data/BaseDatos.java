package pagina.data;

/**
 *  Proyecto 1
 *  Estudiantes:
 *  Crystian Chininin Barrantes 115920081
 *  Eva Durán Escobar 117130031
 *  Miguel Montero Arce 402440709
 * 
 */

import cr.ac.database.managers.DBManager;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class BaseDatos {

    // <editor-fold defaultstate="collapsed" desc="constructores">
    private BaseDatos()
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException {
        configuracion = new Properties();
        try {
            configuracion.load(getClass().getResourceAsStream(ARCHIVO_CONFIGURACION));
            try {
                configuracion.setProperty("useSSL", "false");
                bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER,
                        configuracion.getProperty("server_url"));
                
            } catch (IOException
                    | ClassNotFoundException
                    | IllegalAccessException
                    | InstantiationException ex) {
                System.err.println("No se pudo cargar el manejador de la base de datos..");
                System.err.printf("Excepción: '%s'%n", ex.getMessage());
                throw ex;
            }
        } catch (IOException ex) {
            System.err.println("No se pudo leer el archivo de configuración..");
            throw ex;
        }
    }

    public static BaseDatos obtenerInstancia() {
        if (instancia == null) {
            try {
                instancia = new BaseDatos();
            } catch (IOException
                    | ClassNotFoundException
                    | IllegalAccessException
                    | InstantiationException ex) {
                System.err.printf("Excepción: '%s'%n", ex.getMessage());
            }
        }
        return instancia;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="métodos">
    public Connection obtenerConexion()
            throws SQLException {
        return bd.getConnection(
                configuracion.getProperty("database"),
                configuracion.getProperty("user"),
                configuracion.getProperty("password")
        );
    }

    public void cerrarConexion() {
        bd.closeConnection();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SINGLETON">
    private static BaseDatos instancia = null;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="atributos BD">
    private static final String ARCHIVO_CONFIGURACION = "bd.properties";
    private final Properties configuracion;
    private DBManager bd;
    // </editor-fold>
}
