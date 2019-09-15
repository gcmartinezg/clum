package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.Transformador;
import co.edu.usbcali.clum.dto.TransformadorDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TransformadorMapper {
    public TransformadorDTO transformadorToTransformadorDTO(
        Transformador transformador) throws Exception;

    public Transformador transformadorDTOToTransformador(
        TransformadorDTO transformadorDTO) throws Exception;

    public List<TransformadorDTO> listTransformadorToListTransformadorDTO(
        List<Transformador> transformadors) throws Exception;

    public List<Transformador> listTransformadorDTOToListTransformador(
        List<TransformadorDTO> transformadorDTOs) throws Exception;
}
