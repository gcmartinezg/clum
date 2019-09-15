package co.edu.usbcali.clum.domain;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "canalizacion", schema = "public")
public class Canalizacion implements java.io.Serializable {
    @NotNull
    private Integer canalizacionId;
    @NotNull
    private Estado estado;
    @NotNull
    private Lampara lampara;
    @NotNull
    private TipoSoporte tipoSoporte;
    @NotNull
    private TipoZona tipoZona;
    private String cajaInspeccion;
    private String ducteria;

    public Canalizacion() {
    }

    public Canalizacion(Integer canalizacionId, String cajaInspeccion,
        String ducteria, Estado estado, Lampara lampara,
        TipoSoporte tipoSoporte, TipoZona tipoZona) {
        this.canalizacionId = canalizacionId;
        this.estado = estado;
        this.lampara = lampara;
        this.tipoSoporte = tipoSoporte;
        this.tipoZona = tipoZona;
        this.cajaInspeccion = cajaInspeccion;
        this.ducteria = ducteria;
    }

    @Id
    @Column(name = "canalizacion_id", unique = true, nullable = false)
    public Integer getCanalizacionId() {
        return this.canalizacionId;
    }

    public void setCanalizacionId(Integer canalizacionId) {
        this.canalizacionId = canalizacionId;
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
    @JoinColumn(name = "lampara_id")
    public Lampara getLampara() {
        return this.lampara;
    }

    public void setLampara(Lampara lampara) {
        this.lampara = lampara;
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
    @JoinColumn(name = "tipo_zona_id")
    public TipoZona getTipoZona() {
        return this.tipoZona;
    }

    public void setTipoZona(TipoZona tipoZona) {
        this.tipoZona = tipoZona;
    }

    @Column(name = "caja_inspeccion")
    public String getCajaInspeccion() {
        return this.cajaInspeccion;
    }

    public void setCajaInspeccion(String cajaInspeccion) {
        this.cajaInspeccion = cajaInspeccion;
    }

    @Column(name = "ducteria")
    public String getDucteria() {
        return this.ducteria;
    }

    public void setDucteria(String ducteria) {
        this.ducteria = ducteria;
    }
}
