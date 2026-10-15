/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Entities.Dispositivos;
import Repository.DispositivoRepository;

/**
 *
 * @author jssa3
 */
public class DispositivoService {

    private final DispositivoRepository dispositivoRepository = new DispositivoRepository();

    public boolean crearDispositivo(Dispositivos dispositivo) {
        return dispositivoRepository.crearDispositivo(dispositivo);
    }

    public Dispositivos validarDisponibilidad(Integer idDispositivo) {
        return dispositivoRepository.validarDisponibilidad(idDispositivo);
    }
    

    /*public String codificarDispositivo(String tipoDispositivo, String nombreDispositivo) {

        String tipoDispositivoLimpio = tipoDispositivo.trim().replaceAll("\\s+", "").toUpperCase();
        String nombreDispositivoLimpio = nombreDispositivo.trim().replaceAll("\\s+", "").toUpperCase();
        if(nombreDispositivoLimpio){
            
        }
        
        String prefijo = tipoDispositivoLimpio.substring(0,1);
        String sufijo = nombreDispositivoLimpio.substring(0,);
        

        return prefijo + "-" + middle;
    }*/
}
