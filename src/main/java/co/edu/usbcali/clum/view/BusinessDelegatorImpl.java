package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.Canalizacion;
import co.edu.usbcali.clum.domain.Estado;
import co.edu.usbcali.clum.domain.Lampara;
import co.edu.usbcali.clum.domain.LamparaRegistrada;
import co.edu.usbcali.clum.domain.RedAlimentacion;
import co.edu.usbcali.clum.domain.SoporteLampara;
import co.edu.usbcali.clum.domain.Tercero;
import co.edu.usbcali.clum.domain.TipoBalasto;
import co.edu.usbcali.clum.domain.TipoDocumento;
import co.edu.usbcali.clum.domain.TipoEspacioIluminado;
import co.edu.usbcali.clum.domain.TipoInstalacion;
import co.edu.usbcali.clum.domain.TipoLampara;
import co.edu.usbcali.clum.domain.TipoMaterial;
import co.edu.usbcali.clum.domain.TipoSoporte;
import co.edu.usbcali.clum.domain.TipoTransformador;
import co.edu.usbcali.clum.domain.TipoUsuario;
import co.edu.usbcali.clum.domain.TipoZona;
import co.edu.usbcali.clum.domain.Transformador;
import co.edu.usbcali.clum.domain.Usuario;
import co.edu.usbcali.clum.dto.CanalizacionDTO;
import co.edu.usbcali.clum.dto.EstadoDTO;
import co.edu.usbcali.clum.dto.LamparaDTO;
import co.edu.usbcali.clum.dto.LamparaRegistradaDTO;
import co.edu.usbcali.clum.dto.RedAlimentacionDTO;
import co.edu.usbcali.clum.dto.SoporteLamparaDTO;
import co.edu.usbcali.clum.dto.TerceroDTO;
import co.edu.usbcali.clum.dto.TipoBalastoDTO;
import co.edu.usbcali.clum.dto.TipoDocumentoDTO;
import co.edu.usbcali.clum.dto.TipoEspacioIluminadoDTO;
import co.edu.usbcali.clum.dto.TipoInstalacionDTO;
import co.edu.usbcali.clum.dto.TipoLamparaDTO;
import co.edu.usbcali.clum.dto.TipoMaterialDTO;
import co.edu.usbcali.clum.dto.TipoSoporteDTO;
import co.edu.usbcali.clum.dto.TipoTransformadorDTO;
import co.edu.usbcali.clum.dto.TipoUsuarioDTO;
import co.edu.usbcali.clum.dto.TipoZonaDTO;
import co.edu.usbcali.clum.dto.TransformadorDTO;
import co.edu.usbcali.clum.dto.UsuarioDTO;
import co.edu.usbcali.clum.service.CanalizacionService;
import co.edu.usbcali.clum.service.EstadoService;
import co.edu.usbcali.clum.service.LamparaRegistradaService;
import co.edu.usbcali.clum.service.LamparaService;
import co.edu.usbcali.clum.service.RedAlimentacionService;
import co.edu.usbcali.clum.service.SoporteLamparaService;
import co.edu.usbcali.clum.service.TerceroService;
import co.edu.usbcali.clum.service.TipoBalastoService;
import co.edu.usbcali.clum.service.TipoDocumentoService;
import co.edu.usbcali.clum.service.TipoEspacioIluminadoService;
import co.edu.usbcali.clum.service.TipoInstalacionService;
import co.edu.usbcali.clum.service.TipoLamparaService;
import co.edu.usbcali.clum.service.TipoMaterialService;
import co.edu.usbcali.clum.service.TipoSoporteService;
import co.edu.usbcali.clum.service.TipoTransformadorService;
import co.edu.usbcali.clum.service.TipoUsuarioService;
import co.edu.usbcali.clum.service.TipoZonaService;
import co.edu.usbcali.clum.service.TransformadorService;
import co.edu.usbcali.clum.service.UsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Component("businessDelegator")
public class BusinessDelegatorImpl implements BusinessDelegator {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorImpl.class);
    @Autowired
    private RedAlimentacionService redAlimentacionService;
    @Autowired
    private TipoLamparaService tipoLamparaService;
    @Autowired
    private TerceroService terceroService;
    @Autowired
    private LamparaRegistradaService lamparaRegistradaService;
    @Autowired
    private EstadoService estadoService;
    @Autowired
    private SoporteLamparaService soporteLamparaService;
    @Autowired
    private LamparaService lamparaService;
    @Autowired
    private TipoBalastoService tipoBalastoService;
    @Autowired
    private TipoInstalacionService tipoInstalacionService;
    @Autowired
    private TipoTransformadorService tipoTransformadorService;
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    @Autowired
    private CanalizacionService canalizacionService;
    @Autowired
    private TipoMaterialService tipoMaterialService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TransformadorService transformadorService;
    @Autowired
    private TipoZonaService tipoZonaService;
    @Autowired
    private TipoEspacioIluminadoService tipoEspacioIluminadoService;
    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    @Autowired
    private TipoSoporteService tipoSoporteService;

    public List<RedAlimentacion> getRedAlimentacion() throws Exception {
        return redAlimentacionService.getRedAlimentacion();
    }

    public void saveRedAlimentacion(RedAlimentacion entity)
        throws Exception {
        redAlimentacionService.saveRedAlimentacion(entity);
    }

    public void deleteRedAlimentacion(RedAlimentacion entity)
        throws Exception {
        redAlimentacionService.deleteRedAlimentacion(entity);
    }

    public void updateRedAlimentacion(RedAlimentacion entity)
        throws Exception {
        redAlimentacionService.updateRedAlimentacion(entity);
    }

    public RedAlimentacion getRedAlimentacion(Integer redAlimentacionId)
        throws Exception {
        RedAlimentacion redAlimentacion = null;

        try {
            redAlimentacion = redAlimentacionService.getRedAlimentacion(redAlimentacionId);
        } catch (Exception e) {
            throw e;
        }

        return redAlimentacion;
    }

    public List<RedAlimentacion> findByCriteriaInRedAlimentacion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return redAlimentacionService.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<RedAlimentacion> findPageRedAlimentacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return redAlimentacionService.findPageRedAlimentacion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberRedAlimentacion() throws Exception {
        return redAlimentacionService.findTotalNumberRedAlimentacion();
    }

    public List<RedAlimentacionDTO> getDataRedAlimentacion()
        throws Exception {
        return redAlimentacionService.getDataRedAlimentacion();
    }

    public void validateRedAlimentacion(RedAlimentacion redAlimentacion)
        throws Exception {
        redAlimentacionService.validateRedAlimentacion(redAlimentacion);
    }

    public List<TipoLampara> getTipoLampara() throws Exception {
        return tipoLamparaService.getTipoLampara();
    }

    public void saveTipoLampara(TipoLampara entity) throws Exception {
        tipoLamparaService.saveTipoLampara(entity);
    }

    public void deleteTipoLampara(TipoLampara entity) throws Exception {
        tipoLamparaService.deleteTipoLampara(entity);
    }

    public void updateTipoLampara(TipoLampara entity) throws Exception {
        tipoLamparaService.updateTipoLampara(entity);
    }

    public TipoLampara getTipoLampara(Integer tipoLamparaId)
        throws Exception {
        TipoLampara tipoLampara = null;

        try {
            tipoLampara = tipoLamparaService.getTipoLampara(tipoLamparaId);
        } catch (Exception e) {
            throw e;
        }

        return tipoLampara;
    }

    public List<TipoLampara> findByCriteriaInTipoLampara(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoLamparaService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoLampara> findPageTipoLampara(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoLamparaService.findPageTipoLampara(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoLampara() throws Exception {
        return tipoLamparaService.findTotalNumberTipoLampara();
    }

    public List<TipoLamparaDTO> getDataTipoLampara() throws Exception {
        return tipoLamparaService.getDataTipoLampara();
    }

    public void validateTipoLampara(TipoLampara tipoLampara)
        throws Exception {
        tipoLamparaService.validateTipoLampara(tipoLampara);
    }

    public List<Tercero> getTercero() throws Exception {
        return terceroService.getTercero();
    }

    public void saveTercero(Tercero entity) throws Exception {
        terceroService.saveTercero(entity);
    }

    public void deleteTercero(Tercero entity) throws Exception {
        terceroService.deleteTercero(entity);
    }

    public void updateTercero(Tercero entity) throws Exception {
        terceroService.updateTercero(entity);
    }

    public Tercero getTercero(Integer terceroId) throws Exception {
        Tercero tercero = null;

        try {
            tercero = terceroService.getTercero(terceroId);
        } catch (Exception e) {
            throw e;
        }

        return tercero;
    }

    public List<Tercero> findByCriteriaInTercero(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return terceroService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Tercero> findPageTercero(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return terceroService.findPageTercero(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberTercero() throws Exception {
        return terceroService.findTotalNumberTercero();
    }

    public List<TerceroDTO> getDataTercero() throws Exception {
        return terceroService.getDataTercero();
    }

    public void validateTercero(Tercero tercero) throws Exception {
        terceroService.validateTercero(tercero);
    }

    public List<LamparaRegistrada> getLamparaRegistrada()
        throws Exception {
        return lamparaRegistradaService.getLamparaRegistrada();
    }

    public void saveLamparaRegistrada(LamparaRegistrada entity)
        throws Exception {
        lamparaRegistradaService.saveLamparaRegistrada(entity);
    }

    public void deleteLamparaRegistrada(LamparaRegistrada entity)
        throws Exception {
        lamparaRegistradaService.deleteLamparaRegistrada(entity);
    }

    public void updateLamparaRegistrada(LamparaRegistrada entity)
        throws Exception {
        lamparaRegistradaService.updateLamparaRegistrada(entity);
    }

    public LamparaRegistrada getLamparaRegistrada(Integer lamparaRegistradaId)
        throws Exception {
        LamparaRegistrada lamparaRegistrada = null;

        try {
            lamparaRegistrada = lamparaRegistradaService.getLamparaRegistrada(lamparaRegistradaId);
        } catch (Exception e) {
            throw e;
        }

        return lamparaRegistrada;
    }

    public List<LamparaRegistrada> findByCriteriaInLamparaRegistrada(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return lamparaRegistradaService.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<LamparaRegistrada> findPageLamparaRegistrada(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return lamparaRegistradaService.findPageLamparaRegistrada(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberLamparaRegistrada() throws Exception {
        return lamparaRegistradaService.findTotalNumberLamparaRegistrada();
    }

    public List<LamparaRegistradaDTO> getDataLamparaRegistrada()
        throws Exception {
        return lamparaRegistradaService.getDataLamparaRegistrada();
    }

    public void validateLamparaRegistrada(LamparaRegistrada lamparaRegistrada)
        throws Exception {
        lamparaRegistradaService.validateLamparaRegistrada(lamparaRegistrada);
    }

    public List<Estado> getEstado() throws Exception {
        return estadoService.getEstado();
    }

    public void saveEstado(Estado entity) throws Exception {
        estadoService.saveEstado(entity);
    }

    public void deleteEstado(Estado entity) throws Exception {
        estadoService.deleteEstado(entity);
    }

    public void updateEstado(Estado entity) throws Exception {
        estadoService.updateEstado(entity);
    }

    public Estado getEstado(Integer idEstado) throws Exception {
        Estado estado = null;

        try {
            estado = estadoService.getEstado(idEstado);
        } catch (Exception e) {
            throw e;
        }

        return estado;
    }

    public List<Estado> findByCriteriaInEstado(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return estadoService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Estado> findPageEstado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return estadoService.findPageEstado(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberEstado() throws Exception {
        return estadoService.findTotalNumberEstado();
    }

    public List<EstadoDTO> getDataEstado() throws Exception {
        return estadoService.getDataEstado();
    }

    public void validateEstado(Estado estado) throws Exception {
        estadoService.validateEstado(estado);
    }

    public List<SoporteLampara> getSoporteLampara() throws Exception {
        return soporteLamparaService.getSoporteLampara();
    }

    public void saveSoporteLampara(SoporteLampara entity)
        throws Exception {
        soporteLamparaService.saveSoporteLampara(entity);
    }

    public void deleteSoporteLampara(SoporteLampara entity)
        throws Exception {
        soporteLamparaService.deleteSoporteLampara(entity);
    }

    public void updateSoporteLampara(SoporteLampara entity)
        throws Exception {
        soporteLamparaService.updateSoporteLampara(entity);
    }

    public SoporteLampara getSoporteLampara(Integer soporteLamparaId)
        throws Exception {
        SoporteLampara soporteLampara = null;

        try {
            soporteLampara = soporteLamparaService.getSoporteLampara(soporteLamparaId);
        } catch (Exception e) {
            throw e;
        }

        return soporteLampara;
    }

    public List<SoporteLampara> findByCriteriaInSoporteLampara(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return soporteLamparaService.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<SoporteLampara> findPageSoporteLampara(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return soporteLamparaService.findPageSoporteLampara(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberSoporteLampara() throws Exception {
        return soporteLamparaService.findTotalNumberSoporteLampara();
    }

    public List<SoporteLamparaDTO> getDataSoporteLampara()
        throws Exception {
        return soporteLamparaService.getDataSoporteLampara();
    }

    public void validateSoporteLampara(SoporteLampara soporteLampara)
        throws Exception {
        soporteLamparaService.validateSoporteLampara(soporteLampara);
    }

    public List<Lampara> getLampara() throws Exception {
        return lamparaService.getLampara();
    }

    public void saveLampara(Lampara entity) throws Exception {
        lamparaService.saveLampara(entity);
    }

    public void deleteLampara(Lampara entity) throws Exception {
        lamparaService.deleteLampara(entity);
    }

    public void updateLampara(Lampara entity) throws Exception {
        lamparaService.updateLampara(entity);
    }

    public Lampara getLampara(Integer lamparaId) throws Exception {
        Lampara lampara = null;

        try {
            lampara = lamparaService.getLampara(lamparaId);
        } catch (Exception e) {
            throw e;
        }

        return lampara;
    }

    public List<Lampara> findByCriteriaInLampara(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return lamparaService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Lampara> findPageLampara(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return lamparaService.findPageLampara(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberLampara() throws Exception {
        return lamparaService.findTotalNumberLampara();
    }

    public List<LamparaDTO> getDataLampara() throws Exception {
        return lamparaService.getDataLampara();
    }

    public void validateLampara(Lampara lampara) throws Exception {
        lamparaService.validateLampara(lampara);
    }

    public List<TipoBalasto> getTipoBalasto() throws Exception {
        return tipoBalastoService.getTipoBalasto();
    }

    public void saveTipoBalasto(TipoBalasto entity) throws Exception {
        tipoBalastoService.saveTipoBalasto(entity);
    }

    public void deleteTipoBalasto(TipoBalasto entity) throws Exception {
        tipoBalastoService.deleteTipoBalasto(entity);
    }

    public void updateTipoBalasto(TipoBalasto entity) throws Exception {
        tipoBalastoService.updateTipoBalasto(entity);
    }

    public TipoBalasto getTipoBalasto(Integer tipoBalastoId)
        throws Exception {
        TipoBalasto tipoBalasto = null;

        try {
            tipoBalasto = tipoBalastoService.getTipoBalasto(tipoBalastoId);
        } catch (Exception e) {
            throw e;
        }

        return tipoBalasto;
    }

    public List<TipoBalasto> findByCriteriaInTipoBalasto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoBalastoService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoBalasto> findPageTipoBalasto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoBalastoService.findPageTipoBalasto(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoBalasto() throws Exception {
        return tipoBalastoService.findTotalNumberTipoBalasto();
    }

    public List<TipoBalastoDTO> getDataTipoBalasto() throws Exception {
        return tipoBalastoService.getDataTipoBalasto();
    }

    public void validateTipoBalasto(TipoBalasto tipoBalasto)
        throws Exception {
        tipoBalastoService.validateTipoBalasto(tipoBalasto);
    }

    public List<TipoInstalacion> getTipoInstalacion() throws Exception {
        return tipoInstalacionService.getTipoInstalacion();
    }

    public void saveTipoInstalacion(TipoInstalacion entity)
        throws Exception {
        tipoInstalacionService.saveTipoInstalacion(entity);
    }

    public void deleteTipoInstalacion(TipoInstalacion entity)
        throws Exception {
        tipoInstalacionService.deleteTipoInstalacion(entity);
    }

    public void updateTipoInstalacion(TipoInstalacion entity)
        throws Exception {
        tipoInstalacionService.updateTipoInstalacion(entity);
    }

    public TipoInstalacion getTipoInstalacion(Integer tipoInstalacionId)
        throws Exception {
        TipoInstalacion tipoInstalacion = null;

        try {
            tipoInstalacion = tipoInstalacionService.getTipoInstalacion(tipoInstalacionId);
        } catch (Exception e) {
            throw e;
        }

        return tipoInstalacion;
    }

    public List<TipoInstalacion> findByCriteriaInTipoInstalacion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoInstalacionService.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<TipoInstalacion> findPageTipoInstalacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tipoInstalacionService.findPageTipoInstalacion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoInstalacion() throws Exception {
        return tipoInstalacionService.findTotalNumberTipoInstalacion();
    }

    public List<TipoInstalacionDTO> getDataTipoInstalacion()
        throws Exception {
        return tipoInstalacionService.getDataTipoInstalacion();
    }

    public void validateTipoInstalacion(TipoInstalacion tipoInstalacion)
        throws Exception {
        tipoInstalacionService.validateTipoInstalacion(tipoInstalacion);
    }

    public List<TipoTransformador> getTipoTransformador()
        throws Exception {
        return tipoTransformadorService.getTipoTransformador();
    }

    public void saveTipoTransformador(TipoTransformador entity)
        throws Exception {
        tipoTransformadorService.saveTipoTransformador(entity);
    }

    public void deleteTipoTransformador(TipoTransformador entity)
        throws Exception {
        tipoTransformadorService.deleteTipoTransformador(entity);
    }

    public void updateTipoTransformador(TipoTransformador entity)
        throws Exception {
        tipoTransformadorService.updateTipoTransformador(entity);
    }

    public TipoTransformador getTipoTransformador(Integer tipoTransformadorId)
        throws Exception {
        TipoTransformador tipoTransformador = null;

        try {
            tipoTransformador = tipoTransformadorService.getTipoTransformador(tipoTransformadorId);
        } catch (Exception e) {
            throw e;
        }

        return tipoTransformador;
    }

    public List<TipoTransformador> findByCriteriaInTipoTransformador(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoTransformadorService.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<TipoTransformador> findPageTipoTransformador(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tipoTransformadorService.findPageTipoTransformador(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoTransformador() throws Exception {
        return tipoTransformadorService.findTotalNumberTipoTransformador();
    }

    public List<TipoTransformadorDTO> getDataTipoTransformador()
        throws Exception {
        return tipoTransformadorService.getDataTipoTransformador();
    }

    public void validateTipoTransformador(TipoTransformador tipoTransformador)
        throws Exception {
        tipoTransformadorService.validateTipoTransformador(tipoTransformador);
    }

    public List<TipoDocumento> getTipoDocumento() throws Exception {
        return tipoDocumentoService.getTipoDocumento();
    }

    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoService.saveTipoDocumento(entity);
    }

    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoService.deleteTipoDocumento(entity);
    }

    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoService.updateTipoDocumento(entity);
    }

    public TipoDocumento getTipoDocumento(Integer tipoDocumentoId)
        throws Exception {
        TipoDocumento tipoDocumento = null;

        try {
            tipoDocumento = tipoDocumentoService.getTipoDocumento(tipoDocumentoId);
        } catch (Exception e) {
            throw e;
        }

        return tipoDocumento;
    }

    public List<TipoDocumento> findByCriteriaInTipoDocumento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoDocumentoService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoDocumentoService.findPageTipoDocumento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoDocumento() throws Exception {
        return tipoDocumentoService.findTotalNumberTipoDocumento();
    }

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception {
        return tipoDocumentoService.getDataTipoDocumento();
    }

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception {
        tipoDocumentoService.validateTipoDocumento(tipoDocumento);
    }

    public List<Canalizacion> getCanalizacion() throws Exception {
        return canalizacionService.getCanalizacion();
    }

    public void saveCanalizacion(Canalizacion entity) throws Exception {
        canalizacionService.saveCanalizacion(entity);
    }

    public void deleteCanalizacion(Canalizacion entity)
        throws Exception {
        canalizacionService.deleteCanalizacion(entity);
    }

    public void updateCanalizacion(Canalizacion entity)
        throws Exception {
        canalizacionService.updateCanalizacion(entity);
    }

    public Canalizacion getCanalizacion(Integer canalizacionId)
        throws Exception {
        Canalizacion canalizacion = null;

        try {
            canalizacion = canalizacionService.getCanalizacion(canalizacionId);
        } catch (Exception e) {
            throw e;
        }

        return canalizacion;
    }

    public List<Canalizacion> findByCriteriaInCanalizacion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return canalizacionService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Canalizacion> findPageCanalizacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return canalizacionService.findPageCanalizacion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberCanalizacion() throws Exception {
        return canalizacionService.findTotalNumberCanalizacion();
    }

    public List<CanalizacionDTO> getDataCanalizacion()
        throws Exception {
        return canalizacionService.getDataCanalizacion();
    }

    public void validateCanalizacion(Canalizacion canalizacion)
        throws Exception {
        canalizacionService.validateCanalizacion(canalizacion);
    }

    public List<TipoMaterial> getTipoMaterial() throws Exception {
        return tipoMaterialService.getTipoMaterial();
    }

    public void saveTipoMaterial(TipoMaterial entity) throws Exception {
        tipoMaterialService.saveTipoMaterial(entity);
    }

    public void deleteTipoMaterial(TipoMaterial entity)
        throws Exception {
        tipoMaterialService.deleteTipoMaterial(entity);
    }

    public void updateTipoMaterial(TipoMaterial entity)
        throws Exception {
        tipoMaterialService.updateTipoMaterial(entity);
    }

    public TipoMaterial getTipoMaterial(Integer tipoMaterialId)
        throws Exception {
        TipoMaterial tipoMaterial = null;

        try {
            tipoMaterial = tipoMaterialService.getTipoMaterial(tipoMaterialId);
        } catch (Exception e) {
            throw e;
        }

        return tipoMaterial;
    }

    public List<TipoMaterial> findByCriteriaInTipoMaterial(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoMaterialService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoMaterial> findPageTipoMaterial(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoMaterialService.findPageTipoMaterial(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoMaterial() throws Exception {
        return tipoMaterialService.findTotalNumberTipoMaterial();
    }

    public List<TipoMaterialDTO> getDataTipoMaterial()
        throws Exception {
        return tipoMaterialService.getDataTipoMaterial();
    }

    public void validateTipoMaterial(TipoMaterial tipoMaterial)
        throws Exception {
        tipoMaterialService.validateTipoMaterial(tipoMaterial);
    }

    public List<Usuario> getUsuario() throws Exception {
        return usuarioService.getUsuario();
    }

    public void saveUsuario(Usuario entity) throws Exception {
        usuarioService.saveUsuario(entity);
    }

    public void deleteUsuario(Usuario entity) throws Exception {
        usuarioService.deleteUsuario(entity);
    }

    public void updateUsuario(Usuario entity) throws Exception {
        usuarioService.updateUsuario(entity);
    }

    public Usuario getUsuario(String usuarioId) throws Exception {
        Usuario usuario = null;

        try {
            usuario = usuarioService.getUsuario(usuarioId);
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuarioService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioService.findPageUsuario(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberUsuario() throws Exception {
        return usuarioService.findTotalNumberUsuario();
    }

    public List<UsuarioDTO> getDataUsuario() throws Exception {
        return usuarioService.getDataUsuario();
    }

    public void validateUsuario(Usuario usuario) throws Exception {
        usuarioService.validateUsuario(usuario);
    }

    public List<Transformador> getTransformador() throws Exception {
        return transformadorService.getTransformador();
    }

    public void saveTransformador(Transformador entity)
        throws Exception {
        transformadorService.saveTransformador(entity);
    }

    public void deleteTransformador(Transformador entity)
        throws Exception {
        transformadorService.deleteTransformador(entity);
    }

    public void updateTransformador(Transformador entity)
        throws Exception {
        transformadorService.updateTransformador(entity);
    }

    public Transformador getTransformador(Integer transformadorId)
        throws Exception {
        Transformador transformador = null;

        try {
            transformador = transformadorService.getTransformador(transformadorId);
        } catch (Exception e) {
            throw e;
        }

        return transformador;
    }

    public List<Transformador> findByCriteriaInTransformador(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return transformadorService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Transformador> findPageTransformador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return transformadorService.findPageTransformador(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTransformador() throws Exception {
        return transformadorService.findTotalNumberTransformador();
    }

    public List<TransformadorDTO> getDataTransformador()
        throws Exception {
        return transformadorService.getDataTransformador();
    }

    public void validateTransformador(Transformador transformador)
        throws Exception {
        transformadorService.validateTransformador(transformador);
    }

    public List<TipoZona> getTipoZona() throws Exception {
        return tipoZonaService.getTipoZona();
    }

    public void saveTipoZona(TipoZona entity) throws Exception {
        tipoZonaService.saveTipoZona(entity);
    }

    public void deleteTipoZona(TipoZona entity) throws Exception {
        tipoZonaService.deleteTipoZona(entity);
    }

    public void updateTipoZona(TipoZona entity) throws Exception {
        tipoZonaService.updateTipoZona(entity);
    }

    public TipoZona getTipoZona(Integer tipoZonaId) throws Exception {
        TipoZona tipoZona = null;

        try {
            tipoZona = tipoZonaService.getTipoZona(tipoZonaId);
        } catch (Exception e) {
            throw e;
        }

        return tipoZona;
    }

    public List<TipoZona> findByCriteriaInTipoZona(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoZonaService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoZona> findPageTipoZona(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoZonaService.findPageTipoZona(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberTipoZona() throws Exception {
        return tipoZonaService.findTotalNumberTipoZona();
    }

    public List<TipoZonaDTO> getDataTipoZona() throws Exception {
        return tipoZonaService.getDataTipoZona();
    }

    public void validateTipoZona(TipoZona tipoZona) throws Exception {
        tipoZonaService.validateTipoZona(tipoZona);
    }

    public List<TipoEspacioIluminado> getTipoEspacioIluminado()
        throws Exception {
        return tipoEspacioIluminadoService.getTipoEspacioIluminado();
    }

    public void saveTipoEspacioIluminado(TipoEspacioIluminado entity)
        throws Exception {
        tipoEspacioIluminadoService.saveTipoEspacioIluminado(entity);
    }

    public void deleteTipoEspacioIluminado(TipoEspacioIluminado entity)
        throws Exception {
        tipoEspacioIluminadoService.deleteTipoEspacioIluminado(entity);
    }

    public void updateTipoEspacioIluminado(TipoEspacioIluminado entity)
        throws Exception {
        tipoEspacioIluminadoService.updateTipoEspacioIluminado(entity);
    }

    public TipoEspacioIluminado getTipoEspacioIluminado(
        Integer tipoEspacioIluminadoId) throws Exception {
        TipoEspacioIluminado tipoEspacioIluminado = null;

        try {
            tipoEspacioIluminado = tipoEspacioIluminadoService.getTipoEspacioIluminado(tipoEspacioIluminadoId);
        } catch (Exception e) {
            throw e;
        }

        return tipoEspacioIluminado;
    }

    public List<TipoEspacioIluminado> findByCriteriaInTipoEspacioIluminado(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoEspacioIluminadoService.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<TipoEspacioIluminado> findPageTipoEspacioIluminado(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tipoEspacioIluminadoService.findPageTipoEspacioIluminado(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoEspacioIluminado() throws Exception {
        return tipoEspacioIluminadoService.findTotalNumberTipoEspacioIluminado();
    }

    public List<TipoEspacioIluminadoDTO> getDataTipoEspacioIluminado()
        throws Exception {
        return tipoEspacioIluminadoService.getDataTipoEspacioIluminado();
    }

    public void validateTipoEspacioIluminado(
        TipoEspacioIluminado tipoEspacioIluminado) throws Exception {
        tipoEspacioIluminadoService.validateTipoEspacioIluminado(tipoEspacioIluminado);
    }

    public List<TipoUsuario> getTipoUsuario() throws Exception {
        return tipoUsuarioService.getTipoUsuario();
    }

    public void saveTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioService.saveTipoUsuario(entity);
    }

    public void deleteTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioService.deleteTipoUsuario(entity);
    }

    public void updateTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioService.updateTipoUsuario(entity);
    }

    public TipoUsuario getTipoUsuario(Integer tipoUsuarioId)
        throws Exception {
        TipoUsuario tipoUsuario = null;

        try {
            tipoUsuario = tipoUsuarioService.getTipoUsuario(tipoUsuarioId);
        } catch (Exception e) {
            throw e;
        }

        return tipoUsuario;
    }

    public List<TipoUsuario> findByCriteriaInTipoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoUsuarioService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoUsuario> findPageTipoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoUsuarioService.findPageTipoUsuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoUsuario() throws Exception {
        return tipoUsuarioService.findTotalNumberTipoUsuario();
    }

    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception {
        return tipoUsuarioService.getDataTipoUsuario();
    }

    public void validateTipoUsuario(TipoUsuario tipoUsuario)
        throws Exception {
        tipoUsuarioService.validateTipoUsuario(tipoUsuario);
    }

    public List<TipoSoporte> getTipoSoporte() throws Exception {
        return tipoSoporteService.getTipoSoporte();
    }

    public void saveTipoSoporte(TipoSoporte entity) throws Exception {
        tipoSoporteService.saveTipoSoporte(entity);
    }

    public void deleteTipoSoporte(TipoSoporte entity) throws Exception {
        tipoSoporteService.deleteTipoSoporte(entity);
    }

    public void updateTipoSoporte(TipoSoporte entity) throws Exception {
        tipoSoporteService.updateTipoSoporte(entity);
    }

    public TipoSoporte getTipoSoporte(Integer tipoSoporteId)
        throws Exception {
        TipoSoporte tipoSoporte = null;

        try {
            tipoSoporte = tipoSoporteService.getTipoSoporte(tipoSoporteId);
        } catch (Exception e) {
            throw e;
        }

        return tipoSoporte;
    }

    public List<TipoSoporte> findByCriteriaInTipoSoporte(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoSoporteService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoSoporte> findPageTipoSoporte(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoSoporteService.findPageTipoSoporte(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoSoporte() throws Exception {
        return tipoSoporteService.findTotalNumberTipoSoporte();
    }

    public List<TipoSoporteDTO> getDataTipoSoporte() throws Exception {
        return tipoSoporteService.getDataTipoSoporte();
    }

    public void validateTipoSoporte(TipoSoporte tipoSoporte)
        throws Exception {
        tipoSoporteService.validateTipoSoporte(tipoSoporte);
    }
}
