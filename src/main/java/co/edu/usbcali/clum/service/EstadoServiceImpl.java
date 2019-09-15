package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.EstadoDTO;
import co.edu.usbcali.clum.exception.*;
import co.edu.usbcali.clum.mapper.EstadoMapper;
import co.edu.usbcali.clum.repository.*;
import co.edu.usbcali.clum.utility.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
public class EstadoServiceImpl implements EstadoService {
    private static final Logger log = LoggerFactory.getLogger(EstadoServiceImpl.class);

    /**
     * Repository injected by Spring that manages Estado entities
     *
     */
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private EstadoMapper estadoMapper;
    @Autowired
    private Validator validator;

    /**
    * Repository injected by Spring that manages Canalizacion entities
    *
    */
    @Autowired
    private CanalizacionRepository canalizacionRepository;

    /**
    * Repository injected by Spring that manages Lampara entities
    *
    */
    @Autowired
    private LamparaRepository lamparaRepository;

    /**
    * Repository injected by Spring that manages RedAlimentacion entities
    *
    */
    @Autowired
    private RedAlimentacionRepository redAlimentacionRepository;

    /**
    * Repository injected by Spring that manages SoporteLampara entities
    *
    */
    @Autowired
    private SoporteLamparaRepository soporteLamparaRepository;

    /**
    * Repository injected by Spring that manages Tercero entities
    *
    */
    @Autowired
    private TerceroRepository terceroRepository;

    /**
    * Repository injected by Spring that manages TipoBalasto entities
    *
    */
    @Autowired
    private TipoBalastoRepository tipoBalastoRepository;

    /**
    * Repository injected by Spring that manages TipoDocumento entities
    *
    */
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    /**
    * Repository injected by Spring that manages TipoEspacioIluminado entities
    *
    */
    @Autowired
    private TipoEspacioIluminadoRepository tipoEspacioIluminadoRepository;

    /**
    * Repository injected by Spring that manages TipoInstalacion entities
    *
    */
    @Autowired
    private TipoInstalacionRepository tipoInstalacionRepository;

    /**
    * Repository injected by Spring that manages TipoLampara entities
    *
    */
    @Autowired
    private TipoLamparaRepository tipoLamparaRepository;

    /**
    * Repository injected by Spring that manages TipoMaterial entities
    *
    */
    @Autowired
    private TipoMaterialRepository tipoMaterialRepository;

    /**
    * Repository injected by Spring that manages TipoSoporte entities
    *
    */
    @Autowired
    private TipoSoporteRepository tipoSoporteRepository;

    /**
    * Repository injected by Spring that manages TipoTransformador entities
    *
    */
    @Autowired
    private TipoTransformadorRepository tipoTransformadorRepository;

    /**
    * Repository injected by Spring that manages TipoUsuario entities
    *
    */
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    /**
    * Repository injected by Spring that manages TipoZona entities
    *
    */
    @Autowired
    private TipoZonaRepository tipoZonaRepository;

    /**
    * Repository injected by Spring that manages Transformador entities
    *
    */
    @Autowired
    private TransformadorRepository transformadorRepository;

