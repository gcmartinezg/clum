package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.TipoZona;
import co.edu.usbcali.clum.dto.TipoZonaDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoZonaService {
    public List<TipoZona> getTipoZona() throws Exception;

    /**
         * Save an new TipoZona entity
         */
    public void saveTipoZona(TipoZona entity) throws Exception;

    /**
         * Delete an existing TipoZona entity
         *
         */
    public void deleteTipoZona(TipoZona entity) throws Exception;

    /**
        * Update an existing TipoZona entity
        *
        */
    public void updateTipoZona(TipoZona entity) throws Exception;

    /**
         * Load an existing TipoZona entity
         *
         */
    public TipoZona getTipoZona(Integer tipoZonaId) throws Exception;

    public List<TipoZona> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoZona> findPageTipoZona(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoZona() throws Exception;

    public List<TipoZonaDTO> getDataTipoZona() throws Exception;

    public void validateTipoZona(TipoZona tipoZona) throws Exception;
}
