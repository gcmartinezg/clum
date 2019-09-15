package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.Transformador;
import co.edu.usbcali.clum.dto.TransformadorDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TransformadorService {
    public List<Transformador> getTransformador() throws Exception;

    /**
         * Save an new Transformador entity
         */
    public void saveTransformador(Transformador entity)
        throws Exception;

    /**
         * Delete an existing Transformador entity
         *
         */
    public void deleteTransformador(Transformador entity)
        throws Exception;

    /**
        * Update an existing Transformador entity
        *
        */
    public void updateTransformador(Transformador entity)
        throws Exception;

    /**
         * Load an existing Transformador entity
         *
         */
    public Transformador getTransformador(Integer transformadorId)
        throws Exception;

    public List<Transformador> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Transformador> findPageTransformador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTransformador() throws Exception;

    public List<TransformadorDTO> getDataTransformador()
        throws Exception;

    public void validateTransformador(Transformador transformador)
        throws Exception;
}
