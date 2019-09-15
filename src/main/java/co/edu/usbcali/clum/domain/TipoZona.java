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
@Table(name = "tipo_zona", schema = "public")
public class TipoZona implements java.io.Serializable {
    @NotNull
    private Integer tipoZonaId;
    @NotNull
    private Estado estado;
    private String nombreTipoZona;
    private Set<Canalizacion> canalizacions = new HashSet<Canalizacion>(0);

    public TipoZona() {
    }

    public TipoZona(Integer tipoZonaId, Set<Canalizacion> canalizacions,
        Estado estado, String nombreTipoZona) {
        this.tipoZonaId = tipoZonaId;
        this.estado = estado;
        this.nombreTipoZona = nombreTipoZona;
        this.canalizacions = canalizacions;
    }

    @Id
    @Column(name = "tipo_zona_id", unique = true, nullable = false)
    public Integer getTipoZonaId() {
        return this.tipoZonaId;
    }

    public void setTipoZonaId(Integer tipoZonaId) {
        this.tipoZonaId = tipoZonaId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_tipo_zona")
    public String getNombreTipoZona() {
        return this.nombreTipoZona;
    }

    public void setNombreTipoZona(String nombreTipoZona) {
        this.nombreTipoZona = nombreTipoZona;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoZona")
    public Set<Canalizacion> getCanalizacions() {
        return this.canalizacions;
    }

    public void setCanalizacions(Set<Canalizacion> canalizacions) {
        this.canalizacions = canalizacions;
    }
}
