/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.SolicitudRepository;
import equipalo.entities.Solicitudes;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author jssa3
 */
public class SolicitudService {

private final SolicitudRepository repository;

    public SolicitudService() {
        this.repository = new SolicitudRepository();
    }

    public List<Solicitudes> listarSolicitudes() {
        // Aquí puedes agregar filtros o reglas de negocio antes de retornar
        return repository.consultarSolicitudes();
    }
}
