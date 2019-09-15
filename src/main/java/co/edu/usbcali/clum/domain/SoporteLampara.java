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
@Table(name = "soporte_lampara", schema = "public")
public class SoporteLampara implements java.io.Serializable {
    @NotNull
    private Integer soporteLamparaId;
    @NotNull
    private Estado estado;
    @NotNull
    private TipoMaterial tipoMaterial;
    @NotNull
    private TipoSoporte tipoSoporte;
    private Integer longitud;
    private Set<Lampara> lamparas = new HashSet<Lampara>(0);

    public SoporteLampara() {
    }

    public SoporteLampara(Integer soporteLamparaId, Estado estado,
        Set<Lampara> lamparas, Integer longitud, TipoMaterial tipoMaterial,
        TipoSoporte tipoSoporte) {
        this.soporteLamparaId = soporteLamparaId;
        this.estado = estado;
        this.tipoMaterial = tipoMaterial;
        this.tipoSoporte = tipoSoporte;
        this.longitud = longitud;
        this.lamparas = lamparas;
    }

    @Id
    @Column(name = "soporte_lampara_id", unique = true, nullable = false)
    public Integer getSoporteLamparaId() {
        return this.soporteLamparaId;
    }

    public void setSoporteLamparaId(Integer soporteLamparaId) {
        this.soporteLamparaId = soporteLamparaId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_material_id")
    public TipoMaterial getTipoMaterial() {
        return this.tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_soporte_id")
    public TipoSoporte getTipoSoporte() {
        return this.tipoSoporte;
    }

    public void setTipoSoporte(TipoSoporte tipoSoporte) {
        this.tipoSoporte = tipoSoporte;
    }

    @Column(name = "longitud")
    public Integer getLongitud() {
        return this.longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "soporteLampara")
    public Set<Lampara> getLamparas() {
        return this.lamparas;
    }

    public void setLamparas(Set<Lampara> lamparas) {
        this.lamparas = lamparas;
    }
}
