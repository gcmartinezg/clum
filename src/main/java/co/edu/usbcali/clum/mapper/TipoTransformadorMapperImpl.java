package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.TipoTransformador;
import co.edu.usbcali.clum.dto.TipoTransformadorDTO;
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
public class TipoTransformadorMapperImpl implements TipoTransformadorMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoTransformadorMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    @Transactional(readOnly = true)
    public TipoTransformadorDTO tipoTransformadorToTipoTransformadorDTO(
        TipoTransformador tipoTransformador) throws Exception {
        try {
            TipoTransformadorDTO tipoTransformadorDTO = new TipoTransformadorDTO();

            tipoTransformadorDTO.setTipoTransformadorId(tipoTransformador.getTipoTransformadorId());
            tipoTransformadorDTO.setNombreTipoTransformador((tipoTransformador.getNombreTipoTransformador() != null)
                ? tipoTransformador.getNombreTipoTransformador() : null);
            tipoTransformadorDTO.setIdEstado_Estado((tipoTransformador.getEstado()
                                                                      .getIdEstado() != null)
                ? tipoTransformador.getEstado().getIdEstado() : null);

            return tipoTransformadorDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoTransformador tipoTransformadorDTOToTipoTransformador(
        TipoTransformadorDTO tipoTransformadorDTO) throws Exception {
        try {
            TipoTransformador tipoTransformador = new TipoTransformador();

            tipoTransformador.setTipoTransformadorId(tipoTransformadorDTO.getTipoTransformadorId());
            tipoTransformador.setNombreTipoTransformador((tipoTransformadorDTO.getNombreTipoTransformador() != null)
                ? tipoTransformadorDTO.getNombreTipoTransformador() : null);

            Estado estado = new Estado();

            if (tipoTransformadorDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(tipoTransformadorDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                tipoTransformador.setEstado(estado);
            }

            return tipoTransformador;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoTransformadorDTO> listTipoTransformadorToListTipoTransformadorDTO(
        List<TipoTransformador> listTipoTransformador)
        throws Exception {
        try {
            List<TipoTransformadorDTO> tipoTransformadorDTOs = new ArrayList<TipoTransformadorDTO>();

            for (TipoTransformador tipoTransformador : listTipoTransformador) {
                TipoTransformadorDTO tipoTransformadorDTO = tipoTransformadorToTipoTransformadorDTO(tipoTransformador);

                tipoTransformadorDTOs.add(tipoTransformadorDTO);
            }

            return tipoTransformadorDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoTransformador> listTipoTransformadorDTOToListTipoTransformador(
        List<TipoTransformadorDTO> listTipoTransformadorDTO)
        throws Exception {
        try {
            List<TipoTransformador> listTipoTransformador = new ArrayList<TipoTransformador>();

            for (TipoTransformadorDTO tipoTransformadorDTO : listTipoTransformadorDTO) {
                TipoTransformador tipoTransformador = tipoTransformadorDTOToTipoTransformador(tipoTransformadorDTO);

                listTipoTransformador.add(tipoTransformador);
            }

            return listTipoTransformador;
        } catch (Exception e) {
            throw e;
        }
    }
}
