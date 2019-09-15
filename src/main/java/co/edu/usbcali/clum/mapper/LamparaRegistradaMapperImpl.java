package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.LamparaRegistrada;
import co.edu.usbcali.clum.dto.LamparaRegistradaDTO;
import co.edu.usbcali.clum.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class LamparaRegistradaMapperImpl implements LamparaRegistradaMapper {
    private static final Logger log = LoggerFactory.getLogger(LamparaRegistradaMapperImpl.class);

    /**
    * Service injected by Spring that manages Lampara entities
    *
    */
    @Autowired
    LamparaService serviceLampara1;

    /**
    * Service injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    UsuarioService serviceUsuario2;

    @Transactional(readOnly = true)
    public LamparaRegistradaDTO lamparaRegistradaToLamparaRegistradaDTO(
        LamparaRegistrada lamparaRegistrada) throws Exception {
        try {
            LamparaRegistradaDTO lamparaRegistradaDTO = new LamparaRegistradaDTO();

            lamparaRegistradaDTO.setLamparaRegistradaId(lamparaRegistrada.getLamparaRegistradaId());
            lamparaRegistradaDTO.setFechaHora(lamparaRegistrada.getFechaHora());
            lamparaRegistradaDTO.setLatitudPosActualTecnico((lamparaRegistrada.getLatitudPosActualTecnico() != null)
                ? lamparaRegistrada.getLatitudPosActualTecnico() : null);
            lamparaRegistradaDTO.setLongitudPosActualTecnico((lamparaRegistrada.getLongitudPosActualTecnico() != null)
                ? lamparaRegistrada.getLongitudPosActualTecnico() : null);
            lamparaRegistradaDTO.setLamparaId_Lampara((lamparaRegistrada.getLampara()
                                                                        .getLamparaId() != null)
                ? lamparaRegistrada.getLampara().getLamparaId() : null);
            lamparaRegistradaDTO.setUsuarioId_Usuario((lamparaRegistrada.getUsuario()
                                                                        .getUsuarioId() != null)
                ? lamparaRegistrada.getUsuario().getUsuarioId() : null);

            return lamparaRegistradaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public LamparaRegistrada lamparaRegistradaDTOToLamparaRegistrada(
        LamparaRegistradaDTO lamparaRegistradaDTO) throws Exception {
        try {
            LamparaRegistrada lamparaRegistrada = new LamparaRegistrada();

            lamparaRegistrada.setLamparaRegistradaId(lamparaRegistradaDTO.getLamparaRegistradaId());
            lamparaRegistrada.setFechaHora(lamparaRegistradaDTO.getFechaHora());
            lamparaRegistrada.setLatitudPosActualTecnico((lamparaRegistradaDTO.getLatitudPosActualTecnico() != null)
                ? lamparaRegistradaDTO.getLatitudPosActualTecnico() : null);
            lamparaRegistrada.setLongitudPosActualTecnico((lamparaRegistradaDTO.getLongitudPosActualTecnico() != null)
                ? lamparaRegistradaDTO.getLongitudPosActualTecnico() : null);

            Lampara lampara = new Lampara();

            if (lamparaRegistradaDTO.getLamparaId_Lampara() != null) {
                lampara = serviceLampara1.getLampara(lamparaRegistradaDTO.getLamparaId_Lampara());
            }

            if (lampara != null) {
                lamparaRegistrada.setLampara(lampara);
            }

            Usuario usuario = new Usuario();

            if (lamparaRegistradaDTO.getUsuarioId_Usuario() != null) {
                usuario = serviceUsuario2.getUsuario(lamparaRegistradaDTO.getUsuarioId_Usuario());
            }

            if (usuario != null) {
                lamparaRegistrada.setUsuario(usuario);
            }

            return lamparaRegistrada;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<LamparaRegistradaDTO> listLamparaRegistradaToListLamparaRegistradaDTO(
        List<LamparaRegistrada> listLamparaRegistrada)
        throws Exception {
        try {
            List<LamparaRegistradaDTO> lamparaRegistradaDTOs = new ArrayList<LamparaRegistradaDTO>();

            for (LamparaRegistrada lamparaRegistrada : listLamparaRegistrada) {
                LamparaRegistradaDTO lamparaRegistradaDTO = lamparaRegistradaToLamparaRegistradaDTO(lamparaRegistrada);

                lamparaRegistradaDTOs.add(lamparaRegistradaDTO);
            }

            return lamparaRegistradaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<LamparaRegistrada> listLamparaRegistradaDTOToListLamparaRegistrada(
        List<LamparaRegistradaDTO> listLamparaRegistradaDTO)
        throws Exception {
        try {
            List<LamparaRegistrada> listLamparaRegistrada = new ArrayList<LamparaRegistrada>();

            for (LamparaRegistradaDTO lamparaRegistradaDTO : listLamparaRegistradaDTO) {
                LamparaRegistrada lamparaRegistrada = lamparaRegistradaDTOToLamparaRegistrada(lamparaRegistradaDTO);

                listLamparaRegistrada.add(lamparaRegistrada);
            }

            return listLamparaRegistrada;
        } catch (Exception e) {
            throw e;
        }
    }
}
