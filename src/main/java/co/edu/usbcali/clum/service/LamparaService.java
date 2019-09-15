package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.Lampara;
import co.edu.usbcali.clum.dto.LamparaDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface LamparaService {
    public List<Lampara> getLampara() throws Exception;

    /**
         * Save an new Lampara entity
         */
    public void saveLampara(Lampara entity) throws Exception;

    /**
         * Delete an existing Lampara entity
         *
         */
    public void deleteLampara(Lampara entity) throws Exception;

    /**
        * Update an existing Lampara entity
        *
        */
    public void updateLampara(Lampara entity) throws Exception;

    /**
         * Load an existing Lampara entity
         *
         */
    public Lampara getLampara(Integer lamparaId) throws Exception;

    public List<Lampara> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Lampara> findPageLampara(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberLampara() throws Exception;

    public List<LamparaDTO> getDataLampara() throws Exception;

    public void validateLampara(Lampara lampara) throws Exception;
}
