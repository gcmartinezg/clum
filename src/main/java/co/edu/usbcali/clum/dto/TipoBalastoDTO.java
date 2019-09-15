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
public class TipoBalastoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoBalastoDTO.class);
    private String nombreTipoBalasto;
    private Integer tipoBalastoId;
    private Integer idEstado_Estado;

    public String getNombreTipoBalasto() {
        return nombreTipoBalasto;
    }

    public void setNombreTipoBalasto(String nombreTipoBalasto) {
        this.nombreTipoBalasto = nombreTipoBalasto;
    }

    public Integer getTipoBalastoId() {
        return tipoBalastoId;
    }

    public void setTipoBalastoId(Integer tipoBalastoId) {
        this.tipoBalastoId = tipoBalastoId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }
}
