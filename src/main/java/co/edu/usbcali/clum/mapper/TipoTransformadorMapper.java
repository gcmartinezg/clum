package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.TipoTransformador;
import co.edu.usbcali.clum.dto.TipoTransformadorDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoTransformadorMapper {
    public TipoTransformadorDTO tipoTransformadorToTipoTransformadorDTO(
        TipoTransformador tipoTransformador) throws Exception;

    public TipoTransformador tipoTransformadorDTOToTipoTransformador(
        TipoTransformadorDTO tipoTransformadorDTO) throws Exception;

    public List<TipoTransformadorDTO> listTipoTransformadorToListTipoTransformadorDTO(
        List<TipoTransformador> tipoTransformadors) throws Exception;

    public List<TipoTransformador> listTipoTransformadorDTOToListTipoTransformador(
        List<TipoTransformadorDTO> tipoTransformadorDTOs)
        throws Exception;
}
