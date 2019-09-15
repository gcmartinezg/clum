package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.TipoBalasto;
import co.edu.usbcali.clum.dto.TipoBalastoDTO;
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
public class TipoBalastoMapperImpl implements TipoBalastoMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoBalastoMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    @Transactional(readOnly = true)
    public TipoBalastoDTO tipoBalastoToTipoBalastoDTO(TipoBalasto tipoBalasto)
        throws Exception {
        try {
            TipoBalastoDTO tipoBalastoDTO = new TipoBalastoDTO();

            tipoBalastoDTO.setTipoBalastoId(tipoBalasto.getTipoBalastoId());
            tipoBalastoDTO.setNombreTipoBalasto((tipoBalasto.getNombreTipoBalasto() != null)
                ? tipoBalasto.getNombreTipoBalasto() : null);
            tipoBalastoDTO.setIdEstado_Estado((tipoBalasto.getEstado()
                                                          .getIdEstado() != null)
                ? tipoBalasto.getEstado().getIdEstado() : null);

            return tipoBalastoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoBalasto tipoBalastoDTOToTipoBalasto(
        TipoBalastoDTO tipoBalastoDTO) throws Exception {
        try {
            TipoBalasto tipoBalasto = new TipoBalasto();

            tipoBalasto.setTipoBalastoId(tipoBalastoDTO.getTipoBalastoId());
            tipoBalasto.setNombreTipoBalasto((tipoBalastoDTO.getNombreTipoBalasto() != null)
                ? tipoBalastoDTO.getNombreTipoBalasto() : null);

            Estado estado = new Estado();

            if (tipoBalastoDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(tipoBalastoDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                tipoBalasto.setEstado(estado);
            }

            return tipoBalasto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoBalastoDTO> listTipoBalastoToListTipoBalastoDTO(
        List<TipoBalasto> listTipoBalasto) throws Exception {
        try {
            List<TipoBalastoDTO> tipoBalastoDTOs = new ArrayList<TipoBalastoDTO>();

            for (TipoBalasto tipoBalasto : listTipoBalasto) {
                TipoBalastoDTO tipoBalastoDTO = tipoBalastoToTipoBalastoDTO(tipoBalasto);

                tipoBalastoDTOs.add(tipoBalastoDTO);
            }

            return tipoBalastoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoBalasto> listTipoBalastoDTOToListTipoBalasto(
        List<TipoBalastoDTO> listTipoBalastoDTO) throws Exception {
        try {
            List<TipoBalasto> listTipoBalasto = new ArrayList<TipoBalasto>();

            for (TipoBalastoDTO tipoBalastoDTO : listTipoBalastoDTO) {
                TipoBalasto tipoBalasto = tipoBalastoDTOToTipoBalasto(tipoBalastoDTO);

                listTipoBalasto.add(tipoBalasto);
            }

            return listTipoBalasto;
        } catch (Exception e) {
            throw e;
        }
    }
}
