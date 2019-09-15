package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.LamparaRegistrada;
import co.edu.usbcali.clum.dto.LamparaRegistradaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface LamparaRegistradaMapper {
    public LamparaRegistradaDTO lamparaRegistradaToLamparaRegistradaDTO(
        LamparaRegistrada lamparaRegistrada) throws Exception;

    public LamparaRegistrada lamparaRegistradaDTOToLamparaRegistrada(
        LamparaRegistradaDTO lamparaRegistradaDTO) throws Exception;

    public List<LamparaRegistradaDTO> listLamparaRegistradaToListLamparaRegistradaDTO(
        List<LamparaRegistrada> lamparaRegistradas) throws Exception;

    public List<LamparaRegistrada> listLamparaRegistradaDTOToListLamparaRegistrada(
        List<LamparaRegistradaDTO> lamparaRegistradaDTOs)
        throws Exception;
}
