package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.Transformador;
import co.edu.usbcali.clum.dto.TransformadorDTO;
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
public class TransformadorMapperImpl implements TransformadorMapper {
    private static final Logger log = LoggerFactory.getLogger(TransformadorMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    /**
    * Service injected by Spring that manages TipoSoporte entities
    *
    */
    @Autowired
    TipoSoporteService serviceTipoSoporte2;

    /**
    * Service injected by Spring that manages TipoTransformador entities
    *
    */
    @Autowired
    TipoTransformadorService serviceTipoTransformador3;

    @Transactional(readOnly = true)
    public TransformadorDTO transformadorToTransformadorDTO(
        Transformador transformador) throws Exception {
        try {
            TransformadorDTO transformadorDTO = new TransformadorDTO();

            transformadorDTO.setTransformadorId(transformador.getTransformadorId());
            transformadorDTO.setIdEstado_Estado((transformador.getEstado()
                                                              .getIdEstado() != null)
                ? transformador.getEstado().getIdEstado() : null);
            transformadorDTO.setTipoSoporteId_TipoSoporte((transformador.getTipoSoporte()
                                                                        .getTipoSoporteId() != null)
                ? transformador.getTipoSoporte().getTipoSoporteId() : null);
            transformadorDTO.setTipoTransformadorId_TipoTransformador((transformador.getTipoTransformador()
                                                                                    .getTipoTransformadorId() != null)
                ? transformador.getTipoTransformador().getTipoTransformadorId()
                : null);

            return transformadorDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Transformador transformadorDTOToTransformador(
        TransformadorDTO transformadorDTO) throws Exception {
        try {
            Transformador transformador = new Transformador();

            transformador.setTransformadorId(transformadorDTO.getTransformadorId());

            Estado estado = new Estado();

            if (transformadorDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(transformadorDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                transformador.setEstado(estado);
            }

            TipoSoporte tipoSoporte = new TipoSoporte();

            if (transformadorDTO.getTipoSoporteId_TipoSoporte() != null) {
                tipoSoporte = serviceTipoSoporte2.getTipoSoporte(transformadorDTO.getTipoSoporteId_TipoSoporte());
            }

            if (tipoSoporte != null) {
                transformador.setTipoSoporte(tipoSoporte);
            }

            TipoTransformador tipoTransformador = new TipoTransformador();

            if (transformadorDTO.getTipoTransformadorId_TipoTransformador() != null) {
                tipoTransformador = serviceTipoTransformador3.getTipoTransformador(transformadorDTO.getTipoTransformadorId_TipoTransformador());
            }

            if (tipoTransformador != null) {
                transformador.setTipoTransformador(tipoTransformador);
            }

            return transformador;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TransformadorDTO> listTransformadorToListTransformadorDTO(
        List<Transformador> listTransformador) throws Exception {
        try {
            List<TransformadorDTO> transformadorDTOs = new ArrayList<TransformadorDTO>();

            for (Transformador transformador : listTransformador) {
                TransformadorDTO transformadorDTO = transformadorToTransformadorDTO(transformador);

                transformadorDTOs.add(transformadorDTO);
            }

            return transformadorDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Transformador> listTransformadorDTOToListTransformador(
        List<TransformadorDTO> listTransformadorDTO) throws Exception {
        try {
            List<Transformador> listTransformador = new ArrayList<Transformador>();

            for (TransformadorDTO transformadorDTO : listTransformadorDTO) {
                Transformador transformador = transformadorDTOToTransformador(transformadorDTO);

                listTransformador.add(transformador);
            }

            return listTransformador;
        } catch (Exception e) {
            throw e;
        }
    }
}
