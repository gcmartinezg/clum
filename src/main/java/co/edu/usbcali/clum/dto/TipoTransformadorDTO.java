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
public class TipoTransformadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoTransformadorDTO.class);
    private String nombreTipoTransformador;
    private Integer tipoTransformadorId;
    private Integer idEstado_Estado;

    public String getNombreTipoTransformador() {
        return nombreTipoTransformador;
    }

    public void setNombreTipoTransformador(String nombreTipoTransformador) {
        this.nombreTipoTransformador = nombreTipoTransformador;
    }

    public Integer getTipoTransformadorId() {
        return tipoTransformadorId;
    }

    public void setTipoTransformadorId(Integer tipoTransformadorId) {
        this.tipoTransformadorId = tipoTransformadorId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }
}
