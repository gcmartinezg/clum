package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.TipoEspacioIluminado;
import co.edu.usbcali.clum.dto.TipoEspacioIluminadoDTO;
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
public class TipoEspacioIluminadoMapperImpl
    implements TipoEspacioIluminadoMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoEspacioIluminadoMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    @Transactional(readOnly = true)
    public TipoEspacioIluminadoDTO tipoEspacioIluminadoToTipoEspacioIluminadoDTO(
        TipoEspacioIluminado tipoEspacioIluminado) throws Exception {
        try {
            TipoEspacioIluminadoDTO tipoEspacioIluminadoDTO = new TipoEspacioIluminadoDTO();

            tipoEspacioIluminadoDTO.setTipoEspacioIluminadoId(tipoEspacioIluminado.getTipoEspacioIluminadoId());
            tipoEspacioIluminadoDTO.setNombreTipoEspacioIluminado((tipoEspacioIluminado.getNombreTipoEspacioIluminado() != null)
                ? tipoEspacioIluminado.getNombreTipoEspacioIluminado() : null);
            tipoEspacioIluminadoDTO.setIdEstado_Estado((tipoEspacioIluminado.getEstado()
                                                                            .getIdEstado() != null)
                ? tipoEspacioIluminado.getEstado().getIdEstado() : null);

            return tipoEspacioIluminadoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoEspacioIluminado tipoEspacioIluminadoDTOToTipoEspacioIluminado(
        TipoEspacioIluminadoDTO tipoEspacioIluminadoDTO)
        throws Exception {
        try {
            TipoEspacioIluminado tipoEspacioIluminado = new TipoEspacioIluminado();

            tipoEspacioIluminado.setTipoEspacioIluminadoId(tipoEspacioIluminadoDTO.getTipoEspacioIluminadoId());
            tipoEspacioIluminado.setNombreTipoEspacioIluminado((tipoEspacioIluminadoDTO.getNombreTipoEspacioIluminado() != null)
                ? tipoEspacioIluminadoDTO.getNombreTipoEspacioIluminado() : null);

            Estado estado = new Estado();

            if (tipoEspacioIluminadoDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(tipoEspacioIluminadoDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                tipoEspacioIluminado.setEstado(estado);
            }

            return tipoEspacioIluminado;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoEspacioIluminadoDTO> listTipoEspacioIluminadoToListTipoEspacioIluminadoDTO(
        List<TipoEspacioIluminado> listTipoEspacioIluminado)
        throws Exception {
        try {
            List<TipoEspacioIluminadoDTO> tipoEspacioIluminadoDTOs = new ArrayList<TipoEspacioIluminadoDTO>();

            for (TipoEspacioIluminado tipoEspacioIluminado : listTipoEspacioIluminado) {
                TipoEspacioIluminadoDTO tipoEspacioIluminadoDTO = tipoEspacioIluminadoToTipoEspacioIluminadoDTO(tipoEspacioIluminado);

                tipoEspacioIluminadoDTOs.add(tipoEspacioIluminadoDTO);
            }

            return tipoEspacioIluminadoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoEspacioIluminado> listTipoEspacioIluminadoDTOToListTipoEspacioIluminado(
        List<TipoEspacioIluminadoDTO> listTipoEspacioIluminadoDTO)
        throws Exception {
        try {
            List<TipoEspacioIluminado> listTipoEspacioIluminado = new ArrayList<TipoEspacioIluminado>();

            for (TipoEspacioIluminadoDTO tipoEspacioIluminadoDTO : listTipoEspacioIluminadoDTO) {
                TipoEspacioIluminado tipoEspacioIluminado = tipoEspacioIluminadoDTOToTipoEspacioIluminado(tipoEspacioIluminadoDTO);

                listTipoEspacioIluminado.add(tipoEspacioIluminado);
            }

            return listTipoEspacioIluminado;
        } catch (Exception e) {
            throw e;
        }
    }
}
