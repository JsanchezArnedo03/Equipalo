/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author jssa3
 */
public class Dispositivos {

    private Integer idDispositivo;
    private String codDispositivo;
    private String nombreDispositivo;
    private TipoDispositivo tipoDispositivo;

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public EstadoDispositivo getEstadoDispositivo() {
        return estadoDispositivo;
    }

    public void setEstadoDispositivo(EstadoDispositivo estadoDispositivo) {
        this.estadoDispositivo = estadoDispositivo;
    }
    private EstadoDispositivo estadoDispositivo;

    public Dispositivos() {
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getCodDispositivo() {
        return codDispositivo;
    }

    public void setCodDispositivo(String codDispositivo) {
        this.codDispositivo = codDispositivo;
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public void setNombreDispositivo(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
    }

}
