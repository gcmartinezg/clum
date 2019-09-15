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
public class TransformadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TransformadorDTO.class);
    private Integer transformadorId;
    private Integer idEstado_Estado;
    private Integer tipoSoporteId_TipoSoporte;
    private Integer tipoTransformadorId_TipoTransformador;

    public Integer getTransformadorId() {
        return transformadorId;
    }

    public void setTransformadorId(Integer transformadorId) {
        this.transformadorId = transformadorId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }

    public Integer getTipoSoporteId_TipoSoporte() {
        return tipoSoporteId_TipoSoporte;
    }

    public void setTipoSoporteId_TipoSoporte(Integer tipoSoporteId_TipoSoporte) {
        this.tipoSoporteId_TipoSoporte = tipoSoporteId_TipoSoporte;
    }

    public Integer getTipoTransformadorId_TipoTransformador() {
        return tipoTransformadorId_TipoTransformador;
    }

    public void setTipoTransformadorId_TipoTransformador(
        Integer tipoTransformadorId_TipoTransformador) {
        this.tipoTransformadorId_TipoTransformador = tipoTransformadorId_TipoTransformador;
    }
}
