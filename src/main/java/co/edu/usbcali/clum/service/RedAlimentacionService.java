package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.RedAlimentacion;
import co.edu.usbcali.clum.dto.RedAlimentacionDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface RedAlimentacionService {
    public List<RedAlimentacion> getRedAlimentacion() throws Exception;

    /**
         * Save an new RedAlimentacion entity
         */
    public void saveRedAlimentacion(RedAlimentacion entity)
        throws Exception;

    /**
         * Delete an existing RedAlimentacion entity
         *
         */
    public void deleteRedAlimentacion(RedAlimentacion entity)
        throws Exception;

    /**
        * Update an existing RedAlimentacion entity
        *
        */
    public void updateRedAlimentacion(RedAlimentacion entity)
        throws Exception;

    /**
         * Load an existing RedAlimentacion entity
         *
         */
    public RedAlimentacion getRedAlimentacion(Integer redAlimentacionId)
        throws Exception;

    public List<RedAlimentacion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<RedAlimentacion> findPageRedAlimentacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberRedAlimentacion() throws Exception;

    public List<RedAlimentacionDTO> getDataRedAlimentacion()
        throws Exception;

    public void validateRedAlimentacion(RedAlimentacion redAlimentacion)
        throws Exception;
}
