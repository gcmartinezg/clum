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
@Table(name = "tercero", schema = "public")
public class Tercero implements java.io.Serializable {
    @NotNull
    private Integer terceroId;
    @NotNull
    private Estado estado;
    @NotNull
    private TipoDocumento tipoDocumento;
    private String direccion;
    private String email;
    private String nombreTercero;
    private Long numeroDocumento;
    private Long telefono;
    private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public Tercero() {
    }

    public Tercero(Integer terceroId, String direccion, String email,
        Estado estado, String nombreTercero, Long numeroDocumento,
        Long telefono, TipoDocumento tipoDocumento, Set<Usuario> usuarios) {
        this.terceroId = terceroId;
        this.estado = estado;
        this.tipoDocumento = tipoDocumento;
        this.direccion = direccion;
        this.email = email;
        this.nombreTercero = nombreTercero;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.usuarios = usuarios;
    }

    @Id
    @Column(name = "tercero_id", unique = true, nullable = false)
    public Integer getTerceroId() {
        return this.terceroId;
    }

    public void setTerceroId(Integer terceroId) {
        this.terceroId = terceroId;
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
    @JoinColumn(name = "tipo_documento_id")
    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Column(name = "direccion")
    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "nombre_tercero")
    public String getNombreTercero() {
        return this.nombreTercero;
    }

    public void setNombreTercero(String nombreTercero) {
        this.nombreTercero = nombreTercero;
    }

    @Column(name = "numero_documento")
    public Long getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Column(name = "telefono")
    public Long getTelefono() {
        return this.telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tercero")
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
