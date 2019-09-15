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
public class TipoLamparaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoLamparaDTO.class);
    private String nombreTipoLampara;
    private Integer tipoLamparaId;
    private Integer idEstado_Estado;

    public String getNombreTipoLampara() {
        return nombreTipoLampara;
    }

    public void setNombreTipoLampara(String nombreTipoLampara) {
        this.nombreTipoLampara = nombreTipoLampara;
    }

    public Integer getTipoLamparaId() {
        return tipoLamparaId;
    }

    public void setTipoLamparaId(Integer tipoLamparaId) {
        this.tipoLamparaId = tipoLamparaId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }
}
