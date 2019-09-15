package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.TipoLampara;
import co.edu.usbcali.clum.dto.TipoLamparaDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoLamparaService {
    public List<TipoLampara> getTipoLampara() throws Exception;

    /**
         * Save an new TipoLampara entity
         */
    public void saveTipoLampara(TipoLampara entity) throws Exception;

    /**
         * Delete an existing TipoLampara entity
         *
         */
    public void deleteTipoLampara(TipoLampara entity) throws Exception;

    /**
        * Update an existing TipoLampara entity
        *
        */
    public void updateTipoLampara(TipoLampara entity) throws Exception;

    /**
         * Load an existing TipoLampara entity
         *
         */
    public TipoLampara getTipoLampara(Integer tipoLamparaId)
        throws Exception;

    public List<TipoLampara> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoLampara> findPageTipoLampara(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoLampara() throws Exception;

    public List<TipoLamparaDTO> getDataTipoLampara() throws Exception;

    public void validateTipoLampara(TipoLampara tipoLampara)
        throws Exception;
}
