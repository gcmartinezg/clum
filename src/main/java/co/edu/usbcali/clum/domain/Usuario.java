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
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {
    @NotNull
    private String usuarioId;
    @NotNull
    private Estado estado;
    @NotNull
    private Tercero tercero;
    @NotNull
    private TipoUsuario tipoUsuario;
    private String contrasenia;
    private Set<LamparaRegistrada> lamparaRegistradas = new HashSet<LamparaRegistrada>(0);

    public Usuario() {
    }

    public Usuario(String usuarioId, String contrasenia, Estado estado,
        Set<LamparaRegistrada> lamparaRegistradas, Tercero tercero,
        TipoUsuario tipoUsuario) {
        this.usuarioId = usuarioId;
        this.estado = estado;
        this.tercero = tercero;
        this.tipoUsuario = tipoUsuario;
        this.contrasenia = contrasenia;
        this.lamparaRegistradas = lamparaRegistradas;
    }

    @Id
    @Column(name = "usuario_id", unique = true, nullable = false)
    public String getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
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
    @JoinColumn(name = "tercero_id")
    public Tercero getTercero() {
        return this.tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_usuario_id")
    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Column(name = "contrasenia")
    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<LamparaRegistrada> getLamparaRegistradas() {
        return this.lamparaRegistradas;
    }

    public void setLamparaRegistradas(Set<LamparaRegistrada> lamparaRegistradas) {
        this.lamparaRegistradas = lamparaRegistradas;
    }
}
