package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.TipoInstalacion;
import co.edu.usbcali.clum.dto.TipoInstalacionDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoInstalacionService {
    public List<TipoInstalacion> getTipoInstalacion() throws Exception;

    /**
         * Save an new TipoInstalacion entity
         */
    public void saveTipoInstalacion(TipoInstalacion entity)
        throws Exception;

    /**
         * Delete an existing TipoInstalacion entity
         *
         */
    public void deleteTipoInstalacion(TipoInstalacion entity)
        throws Exception;

    /**
        * Update an existing TipoInstalacion entity
        *
        */
    public void updateTipoInstalacion(TipoInstalacion entity)
        throws Exception;

    /**
         * Load an existing TipoInstalacion entity
         *
         */
    public TipoInstalacion getTipoInstalacion(Integer tipoInstalacionId)
        throws Exception;

    public List<TipoInstalacion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoInstalacion> findPageTipoInstalacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoInstalacion() throws Exception;

    public List<TipoInstalacionDTO> getDataTipoInstalacion()
        throws Exception;

    public void validateTipoInstalacion(TipoInstalacion tipoInstalacion)
        throws Exception;
}
