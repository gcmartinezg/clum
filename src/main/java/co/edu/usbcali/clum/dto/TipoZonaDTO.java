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
public class TipoZonaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoZonaDTO.class);
    private String nombreTipoZona;
    private Integer tipoZonaId;
    private Integer idEstado_Estado;

    public String getNombreTipoZona() {
        return nombreTipoZona;
    }

    public void setNombreTipoZona(String nombreTipoZona) {
        this.nombreTipoZona = nombreTipoZona;
    }

    public Integer getTipoZonaId() {
        return tipoZonaId;
    }

    public void setTipoZonaId(Integer tipoZonaId) {
        this.tipoZonaId = tipoZonaId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }
}
