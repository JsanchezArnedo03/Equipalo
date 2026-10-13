/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Entities.TipoDocumento;
import Repository.TipoDocumentoRepository;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jssa3
 */
public class TipoDocumentoService {

    private final TipoDocumentoRepository documentoRepository = new TipoDocumentoRepository();

    public List<String> getAllTipoDocumento() {
        return documentoRepository.getAllTipoDocumento();
    }

    public TipoDocumento getByIndex(Integer index) throws SQLException {
        return documentoRepository.getByIndex(index);
    }
}
