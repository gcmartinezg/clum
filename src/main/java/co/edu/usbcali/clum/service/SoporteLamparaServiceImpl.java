package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.SoporteLamparaDTO;
import co.edu.usbcali.clum.exception.*;
import co.edu.usbcali.clum.mapper.SoporteLamparaMapper;
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
public class SoporteLamparaServiceImpl implements SoporteLamparaService {
    private static final Logger log = LoggerFactory.getLogger(SoporteLamparaServiceImpl.class);

    /**
     * Repository injected by Spring that manages SoporteLampara entities
     *
     */
    @Autowired
    private SoporteLamparaRepository soporteLamparaRepository;
    @Autowired
    private SoporteLamparaMapper soporteLamparaMapper;
    @Autowired
    private Validator validator;

    /**
    * Repository injected by Spring that manages Lampara entities
    *
    */
    @Autowired
    private LamparaRepository lamparaRepository;

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    /**
    * Service injected by Spring that manages TipoMaterial entities
    *
    */
    @Autowired
    TipoMaterialService serviceTipoMaterial2;

    /**
    * Service injected by Spring that manages TipoSoporte entities
    *
    */
    @Autowired
    TipoSoporteService serviceTipoSoporte3;

    public void validateSoporteLampara(SoporteLampara soporteLampara)
        throws Exception {
        try {
            Set<ConstraintViolation<SoporteLampara>> constraintViolations = validator.validate(soporteLampara);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<SoporteLampara> constraintViolation : constraintViolations) {
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
    public List<SoporteLampara> getSoporteLampara() throws Exception {
        log.debug("finding all SoporteLampara instances");

        List<SoporteLampara> list = new ArrayList<SoporteLampara>();

        try {
            list = soporteLamparaRepository.findAll();
        } catch (Exception e) {
            log.error("finding all SoporteLampara failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "SoporteLampara");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveSoporteLampara(SoporteLampara entity)
        throws Exception {
        log.debug("saving SoporteLampara instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "SoporteLampara");
            }

            validateSoporteLampara(entity);

            if (getSoporteLampara(entity.getSoporteLamparaId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            soporteLamparaRepository.save(entity);
            log.debug("save SoporteLampara successful");
        } catch (Exception e) {
            log.error("save SoporteLampara failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteSoporteLampara(SoporteLampara entity)
        throws Exception {
        log.debug("deleting SoporteLampara instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("SoporteLampara");
        }

        if (entity.getSoporteLamparaId() == null) {
            throw new ZMessManager().new EmptyFieldException("soporteLamparaId");
        }

        List<Lampara> lamparas = null;

        try {
            lamparas = lamparaRepository.findByProperty("soporteLampara.soporteLamparaId",
                    entity.getSoporteLamparaId());

            if (Utilities.validationsList(lamparas) == true) {
                throw new ZMessManager().new DeletingException("lamparas");
            }

            soporteLamparaRepository.deleteById(entity.getSoporteLamparaId());
            log.debug("delete SoporteLampara successful");
        } catch (Exception e) {
            log.error("delete SoporteLampara failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateSoporteLampara(SoporteLampara entity)
        throws Exception {
        log.debug("updating SoporteLampara instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "SoporteLampara");
            }

            validateSoporteLampara(entity);

            soporteLamparaRepository.update(entity);

            log.debug("update SoporteLampara successful");
        } catch (Exception e) {
            log.error("update SoporteLampara failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<SoporteLamparaDTO> getDataSoporteLampara()
        throws Exception {
        try {
            List<SoporteLampara> soporteLampara = soporteLamparaRepository.findAll();

            List<SoporteLamparaDTO> soporteLamparaDTO = new ArrayList<SoporteLamparaDTO>();

            for (SoporteLampara soporteLamparaTmp : soporteLampara) {
                SoporteLamparaDTO soporteLamparaDTO2 = soporteLamparaMapper.soporteLamparaToSoporteLamparaDTO(soporteLamparaTmp);
                soporteLamparaDTO.add(soporteLamparaDTO2);
            }

            return soporteLamparaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public SoporteLampara getSoporteLampara(Integer soporteLamparaId)
        throws Exception {
        log.debug("getting SoporteLampara instance");

        SoporteLampara entity = null;

        try {
            if (soporteLamparaRepository.findById(soporteLamparaId).isPresent()) {
                entity = soporteLamparaRepository.findById(soporteLamparaId)
                                                 .get();
            }
        } catch (Exception e) {
            log.error("get SoporteLampara failed", e);
            throw new ZMessManager().new FindingException("SoporteLampara");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<SoporteLampara> findPageSoporteLampara(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<SoporteLampara> entity = null;

        try {
            entity = soporteLamparaRepository.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "SoporteLampara Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberSoporteLampara() throws Exception {
        Long entity = null;

        try {
            entity = soporteLamparaRepository.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "SoporteLampara Count");
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
    public List<SoporteLampara> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<SoporteLampara> list = new ArrayList<SoporteLampara>();
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
            list = soporteLamparaRepository.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
