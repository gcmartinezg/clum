package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.TipoEspacioIluminado;
import co.edu.usbcali.clum.dto.TipoEspacioIluminadoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoEspacioIluminadoMapper {
    public TipoEspacioIluminadoDTO tipoEspacioIluminadoToTipoEspacioIluminadoDTO(
        TipoEspacioIluminado tipoEspacioIluminado) throws Exception;

    public TipoEspacioIluminado tipoEspacioIluminadoDTOToTipoEspacioIluminado(
        TipoEspacioIluminadoDTO tipoEspacioIluminadoDTO)
        throws Exception;

    public List<TipoEspacioIluminadoDTO> listTipoEspacioIluminadoToListTipoEspacioIluminadoDTO(
        List<TipoEspacioIluminado> tipoEspacioIluminados)
        throws Exception;

    public List<TipoEspacioIluminado> listTipoEspacioIluminadoDTOToListTipoEspacioIluminado(
        List<TipoEspacioIluminadoDTO> tipoEspacioIluminadoDTOs)
        throws Exception;
}
