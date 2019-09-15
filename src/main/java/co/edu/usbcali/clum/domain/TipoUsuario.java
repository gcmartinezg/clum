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
@Table(name = "tipo_usuario", schema = "public")
public class TipoUsuario implements java.io.Serializable {
    @NotNull
    private Integer tipoUsuarioId;
    @NotNull
    private Estado estado;
    private String nombreTipoUsuario;
    private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public TipoUsuario() {
    }

    public TipoUsuario(Integer tipoUsuarioId, Estado estado,
        String nombreTipoUsuario, Set<Usuario> usuarios) {
        this.tipoUsuarioId = tipoUsuarioId;
        this.estado = estado;
        this.nombreTipoUsuario = nombreTipoUsuario;
        this.usuarios = usuarios;
    }

    @Id
    @Column(name = "tipo_usuario_id", unique = true, nullable = false)
    public Integer getTipoUsuarioId() {
        return this.tipoUsuarioId;
    }

    public void setTipoUsuarioId(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Column(name = "nombre_tipo_usuario")
    public String getNombreTipoUsuario() {
        return this.nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoUsuario")
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
