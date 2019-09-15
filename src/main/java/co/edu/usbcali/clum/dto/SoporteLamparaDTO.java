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
public class SoporteLamparaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SoporteLamparaDTO.class);
    private Integer longitud;
    private Integer soporteLamparaId;
    private Integer idEstado_Estado;
    private Integer tipoMaterialId_TipoMaterial;
    private Integer tipoSoporteId_TipoSoporte;

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public Integer getSoporteLamparaId() {
        return soporteLamparaId;
    }

    public void setSoporteLamparaId(Integer soporteLamparaId) {
        this.soporteLamparaId = soporteLamparaId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
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
