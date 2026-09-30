package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión a la base de datos MySQL.
 * 
 * @author jssa3
 */
public class Conexion {

    // Constantes de configuración de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/prestamos";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "7528"; // Cambia por tu contraseña real de MySQL

    public Conexion() {
    }

    /**
     * Obtiene una nueva conexión a la base de datos MySQL.
     * 
     * @return Connection objeto de conexión activo o null si falla.
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            // Cargar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión usando las variables de la clase
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver de MySQL no encontrado. Revisa las librerías/JAR agregadas al proyecto.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}