/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Conexion.Conexion;
import Entities.TipoDispositivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jssa3
 */
public class TipoDispositivoRepository {

    public List<String> getAllTipoDispositivo() {
        List<String> tiposDispositivos = new ArrayList<>();

        String consulta = "SELECT * FROM tipo_dispositivo;";

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TipoDispositivo tipoDispositivo = new TipoDispositivo();
                tipoDispositivo.setTipoDispositivo(rs.getString("tipo_dispositivo"));
                tiposDispositivos.add(tipoDispositivo.getTipoDispositivo());
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar los tipos de dispositivo: " + e.getMessage());
        }

        // Retorna directamente la lista poblada
        return tiposDispositivos;
    }
}
