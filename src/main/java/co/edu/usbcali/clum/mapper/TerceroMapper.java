package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.Tercero;
import co.edu.usbcali.clum.dto.TerceroDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TerceroMapper {
    public TerceroDTO terceroToTerceroDTO(Tercero tercero)
        throws Exception;

    public Tercero terceroDTOToTercero(TerceroDTO terceroDTO)
        throws Exception;

    public List<TerceroDTO> listTerceroToListTerceroDTO(List<Tercero> terceros)
        throws Exception;

    public List<Tercero> listTerceroDTOToListTercero(
        List<TerceroDTO> terceroDTOs) throws Exception;
}
