package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.TipoMaterial;
import co.edu.usbcali.clum.dto.TipoMaterialDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoMaterialMapper {
    public TipoMaterialDTO tipoMaterialToTipoMaterialDTO(
        TipoMaterial tipoMaterial) throws Exception;

    public TipoMaterial tipoMaterialDTOToTipoMaterial(
        TipoMaterialDTO tipoMaterialDTO) throws Exception;

    public List<TipoMaterialDTO> listTipoMaterialToListTipoMaterialDTO(
        List<TipoMaterial> tipoMaterials) throws Exception;

    public List<TipoMaterial> listTipoMaterialDTOToListTipoMaterial(
        List<TipoMaterialDTO> tipoMaterialDTOs) throws Exception;
}
