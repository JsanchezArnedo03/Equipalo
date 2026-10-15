/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.Date;
import java.util.List;

/**
 *
 * @author jssa3
 */
public class Solicitudes {

    private Integer idSolicitud;
    private String codSolicitud;
    private Empleados empleadoSolicita;
    private Dispositivos dispositivoSolicitado;
    private Date fechaCreacionSolicitud;
    private Date fechaSolicitada;
    private EstadoSolicitud estadoSolicitud;

    private List<Solicitudes> tabla;

    public Solicitudes() {
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getCodSolicitud() {
        return codSolicitud;
    }

    public void setCodSolicitud(String codSolicitud) {
        this.codSolicitud = codSolicitud;
    }

    public Empleados getEmpleadoSolicita() {
        return empleadoSolicita;
    }

    public void setEmpleadoSolicita(Empleados empleadoSolicita) {
        this.empleadoSolicita = empleadoSolicita;
    }

    public Dispositivos getDispositivoSolicitado() {
        return dispositivoSolicitado;
    }

    public void setDispositivoSolicitado(Dispositivos dispositivoSolicitado) {
        this.dispositivoSolicitado = dispositivoSolicitado;
    }

    public Date getFechaCreacionSolicitud() {
        return fechaCreacionSolicitud;
    }

    public void setFechaCreacionSolicitud(Date fechaCreacionSolicitud) {
        this.fechaCreacionSolicitud = fechaCreacionSolicitud;
    }

    public Date getFechaSolicitada() {
        return fechaSolicitada;
    }

    public void setFechaSolicitada(Date fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public List<Solicitudes> getTabla() {
        return tabla;
    }

    public void setTabla(List<Solicitudes> tabla) {
        this.tabla = tabla;
    }
}
