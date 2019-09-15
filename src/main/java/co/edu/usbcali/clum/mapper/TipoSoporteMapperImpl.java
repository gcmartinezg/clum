package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.TipoSoporte;
import co.edu.usbcali.clum.dto.TipoSoporteDTO;
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
public class TipoSoporteMapperImpl implements TipoSoporteMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoSoporteMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    @Transactional(readOnly = true)
    public TipoSoporteDTO tipoSoporteToTipoSoporteDTO(TipoSoporte tipoSoporte)
        throws Exception {
        try {
            TipoSoporteDTO tipoSoporteDTO = new TipoSoporteDTO();

            tipoSoporteDTO.setTipoSoporteId(tipoSoporte.getTipoSoporteId());
            tipoSoporteDTO.setNombreTipoSoporte((tipoSoporte.getNombreTipoSoporte() != null)
                ? tipoSoporte.getNombreTipoSoporte() : null);
            tipoSoporteDTO.setIdEstado_Estado((tipoSoporte.getEstado()
                                                          .getIdEstado() != null)
                ? tipoSoporte.getEstado().getIdEstado() : null);

            return tipoSoporteDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoSoporte tipoSoporteDTOToTipoSoporte(
        TipoSoporteDTO tipoSoporteDTO) throws Exception {
        try {
            TipoSoporte tipoSoporte = new TipoSoporte();

            tipoSoporte.setTipoSoporteId(tipoSoporteDTO.getTipoSoporteId());
            tipoSoporte.setNombreTipoSoporte((tipoSoporteDTO.getNombreTipoSoporte() != null)
                ? tipoSoporteDTO.getNombreTipoSoporte() : null);

            Estado estado = new Estado();

            if (tipoSoporteDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(tipoSoporteDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                tipoSoporte.setEstado(estado);
            }

            return tipoSoporte;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoSoporteDTO> listTipoSoporteToListTipoSoporteDTO(
        List<TipoSoporte> listTipoSoporte) throws Exception {
        try {
            List<TipoSoporteDTO> tipoSoporteDTOs = new ArrayList<TipoSoporteDTO>();

            for (TipoSoporte tipoSoporte : listTipoSoporte) {
                TipoSoporteDTO tipoSoporteDTO = tipoSoporteToTipoSoporteDTO(tipoSoporte);

                tipoSoporteDTOs.add(tipoSoporteDTO);
            }

            return tipoSoporteDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoSoporte> listTipoSoporteDTOToListTipoSoporte(
        List<TipoSoporteDTO> listTipoSoporteDTO) throws Exception {
        try {
            List<TipoSoporte> listTipoSoporte = new ArrayList<TipoSoporte>();

            for (TipoSoporteDTO tipoSoporteDTO : listTipoSoporteDTO) {
                TipoSoporte tipoSoporte = tipoSoporteDTOToTipoSoporte(tipoSoporteDTO);

                listTipoSoporte.add(tipoSoporte);
            }

            return listTipoSoporte;
        } catch (Exception e) {
            throw e;
        }
    }
}
