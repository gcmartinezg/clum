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
@Table(name = "transformador", schema = "public")
public class Transformador implements java.io.Serializable {
    @NotNull
    private Integer transformadorId;
    @NotNull
    private Estado estado;
    @NotNull
    private TipoSoporte tipoSoporte;
    @NotNull
    private TipoTransformador tipoTransformador;
    private Set<Lampara> lamparas = new HashSet<Lampara>(0);

    public Transformador() {
    }

    public Transformador(Integer transformadorId, Estado estado,
        Set<Lampara> lamparas, TipoSoporte tipoSoporte,
        TipoTransformador tipoTransformador) {
        this.transformadorId = transformadorId;
        this.estado = estado;
        this.tipoSoporte = tipoSoporte;
        this.tipoTransformador = tipoTransformador;
        this.lamparas = lamparas;
    }

    @Id
    @Column(name = "transformador_id", unique = true, nullable = false)
    public Integer getTransformadorId() {
        return this.transformadorId;
    }

    public void setTransformadorId(Integer transformadorId) {
        this.transformadorId = transformadorId;
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
    @JoinColumn(name = "tipo_soporte_id")
    public TipoSoporte getTipoSoporte() {
        return this.tipoSoporte;
    }

    public void setTipoSoporte(TipoSoporte tipoSoporte) {
        this.tipoSoporte = tipoSoporte;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_transformador_id")
    public TipoTransformador getTipoTransformador() {
        return this.tipoTransformador;
    }

    public void setTipoTransformador(TipoTransformador tipoTransformador) {
        this.tipoTransformador = tipoTransformador;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transformador")
    public Set<Lampara> getLamparas() {
        return this.lamparas;
    }

    public void setLamparas(Set<Lampara> lamparas) {
        this.lamparas = lamparas;
    }
}
