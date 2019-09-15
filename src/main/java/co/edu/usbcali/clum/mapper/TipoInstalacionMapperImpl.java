package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.TipoInstalacion;
import co.edu.usbcali.clum.dto.TipoInstalacionDTO;
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
public class TipoInstalacionMapperImpl implements TipoInstalacionMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoInstalacionMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    @Transactional(readOnly = true)
    public TipoInstalacionDTO tipoInstalacionToTipoInstalacionDTO(
        TipoInstalacion tipoInstalacion) throws Exception {
        try {
            TipoInstalacionDTO tipoInstalacionDTO = new TipoInstalacionDTO();

            tipoInstalacionDTO.setTipoInstalacionId(tipoInstalacion.getTipoInstalacionId());
            tipoInstalacionDTO.setNombreTipoInstalacion((tipoInstalacion.getNombreTipoInstalacion() != null)
                ? tipoInstalacion.getNombreTipoInstalacion() : null);
            tipoInstalacionDTO.setIdEstado_Estado((tipoInstalacion.getEstado()
                                                                  .getIdEstado() != null)
                ? tipoInstalacion.getEstado().getIdEstado() : null);

            return tipoInstalacionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoInstalacion tipoInstalacionDTOToTipoInstalacion(
        TipoInstalacionDTO tipoInstalacionDTO) throws Exception {
        try {
            TipoInstalacion tipoInstalacion = new TipoInstalacion();

            tipoInstalacion.setTipoInstalacionId(tipoInstalacionDTO.getTipoInstalacionId());
            tipoInstalacion.setNombreTipoInstalacion((tipoInstalacionDTO.getNombreTipoInstalacion() != null)
                ? tipoInstalacionDTO.getNombreTipoInstalacion() : null);

            Estado estado = new Estado();

            if (tipoInstalacionDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(tipoInstalacionDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                tipoInstalacion.setEstado(estado);
            }

            return tipoInstalacion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoInstalacionDTO> listTipoInstalacionToListTipoInstalacionDTO(
        List<TipoInstalacion> listTipoInstalacion) throws Exception {
        try {
            List<TipoInstalacionDTO> tipoInstalacionDTOs = new ArrayList<TipoInstalacionDTO>();

            for (TipoInstalacion tipoInstalacion : listTipoInstalacion) {
                TipoInstalacionDTO tipoInstalacionDTO = tipoInstalacionToTipoInstalacionDTO(tipoInstalacion);

                tipoInstalacionDTOs.add(tipoInstalacionDTO);
            }

            return tipoInstalacionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoInstalacion> listTipoInstalacionDTOToListTipoInstalacion(
        List<TipoInstalacionDTO> listTipoInstalacionDTO)
        throws Exception {
        try {
            List<TipoInstalacion> listTipoInstalacion = new ArrayList<TipoInstalacion>();

            for (TipoInstalacionDTO tipoInstalacionDTO : listTipoInstalacionDTO) {
                TipoInstalacion tipoInstalacion = tipoInstalacionDTOToTipoInstalacion(tipoInstalacionDTO);

                listTipoInstalacion.add(tipoInstalacion);
            }

            return listTipoInstalacion;
        } catch (Exception e) {
            throw e;
        }
    }
}
