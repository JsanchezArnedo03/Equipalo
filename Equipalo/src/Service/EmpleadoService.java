/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.EmpleadoRepository;
import Entities.Empleados;

/**
 *
 * @author jssa3
 */
public class EmpleadoService {

    private EmpleadoRepository empleadoRepository = new EmpleadoRepository();

    public Empleados validarExistencia(String numeroDocumento) {
        Empleados empleado = empleadoRepository.validarExistencia(numeroDocumento);
        return empleado;
    }

    public boolean CrearEmpleado(Empleados empleado) {
        return empleadoRepository.crearEmpleado(empleado);
    }

    public String codificarEmpleado(String numeroDocumento,
            String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {

        String nombreCompleto = primerNombre + segundoNombre + primerApellido + segundoApellido;
        String nombreLimpio = nombreCompleto.trim().replaceAll("\\s+", "").toUpperCase();
        String docLimpio = numeroDocumento.trim().replaceAll("[^a-zA-Z0-9]", "");
        String parteNombre = nombreLimpio.substring(0, Math.min(nombreLimpio.length(), 3));

        // 3. Extraer los últimos 4 dígitos del documento (o los que tenga si es más corto)
        String parteDoc = docLimpio.length() > 4
                ? docLimpio.substring(docLimpio.length() - 4)
                : docLimpio;
        return parteNombre + "-" + parteDoc;
    }
}
