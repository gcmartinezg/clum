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
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioDTO.class);
    private String contrasenia;
    private String usuarioId;
    private Integer idEstado_Estado;
    private Integer terceroId_Tercero;
    private Integer tipoUsuarioId_TipoUsuario;

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }

    public Integer getTerceroId_Tercero() {
        return terceroId_Tercero;
    }

    public void setTerceroId_Tercero(Integer terceroId_Tercero) {
        this.terceroId_Tercero = terceroId_Tercero;
    }

    public Integer getTipoUsuarioId_TipoUsuario() {
        return tipoUsuarioId_TipoUsuario;
    }

    public void setTipoUsuarioId_TipoUsuario(Integer tipoUsuarioId_TipoUsuario) {
        this.tipoUsuarioId_TipoUsuario = tipoUsuarioId_TipoUsuario;
    }
}
