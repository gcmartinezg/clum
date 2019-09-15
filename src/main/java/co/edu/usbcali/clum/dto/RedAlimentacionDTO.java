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
public class RedAlimentacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RedAlimentacionDTO.class);
    private String calibreConductorAwg;
    private Integer redAlimentacionId;
    private Integer idEstado_Estado;
    private Integer tipoInstalacionId_TipoInstalacion;
    private Integer tipoMaterialId_TipoMaterial;
    private Integer tipoSoporteId_TipoSoporte;

    public String getCalibreConductorAwg() {
        return calibreConductorAwg;
    }

    public void setCalibreConductorAwg(String calibreConductorAwg) {
        this.calibreConductorAwg = calibreConductorAwg;
    }

    public Integer getRedAlimentacionId() {
        return redAlimentacionId;
    }

    public void setRedAlimentacionId(Integer redAlimentacionId) {
        this.redAlimentacionId = redAlimentacionId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }

    public Integer getTipoInstalacionId_TipoInstalacion() {
        return tipoInstalacionId_TipoInstalacion;
    }

    public void setTipoInstalacionId_TipoInstalacion(
        Integer tipoInstalacionId_TipoInstalacion) {
        this.tipoInstalacionId_TipoInstalacion = tipoInstalacionId_TipoInstalacion;
    }

    public Integer getTipoMaterialId_TipoMaterial() {
        return tipoMaterialId_TipoMaterial;
    }

    public void setTipoMaterialId_TipoMaterial(
        Integer tipoMaterialId_TipoMaterial) {
        this.tipoMaterialId_TipoMaterial = tipoMaterialId_TipoMaterial;
    }

    public Integer getTipoSoporteId_TipoSoporte() {
        return tipoSoporteId_TipoSoporte;
    }

    public void setTipoSoporteId_TipoSoporte(Integer tipoSoporteId_TipoSoporte) {
        this.tipoSoporteId_TipoSoporte = tipoSoporteId_TipoSoporte;
    }
}
