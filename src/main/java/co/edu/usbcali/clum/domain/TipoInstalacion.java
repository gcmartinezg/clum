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
@Table(name = "tipo_instalacion", schema = "public")
public class TipoInstalacion implements java.io.Serializable {
    @NotNull
    private Integer tipoInstalacionId;
    @NotNull
    private Estado estado;
    private String nombreTipoInstalacion;
    private Set<RedAlimentacion> redAlimentacions = new HashSet<RedAlimentacion>(0);

    public TipoInstalacion() {
    }

    public TipoInstalacion(Integer tipoInstalacionId, Estado estado,
        String nombreTipoInstalacion, Set<RedAlimentacion> redAlimentacions) {
        this.tipoInstalacionId = tipoInstalacionId;
        this.estado = estado;
        this.nombreTipoInstalacion = nombreTipoInstalacion;
        this.redAlimentacions = redAlimentacions;
    }

    @Id
    @Column(name = "tipo_instalacion_id", unique = true, nullable = false)
    public Integer getTipoInstalacionId() {
        return this.tipoInstalacionId;
    }

    public void setTipoInstalacionId(Integer tipoInstalacionId) {
        this.tipoInstalacionId = tipoInstalacionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_tipo_instalacion")
    public String getNombreTipoInstalacion() {
        return this.nombreTipoInstalacion;
    }

    public void setNombreTipoInstalacion(String nombreTipoInstalacion) {
        this.nombreTipoInstalacion = nombreTipoInstalacion;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoInstalacion")
    public Set<RedAlimentacion> getRedAlimentacions() {
        return this.redAlimentacions;
    }

    public void setRedAlimentacions(Set<RedAlimentacion> redAlimentacions) {
        this.redAlimentacions = redAlimentacions;
    }
}
