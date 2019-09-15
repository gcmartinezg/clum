package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.TipoSoporte;
import co.edu.usbcali.clum.dto.TipoSoporteDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoSoporteMapper {
    public TipoSoporteDTO tipoSoporteToTipoSoporteDTO(TipoSoporte tipoSoporte)
        throws Exception;

    public TipoSoporte tipoSoporteDTOToTipoSoporte(
        TipoSoporteDTO tipoSoporteDTO) throws Exception;

    public List<TipoSoporteDTO> listTipoSoporteToListTipoSoporteDTO(
        List<TipoSoporte> tipoSoportes) throws Exception;

    public List<TipoSoporte> listTipoSoporteDTOToListTipoSoporte(
        List<TipoSoporteDTO> tipoSoporteDTOs) throws Exception;
}
