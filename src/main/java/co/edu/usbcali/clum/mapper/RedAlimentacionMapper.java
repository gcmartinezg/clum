package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.RedAlimentacion;
import co.edu.usbcali.clum.dto.RedAlimentacionDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface RedAlimentacionMapper {
    public RedAlimentacionDTO redAlimentacionToRedAlimentacionDTO(
        RedAlimentacion redAlimentacion) throws Exception;

    public RedAlimentacion redAlimentacionDTOToRedAlimentacion(
        RedAlimentacionDTO redAlimentacionDTO) throws Exception;

    public List<RedAlimentacionDTO> listRedAlimentacionToListRedAlimentacionDTO(
        List<RedAlimentacion> redAlimentacions) throws Exception;

    public List<RedAlimentacion> listRedAlimentacionDTOToListRedAlimentacion(
        List<RedAlimentacionDTO> redAlimentacionDTOs) throws Exception;
}
