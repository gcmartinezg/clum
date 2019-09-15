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
@Table(name = "tipo_espacio_iluminado", schema = "public")
public class TipoEspacioIluminado implements java.io.Serializable {
    @NotNull
    private Integer tipoEspacioIluminadoId;
    @NotNull
    private Estado estado;
    private String nombreTipoEspacioIluminado;
    private Set<Lampara> lamparas = new HashSet<Lampara>(0);

    public TipoEspacioIluminado() {
    }

    public TipoEspacioIluminado(Integer tipoEspacioIluminadoId, Estado estado,
        Set<Lampara> lamparas, String nombreTipoEspacioIluminado) {
        this.tipoEspacioIluminadoId = tipoEspacioIluminadoId;
        this.estado = estado;
        this.nombreTipoEspacioIluminado = nombreTipoEspacioIluminado;
        this.lamparas = lamparas;
    }

    @Id
    @Column(name = "tipo_espacio_iluminado_id", unique = true, nullable = false)
    public Integer getTipoEspacioIluminadoId() {
        return this.tipoEspacioIluminadoId;
    }

    public void setTipoEspacioIluminadoId(Integer tipoEspacioIluminadoId) {
        this.tipoEspacioIluminadoId = tipoEspacioIluminadoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_tipo_espacio_iluminado")
    public String getNombreTipoEspacioIluminado() {
        return this.nombreTipoEspacioIluminado;
    }

    public void setNombreTipoEspacioIluminado(String nombreTipoEspacioIluminado) {
        this.nombreTipoEspacioIluminado = nombreTipoEspacioIluminado;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoEspacioIluminado")
    public Set<Lampara> getLamparas() {
        return this.lamparas;
    }

    public void setLamparas(Set<Lampara> lamparas) {
        this.lamparas = lamparas;
    }
}
