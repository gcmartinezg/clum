package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.Tercero;
import co.edu.usbcali.clum.dto.TerceroDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TerceroService {
    public List<Tercero> getTercero() throws Exception;

    /**
         * Save an new Tercero entity
         */
    public void saveTercero(Tercero entity) throws Exception;

    /**
         * Delete an existing Tercero entity
         *
         */
    public void deleteTercero(Tercero entity) throws Exception;

    /**
        * Update an existing Tercero entity
        *
        */
    public void updateTercero(Tercero entity) throws Exception;

    /**
         * Load an existing Tercero entity
         *
         */
    public Tercero getTercero(Integer terceroId) throws Exception;

    public List<Tercero> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tercero> findPageTercero(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTercero() throws Exception;

    public List<TerceroDTO> getDataTercero() throws Exception;

    public void validateTercero(Tercero tercero) throws Exception;
}
