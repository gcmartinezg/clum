package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.TipoDocumento;
import co.edu.usbcali.clum.dto.TipoDocumentoDTO;
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
public class TipoDocumentoMapperImpl implements TipoDocumentoMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoDocumentoMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    @Transactional(readOnly = true)
    public TipoDocumentoDTO tipoDocumentoToTipoDocumentoDTO(
        TipoDocumento tipoDocumento) throws Exception {
        try {
            TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();

            tipoDocumentoDTO.setTipoDocumentoId(tipoDocumento.getTipoDocumentoId());
            tipoDocumentoDTO.setNombreTipoDocumento((tipoDocumento.getNombreTipoDocumento() != null)
                ? tipoDocumento.getNombreTipoDocumento() : null);
            tipoDocumentoDTO.setIdEstado_Estado((tipoDocumento.getEstado()
                                                              .getIdEstado() != null)
                ? tipoDocumento.getEstado().getIdEstado() : null);

            return tipoDocumentoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoDocumento tipoDocumentoDTOToTipoDocumento(
        TipoDocumentoDTO tipoDocumentoDTO) throws Exception {
        try {
            TipoDocumento tipoDocumento = new TipoDocumento();

            tipoDocumento.setTipoDocumentoId(tipoDocumentoDTO.getTipoDocumentoId());
            tipoDocumento.setNombreTipoDocumento((tipoDocumentoDTO.getNombreTipoDocumento() != null)
                ? tipoDocumentoDTO.getNombreTipoDocumento() : null);

            Estado estado = new Estado();

            if (tipoDocumentoDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(tipoDocumentoDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                tipoDocumento.setEstado(estado);
            }

            return tipoDocumento;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoDocumentoDTO> listTipoDocumentoToListTipoDocumentoDTO(
        List<TipoDocumento> listTipoDocumento) throws Exception {
        try {
            List<TipoDocumentoDTO> tipoDocumentoDTOs = new ArrayList<TipoDocumentoDTO>();

            for (TipoDocumento tipoDocumento : listTipoDocumento) {
                TipoDocumentoDTO tipoDocumentoDTO = tipoDocumentoToTipoDocumentoDTO(tipoDocumento);

                tipoDocumentoDTOs.add(tipoDocumentoDTO);
            }

            return tipoDocumentoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoDocumento> listTipoDocumentoDTOToListTipoDocumento(
        List<TipoDocumentoDTO> listTipoDocumentoDTO) throws Exception {
        try {
            List<TipoDocumento> listTipoDocumento = new ArrayList<TipoDocumento>();

            for (TipoDocumentoDTO tipoDocumentoDTO : listTipoDocumentoDTO) {
                TipoDocumento tipoDocumento = tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);

                listTipoDocumento.add(tipoDocumento);
            }

            return listTipoDocumento;
        } catch (Exception e) {
            throw e;
        }
    }
}
