/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Conexion.Conexion;
import Entities.Dispositivos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jssa3
 */
public class DispositivoRepository {

    public boolean crearDispositivo(Dispositivos dispositivo) {

        String sql = "INSERT INTO dispositivos VALUES (?, ?)";
        try (Connection con = Conexion.getConnection(); // Ajusta 'getConexion()' al nombre de tu método en la clase Conexion
                 PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignación en orden secuencial
            ps.setString(1, dispositivo.getCodDispositivo());
            ps.setString(2, dispositivo.getNombreDispositivo());

            // executeUpdate devuelve el número de filas insertadas
            int filasInsertadas = ps.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar dispositivo: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<String> getAllDispostivos() {
        ArrayList<String> listDispositivos = new ArrayList<>();
        String sql = "SELECT nombre_dispositivo FROM dispositivos;";
        try (Connection con = Conexion.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql); 
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                listDispositivos.add(rs.getString("nombre_dispositivo"));
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar: " + e.getMessage());
        }
        return listDispositivos;
    }
}
