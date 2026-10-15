/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Conexion.Conexion;
import Entities.Dispositivos;
import Entities.EstadoDispositivo;
import Entities.TipoDispositivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jssa3
 */
public class DispositivoRepository {

    Connection con = Conexion.getConnection();

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
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                listDispositivos.add(rs.getString("nombre_dispositivo"));
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar: " + e.getMessage());
        }
        return listDispositivos;
    }

    public Dispositivos validarDisponibilidad(Integer idDispositivo) {
        String consulta = "SELECT d.id_dispositivo, d.nombre_dispositivo,tpd.tipo_dispositivo, ed.id_estado_dispositivo "
                + "            FROM dispositivos d "
                + "            INNER JOIN estado_dispositivo ed ON d.fk_estado_dispositivo = ed.id_estado_dispositivo "
                + "            INNER JOIN tipo_dispositivo tpd ON d.fk_tipo_dispositivo = tpd.id_tipo_dispositivo"
                + "            WHERE d.id_dispositivo = ?";
        Dispositivos dispositivoValido = null;
        TipoDispositivo tipoDispositivo = null;
        try {
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, idDispositivo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer idEstadoDispositivo = rs.getInt("ed.id_estado_dispositivo");
                if (idEstadoDispositivo == 1) {

                    dispositivoValido = new Dispositivos();
                    tipoDispositivo = new TipoDispositivo();
                    dispositivoValido.setIdDispositivo(rs.getInt("id_dispositivo"));
                    dispositivoValido.setNombreDispositivo(rs.getString("nombre_dispositivo"));
                    tipoDispositivo.setTipoDispositivo(rs.getString("tipo_dispositivo"));
                    tipoDispositivo.setSiglas(rs.getString("siglas"));
                    dispositivoValido.setTipoDispositivo(tipoDispositivo);

                    return dispositivoValido;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DispositivoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dispositivoValido;
    }

}
