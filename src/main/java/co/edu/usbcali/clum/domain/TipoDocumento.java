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
@Table(name = "tipo_documento", schema = "public")
public class TipoDocumento implements java.io.Serializable {
    @NotNull
    private Integer tipoDocumentoId;
    @NotNull
    private Estado estado;
    private String nombreTipoDocumento;
    private Set<Tercero> terceros = new HashSet<Tercero>(0);

    public TipoDocumento() {
    }

    public TipoDocumento(Integer tipoDocumentoId, Estado estado,
        String nombreTipoDocumento, Set<Tercero> terceros) {
        this.tipoDocumentoId = tipoDocumentoId;
        this.estado = estado;
        this.nombreTipoDocumento = nombreTipoDocumento;
        this.terceros = terceros;
    }

    @Id
    @Column(name = "tipo_documento_id", unique = true, nullable = false)
    public Integer getTipoDocumentoId() {
        return this.tipoDocumentoId;
    }

    public void setTipoDocumentoId(Integer tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_tipo_documento")
    public String getNombreTipoDocumento() {
        return this.nombreTipoDocumento;
    }

    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        this.nombreTipoDocumento = nombreTipoDocumento;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDocumento")
    public Set<Tercero> getTerceros() {
        return this.terceros;
    }

    public void setTerceros(Set<Tercero> terceros) {
        this.terceros = terceros;
    }
}
