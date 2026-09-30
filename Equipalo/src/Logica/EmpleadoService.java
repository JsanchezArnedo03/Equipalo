/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.EmpleadoRepository;
import equipalo.entities.Empleados;

/**
 *
 * @author jssa3
 */
public class EmpleadoService {

    private EmpleadoRepository persistencia = new EmpleadoRepository();

    public Empleados validarExistencia(String numeroDocumento) {
        Empleados empleado = persistencia.validarExistencia(numeroDocumento);
        return empleado;
    }

}
