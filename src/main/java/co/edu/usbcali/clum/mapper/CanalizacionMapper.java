package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.Canalizacion;
import co.edu.usbcali.clum.dto.CanalizacionDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface CanalizacionMapper {
    public CanalizacionDTO canalizacionToCanalizacionDTO(
        Canalizacion canalizacion) throws Exception;

    public Canalizacion canalizacionDTOToCanalizacion(
        CanalizacionDTO canalizacionDTO) throws Exception;

    public List<CanalizacionDTO> listCanalizacionToListCanalizacionDTO(
        List<Canalizacion> canalizacions) throws Exception;

    public List<Canalizacion> listCanalizacionDTOToListCanalizacion(
        List<CanalizacionDTO> canalizacionDTOs) throws Exception;
}
