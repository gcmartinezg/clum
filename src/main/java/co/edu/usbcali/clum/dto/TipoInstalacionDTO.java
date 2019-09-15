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
public class TipoInstalacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoInstalacionDTO.class);
    private String nombreTipoInstalacion;
    private Integer tipoInstalacionId;
    private Integer idEstado_Estado;

    public String getNombreTipoInstalacion() {
        return nombreTipoInstalacion;
    }

    public void setNombreTipoInstalacion(String nombreTipoInstalacion) {
        this.nombreTipoInstalacion = nombreTipoInstalacion;
    }

    public Integer getTipoInstalacionId() {
        return tipoInstalacionId;
    }

    public void setTipoInstalacionId(Integer tipoInstalacionId) {
        this.tipoInstalacionId = tipoInstalacionId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }
}
