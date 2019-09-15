package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.TipoLampara;
import co.edu.usbcali.clum.dto.TipoLamparaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoLamparaMapper {
    public TipoLamparaDTO tipoLamparaToTipoLamparaDTO(TipoLampara tipoLampara)
        throws Exception;

    public TipoLampara tipoLamparaDTOToTipoLampara(
        TipoLamparaDTO tipoLamparaDTO) throws Exception;

    public List<TipoLamparaDTO> listTipoLamparaToListTipoLamparaDTO(
        List<TipoLampara> tipoLamparas) throws Exception;

    public List<TipoLampara> listTipoLamparaDTOToListTipoLampara(
        List<TipoLamparaDTO> tipoLamparaDTOs) throws Exception;
}
