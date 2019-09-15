package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.LamparaRegistrada;
import co.edu.usbcali.clum.dto.LamparaRegistradaDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface LamparaRegistradaService {
    public List<LamparaRegistrada> getLamparaRegistrada()
        throws Exception;

    /**
         * Save an new LamparaRegistrada entity
         */
    public void saveLamparaRegistrada(LamparaRegistrada entity)
        throws Exception;

    /**
         * Delete an existing LamparaRegistrada entity
         *
         */
    public void deleteLamparaRegistrada(LamparaRegistrada entity)
        throws Exception;

    /**
        * Update an existing LamparaRegistrada entity
        *
        */
    public void updateLamparaRegistrada(LamparaRegistrada entity)
        throws Exception;

    /**
         * Load an existing LamparaRegistrada entity
         *
         */
    public LamparaRegistrada getLamparaRegistrada(Integer lamparaRegistradaId)
        throws Exception;

    public List<LamparaRegistrada> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<LamparaRegistrada> findPageLamparaRegistrada(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberLamparaRegistrada() throws Exception;

    public List<LamparaRegistradaDTO> getDataLamparaRegistrada()
        throws Exception;

    public void validateLamparaRegistrada(LamparaRegistrada lamparaRegistrada)
        throws Exception;
}
