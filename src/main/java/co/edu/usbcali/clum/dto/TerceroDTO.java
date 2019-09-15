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
public class TerceroDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TerceroDTO.class);
    private String direccion;
    private String email;
    private String nombreTercero;
    private Long numeroDocumento;
    private Long telefono;
    private Integer terceroId;
    private Integer idEstado_Estado;
    private Integer tipoDocumentoId_TipoDocumento;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreTercero() {
        return nombreTercero;
    }

    public void setNombreTercero(String nombreTercero) {
        this.nombreTercero = nombreTercero;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Integer getTerceroId() {
        return terceroId;
    }

    public void setTerceroId(Integer terceroId) {
        this.terceroId = terceroId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }

    public Integer getTipoDocumentoId_TipoDocumento() {
        return tipoDocumentoId_TipoDocumento;
    }

    public void setTipoDocumentoId_TipoDocumento(
        Integer tipoDocumentoId_TipoDocumento) {
        this.tipoDocumentoId_TipoDocumento = tipoDocumentoId_TipoDocumento;
    }
}
