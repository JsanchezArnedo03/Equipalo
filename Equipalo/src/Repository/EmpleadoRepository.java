/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Conexion.Conexion;
import Entities.Empleados;
import Entities.TipoDocumento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jssa3
 */
public class EmpleadoRepository {

    public boolean crearEmpleado(Empleados empleado) {
        String sql = "INSERT INTO empleados (fk_tipo_documento, cod_empleado, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Conexion conexion = new Conexion();

        // try-with-resources cierra automáticamente la conexión y el PreparedStatement
        try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Asumiendo que getIdTipoDocumento() devuelve el ID numérico (INT)
            ps.setInt(1, empleado.getTipoDocumento().getIdTipoDocumento());
            ps.setString(2, empleado.getCodEmpleado());
            ps.setString(3, empleado.getNumeroDocumento());
            ps.setString(4, empleado.getPrimerNombre());
            ps.setString(5, empleado.getSegundoNombre());
            ps.setString(6, empleado.getPrimerApellido());
            ps.setString(7, empleado.getSegundoApellido());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al crear empleado: " + e.getMessage());
            return false;
        }
    }

    public Empleados validarExistencia(String numeroDocumento) {
        String sql = "SELECT * FROM empleados WHERE numero_documento = ?";
        Empleados empleado = null;

        Conexion conexion = new Conexion();

        try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, numeroDocumento);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    empleado = new Empleados();
                    empleado.setIdEmpleado(rs.getInt("id_empleado"));
                    empleado.setCodEmpleado(rs.getString("cod_empleado"));
                    empleado.setNumeroDocumento(rs.getString("numero_documento"));
                    empleado.setPrimerNombre(rs.getString("primer_nombre"));
                    empleado.setSegundoNombre(rs.getString("segundo_nombre"));
                    empleado.setPrimerApellido(rs.getString("primer_apellido"));
                    empleado.setSegundoApellido(rs.getString("segundo_apellido"));

                    // Mapeo del objeto TipoDocumento si tu entidad lo requiere
                    TipoDocumento tipoDoc = new TipoDocumento();
                    tipoDoc.setIdTipoDocumento(rs.getInt("fk_tipo_documento"));
                    empleado.setTipoDocumento(tipoDoc);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar empleado: " + e.getMessage());
        }

        return empleado;
    }
}
