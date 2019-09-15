package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.TipoBalasto;
import co.edu.usbcali.clum.dto.TipoBalastoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoBalastoMapper {
    public TipoBalastoDTO tipoBalastoToTipoBalastoDTO(TipoBalasto tipoBalasto)
        throws Exception;

    public TipoBalasto tipoBalastoDTOToTipoBalasto(
        TipoBalastoDTO tipoBalastoDTO) throws Exception;

    public List<TipoBalastoDTO> listTipoBalastoToListTipoBalastoDTO(
        List<TipoBalasto> tipoBalastos) throws Exception;

    public List<TipoBalasto> listTipoBalastoDTOToListTipoBalasto(
        List<TipoBalastoDTO> tipoBalastoDTOs) throws Exception;
}
