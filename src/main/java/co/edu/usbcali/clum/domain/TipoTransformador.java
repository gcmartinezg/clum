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
@Table(name = "tipo_transformador", schema = "public")
public class TipoTransformador implements java.io.Serializable {
    @NotNull
    private Integer tipoTransformadorId;
    @NotNull
    private Estado estado;
    private String nombreTipoTransformador;
    private Set<Transformador> transformadors = new HashSet<Transformador>(0);

    public TipoTransformador() {
    }

    public TipoTransformador(Integer tipoTransformadorId, Estado estado,
        String nombreTipoTransformador, Set<Transformador> transformadors) {
        this.tipoTransformadorId = tipoTransformadorId;
        this.estado = estado;
        this.nombreTipoTransformador = nombreTipoTransformador;
        this.transformadors = transformadors;
    }

    @Id
    @Column(name = "tipo_transformador_id", unique = true, nullable = false)
    public Integer getTipoTransformadorId() {
        return this.tipoTransformadorId;
    }

    public void setTipoTransformadorId(Integer tipoTransformadorId) {
        this.tipoTransformadorId = tipoTransformadorId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_tipo_transformador")
    public String getNombreTipoTransformador() {
        return this.nombreTipoTransformador;
    }

    public void setNombreTipoTransformador(String nombreTipoTransformador) {
        this.nombreTipoTransformador = nombreTipoTransformador;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoTransformador")
    public Set<Transformador> getTransformadors() {
        return this.transformadors;
    }

    public void setTransformadors(Set<Transformador> transformadors) {
        this.transformadors = transformadors;
    }
}
