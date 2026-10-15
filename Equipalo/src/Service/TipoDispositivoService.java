/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.TipoDispositivoRepository;
import java.util.List;

/**
 *
 * @author jssa3
 */
public class TipoDispositivoService {

    TipoDispositivoRepository tipoDispositivoRepository = new TipoDispositivoRepository();

    public List<String> getAllTipoDispositivo() {
        return tipoDispositivoRepository.getAllTipoDispositivo();
    }
}
