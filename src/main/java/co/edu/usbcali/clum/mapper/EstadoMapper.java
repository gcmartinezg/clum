package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.Estado;
import co.edu.usbcali.clum.dto.EstadoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface EstadoMapper {
    public EstadoDTO estadoToEstadoDTO(Estado estado) throws Exception;

    public Estado estadoDTOToEstado(EstadoDTO estadoDTO)
        throws Exception;

    public List<EstadoDTO> listEstadoToListEstadoDTO(List<Estado> estados)
        throws Exception;

    public List<Estado> listEstadoDTOToListEstado(List<EstadoDTO> estadoDTOs)
        throws Exception;
}
