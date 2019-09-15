package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.TipoBalasto;
import co.edu.usbcali.clum.dto.TipoBalastoDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoBalastoService {
    public List<TipoBalasto> getTipoBalasto() throws Exception;

    /**
         * Save an new TipoBalasto entity
         */
    public void saveTipoBalasto(TipoBalasto entity) throws Exception;

    /**
         * Delete an existing TipoBalasto entity
         *
         */
    public void deleteTipoBalasto(TipoBalasto entity) throws Exception;

    /**
        * Update an existing TipoBalasto entity
        *
        */
    public void updateTipoBalasto(TipoBalasto entity) throws Exception;

    /**
         * Load an existing TipoBalasto entity
         *
         */
    public TipoBalasto getTipoBalasto(Integer tipoBalastoId)
        throws Exception;

    public List<TipoBalasto> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoBalasto> findPageTipoBalasto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoBalasto() throws Exception;

    public List<TipoBalastoDTO> getDataTipoBalasto() throws Exception;

    public void validateTipoBalasto(TipoBalasto tipoBalasto)
        throws Exception;
}
