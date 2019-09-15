package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.SoporteLampara;
import co.edu.usbcali.clum.dto.SoporteLamparaDTO;
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
public class SoporteLamparaMapperImpl implements SoporteLamparaMapper {
    private static final Logger log = LoggerFactory.getLogger(SoporteLamparaMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    /**
    * Service injected by Spring that manages TipoMaterial entities
    *
    */
    @Autowired
    TipoMaterialService serviceTipoMaterial2;

    /**
    * Service injected by Spring that manages TipoSoporte entities
    *
    */
    @Autowired
    TipoSoporteService serviceTipoSoporte3;

    @Transactional(readOnly = true)
    public SoporteLamparaDTO soporteLamparaToSoporteLamparaDTO(
        SoporteLampara soporteLampara) throws Exception {
        try {
            SoporteLamparaDTO soporteLamparaDTO = new SoporteLamparaDTO();

            soporteLamparaDTO.setSoporteLamparaId(soporteLampara.getSoporteLamparaId());
            soporteLamparaDTO.setLongitud((soporteLampara.getLongitud() != null)
                ? soporteLampara.getLongitud() : null);
            soporteLamparaDTO.setIdEstado_Estado((soporteLampara.getEstado()
                                                                .getIdEstado() != null)
                ? soporteLampara.getEstado().getIdEstado() : null);
            soporteLamparaDTO.setTipoMaterialId_TipoMaterial((soporteLampara.getTipoMaterial()
                                                                            .getTipoMaterialId() != null)
                ? soporteLampara.getTipoMaterial().getTipoMaterialId() : null);
            soporteLamparaDTO.setTipoSoporteId_TipoSoporte((soporteLampara.getTipoSoporte()
                                                                          .getTipoSoporteId() != null)
                ? soporteLampara.getTipoSoporte().getTipoSoporteId() : null);

            return soporteLamparaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public SoporteLampara soporteLamparaDTOToSoporteLampara(
        SoporteLamparaDTO soporteLamparaDTO) throws Exception {
        try {
            SoporteLampara soporteLampara = new SoporteLampara();

            soporteLampara.setSoporteLamparaId(soporteLamparaDTO.getSoporteLamparaId());
            soporteLampara.setLongitud((soporteLamparaDTO.getLongitud() != null)
                ? soporteLamparaDTO.getLongitud() : null);

            Estado estado = new Estado();

            if (soporteLamparaDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(soporteLamparaDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                soporteLampara.setEstado(estado);
            }

            TipoMaterial tipoMaterial = new TipoMaterial();

            if (soporteLamparaDTO.getTipoMaterialId_TipoMaterial() != null) {
                tipoMaterial = serviceTipoMaterial2.getTipoMaterial(soporteLamparaDTO.getTipoMaterialId_TipoMaterial());
            }

            if (tipoMaterial != null) {
                soporteLampara.setTipoMaterial(tipoMaterial);
            }

            TipoSoporte tipoSoporte = new TipoSoporte();

            if (soporteLamparaDTO.getTipoSoporteId_TipoSoporte() != null) {
                tipoSoporte = serviceTipoSoporte3.getTipoSoporte(soporteLamparaDTO.getTipoSoporteId_TipoSoporte());
            }

            if (tipoSoporte != null) {
                soporteLampara.setTipoSoporte(tipoSoporte);
            }

            return soporteLampara;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SoporteLamparaDTO> listSoporteLamparaToListSoporteLamparaDTO(
        List<SoporteLampara> listSoporteLampara) throws Exception {
        try {
            List<SoporteLamparaDTO> soporteLamparaDTOs = new ArrayList<SoporteLamparaDTO>();

            for (SoporteLampara soporteLampara : listSoporteLampara) {
                SoporteLamparaDTO soporteLamparaDTO = soporteLamparaToSoporteLamparaDTO(soporteLampara);

                soporteLamparaDTOs.add(soporteLamparaDTO);
            }

            return soporteLamparaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SoporteLampara> listSoporteLamparaDTOToListSoporteLampara(
        List<SoporteLamparaDTO> listSoporteLamparaDTO)
        throws Exception {
        try {
            List<SoporteLampara> listSoporteLampara = new ArrayList<SoporteLampara>();

            for (SoporteLamparaDTO soporteLamparaDTO : listSoporteLamparaDTO) {
                SoporteLampara soporteLampara = soporteLamparaDTOToSoporteLampara(soporteLamparaDTO);

                listSoporteLampara.add(soporteLampara);
            }

            return listSoporteLampara;
        } catch (Exception e) {
            throw e;
        }
    }
}
