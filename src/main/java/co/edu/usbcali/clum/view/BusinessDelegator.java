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

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface BusinessDelegator {
    public List<RedAlimentacion> getRedAlimentacion() throws Exception;

    public void saveRedAlimentacion(RedAlimentacion entity)
        throws Exception;

    public void deleteRedAlimentacion(RedAlimentacion entity)
        throws Exception;

    public void updateRedAlimentacion(RedAlimentacion entity)
        throws Exception;

    public RedAlimentacion getRedAlimentacion(Integer redAlimentacionId)
        throws Exception;

    public List<RedAlimentacion> findByCriteriaInRedAlimentacion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<RedAlimentacion> findPageRedAlimentacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberRedAlimentacion() throws Exception;

    public List<RedAlimentacionDTO> getDataRedAlimentacion()
        throws Exception;

    public void validateRedAlimentacion(RedAlimentacion redAlimentacion)
        throws Exception;

    public List<TipoLampara> getTipoLampara() throws Exception;

    public void saveTipoLampara(TipoLampara entity) throws Exception;

    public void deleteTipoLampara(TipoLampara entity) throws Exception;

    public void updateTipoLampara(TipoLampara entity) throws Exception;

    public TipoLampara getTipoLampara(Integer tipoLamparaId)
        throws Exception;

    public List<TipoLampara> findByCriteriaInTipoLampara(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoLampara> findPageTipoLampara(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoLampara() throws Exception;

    public List<TipoLamparaDTO> getDataTipoLampara() throws Exception;

    public void validateTipoLampara(TipoLampara tipoLampara)
        throws Exception;

    public List<Tercero> getTercero() throws Exception;

    public void saveTercero(Tercero entity) throws Exception;

    public void deleteTercero(Tercero entity) throws Exception;

    public void updateTercero(Tercero entity) throws Exception;

    public Tercero getTercero(Integer terceroId) throws Exception;

    public List<Tercero> findByCriteriaInTercero(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tercero> findPageTercero(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTercero() throws Exception;

    public List<TerceroDTO> getDataTercero() throws Exception;

    public void validateTercero(Tercero tercero) throws Exception;

    public List<LamparaRegistrada> getLamparaRegistrada()
        throws Exception;

    public void saveLamparaRegistrada(LamparaRegistrada entity)
        throws Exception;

    public void deleteLamparaRegistrada(LamparaRegistrada entity)
        throws Exception;

    public void updateLamparaRegistrada(LamparaRegistrada entity)
        throws Exception;

    public LamparaRegistrada getLamparaRegistrada(Integer lamparaRegistradaId)
        throws Exception;

    public List<LamparaRegistrada> findByCriteriaInLamparaRegistrada(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<LamparaRegistrada> findPageLamparaRegistrada(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberLamparaRegistrada() throws Exception;

    public List<LamparaRegistradaDTO> getDataLamparaRegistrada()
        throws Exception;

    public void validateLamparaRegistrada(LamparaRegistrada lamparaRegistrada)
        throws Exception;

    public List<Estado> getEstado() throws Exception;

    public void saveEstado(Estado entity) throws Exception;

    public void deleteEstado(Estado entity) throws Exception;

    public void updateEstado(Estado entity) throws Exception;

    public Estado getEstado(Integer idEstado) throws Exception;

    public List<Estado> findByCriteriaInEstado(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Estado> findPageEstado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEstado() throws Exception;

    public List<EstadoDTO> getDataEstado() throws Exception;

    public void validateEstado(Estado estado) throws Exception;

    public List<SoporteLampara> getSoporteLampara() throws Exception;

    public void saveSoporteLampara(SoporteLampara entity)
        throws Exception;

    public void deleteSoporteLampara(SoporteLampara entity)
        throws Exception;

    public void updateSoporteLampara(SoporteLampara entity)
        throws Exception;

    public SoporteLampara getSoporteLampara(Integer soporteLamparaId)
        throws Exception;

    public List<SoporteLampara> findByCriteriaInSoporteLampara(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<SoporteLampara> findPageSoporteLampara(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSoporteLampara() throws Exception;

    public List<SoporteLamparaDTO> getDataSoporteLampara()
        throws Exception;

    public void validateSoporteLampara(SoporteLampara soporteLampara)
        throws Exception;

    public List<Lampara> getLampara() throws Exception;

    public void saveLampara(Lampara entity) throws Exception;

    public void deleteLampara(Lampara entity) throws Exception;

    public void updateLampara(Lampara entity) throws Exception;

    public Lampara getLampara(Integer lamparaId) throws Exception;

    public List<Lampara> findByCriteriaInLampara(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Lampara> findPageLampara(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberLampara() throws Exception;

    public List<LamparaDTO> getDataLampara() throws Exception;

    public void validateLampara(Lampara lampara) throws Exception;

    public List<TipoBalasto> getTipoBalasto() throws Exception;

    public void saveTipoBalasto(TipoBalasto entity) throws Exception;

    public void deleteTipoBalasto(TipoBalasto entity) throws Exception;

    public void updateTipoBalasto(TipoBalasto entity) throws Exception;

    public TipoBalasto getTipoBalasto(Integer tipoBalastoId)
        throws Exception;

    public List<TipoBalasto> findByCriteriaInTipoBalasto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoBalasto> findPageTipoBalasto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoBalasto() throws Exception;

    public List<TipoBalastoDTO> getDataTipoBalasto() throws Exception;

    public void validateTipoBalasto(TipoBalasto tipoBalasto)
        throws Exception;

    public List<TipoInstalacion> getTipoInstalacion() throws Exception;

    public void saveTipoInstalacion(TipoInstalacion entity)
        throws Exception;

    public void deleteTipoInstalacion(TipoInstalacion entity)
        throws Exception;

    public void updateTipoInstalacion(TipoInstalacion entity)
        throws Exception;

    public TipoInstalacion getTipoInstalacion(Integer tipoInstalacionId)
        throws Exception;

    public List<TipoInstalacion> findByCriteriaInTipoInstalacion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoInstalacion> findPageTipoInstalacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoInstalacion() throws Exception;

    public List<TipoInstalacionDTO> getDataTipoInstalacion()
        throws Exception;

    public void validateTipoInstalacion(TipoInstalacion tipoInstalacion)
        throws Exception;

    public List<TipoTransformador> getTipoTransformador()
        throws Exception;

    public void saveTipoTransformador(TipoTransformador entity)
        throws Exception;

    public void deleteTipoTransformador(TipoTransformador entity)
        throws Exception;

    public void updateTipoTransformador(TipoTransformador entity)
        throws Exception;

    public TipoTransformador getTipoTransformador(Integer tipoTransformadorId)
        throws Exception;

    public List<TipoTransformador> findByCriteriaInTipoTransformador(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoTransformador> findPageTipoTransformador(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoTransformador() throws Exception;

    public List<TipoTransformadorDTO> getDataTipoTransformador()
        throws Exception;

    public void validateTipoTransformador(TipoTransformador tipoTransformador)
        throws Exception;

    public List<TipoDocumento> getTipoDocumento() throws Exception;

    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception;

    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception;

    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception;

    public TipoDocumento getTipoDocumento(Integer tipoDocumentoId)
        throws Exception;

    public List<TipoDocumento> findByCriteriaInTipoDocumento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoDocumento() throws Exception;

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception;

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception;

    public List<Canalizacion> getCanalizacion() throws Exception;

    public void saveCanalizacion(Canalizacion entity) throws Exception;

    public void deleteCanalizacion(Canalizacion entity)
        throws Exception;

    public void updateCanalizacion(Canalizacion entity)
        throws Exception;

    public Canalizacion getCanalizacion(Integer canalizacionId)
        throws Exception;

    public List<Canalizacion> findByCriteriaInCanalizacion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Canalizacion> findPageCanalizacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCanalizacion() throws Exception;

    public List<CanalizacionDTO> getDataCanalizacion()
        throws Exception;

    public void validateCanalizacion(Canalizacion canalizacion)
        throws Exception;

    public List<TipoMaterial> getTipoMaterial() throws Exception;

    public void saveTipoMaterial(TipoMaterial entity) throws Exception;

    public void deleteTipoMaterial(TipoMaterial entity)
        throws Exception;

    public void updateTipoMaterial(TipoMaterial entity)
        throws Exception;

    public TipoMaterial getTipoMaterial(Integer tipoMaterialId)
        throws Exception;

    public List<TipoMaterial> findByCriteriaInTipoMaterial(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoMaterial> findPageTipoMaterial(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoMaterial() throws Exception;

    public List<TipoMaterialDTO> getDataTipoMaterial()
        throws Exception;

    public void validateTipoMaterial(TipoMaterial tipoMaterial)
        throws Exception;

    public List<Usuario> getUsuario() throws Exception;

    public void saveUsuario(Usuario entity) throws Exception;

    public void deleteUsuario(Usuario entity) throws Exception;

    public void updateUsuario(Usuario entity) throws Exception;

    public Usuario getUsuario(String usuarioId) throws Exception;

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuario() throws Exception;

    public List<UsuarioDTO> getDataUsuario() throws Exception;

    public void validateUsuario(Usuario usuario) throws Exception;

    public List<Transformador> getTransformador() throws Exception;

    public void saveTransformador(Transformador entity)
        throws Exception;

    public void deleteTransformador(Transformador entity)
        throws Exception;

    public void updateTransformador(Transformador entity)
        throws Exception;

    public Transformador getTransformador(Integer transformadorId)
        throws Exception;

    public List<Transformador> findByCriteriaInTransformador(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Transformador> findPageTransformador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTransformador() throws Exception;

    public List<TransformadorDTO> getDataTransformador()
        throws Exception;

    public void validateTransformador(Transformador transformador)
        throws Exception;

    public List<TipoZona> getTipoZona() throws Exception;

    public void saveTipoZona(TipoZona entity) throws Exception;

    public void deleteTipoZona(TipoZona entity) throws Exception;

    public void updateTipoZona(TipoZona entity) throws Exception;

    public TipoZona getTipoZona(Integer tipoZonaId) throws Exception;

    public List<TipoZona> findByCriteriaInTipoZona(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoZona> findPageTipoZona(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoZona() throws Exception;

    public List<TipoZonaDTO> getDataTipoZona() throws Exception;

    public void validateTipoZona(TipoZona tipoZona) throws Exception;

    public List<TipoEspacioIluminado> getTipoEspacioIluminado()
        throws Exception;

    public void saveTipoEspacioIluminado(TipoEspacioIluminado entity)
        throws Exception;

    public void deleteTipoEspacioIluminado(TipoEspacioIluminado entity)
        throws Exception;

    public void updateTipoEspacioIluminado(TipoEspacioIluminado entity)
        throws Exception;

    public TipoEspacioIluminado getTipoEspacioIluminado(
        Integer tipoEspacioIluminadoId) throws Exception;

    public List<TipoEspacioIluminado> findByCriteriaInTipoEspacioIluminado(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoEspacioIluminado> findPageTipoEspacioIluminado(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoEspacioIluminado() throws Exception;

    public List<TipoEspacioIluminadoDTO> getDataTipoEspacioIluminado()
        throws Exception;

    public void validateTipoEspacioIluminado(
        TipoEspacioIluminado tipoEspacioIluminado) throws Exception;

    public List<TipoUsuario> getTipoUsuario() throws Exception;

    public void saveTipoUsuario(TipoUsuario entity) throws Exception;

    public void deleteTipoUsuario(TipoUsuario entity) throws Exception;

    public void updateTipoUsuario(TipoUsuario entity) throws Exception;

    public TipoUsuario getTipoUsuario(Integer tipoUsuarioId)
        throws Exception;

    public List<TipoUsuario> findByCriteriaInTipoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoUsuario> findPageTipoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoUsuario() throws Exception;

    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception;

    public void validateTipoUsuario(TipoUsuario tipoUsuario)
        throws Exception;

    public List<TipoSoporte> getTipoSoporte() throws Exception;

    public void saveTipoSoporte(TipoSoporte entity) throws Exception;

    public void deleteTipoSoporte(TipoSoporte entity) throws Exception;

    public void updateTipoSoporte(TipoSoporte entity) throws Exception;

    public TipoSoporte getTipoSoporte(Integer tipoSoporteId)
        throws Exception;

    public List<TipoSoporte> findByCriteriaInTipoSoporte(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoSoporte> findPageTipoSoporte(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoSoporte() throws Exception;

    public List<TipoSoporteDTO> getDataTipoSoporte() throws Exception;

    public void validateTipoSoporte(TipoSoporte tipoSoporte)
        throws Exception;
}
