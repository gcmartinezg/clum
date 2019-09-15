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
@Table(name = "tipo_soporte", schema = "public")
public class TipoSoporte implements java.io.Serializable {
	@NotNull
    private Integer tipoSoporteId;
    @NotNull
    private Estado estado;
    private String nombreTipoSoporte;
    private Set<Canalizacion> canalizacions = new HashSet<Canalizacion>(0);
    private Set<RedAlimentacion> redAlimentacions = new HashSet<RedAlimentacion>(0);
    private Set<SoporteLampara> soporteLamparas = new HashSet<SoporteLampara>(0);
    private Set<Transformador> transformadors = new HashSet<Transformador>(0);

    public TipoSoporte() {
    }

    public TipoSoporte(Integer tipoSoporteId, Set<Canalizacion> canalizacions,
        Estado estado, String nombreTipoSoporte,
        Set<RedAlimentacion> redAlimentacions,
        Set<SoporteLampara> soporteLamparas, Set<Transformador> transformadors) {
        this.tipoSoporteId = tipoSoporteId;
        this.estado = estado;
        this.nombreTipoSoporte = nombreTipoSoporte;
        this.canalizacions = canalizacions;
        this.redAlimentacions = redAlimentacions;
        this.soporteLamparas = soporteLamparas;
        this.transformadors = transformadors;
    }

    @Id
    @Column(name = "tipo_soporte_id", unique = true, nullable = false)
    public Integer getTipoSoporteId() {
        return this.tipoSoporteId;
    }

    public void setTipoSoporteId(Integer tipoSoporteId) {
        this.tipoSoporteId = tipoSoporteId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_tipo_soporte")
    public String getNombreTipoSoporte() {
        return this.nombreTipoSoporte;
    }

    public void setNombreTipoSoporte(String nombreTipoSoporte) {
        this.nombreTipoSoporte = nombreTipoSoporte;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoSoporte")
    public Set<Canalizacion> getCanalizacions() {
        return this.canalizacions;
    }

    public void setCanalizacions(Set<Canalizacion> canalizacions) {
        this.canalizacions = canalizacions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoSoporte")
    public Set<RedAlimentacion> getRedAlimentacions() {
        return this.redAlimentacions;
    }

    public void setRedAlimentacions(Set<RedAlimentacion> redAlimentacions) {
        this.redAlimentacions = redAlimentacions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoSoporte")
    public Set<SoporteLampara> getSoporteLamparas() {
        return this.soporteLamparas;
    }

    public void setSoporteLamparas(Set<SoporteLampara> soporteLamparas) {
        this.soporteLamparas = soporteLamparas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoSoporte")
    public Set<Transformador> getTransformadors() {
        return this.transformadors;
    }

    public void setTransformadors(Set<Transformador> transformadors) {
        this.transformadors = transformadors;
    }
}