    /**
    * Repository injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validateEstado(Estado estado) throws Exception {
        try {
            Set<ConstraintViolation<Estado>> constraintViolations = validator.validate(estado);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Estado> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Estado> getEstado() throws Exception {
        log.debug("finding all Estado instances");

        List<Estado> list = new ArrayList<Estado>();

        try {
            list = estadoRepository.findAll();
        } catch (Exception e) {
            log.error("finding all Estado failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Estado");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveEstado(Estado entity) throws Exception {
        log.debug("saving Estado instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Estado");
            }

            validateEstado(entity);

            if (getEstado(entity.getIdEstado()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            estadoRepository.save(entity);
            log.debug("save Estado successful");
        } catch (Exception e) {
            log.error("save Estado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteEstado(Estado entity) throws Exception {
        log.debug("deleting Estado instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Estado");
        }

        if (entity.getIdEstado() == null) {
            throw new ZMessManager().new EmptyFieldException("idEstado");
        }

        List<Canalizacion> canalizacions = null;
        List<Lampara> lamparas = null;
        List<RedAlimentacion> redAlimentacions = null;
        List<SoporteLampara> soporteLamparas = null;
        List<Tercero> terceros = null;
        List<TipoBalasto> tipoBalastos = null;
        List<TipoDocumento> tipoDocumentos = null;
        List<TipoEspacioIluminado> tipoEspacioIluminados = null;
        List<TipoInstalacion> tipoInstalacions = null;
        List<TipoLampara> tipoLamparas = null;
        List<TipoMaterial> tipoMaterials = null;
        List<TipoSoporte> tipoSoportes = null;
        List<TipoTransformador> tipoTransformadors = null;
        List<TipoUsuario> tipoUsuarios = null;
        List<TipoZona> tipoZonas = null;
        List<Transformador> transformadors = null;
        List<Usuario> usuarios = null;

        try {
            canalizacions = canalizacionRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(canalizacions) == true) {
                throw new ZMessManager().new DeletingException("canalizacions");
            }

            lamparas = lamparaRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(lamparas) == true) {
                throw new ZMessManager().new DeletingException("lamparas");
            }

            redAlimentacions = redAlimentacionRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(redAlimentacions) == true) {
                throw new ZMessManager().new DeletingException(
                    "redAlimentacions");
            }

            soporteLamparas = soporteLamparaRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(soporteLamparas) == true) {
                throw new ZMessManager().new DeletingException(
                    "soporteLamparas");
            }

            terceros = terceroRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(terceros) == true) {
                throw new ZMessManager().new DeletingException("terceros");
            }

            tipoBalastos = tipoBalastoRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(tipoBalastos) == true) {
                throw new ZMessManager().new DeletingException("tipoBalastos");
            }

            tipoDocumentos = tipoDocumentoRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(tipoDocumentos) == true) {
                throw new ZMessManager().new DeletingException("tipoDocumentos");
            }

            tipoEspacioIluminados = tipoEspacioIluminadoRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(tipoEspacioIluminados) == true) {
                throw new ZMessManager().new DeletingException(
                    "tipoEspacioIluminados");
            }

            tipoInstalacions = tipoInstalacionRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(tipoInstalacions) == true) {
                throw new ZMessManager().new DeletingException(
                    "tipoInstalacions");
            }

            tipoLamparas = tipoLamparaRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(tipoLamparas) == true) {
                throw new ZMessManager().new DeletingException("tipoLamparas");
            }

            tipoMaterials = tipoMaterialRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(tipoMaterials) == true) {
                throw new ZMessManager().new DeletingException("tipoMaterials");
            }

            tipoSoportes = tipoSoporteRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(tipoSoportes) == true) {
                throw new ZMessManager().new DeletingException("tipoSoportes");
            }

            tipoTransformadors = tipoTransformadorRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(tipoTransformadors) == true) {
                throw new ZMessManager().new DeletingException(
                    "tipoTransformadors");
            }

            tipoUsuarios = tipoUsuarioRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(tipoUsuarios) == true) {
                throw new ZMessManager().new DeletingException("tipoUsuarios");
            }

            tipoZonas = tipoZonaRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(tipoZonas) == true) {
                throw new ZMessManager().new DeletingException("tipoZonas");
            }

            transformadors = transformadorRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(transformadors) == true) {
                throw new ZMessManager().new DeletingException("transformadors");
            }

            usuarios = usuarioRepository.findByProperty("estado.idEstado",
                    entity.getIdEstado());

            if (Utilities.validationsList(usuarios) == true) {
                throw new ZMessManager().new DeletingException("usuarios");
            }

            estadoRepository.deleteById(entity.getIdEstado());
            log.debug("delete Estado successful");
        } catch (Exception e) {
            log.error("delete Estado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateEstado(Estado entity) throws Exception {
        log.debug("updating Estado instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Estado");
            }

            validateEstado(entity);

            estadoRepository.update(entity);

            log.debug("update Estado successful");
        } catch (Exception e) {
            log.error("update Estado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<EstadoDTO> getDataEstado() throws Exception {
        try {
            List<Estado> estado = estadoRepository.findAll();

            List<EstadoDTO> estadoDTO = new ArrayList<EstadoDTO>();

            for (Estado estadoTmp : estado) {
                EstadoDTO estadoDTO2 = estadoMapper.estadoToEstadoDTO(estadoTmp);
                estadoDTO.add(estadoDTO2);
            }

            return estadoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Estado getEstado(Integer idEstado) throws Exception {
        log.debug("getting Estado instance");

        Estado entity = null;

        try {
            if (estadoRepository.findById(idEstado).isPresent()) {
                entity = estadoRepository.findById(idEstado).get();
            }
        } catch (Exception e) {
            log.error("get Estado failed", e);
            throw new ZMessManager().new FindingException("Estado");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Estado> findPageEstado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Estado> entity = null;

        try {
            entity = estadoRepository.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Estado Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberEstado() throws Exception {
        Long entity = null;

        try {
            entity = estadoRepository.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Estado Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Estado> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Estado> list = new ArrayList<Estado>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between " + value +
                        " and " + value2 + ")")
                        : (tempWhere + " AND (model." + variable + " between " +
                        value + " and " + value2 + ")");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = estadoRepository.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
