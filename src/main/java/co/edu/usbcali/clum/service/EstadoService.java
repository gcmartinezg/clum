package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.Estado;
import co.edu.usbcali.clum.dto.EstadoDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface EstadoService {
    public List<Estado> getEstado() throws Exception;

    /**
         * Save an new Estado entity
         */
    public void saveEstado(Estado entity) throws Exception;

    /**
         * Delete an existing Estado entity
         *
         */
    public void deleteEstado(Estado entity) throws Exception;

    /**
        * Update an existing Estado entity
        *
        */
    public void updateEstado(Estado entity) throws Exception;

    /**
         * Load an existing Estado entity
         *
         */
    public Estado getEstado(Integer idEstado) throws Exception;

    public List<Estado> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Estado> findPageEstado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEstado() throws Exception;

    public List<EstadoDTO> getDataEstado() throws Exception;

    public void validateEstado(Estado estado) throws Exception;
}
