package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.SoporteLampara;
import co.edu.usbcali.clum.dto.SoporteLamparaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface SoporteLamparaMapper {
    public SoporteLamparaDTO soporteLamparaToSoporteLamparaDTO(
        SoporteLampara soporteLampara) throws Exception;

    public SoporteLampara soporteLamparaDTOToSoporteLampara(
        SoporteLamparaDTO soporteLamparaDTO) throws Exception;

    public List<SoporteLamparaDTO> listSoporteLamparaToListSoporteLamparaDTO(
        List<SoporteLampara> soporteLamparas) throws Exception;

    public List<SoporteLampara> listSoporteLamparaDTOToListSoporteLampara(
        List<SoporteLamparaDTO> soporteLamparaDTOs) throws Exception;
}
