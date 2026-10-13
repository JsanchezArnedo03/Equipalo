/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Conexion.Conexion;
import Entities.TipoDocumento;
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
public class TipoDocumentoRepository {
    
    public List<String> getAllTipoDocumento() {
        List<String> tiposDocumentos = new ArrayList<>();
        
        String consulta = "Select tp.tipo_documento from tipo_documento tp;";
        
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                
                TipoDocumento tipoDocumento = new TipoDocumento();
                tipoDocumento.setTipoDocumento(rs.getString("tipo_documento"));
                tiposDocumentos.add(tipoDocumento.getTipoDocumento());
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar solicitudes: " + e.getMessage());
        }

        // Retorna directamente la lista poblada
        return tiposDocumentos;
    }
    
    public TipoDocumento getByIndex(Integer index) throws SQLException {
        TipoDocumento tipoDocumento = new TipoDocumento();
        String consulta = "SELECT * FROM tipo_documento where id_tipo_documento = ?;";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setInt(1, index);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    tipoDocumento.setIdTipoDocumento(rs.getInt("id_tipo_documento"));
                    tipoDocumento.setTipoDocumento(rs.getString("tipo_documento"));
                    tipoDocumento.setAbreviatura(rs.getString("abreviatura"));
                    tipoDocumento.setDescripcion(rs.getString("descripcion"));
                }
            } catch (SQLException e) {
                System.err.println("Error al consultar solicitudes: " + e.getMessage());
            }
        }
        return tipoDocumento;
    }
}
