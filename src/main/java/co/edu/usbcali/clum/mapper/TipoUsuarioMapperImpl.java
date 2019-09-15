package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.TipoUsuario;
import co.edu.usbcali.clum.dto.TipoUsuarioDTO;
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
public class TipoUsuarioMapperImpl implements TipoUsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoUsuarioMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    @Transactional(readOnly = true)
    public TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario)
        throws Exception {
        try {
            TipoUsuarioDTO tipoUsuarioDTO = new TipoUsuarioDTO();

            tipoUsuarioDTO.setTipoUsuarioId(tipoUsuario.getTipoUsuarioId());
            tipoUsuarioDTO.setNombreTipoUsuario((tipoUsuario.getNombreTipoUsuario() != null)
                ? tipoUsuario.getNombreTipoUsuario() : null);
            tipoUsuarioDTO.setIdEstado_Estado((tipoUsuario.getEstado()
                                                          .getIdEstado() != null)
                ? tipoUsuario.getEstado().getIdEstado() : null);

            return tipoUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoUsuario tipoUsuarioDTOToTipoUsuario(
        TipoUsuarioDTO tipoUsuarioDTO) throws Exception {
        try {
            TipoUsuario tipoUsuario = new TipoUsuario();

            tipoUsuario.setTipoUsuarioId(tipoUsuarioDTO.getTipoUsuarioId());
            tipoUsuario.setNombreTipoUsuario((tipoUsuarioDTO.getNombreTipoUsuario() != null)
                ? tipoUsuarioDTO.getNombreTipoUsuario() : null);

            Estado estado = new Estado();

            if (tipoUsuarioDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(tipoUsuarioDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                tipoUsuario.setEstado(estado);
            }

            return tipoUsuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoUsuarioDTO> listTipoUsuarioToListTipoUsuarioDTO(
        List<TipoUsuario> listTipoUsuario) throws Exception {
        try {
            List<TipoUsuarioDTO> tipoUsuarioDTOs = new ArrayList<TipoUsuarioDTO>();

            for (TipoUsuario tipoUsuario : listTipoUsuario) {
                TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioToTipoUsuarioDTO(tipoUsuario);

                tipoUsuarioDTOs.add(tipoUsuarioDTO);
            }

            return tipoUsuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoUsuario> listTipoUsuarioDTOToListTipoUsuario(
        List<TipoUsuarioDTO> listTipoUsuarioDTO) throws Exception {
        try {
            List<TipoUsuario> listTipoUsuario = new ArrayList<TipoUsuario>();

            for (TipoUsuarioDTO tipoUsuarioDTO : listTipoUsuarioDTO) {
                TipoUsuario tipoUsuario = tipoUsuarioDTOToTipoUsuario(tipoUsuarioDTO);

                listTipoUsuario.add(tipoUsuario);
            }

            return listTipoUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
