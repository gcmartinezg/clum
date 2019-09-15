package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.TipoLampara;
import co.edu.usbcali.clum.dto.TipoLamparaDTO;
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
public class TipoLamparaMapperImpl implements TipoLamparaMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoLamparaMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    @Transactional(readOnly = true)
    public TipoLamparaDTO tipoLamparaToTipoLamparaDTO(TipoLampara tipoLampara)
        throws Exception {
        try {
            TipoLamparaDTO tipoLamparaDTO = new TipoLamparaDTO();

            tipoLamparaDTO.setTipoLamparaId(tipoLampara.getTipoLamparaId());
            tipoLamparaDTO.setNombreTipoLampara((tipoLampara.getNombreTipoLampara() != null)
                ? tipoLampara.getNombreTipoLampara() : null);
            tipoLamparaDTO.setIdEstado_Estado((tipoLampara.getEstado()
                                                          .getIdEstado() != null)
                ? tipoLampara.getEstado().getIdEstado() : null);

            return tipoLamparaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoLampara tipoLamparaDTOToTipoLampara(
        TipoLamparaDTO tipoLamparaDTO) throws Exception {
        try {
            TipoLampara tipoLampara = new TipoLampara();

            tipoLampara.setTipoLamparaId(tipoLamparaDTO.getTipoLamparaId());
            tipoLampara.setNombreTipoLampara((tipoLamparaDTO.getNombreTipoLampara() != null)
                ? tipoLamparaDTO.getNombreTipoLampara() : null);

            Estado estado = new Estado();

            if (tipoLamparaDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(tipoLamparaDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                tipoLampara.setEstado(estado);
            }

            return tipoLampara;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoLamparaDTO> listTipoLamparaToListTipoLamparaDTO(
        List<TipoLampara> listTipoLampara) throws Exception {
        try {
            List<TipoLamparaDTO> tipoLamparaDTOs = new ArrayList<TipoLamparaDTO>();

            for (TipoLampara tipoLampara : listTipoLampara) {
                TipoLamparaDTO tipoLamparaDTO = tipoLamparaToTipoLamparaDTO(tipoLampara);

                tipoLamparaDTOs.add(tipoLamparaDTO);
            }

            return tipoLamparaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoLampara> listTipoLamparaDTOToListTipoLampara(
        List<TipoLamparaDTO> listTipoLamparaDTO) throws Exception {
        try {
            List<TipoLampara> listTipoLampara = new ArrayList<TipoLampara>();

            for (TipoLamparaDTO tipoLamparaDTO : listTipoLamparaDTO) {
                TipoLampara tipoLampara = tipoLamparaDTOToTipoLampara(tipoLamparaDTO);

                listTipoLampara.add(tipoLampara);
            }

            return listTipoLampara;
        } catch (Exception e) {
            throw e;
        }
    }
}
