/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package equipalo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jssa3
 */
public class Equipalo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String numeroDocumento = "123456";
        String nombreDispositivo = "Pablito";

        Date fechaSolicitud = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = sdf.format(fechaSolicitud);

        String prefijo = numeroDocumento.substring(0, 3);
        String middle = nombreDispositivo.substring(0, 3);

        String codSolicitud = prefijo + middle + fecha;

        System.out.println("Codigo de solicitud: " + codSolicitud);

    }

}
