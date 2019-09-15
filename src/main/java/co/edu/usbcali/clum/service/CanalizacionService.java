package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.Canalizacion;
import co.edu.usbcali.clum.dto.CanalizacionDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface CanalizacionService {
    public List<Canalizacion> getCanalizacion() throws Exception;

    /**
         * Save an new Canalizacion entity
         */
    public void saveCanalizacion(Canalizacion entity) throws Exception;

    /**
         * Delete an existing Canalizacion entity
         *
         */
    public void deleteCanalizacion(Canalizacion entity)
        throws Exception;

    /**
        * Update an existing Canalizacion entity
        *
        */
    public void updateCanalizacion(Canalizacion entity)
        throws Exception;

    /**
         * Load an existing Canalizacion entity
         *
         */
    public Canalizacion getCanalizacion(Integer canalizacionId)
        throws Exception;

    public List<Canalizacion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Canalizacion> findPageCanalizacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCanalizacion() throws Exception;

    public List<CanalizacionDTO> getDataCanalizacion()
        throws Exception;

    public void validateCanalizacion(Canalizacion canalizacion)
        throws Exception;
}
