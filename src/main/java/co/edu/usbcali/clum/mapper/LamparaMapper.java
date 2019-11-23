package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.Lampara;
import co.edu.usbcali.clum.dto.LamparaDTO;

import java.util.List;
import java.util.Map;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface LamparaMapper {
    public LamparaDTO lamparaToLamparaDTO(Lampara lampara)
        throws Exception;

    public Lampara lamparaDTOToLampara(LamparaDTO lamparaDTO)
        throws Exception;

    public List<LamparaDTO> listLamparaToListLamparaDTO(List<Lampara> lamparas)
        throws Exception;

    public List<Lampara> listLamparaDTOToListLampara(
        List<LamparaDTO> lamparaDTOs) throws Exception;
    
    public LamparaDTO lamparaFirebaseToLampara(Map<String, Object> data) throws Exception;
}
