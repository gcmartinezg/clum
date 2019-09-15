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
@Table(name = "red_alimentacion", schema = "public")
public class RedAlimentacion implements java.io.Serializable {
    @NotNull
    private Integer redAlimentacionId;
    @NotNull
    private Estado estado;
    @NotNull
    private TipoInstalacion tipoInstalacion;
    @NotNull
    private TipoMaterial tipoMaterial;
    @NotNull
    private TipoSoporte tipoSoporte;
    private String calibreConductorAwg;
    private Set<Lampara> lamparas = new HashSet<Lampara>(0);

    public RedAlimentacion() {
    }

    public RedAlimentacion(Integer redAlimentacionId,
        String calibreConductorAwg, Estado estado, Set<Lampara> lamparas,
        TipoInstalacion tipoInstalacion, TipoMaterial tipoMaterial,
        TipoSoporte tipoSoporte) {
        this.redAlimentacionId = redAlimentacionId;
        this.estado = estado;
        this.tipoInstalacion = tipoInstalacion;
        this.tipoMaterial = tipoMaterial;
        this.tipoSoporte = tipoSoporte;
        this.calibreConductorAwg = calibreConductorAwg;
        this.lamparas = lamparas;
    }

    @Id
    @Column(name = "red_alimentacion_id", unique = true, nullable = false)
    public Integer getRedAlimentacionId() {
        return this.redAlimentacionId;
    }

    public void setRedAlimentacionId(Integer redAlimentacionId) {
        this.redAlimentacionId = redAlimentacionId;
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
    @JoinColumn(name = "tipo_instalacion_id")
    public TipoInstalacion getTipoInstalacion() {
        return this.tipoInstalacion;
    }

    public void setTipoInstalacion(TipoInstalacion tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
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

    @Column(name = "calibre_conductor_awg")
    public String getCalibreConductorAwg() {
        return this.calibreConductorAwg;
    }

    public void setCalibreConductorAwg(String calibreConductorAwg) {
        this.calibreConductorAwg = calibreConductorAwg;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "redAlimentacion")
    public Set<Lampara> getLamparas() {
        return this.lamparas;
    }

    public void setLamparas(Set<Lampara> lamparas) {
        this.lamparas = lamparas;
    }
}
