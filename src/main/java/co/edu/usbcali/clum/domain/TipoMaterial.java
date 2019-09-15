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
@Table(name = "tipo_material", schema = "public")
public class TipoMaterial implements java.io.Serializable {
    @NotNull
    private Integer tipoMaterialId;
    @NotNull
    private Estado estado;
    private String nombreTipoMaterial;
    private Set<RedAlimentacion> redAlimentacions = new HashSet<RedAlimentacion>(0);
    private Set<SoporteLampara> soporteLamparas = new HashSet<SoporteLampara>(0);

    public TipoMaterial() {
    }

    public TipoMaterial(Integer tipoMaterialId, Estado estado,
        String nombreTipoMaterial, Set<RedAlimentacion> redAlimentacions,
        Set<SoporteLampara> soporteLamparas) {
        this.tipoMaterialId = tipoMaterialId;
        this.estado = estado;
        this.nombreTipoMaterial = nombreTipoMaterial;
        this.redAlimentacions = redAlimentacions;
        this.soporteLamparas = soporteLamparas;
    }

    @Id
    @Column(name = "tipo_material_id", unique = true, nullable = false)
    public Integer getTipoMaterialId() {
        return this.tipoMaterialId;
    }

    public void setTipoMaterialId(Integer tipoMaterialId) {
        this.tipoMaterialId = tipoMaterialId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_tipo_material")
    public String getNombreTipoMaterial() {
        return this.nombreTipoMaterial;
    }

    public void setNombreTipoMaterial(String nombreTipoMaterial) {
        this.nombreTipoMaterial = nombreTipoMaterial;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoMaterial")
    public Set<RedAlimentacion> getRedAlimentacions() {
        return this.redAlimentacions;
    }

    public void setRedAlimentacions(Set<RedAlimentacion> redAlimentacions) {
        this.redAlimentacions = redAlimentacions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoMaterial")
    public Set<SoporteLampara> getSoporteLamparas() {
        return this.soporteLamparas;
    }

    public void setSoporteLamparas(Set<SoporteLampara> soporteLamparas) {
        this.soporteLamparas = soporteLamparas;
    }
}
