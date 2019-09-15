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
@Table(name = "lampara", schema = "public")
public class Lampara implements java.io.Serializable {
    @NotNull
    private Integer lamparaId;
    @NotNull
    private Estado estado;
    @NotNull
    private RedAlimentacion redAlimentacion;
    @NotNull
    private SoporteLampara soporteLampara;
    @NotNull
    private TipoBalasto tipoBalasto;
    @NotNull
    private TipoEspacioIluminado tipoEspacioIluminado;
    @NotNull
    private TipoLampara tipoLampara;
    @NotNull
    private Transformador transformador;
    private String controlEncendido;
    private String funcionamiento;
    private Double latitudLampara;
    private Double longitudLampara;
    private Integer nivelTension;
    private Integer potencia;
    private String urlImagen;
    private Long valorPerdidas;
    private Set<Canalizacion> canalizacions = new HashSet<Canalizacion>(0);
    private Set<LamparaRegistrada> lamparaRegistradas = new HashSet<LamparaRegistrada>(0);

    public Lampara() {
    }

    public Lampara(Integer lamparaId, Set<Canalizacion> canalizacions,
        String controlEncendido, Estado estado, String funcionamiento,
        Set<LamparaRegistrada> lamparaRegistradas, Double latitudLampara,
        Double longitudLampara, Integer nivelTension, Integer potencia,
        RedAlimentacion redAlimentacion, SoporteLampara soporteLampara,
        TipoBalasto tipoBalasto, TipoEspacioIluminado tipoEspacioIluminado,
        TipoLampara tipoLampara, Transformador transformador, String urlImagen,
        Long valorPerdidas) {
        this.lamparaId = lamparaId;
        this.estado = estado;
        this.redAlimentacion = redAlimentacion;
        this.soporteLampara = soporteLampara;
        this.tipoBalasto = tipoBalasto;
        this.tipoEspacioIluminado = tipoEspacioIluminado;
        this.tipoLampara = tipoLampara;
        this.transformador = transformador;
        this.controlEncendido = controlEncendido;
        this.funcionamiento = funcionamiento;
        this.latitudLampara = latitudLampara;
        this.longitudLampara = longitudLampara;
        this.nivelTension = nivelTension;
        this.potencia = potencia;
        this.urlImagen = urlImagen;
        this.valorPerdidas = valorPerdidas;
        this.canalizacions = canalizacions;
        this.lamparaRegistradas = lamparaRegistradas;
    }

    @Id
    @Column(name = "lampara_id", unique = true, nullable = false)
    public Integer getLamparaId() {
        return this.lamparaId;
    }

    public void setLamparaId(Integer lamparaId) {
        this.lamparaId = lamparaId;
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
    @JoinColumn(name = "red_alimentacion_id")
    public RedAlimentacion getRedAlimentacion() {
        return this.redAlimentacion;
    }

    public void setRedAlimentacion(RedAlimentacion redAlimentacion) {
        this.redAlimentacion = redAlimentacion;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soporte_lampara_id")
    public SoporteLampara getSoporteLampara() {
        return this.soporteLampara;
    }

    public void setSoporteLampara(SoporteLampara soporteLampara) {
        this.soporteLampara = soporteLampara;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_balasto_id")
    public TipoBalasto getTipoBalasto() {
        return this.tipoBalasto;
    }

    public void setTipoBalasto(TipoBalasto tipoBalasto) {
        this.tipoBalasto = tipoBalasto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_espacio_iluminado_id")
    public TipoEspacioIluminado getTipoEspacioIluminado() {
        return this.tipoEspacioIluminado;
    }

    public void setTipoEspacioIluminado(
        TipoEspacioIluminado tipoEspacioIluminado) {
        this.tipoEspacioIluminado = tipoEspacioIluminado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_lampara_id")
    public TipoLampara getTipoLampara() {
        return this.tipoLampara;
    }

    public void setTipoLampara(TipoLampara tipoLampara) {
        this.tipoLampara = tipoLampara;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transformador_id")
    public Transformador getTransformador() {
        return this.transformador;
    }

    public void setTransformador(Transformador transformador) {
        this.transformador = transformador;
    }

    @Column(name = "control_encendido")
    public String getControlEncendido() {
        return this.controlEncendido;
    }

    public void setControlEncendido(String controlEncendido) {
        this.controlEncendido = controlEncendido;
    }

    @Column(name = "funcionamiento")
    public String getFuncionamiento() {
        return this.funcionamiento;
    }

    public void setFuncionamiento(String funcionamiento) {
        this.funcionamiento = funcionamiento;
    }

    @Column(name = "latitud_lampara")
    public Double getLatitudLampara() {
        return this.latitudLampara;
    }

    public void setLatitudLampara(Double latitudLampara) {
        this.latitudLampara = latitudLampara;
    }

    @Column(name = "longitud_lampara")
    public Double getLongitudLampara() {
        return this.longitudLampara;
    }

    public void setLongitudLampara(Double longitudLampara) {
        this.longitudLampara = longitudLampara;
    }

    @Column(name = "nivel_tension")
    public Integer getNivelTension() {
        return this.nivelTension;
    }

    public void setNivelTension(Integer nivelTension) {
        this.nivelTension = nivelTension;
    }

    @Column(name = "potencia")
    public Integer getPotencia() {
        return this.potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    @Column(name = "url_imagen")
    public String getUrlImagen() {
        return this.urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Column(name = "valor_perdidas")
    public Long getValorPerdidas() {
        return this.valorPerdidas;
    }

    public void setValorPerdidas(Long valorPerdidas) {
        this.valorPerdidas = valorPerdidas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lampara")
    public Set<Canalizacion> getCanalizacions() {
        return this.canalizacions;
    }

    public void setCanalizacions(Set<Canalizacion> canalizacions) {
        this.canalizacions = canalizacions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lampara")
    public Set<LamparaRegistrada> getLamparaRegistradas() {
        return this.lamparaRegistradas;
    }

    public void setLamparaRegistradas(Set<LamparaRegistrada> lamparaRegistradas) {
        this.lamparaRegistradas = lamparaRegistradas;
    }
}
