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
public class LamparaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LamparaDTO.class);
    private String controlEncendido;
    private String funcionamiento;
    private Integer lamparaId;
    private Double latitudLampara;
    private Double longitudLampara;
    private Integer nivelTension;
    private Integer potencia;
    private String urlImagen;
    private Long valorPerdidas;
    private Integer idEstado_Estado;
    private Integer redAlimentacionId_RedAlimentacion;
    private Integer soporteLamparaId_SoporteLampara;
    private Integer tipoBalastoId_TipoBalasto;
    private Integer tipoEspacioIluminadoId_TipoEspacioIluminado;
    private Integer tipoLamparaId_TipoLampara;
    private Integer transformadorId_Transformador;

    public String getControlEncendido() {
        return controlEncendido;
    }

    public void setControlEncendido(String controlEncendido) {
        this.controlEncendido = controlEncendido;
    }

    public String getFuncionamiento() {
        return funcionamiento;
    }

    public void setFuncionamiento(String funcionamiento) {
        this.funcionamiento = funcionamiento;
    }

    public Integer getLamparaId() {
        return lamparaId;
    }

    public void setLamparaId(Integer lamparaId) {
        this.lamparaId = lamparaId;
    }

    public Double getLatitudLampara() {
        return latitudLampara;
    }

    public void setLatitudLampara(Double latitudLampara) {
        this.latitudLampara = latitudLampara;
    }

    public Double getLongitudLampara() {
        return longitudLampara;
    }

    public void setLongitudLampara(Double longitudLampara) {
        this.longitudLampara = longitudLampara;
    }

    public Integer getNivelTension() {
        return nivelTension;
    }

    public void setNivelTension(Integer nivelTension) {
        this.nivelTension = nivelTension;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Long getValorPerdidas() {
        return valorPerdidas;
    }

    public void setValorPerdidas(Long valorPerdidas) {
        this.valorPerdidas = valorPerdidas;
    }

    public Integer getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Integer idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }

    public Integer getRedAlimentacionId_RedAlimentacion() {
        return redAlimentacionId_RedAlimentacion;
    }

    public void setRedAlimentacionId_RedAlimentacion(
        Integer redAlimentacionId_RedAlimentacion) {
        this.redAlimentacionId_RedAlimentacion = redAlimentacionId_RedAlimentacion;
    }

    public Integer getSoporteLamparaId_SoporteLampara() {
        return soporteLamparaId_SoporteLampara;
    }

    public void setSoporteLamparaId_SoporteLampara(
        Integer soporteLamparaId_SoporteLampara) {
        this.soporteLamparaId_SoporteLampara = soporteLamparaId_SoporteLampara;
    }

    public Integer getTipoBalastoId_TipoBalasto() {
        return tipoBalastoId_TipoBalasto;
    }

    public void setTipoBalastoId_TipoBalasto(Integer tipoBalastoId_TipoBalasto) {
        this.tipoBalastoId_TipoBalasto = tipoBalastoId_TipoBalasto;
    }

    public Integer getTipoEspacioIluminadoId_TipoEspacioIluminado() {
        return tipoEspacioIluminadoId_TipoEspacioIluminado;
    }

    public void setTipoEspacioIluminadoId_TipoEspacioIluminado(
        Integer tipoEspacioIluminadoId_TipoEspacioIluminado) {
        this.tipoEspacioIluminadoId_TipoEspacioIluminado = tipoEspacioIluminadoId_TipoEspacioIluminado;
    }

    public Integer getTipoLamparaId_TipoLampara() {
        return tipoLamparaId_TipoLampara;
    }

    public void setTipoLamparaId_TipoLampara(Integer tipoLamparaId_TipoLampara) {
        this.tipoLamparaId_TipoLampara = tipoLamparaId_TipoLampara;
    }

    public Integer getTransformadorId_Transformador() {
        return transformadorId_Transformador;
    }

    public void setTransformadorId_Transformador(
        Integer transformadorId_Transformador) {
        this.transformadorId_Transformador = transformadorId_Transformador;
    }
}
