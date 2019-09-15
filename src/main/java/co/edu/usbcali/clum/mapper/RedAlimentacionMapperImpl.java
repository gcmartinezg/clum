package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.RedAlimentacion;
import co.edu.usbcali.clum.dto.RedAlimentacionDTO;
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
public class RedAlimentacionMapperImpl implements RedAlimentacionMapper {
    private static final Logger log = LoggerFactory.getLogger(RedAlimentacionMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    /**
    * Service injected by Spring that manages TipoInstalacion entities
    *
    */
    @Autowired
    TipoInstalacionService serviceTipoInstalacion2;

    /**
    * Service injected by Spring that manages TipoMaterial entities
    *
    */
    @Autowired
    TipoMaterialService serviceTipoMaterial3;

    /**
    * Service injected by Spring that manages TipoSoporte entities
    *
    */
    @Autowired
    TipoSoporteService serviceTipoSoporte4;

    @Transactional(readOnly = true)
    public RedAlimentacionDTO redAlimentacionToRedAlimentacionDTO(
        RedAlimentacion redAlimentacion) throws Exception {
        try {
            RedAlimentacionDTO redAlimentacionDTO = new RedAlimentacionDTO();

            redAlimentacionDTO.setRedAlimentacionId(redAlimentacion.getRedAlimentacionId());
            redAlimentacionDTO.setCalibreConductorAwg((redAlimentacion.getCalibreConductorAwg() != null)
                ? redAlimentacion.getCalibreConductorAwg() : null);
            redAlimentacionDTO.setIdEstado_Estado((redAlimentacion.getEstado()
                                                                  .getIdEstado() != null)
                ? redAlimentacion.getEstado().getIdEstado() : null);
            redAlimentacionDTO.setTipoInstalacionId_TipoInstalacion((redAlimentacion.getTipoInstalacion()
                                                                                    .getTipoInstalacionId() != null)
                ? redAlimentacion.getTipoInstalacion().getTipoInstalacionId()
                : null);
            redAlimentacionDTO.setTipoMaterialId_TipoMaterial((redAlimentacion.getTipoMaterial()
                                                                              .getTipoMaterialId() != null)
                ? redAlimentacion.getTipoMaterial().getTipoMaterialId() : null);
            redAlimentacionDTO.setTipoSoporteId_TipoSoporte((redAlimentacion.getTipoSoporte()
                                                                            .getTipoSoporteId() != null)
                ? redAlimentacion.getTipoSoporte().getTipoSoporteId() : null);

            return redAlimentacionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public RedAlimentacion redAlimentacionDTOToRedAlimentacion(
        RedAlimentacionDTO redAlimentacionDTO) throws Exception {
        try {
            RedAlimentacion redAlimentacion = new RedAlimentacion();

            redAlimentacion.setRedAlimentacionId(redAlimentacionDTO.getRedAlimentacionId());
            redAlimentacion.setCalibreConductorAwg((redAlimentacionDTO.getCalibreConductorAwg() != null)
                ? redAlimentacionDTO.getCalibreConductorAwg() : null);

            Estado estado = new Estado();

            if (redAlimentacionDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(redAlimentacionDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                redAlimentacion.setEstado(estado);
            }

            TipoInstalacion tipoInstalacion = new TipoInstalacion();

            if (redAlimentacionDTO.getTipoInstalacionId_TipoInstalacion() != null) {
                tipoInstalacion = serviceTipoInstalacion2.getTipoInstalacion(redAlimentacionDTO.getTipoInstalacionId_TipoInstalacion());
            }

            if (tipoInstalacion != null) {
                redAlimentacion.setTipoInstalacion(tipoInstalacion);
            }

            TipoMaterial tipoMaterial = new TipoMaterial();

            if (redAlimentacionDTO.getTipoMaterialId_TipoMaterial() != null) {
                tipoMaterial = serviceTipoMaterial3.getTipoMaterial(redAlimentacionDTO.getTipoMaterialId_TipoMaterial());
            }

            if (tipoMaterial != null) {
                redAlimentacion.setTipoMaterial(tipoMaterial);
            }

            TipoSoporte tipoSoporte = new TipoSoporte();

            if (redAlimentacionDTO.getTipoSoporteId_TipoSoporte() != null) {
                tipoSoporte = serviceTipoSoporte4.getTipoSoporte(redAlimentacionDTO.getTipoSoporteId_TipoSoporte());
            }

            if (tipoSoporte != null) {
                redAlimentacion.setTipoSoporte(tipoSoporte);
            }

            return redAlimentacion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RedAlimentacionDTO> listRedAlimentacionToListRedAlimentacionDTO(
        List<RedAlimentacion> listRedAlimentacion) throws Exception {
        try {
            List<RedAlimentacionDTO> redAlimentacionDTOs = new ArrayList<RedAlimentacionDTO>();

            for (RedAlimentacion redAlimentacion : listRedAlimentacion) {
                RedAlimentacionDTO redAlimentacionDTO = redAlimentacionToRedAlimentacionDTO(redAlimentacion);

                redAlimentacionDTOs.add(redAlimentacionDTO);
            }

            return redAlimentacionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RedAlimentacion> listRedAlimentacionDTOToListRedAlimentacion(
        List<RedAlimentacionDTO> listRedAlimentacionDTO)
        throws Exception {
        try {
            List<RedAlimentacion> listRedAlimentacion = new ArrayList<RedAlimentacion>();

            for (RedAlimentacionDTO redAlimentacionDTO : listRedAlimentacionDTO) {
                RedAlimentacion redAlimentacion = redAlimentacionDTOToRedAlimentacion(redAlimentacionDTO);

                listRedAlimentacion.add(redAlimentacion);
            }

            return listRedAlimentacion;
        } catch (Exception e) {
            throw e;
        }
    }
}
