package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.TipoSoporte;
import co.edu.usbcali.clum.dto.TipoSoporteDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoSoporteService {
    public List<TipoSoporte> getTipoSoporte() throws Exception;

    /**
         * Save an new TipoSoporte entity
         */
    public void saveTipoSoporte(TipoSoporte entity) throws Exception;

    /**
         * Delete an existing TipoSoporte entity
         *
         */
    public void deleteTipoSoporte(TipoSoporte entity) throws Exception;

    /**
        * Update an existing TipoSoporte entity
        *
        */
    public void updateTipoSoporte(TipoSoporte entity) throws Exception;

    /**
         * Load an existing TipoSoporte entity
         *
         */
    public TipoSoporte getTipoSoporte(Integer tipoSoporteId)
        throws Exception;

    public List<TipoSoporte> findByCriteria(Object[] variables,
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
