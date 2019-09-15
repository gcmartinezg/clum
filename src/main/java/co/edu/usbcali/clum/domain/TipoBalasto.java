package co.edu.usbcali.clum.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "tipo_balasto", schema = "public")
public class TipoBalasto implements java.io.Serializable {
    @NotNull
    private Integer tipoBalastoId;
    @NotNull
    private Estado estado;
    private String nombreTipoBalasto;
    private Set<Lampara> lamparas = new HashSet<Lampara>(0);

    public TipoBalasto() {
    }

    public TipoBalasto(Integer tipoBalastoId, Estado estado,
        Set<Lampara> lamparas, String nombreTipoBalasto) {
        this.tipoBalastoId = tipoBalastoId;
        this.estado = estado;
        this.nombreTipoBalasto = nombreTipoBalasto;
        this.lamparas = lamparas;
    }

    @Id
    @Column(name = "tipo_balasto_id", unique = true, nullable = false)
    public Integer getTipoBalastoId() {
        return this.tipoBalastoId;
    }

    public void setTipoBalastoId(Integer tipoBalastoId) {
        this.tipoBalastoId = tipoBalastoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_tipo_balasto")
    public String getNombreTipoBalasto() {
        return this.nombreTipoBalasto;
    }

    public void setNombreTipoBalasto(String nombreTipoBalasto) {
        this.nombreTipoBalasto = nombreTipoBalasto;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoBalasto")
    public Set<Lampara> getLamparas() {
        return this.lamparas;
    }

    public void setLamparas(Set<Lampara> lamparas) {
        this.lamparas = lamparas;
    }
}
