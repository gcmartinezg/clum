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
public class TipoSoporteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoSoporteDTO.class);
    private String nombreTipoSoporte;
    private Integer tipoSoporteId;
    private Integer idEstado_Estado;

    public String getNombreTipoSoporte() {
        return nombreTipoSoporte;
    }

    public void setNombreTipoSoporte(String nombreTipoSoporte) {
        this.nombreTipoSoporte = nombreTipoSoporte;
    }

    public Integer getTipoSoporteId() {
        return tipoSoporteId;
    }

    public void setTipoSoporteId(Integer tipoSoporteId) {
        this.tipoSoporteId = tipoSoporteId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }
}
