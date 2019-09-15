package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.Estado;
import co.edu.usbcali.clum.dto.EstadoDTO;
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
public class EstadoMapperImpl implements EstadoMapper {
    private static final Logger log = LoggerFactory.getLogger(EstadoMapperImpl.class);

    @Transactional(readOnly = true)
    public EstadoDTO estadoToEstadoDTO(Estado estado) throws Exception {
        try {
            EstadoDTO estadoDTO = new EstadoDTO();

            estadoDTO.setIdEstado(estado.getIdEstado());
            estadoDTO.setEstado((estado.getEstado() != null)
                ? estado.getEstado() : null);

            return estadoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Estado estadoDTOToEstado(EstadoDTO estadoDTO)
        throws Exception {
        try {
            Estado estado = new Estado();

            estado.setIdEstado(estadoDTO.getIdEstado());
            estado.setEstado((estadoDTO.getEstado() != null)
                ? estadoDTO.getEstado() : null);

            return estado;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EstadoDTO> listEstadoToListEstadoDTO(List<Estado> listEstado)
        throws Exception {
        try {
            List<EstadoDTO> estadoDTOs = new ArrayList<EstadoDTO>();

            for (Estado estado : listEstado) {
                EstadoDTO estadoDTO = estadoToEstadoDTO(estado);

                estadoDTOs.add(estadoDTO);
            }

            return estadoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Estado> listEstadoDTOToListEstado(List<EstadoDTO> listEstadoDTO)
        throws Exception {
        try {
            List<Estado> listEstado = new ArrayList<Estado>();

            for (EstadoDTO estadoDTO : listEstadoDTO) {
                Estado estado = estadoDTOToEstado(estadoDTO);

                listEstado.add(estado);
            }

            return listEstado;
        } catch (Exception e) {
            throw e;
        }
    }
}
