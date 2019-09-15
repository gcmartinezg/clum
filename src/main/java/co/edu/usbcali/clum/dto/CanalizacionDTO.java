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
public class CanalizacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CanalizacionDTO.class);
    private String cajaInspeccion;
    private Integer canalizacionId;
    private String ducteria;
    private Integer idEstado_Estado;
    private Integer lamparaId_Lampara;
    private Integer tipoSoporteId_TipoSoporte;
    private Integer tipoZonaId_TipoZona;

    public String getCajaInspeccion() {
        return cajaInspeccion;
    }

    public void setCajaInspeccion(String cajaInspeccion) {
        this.cajaInspeccion = cajaInspeccion;
    }

    public Integer getCanalizacionId() {
        return canalizacionId;
    }

    public void setCanalizacionId(Integer canalizacionId) {
        this.canalizacionId = canalizacionId;
    }

    public String getDucteria() {
        return ducteria;
    }

    public void setDucteria(String ducteria) {
        this.ducteria = ducteria;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }

    public Integer getLamparaId_Lampara() {
        return lamparaId_Lampara;
    }

    public void setLamparaId_Lampara(Integer lamparaId_Lampara) {
        this.lamparaId_Lampara = lamparaId_Lampara;
    }

    public Integer getTipoSoporteId_TipoSoporte() {
        return tipoSoporteId_TipoSoporte;
    }

    public void setTipoSoporteId_TipoSoporte(Integer tipoSoporteId_TipoSoporte) {
        this.tipoSoporteId_TipoSoporte = tipoSoporteId_TipoSoporte;
    }

    public Integer getTipoZonaId_TipoZona() {
        return tipoZonaId_TipoZona;
    }

    public void setTipoZonaId_TipoZona(Integer tipoZonaId_TipoZona) {
        this.tipoZonaId_TipoZona = tipoZonaId_TipoZona;
    }
}
