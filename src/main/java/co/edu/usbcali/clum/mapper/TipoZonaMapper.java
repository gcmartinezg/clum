package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.TipoZona;
import co.edu.usbcali.clum.dto.TipoZonaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoZonaMapper {
    public TipoZonaDTO tipoZonaToTipoZonaDTO(TipoZona tipoZona)
        throws Exception;

    public TipoZona tipoZonaDTOToTipoZona(TipoZonaDTO tipoZonaDTO)
        throws Exception;

    public List<TipoZonaDTO> listTipoZonaToListTipoZonaDTO(
        List<TipoZona> tipoZonas) throws Exception;

    public List<TipoZona> listTipoZonaDTOToListTipoZona(
        List<TipoZonaDTO> tipoZonaDTOs) throws Exception;
}
