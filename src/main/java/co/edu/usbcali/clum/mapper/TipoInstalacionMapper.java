package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.TipoInstalacion;
import co.edu.usbcali.clum.dto.TipoInstalacionDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoInstalacionMapper {
    public TipoInstalacionDTO tipoInstalacionToTipoInstalacionDTO(
        TipoInstalacion tipoInstalacion) throws Exception;

    public TipoInstalacion tipoInstalacionDTOToTipoInstalacion(
        TipoInstalacionDTO tipoInstalacionDTO) throws Exception;

    public List<TipoInstalacionDTO> listTipoInstalacionToListTipoInstalacionDTO(
        List<TipoInstalacion> tipoInstalacions) throws Exception;

    public List<TipoInstalacion> listTipoInstalacionDTOToListTipoInstalacion(
        List<TipoInstalacionDTO> tipoInstalacionDTOs) throws Exception;
}
