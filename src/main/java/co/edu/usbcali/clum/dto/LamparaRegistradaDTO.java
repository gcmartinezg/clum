package co.edu.usbcali.clum.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public class LamparaRegistradaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LamparaRegistradaDTO.class);
    private Date fechaHora;
    private Integer lamparaRegistradaId;
    private Double latitudPosActualTecnico;
    private Double longitudPosActualTecnico;
    private Integer lamparaId_Lampara;
    private String usuarioId_Usuario;

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getLamparaRegistradaId() {
        return lamparaRegistradaId;
    }

    public void setLamparaRegistradaId(Integer lamparaRegistradaId) {
        this.lamparaRegistradaId = lamparaRegistradaId;
    }

    public Double getLatitudPosActualTecnico() {
        return latitudPosActualTecnico;
    }

    public void setLatitudPosActualTecnico(Double latitudPosActualTecnico) {
        this.latitudPosActualTecnico = latitudPosActualTecnico;
    }

    public Double getLongitudPosActualTecnico() {
        return longitudPosActualTecnico;
    }

    public void setLongitudPosActualTecnico(Double longitudPosActualTecnico) {
        this.longitudPosActualTecnico = longitudPosActualTecnico;
    }

    public Integer getLamparaId_Lampara() {
        return lamparaId_Lampara;
    }

    public void setLamparaId_Lampara(Integer lamparaId_Lampara) {
        this.lamparaId_Lampara = lamparaId_Lampara;
    }

    public String getUsuarioId_Usuario() {
        return usuarioId_Usuario;
    }

    public void setUsuarioId_Usuario(String usuarioId_Usuario) {
        this.usuarioId_Usuario = usuarioId_Usuario;
    }
}
