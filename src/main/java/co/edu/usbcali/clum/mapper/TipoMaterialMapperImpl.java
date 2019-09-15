package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.TipoMaterial;
import co.edu.usbcali.clum.dto.TipoMaterialDTO;
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
public class TipoMaterialMapperImpl implements TipoMaterialMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoMaterialMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    @Transactional(readOnly = true)
    public TipoMaterialDTO tipoMaterialToTipoMaterialDTO(
        TipoMaterial tipoMaterial) throws Exception {
        try {
            TipoMaterialDTO tipoMaterialDTO = new TipoMaterialDTO();

            tipoMaterialDTO.setTipoMaterialId(tipoMaterial.getTipoMaterialId());
            tipoMaterialDTO.setNombreTipoMaterial((tipoMaterial.getNombreTipoMaterial() != null)
                ? tipoMaterial.getNombreTipoMaterial() : null);
            tipoMaterialDTO.setIdEstado_Estado((tipoMaterial.getEstado()
                                                            .getIdEstado() != null)
                ? tipoMaterial.getEstado().getIdEstado() : null);

            return tipoMaterialDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoMaterial tipoMaterialDTOToTipoMaterial(
        TipoMaterialDTO tipoMaterialDTO) throws Exception {
        try {
            TipoMaterial tipoMaterial = new TipoMaterial();

            tipoMaterial.setTipoMaterialId(tipoMaterialDTO.getTipoMaterialId());
            tipoMaterial.setNombreTipoMaterial((tipoMaterialDTO.getNombreTipoMaterial() != null)
                ? tipoMaterialDTO.getNombreTipoMaterial() : null);

            Estado estado = new Estado();

            if (tipoMaterialDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(tipoMaterialDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                tipoMaterial.setEstado(estado);
            }

            return tipoMaterial;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoMaterialDTO> listTipoMaterialToListTipoMaterialDTO(
        List<TipoMaterial> listTipoMaterial) throws Exception {
        try {
            List<TipoMaterialDTO> tipoMaterialDTOs = new ArrayList<TipoMaterialDTO>();

            for (TipoMaterial tipoMaterial : listTipoMaterial) {
                TipoMaterialDTO tipoMaterialDTO = tipoMaterialToTipoMaterialDTO(tipoMaterial);

                tipoMaterialDTOs.add(tipoMaterialDTO);
            }

            return tipoMaterialDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoMaterial> listTipoMaterialDTOToListTipoMaterial(
        List<TipoMaterialDTO> listTipoMaterialDTO) throws Exception {
        try {
            List<TipoMaterial> listTipoMaterial = new ArrayList<TipoMaterial>();

            for (TipoMaterialDTO tipoMaterialDTO : listTipoMaterialDTO) {
                TipoMaterial tipoMaterial = tipoMaterialDTOToTipoMaterial(tipoMaterialDTO);

                listTipoMaterial.add(tipoMaterial);
            }

            return listTipoMaterial;
        } catch (Exception e) {
            throw e;
        }
    }
}
