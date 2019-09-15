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
@Table(name = "estado", schema = "public")
public class Estado implements java.io.Serializable {
    @NotNull
    private Integer idEstado;
    private String estado;
    private Set<Canalizacion> canalizacions = new HashSet<Canalizacion>(0);
    private Set<Lampara> lamparas = new HashSet<Lampara>(0);
    private Set<RedAlimentacion> redAlimentacions = new HashSet<RedAlimentacion>(0);
    private Set<SoporteLampara> soporteLamparas = new HashSet<SoporteLampara>(0);
    private Set<Tercero> terceros = new HashSet<Tercero>(0);
    private Set<TipoBalasto> tipoBalastos = new HashSet<TipoBalasto>(0);
    private Set<TipoDocumento> tipoDocumentos = new HashSet<TipoDocumento>(0);
    private Set<TipoEspacioIluminado> tipoEspacioIluminados = new HashSet<TipoEspacioIluminado>(0);
    private Set<TipoInstalacion> tipoInstalacions = new HashSet<TipoInstalacion>(0);
    private Set<TipoLampara> tipoLamparas = new HashSet<TipoLampara>(0);
    private Set<TipoMaterial> tipoMaterials = new HashSet<TipoMaterial>(0);
    private Set<TipoSoporte> tipoSoportes = new HashSet<TipoSoporte>(0);
    private Set<TipoTransformador> tipoTransformadors = new HashSet<TipoTransformador>(0);
    private Set<TipoUsuario> tipoUsuarios = new HashSet<TipoUsuario>(0);
    private Set<TipoZona> tipoZonas = new HashSet<TipoZona>(0);
    private Set<Transformador> transformadors = new HashSet<Transformador>(0);
    private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public Estado() {
    }

    public Estado(Integer idEstado, Set<Canalizacion> canalizacions,
        String estado, Set<Lampara> lamparas,
        Set<RedAlimentacion> redAlimentacions,
        Set<SoporteLampara> soporteLamparas, Set<Tercero> terceros,
        Set<TipoBalasto> tipoBalastos, Set<TipoDocumento> tipoDocumentos,
        Set<TipoEspacioIluminado> tipoEspacioIluminados,
        Set<TipoInstalacion> tipoInstalacions, Set<TipoLampara> tipoLamparas,
        Set<TipoMaterial> tipoMaterials, Set<TipoSoporte> tipoSoportes,
        Set<TipoTransformador> tipoTransformadors,
        Set<TipoUsuario> tipoUsuarios, Set<TipoZona> tipoZonas,
        Set<Transformador> transformadors, Set<Usuario> usuarios) {
        this.idEstado = idEstado;
        this.estado = estado;
        this.canalizacions = canalizacions;
        this.lamparas = lamparas;
        this.redAlimentacions = redAlimentacions;
        this.soporteLamparas = soporteLamparas;
        this.terceros = terceros;
        this.tipoBalastos = tipoBalastos;
        this.tipoDocumentos = tipoDocumentos;
        this.tipoEspacioIluminados = tipoEspacioIluminados;
        this.tipoInstalacions = tipoInstalacions;
        this.tipoLamparas = tipoLamparas;
        this.tipoMaterials = tipoMaterials;
        this.tipoSoportes = tipoSoportes;
        this.tipoTransformadors = tipoTransformadors;
        this.tipoUsuarios = tipoUsuarios;
        this.tipoZonas = tipoZonas;
        this.transformadors = transformadors;
        this.usuarios = usuarios;
    }

    @Id
    @Column(name = "id_estado", unique = true, nullable = false)
    public Integer getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    @Column(name = "estado")
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<Canalizacion> getCanalizacions() {
        return this.canalizacions;
    }

    public void setCanalizacions(Set<Canalizacion> canalizacions) {
        this.canalizacions = canalizacions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<Lampara> getLamparas() {
        return this.lamparas;
    }

    public void setLamparas(Set<Lampara> lamparas) {
        this.lamparas = lamparas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<RedAlimentacion> getRedAlimentacions() {
        return this.redAlimentacions;
    }

    public void setRedAlimentacions(Set<RedAlimentacion> redAlimentacions) {
        this.redAlimentacions = redAlimentacions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<SoporteLampara> getSoporteLamparas() {
        return this.soporteLamparas;
    }

    public void setSoporteLamparas(Set<SoporteLampara> soporteLamparas) {
        this.soporteLamparas = soporteLamparas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<Tercero> getTerceros() {
        return this.terceros;
    }

    public void setTerceros(Set<Tercero> terceros) {
        this.terceros = terceros;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<TipoBalasto> getTipoBalastos() {
        return this.tipoBalastos;
    }

    public void setTipoBalastos(Set<TipoBalasto> tipoBalastos) {
        this.tipoBalastos = tipoBalastos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<TipoDocumento> getTipoDocumentos() {
        return this.tipoDocumentos;
    }

    public void setTipoDocumentos(Set<TipoDocumento> tipoDocumentos) {
        this.tipoDocumentos = tipoDocumentos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<TipoEspacioIluminado> getTipoEspacioIluminados() {
        return this.tipoEspacioIluminados;
    }

    public void setTipoEspacioIluminados(
        Set<TipoEspacioIluminado> tipoEspacioIluminados) {
        this.tipoEspacioIluminados = tipoEspacioIluminados;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<TipoInstalacion> getTipoInstalacions() {
        return this.tipoInstalacions;
    }

    public void setTipoInstalacions(Set<TipoInstalacion> tipoInstalacions) {
        this.tipoInstalacions = tipoInstalacions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<TipoLampara> getTipoLamparas() {
        return this.tipoLamparas;
    }

    public void setTipoLamparas(Set<TipoLampara> tipoLamparas) {
        this.tipoLamparas = tipoLamparas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<TipoMaterial> getTipoMaterials() {
        return this.tipoMaterials;
    }

    public void setTipoMaterials(Set<TipoMaterial> tipoMaterials) {
        this.tipoMaterials = tipoMaterials;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<TipoSoporte> getTipoSoportes() {
        return this.tipoSoportes;
    }

    public void setTipoSoportes(Set<TipoSoporte> tipoSoportes) {
        this.tipoSoportes = tipoSoportes;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<TipoTransformador> getTipoTransformadors() {
        return this.tipoTransformadors;
    }

    public void setTipoTransformadors(Set<TipoTransformador> tipoTransformadors) {
        this.tipoTransformadors = tipoTransformadors;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<TipoUsuario> getTipoUsuarios() {
        return this.tipoUsuarios;
    }

    public void setTipoUsuarios(Set<TipoUsuario> tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<TipoZona> getTipoZonas() {
        return this.tipoZonas;
    }

    public void setTipoZonas(Set<TipoZona> tipoZonas) {
        this.tipoZonas = tipoZonas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<Transformador> getTransformadors() {
        return this.transformadors;
    }

    public void setTransformadors(Set<Transformador> transformadors) {
        this.transformadors = transformadors;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
