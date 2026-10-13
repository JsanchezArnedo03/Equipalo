/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.DispositivoRepository;

/**
 *
 * @author jssa3
 */
public class DispositivoService {
    
    private final DispositivoRepository dispositivoRepository = new DispositivoRepository();
    
    public boolean validarDisponibilidad(Integer idDispositivo){
        return dispositivoRepository.validarDisponibilidad(idDispositivo);
    }
    
}
