package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.TipoZona;
import co.edu.usbcali.clum.dto.TipoZonaDTO;
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
public class TipoZonaMapperImpl implements TipoZonaMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoZonaMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    @Transactional(readOnly = true)
    public TipoZonaDTO tipoZonaToTipoZonaDTO(TipoZona tipoZona)
        throws Exception {
        try {
            TipoZonaDTO tipoZonaDTO = new TipoZonaDTO();

            tipoZonaDTO.setTipoZonaId(tipoZona.getTipoZonaId());
            tipoZonaDTO.setNombreTipoZona((tipoZona.getNombreTipoZona() != null)
                ? tipoZona.getNombreTipoZona() : null);
            tipoZonaDTO.setIdEstado_Estado((tipoZona.getEstado().getIdEstado() != null)
                ? tipoZona.getEstado().getIdEstado() : null);

            return tipoZonaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoZona tipoZonaDTOToTipoZona(TipoZonaDTO tipoZonaDTO)
        throws Exception {
        try {
            TipoZona tipoZona = new TipoZona();

            tipoZona.setTipoZonaId(tipoZonaDTO.getTipoZonaId());
            tipoZona.setNombreTipoZona((tipoZonaDTO.getNombreTipoZona() != null)
                ? tipoZonaDTO.getNombreTipoZona() : null);

            Estado estado = new Estado();

            if (tipoZonaDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(tipoZonaDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                tipoZona.setEstado(estado);
            }

            return tipoZona;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoZonaDTO> listTipoZonaToListTipoZonaDTO(
        List<TipoZona> listTipoZona) throws Exception {
        try {
            List<TipoZonaDTO> tipoZonaDTOs = new ArrayList<TipoZonaDTO>();

            for (TipoZona tipoZona : listTipoZona) {
                TipoZonaDTO tipoZonaDTO = tipoZonaToTipoZonaDTO(tipoZona);

                tipoZonaDTOs.add(tipoZonaDTO);
            }

            return tipoZonaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoZona> listTipoZonaDTOToListTipoZona(
        List<TipoZonaDTO> listTipoZonaDTO) throws Exception {
        try {
            List<TipoZona> listTipoZona = new ArrayList<TipoZona>();

            for (TipoZonaDTO tipoZonaDTO : listTipoZonaDTO) {
                TipoZona tipoZona = tipoZonaDTOToTipoZona(tipoZonaDTO);

                listTipoZona.add(tipoZona);
            }

            return listTipoZona;
        } catch (Exception e) {
            throw e;
        }
    }
}
