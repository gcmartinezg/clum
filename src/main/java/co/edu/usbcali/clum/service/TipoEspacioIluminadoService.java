package co.edu.usbcali.clum.service;

import co.edu.usbcali.clum.domain.TipoEspacioIluminado;
import co.edu.usbcali.clum.dto.TipoEspacioIluminadoDTO;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoEspacioIluminadoService {
    public List<TipoEspacioIluminado> getTipoEspacioIluminado()
        throws Exception;

    /**
         * Save an new TipoEspacioIluminado entity
         */
    public void saveTipoEspacioIluminado(TipoEspacioIluminado entity)
        throws Exception;

    /**
         * Delete an existing TipoEspacioIluminado entity
         *
         */
    public void deleteTipoEspacioIluminado(TipoEspacioIluminado entity)
        throws Exception;

    /**
        * Update an existing TipoEspacioIluminado entity
        *
        */
    public void updateTipoEspacioIluminado(TipoEspacioIluminado entity)
        throws Exception;

    /**
         * Load an existing TipoEspacioIluminado entity
         *
         */
    public TipoEspacioIluminado getTipoEspacioIluminado(
        Integer tipoEspacioIluminadoId) throws Exception;

    public List<TipoEspacioIluminado> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoEspacioIluminado> findPageTipoEspacioIluminado(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoEspacioIluminado() throws Exception;

    public List<TipoEspacioIluminadoDTO> getDataTipoEspacioIluminado()
        throws Exception;

    public void validateTipoEspacioIluminado(
        TipoEspacioIluminado tipoEspacioIluminado) throws Exception;
}
