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
@Table(name = "tipo_lampara", schema = "public")
public class TipoLampara implements java.io.Serializable {
    @NotNull
    private Integer tipoLamparaId;
    @NotNull
    private Estado estado;
    private String nombreTipoLampara;
    private Set<Lampara> lamparas = new HashSet<Lampara>(0);

    public TipoLampara() {
    }

    public TipoLampara(Integer tipoLamparaId, Estado estado,
        Set<Lampara> lamparas, String nombreTipoLampara) {
        this.tipoLamparaId = tipoLamparaId;
        this.estado = estado;
        this.nombreTipoLampara = nombreTipoLampara;
        this.lamparas = lamparas;
    }

    @Id
    @Column(name = "tipo_lampara_id", unique = true, nullable = false)
    public Integer getTipoLamparaId() {
        return this.tipoLamparaId;
    }

    public void setTipoLamparaId(Integer tipoLamparaId) {
        this.tipoLamparaId = tipoLamparaId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_tipo_lampara")
    public String getNombreTipoLampara() {
        return this.nombreTipoLampara;
    }

    public void setNombreTipoLampara(String nombreTipoLampara) {
        this.nombreTipoLampara = nombreTipoLampara;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoLampara")
    public Set<Lampara> getLamparas() {
        return this.lamparas;
    }

    public void setLamparas(Set<Lampara> lamparas) {
        this.lamparas = lamparas;
    }
}
