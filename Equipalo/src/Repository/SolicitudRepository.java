/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entities.Solicitudes;
import java.util.List;
import Conexion.Conexion;
import Entities.Dispositivos;
import Entities.Empleados;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jssa3
 */
public class SolicitudRepository {

    public boolean crearSolicitud(Solicitudes solicitudes) {
        String sql = "INSERT INTO solicitudes (cod_solicitud,fk_empleado_solicita,fk_dispositivo_solicitado,"
                + "fecha_creacion_solicitud,fecha_solicitada,estado_solicitud)"
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(2, solicitudes.getCodSolicitud());
            ps.setObject(3, solicitudes.getEmpleadoSolicita());
            ps.setObject(4, solicitudes.getDispositivoSolicitado());
            ps.setDate(5, (Date) solicitudes.getFechaCreacionSolicitud());
            ps.setDate(6, (Date) solicitudes.getFechaSolicitada());
            ps.setObject(7, solicitudes.getEstadoSolicitud());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al crear empleado: " + e.getMessage());
            return false;
        }
    }

    public List<Solicitudes> consultarSolicitudes() {
        List<Solicitudes> tabla = new ArrayList<>();

        String consulta = "SELECT s.estado_solicitud, s.cod_solicitud, s.fecha_creacion_solicitud, s.fecha_solicitada, "
                + "e.primer_nombre, e.segundo_nombre, e.primer_apellido, e.segundo_apellido, "
                + "d.cod_dispositivo, d.nombre_dispositivo, "
                + "est.estado_solicitud "
                + "FROM solicitudes s "
                + "INNER JOIN empleados e ON s.fk_empleado_solicita = e.id_empleado "
                + "INNER JOIN dispositivos d ON s.fk_dispositivo_solicitado = d.id_dispositivo "
                + "INNER JOIN estado_solicitud est ON s.estado_solicitud = est.id_estado_solicitud;";

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // 1. Mapear objeto Dispositivos
                Dispositivos dispositivo = new Dispositivos();
                dispositivo.setCodDispositivo(rs.getString("cod_dispositivo"));
                dispositivo.setNombreDispositivo(rs.getString("nombre_dispositivo"));

                // 2. Mapear objeto Empleados
                Empleados empleadoSolicita = new Empleados();
                empleadoSolicita.setPrimerNombre(rs.getString("primer_nombre"));
                empleadoSolicita.setSegundoNombre(rs.getString("segundo_nombre"));
                empleadoSolicita.setPrimerApellido(rs.getString("primer_apellido"));
                empleadoSolicita.setSegundoApellido(rs.getString("segundo_apellido"));
                empleadoSolicita.setNombreCompleto(rs.getString("primer_nombre")
                        + rs.getString("segundo_nombre") + rs.getString("primer_apellido")
                        + rs.getString("segundo_apellido"));
                // 3. Mapear objeto Solicitudes
                Solicitudes fila = new Solicitudes();
                fila.setCodSolicitud(rs.getString("cod_solicitud"));
                fila.setEmpleadoSolicita(empleadoSolicita);
                fila.setDispositivoSolicitado(dispositivo);
                fila.setFechaCreacionSolicitud(rs.getDate("fecha_creacion_solicitud"));
                fila.setFechaSolicitada(rs.getDate("fecha_solicitada"));

                // 4. Agregar a la lista
                tabla.add(fila);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar solicitudes: " + e.getMessage());
        }

        // Retorna directamente la lista poblada
        return tabla;
    }
}
