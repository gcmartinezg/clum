package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.SoporteLampara;
import co.edu.usbcali.clum.dto.SoporteLamparaDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface SoporteLamparaService {
    public List<SoporteLampara> getSoporteLampara() throws Exception;

    /**
         * Save an new SoporteLampara entity
         */
    public void saveSoporteLampara(SoporteLampara entity)
        throws Exception;

    /**
         * Delete an existing SoporteLampara entity
         *
         */
    public void deleteSoporteLampara(SoporteLampara entity)
        throws Exception;

    /**
        * Update an existing SoporteLampara entity
        *
        */
    public void updateSoporteLampara(SoporteLampara entity)
        throws Exception;

    /**
         * Load an existing SoporteLampara entity
         *
         */
    public SoporteLampara getSoporteLampara(Integer soporteLamparaId)
        throws Exception;

    public List<SoporteLampara> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SoporteLampara> findPageSoporteLampara(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSoporteLampara() throws Exception;

    public List<SoporteLamparaDTO> getDataSoporteLampara()
        throws Exception;

    public void validateSoporteLampara(SoporteLampara soporteLampara)
        throws Exception;
}
