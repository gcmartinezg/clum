package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.TipoMaterial;
import co.edu.usbcali.clum.dto.TipoMaterialDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoMaterialService {
    public List<TipoMaterial> getTipoMaterial() throws Exception;

    /**
         * Save an new TipoMaterial entity
         */
    public void saveTipoMaterial(TipoMaterial entity) throws Exception;

    /**
         * Delete an existing TipoMaterial entity
         *
         */
    public void deleteTipoMaterial(TipoMaterial entity)
        throws Exception;

    /**
        * Update an existing TipoMaterial entity
        *
        */
    public void updateTipoMaterial(TipoMaterial entity)
        throws Exception;

    /**
         * Load an existing TipoMaterial entity
         *
         */
    public TipoMaterial getTipoMaterial(Integer tipoMaterialId)
        throws Exception;

    public List<TipoMaterial> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoMaterial> findPageTipoMaterial(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoMaterial() throws Exception;

    public List<TipoMaterialDTO> getDataTipoMaterial()
        throws Exception;

    public void validateTipoMaterial(TipoMaterial tipoMaterial)
        throws Exception;
}
