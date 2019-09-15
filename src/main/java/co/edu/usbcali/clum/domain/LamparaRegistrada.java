package co.edu.usbcali.clum.domain;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "lampara_registrada", schema = "public")
public class LamparaRegistrada implements java.io.Serializable {
    @NotNull
    private Integer lamparaRegistradaId;
    @NotNull
    private Lampara lampara;
    @NotNull
    private Usuario usuario;
    private Date fechaHora;
    private Double latitudPosActualTecnico;
    private Double longitudPosActualTecnico;

    public LamparaRegistrada() {
    }

    public LamparaRegistrada(Integer lamparaRegistradaId, Date fechaHora,
        Lampara lampara, Double latitudPosActualTecnico,
        Double longitudPosActualTecnico, Usuario usuario) {
        this.lamparaRegistradaId = lamparaRegistradaId;
        this.lampara = lampara;
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.latitudPosActualTecnico = latitudPosActualTecnico;
        this.longitudPosActualTecnico = longitudPosActualTecnico;
    }

    @Id
    @Column(name = "lampara_registrada_id", unique = true, nullable = false)
    public Integer getLamparaRegistradaId() {
        return this.lamparaRegistradaId;
    }

    public void setLamparaRegistradaId(Integer lamparaRegistradaId) {
        this.lamparaRegistradaId = lamparaRegistradaId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lampara_id")
    public Lampara getLampara() {
        return this.lampara;
    }

    public void setLampara(Lampara lampara) {
        this.lampara = lampara;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "fecha_hora")
    public Date getFechaHora() {
        return this.fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Column(name = "latitud_pos_actual_tecnico")
    public Double getLatitudPosActualTecnico() {
        return this.latitudPosActualTecnico;
    }

    public void setLatitudPosActualTecnico(Double latitudPosActualTecnico) {
        this.latitudPosActualTecnico = latitudPosActualTecnico;
    }

    @Column(name = "longitud_pos_actual_tecnico")
    public Double getLongitudPosActualTecnico() {
        return this.longitudPosActualTecnico;
    }

    public void setLongitudPosActualTecnico(Double longitudPosActualTecnico) {
        this.longitudPosActualTecnico = longitudPosActualTecnico;
    }
}
