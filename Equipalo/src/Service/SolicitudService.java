/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.SolicitudRepository;
import Entities.Solicitudes;
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

    public boolean crearSolicitud(Solicitudes solicitudes) {
        return repository.crearSolicitud(solicitudes);
    }

    public List<Solicitudes> listarSolicitudes() {
        // Aquí puedes agregar filtros o reglas de negocio antes de retornar
        return repository.consultarSolicitudes();
    }

    public String codificarSolicitud(String numerdoDocumentoEmpleado,
            String nombreDispositivo, String fechaSolicitud) {

        /*
        String sufijo = null;
        
       

        // 3. Extraer los últimos 4 dígitos del documento (o los que tenga si es más corto)
        String parteDoc = codLimpio.length() > 4
                ? codLimpio.substring(codLimpio.length() - 4)
                : codLimpio;
        return codLimpio + "-" + parteDoc;
    }

}

/*public boolean validarDisponibilidad(Integer idDispositivo) {
        return repository.validarDisponibilidad(idDispositivo);
    }*/
        return null;
    }
}
