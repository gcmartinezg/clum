package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.TipoDocumento;
import co.edu.usbcali.clum.dto.TipoDocumentoDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoDocumentoService {
    public List<TipoDocumento> getTipoDocumento() throws Exception;

    /**
         * Save an new TipoDocumento entity
         */
    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception;

    /**
         * Delete an existing TipoDocumento entity
         *
         */
    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception;

    /**
        * Update an existing TipoDocumento entity
        *
        */
    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception;

    /**
         * Load an existing TipoDocumento entity
         *
         */
    public TipoDocumento getTipoDocumento(Integer tipoDocumentoId)
        throws Exception;

    public List<TipoDocumento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoDocumento() throws Exception;

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception;

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception;
}
