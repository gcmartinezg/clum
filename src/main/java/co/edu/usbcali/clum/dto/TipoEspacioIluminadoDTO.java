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
public class TipoEspacioIluminadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoEspacioIluminadoDTO.class);
    private String nombreTipoEspacioIluminado;
    private Integer tipoEspacioIluminadoId;
    private Integer idEstado_Estado;

    public String getNombreTipoEspacioIluminado() {
        return nombreTipoEspacioIluminado;
    }

    public void setNombreTipoEspacioIluminado(String nombreTipoEspacioIluminado) {
        this.nombreTipoEspacioIluminado = nombreTipoEspacioIluminado;
    }

    public Integer getTipoEspacioIluminadoId() {
        return tipoEspacioIluminadoId;
    }

    public void setTipoEspacioIluminadoId(Integer tipoEspacioIluminadoId) {
        this.tipoEspacioIluminadoId = tipoEspacioIluminadoId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }
}
