package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.TipoTransformador;
import co.edu.usbcali.clum.dto.TipoTransformadorDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoTransformadorService {
    public List<TipoTransformador> getTipoTransformador()
        throws Exception;

    /**
         * Save an new TipoTransformador entity
         */
    public void saveTipoTransformador(TipoTransformador entity)
        throws Exception;

    /**
         * Delete an existing TipoTransformador entity
         *
         */
    public void deleteTipoTransformador(TipoTransformador entity)
        throws Exception;

    /**
        * Update an existing TipoTransformador entity
        *
        */
    public void updateTipoTransformador(TipoTransformador entity)
        throws Exception;

    /**
         * Load an existing TipoTransformador entity
         *
         */
    public TipoTransformador getTipoTransformador(Integer tipoTransformadorId)
        throws Exception;

    public List<TipoTransformador> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoTransformador> findPageTipoTransformador(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoTransformador() throws Exception;

    public List<TipoTransformadorDTO> getDataTipoTransformador()
        throws Exception;

    public void validateTipoTransformador(TipoTransformador tipoTransformador)
        throws Exception;
}
