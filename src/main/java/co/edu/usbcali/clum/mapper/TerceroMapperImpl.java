package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.Tercero;
import co.edu.usbcali.clum.dto.TerceroDTO;
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
public class TerceroMapperImpl implements TerceroMapper {
    private static final Logger log = LoggerFactory.getLogger(TerceroMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    /**
    * Service injected by Spring that manages TipoDocumento entities
    *
    */
    @Autowired
    TipoDocumentoService serviceTipoDocumento2;

    @Transactional(readOnly = true)
    public TerceroDTO terceroToTerceroDTO(Tercero tercero)
        throws Exception {
        try {
            TerceroDTO terceroDTO = new TerceroDTO();

            terceroDTO.setTerceroId(tercero.getTerceroId());
            terceroDTO.setDireccion((tercero.getDireccion() != null)
                ? tercero.getDireccion() : null);
            terceroDTO.setEmail((tercero.getEmail() != null)
                ? tercero.getEmail() : null);
            terceroDTO.setNombreTercero((tercero.getNombreTercero() != null)
                ? tercero.getNombreTercero() : null);
            terceroDTO.setNumeroDocumento((tercero.getNumeroDocumento() != null)
                ? tercero.getNumeroDocumento() : null);
            terceroDTO.setTelefono((tercero.getTelefono() != null)
                ? tercero.getTelefono() : null);
            terceroDTO.setIdEstado_Estado((tercero.getEstado().getIdEstado() != null)
                ? tercero.getEstado().getIdEstado() : null);
            terceroDTO.setTipoDocumentoId_TipoDocumento((tercero.getTipoDocumento()
                                                                .getTipoDocumentoId() != null)
                ? tercero.getTipoDocumento().getTipoDocumentoId() : null);

            return terceroDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Tercero terceroDTOToTercero(TerceroDTO terceroDTO)
        throws Exception {
        try {
            Tercero tercero = new Tercero();

            tercero.setTerceroId(terceroDTO.getTerceroId());
            tercero.setDireccion((terceroDTO.getDireccion() != null)
                ? terceroDTO.getDireccion() : null);
            tercero.setEmail((terceroDTO.getEmail() != null)
                ? terceroDTO.getEmail() : null);
            tercero.setNombreTercero((terceroDTO.getNombreTercero() != null)
                ? terceroDTO.getNombreTercero() : null);
            tercero.setNumeroDocumento((terceroDTO.getNumeroDocumento() != null)
                ? terceroDTO.getNumeroDocumento() : null);
            tercero.setTelefono((terceroDTO.getTelefono() != null)
                ? terceroDTO.getTelefono() : null);

            Estado estado = new Estado();

            if (terceroDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(terceroDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                tercero.setEstado(estado);
            }

            TipoDocumento tipoDocumento = new TipoDocumento();

            if (terceroDTO.getTipoDocumentoId_TipoDocumento() != null) {
                tipoDocumento = serviceTipoDocumento2.getTipoDocumento(terceroDTO.getTipoDocumentoId_TipoDocumento());
            }

            if (tipoDocumento != null) {
                tercero.setTipoDocumento(tipoDocumento);
            }

            return tercero;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TerceroDTO> listTerceroToListTerceroDTO(
        List<Tercero> listTercero) throws Exception {
        try {
            List<TerceroDTO> terceroDTOs = new ArrayList<TerceroDTO>();

            for (Tercero tercero : listTercero) {
                TerceroDTO terceroDTO = terceroToTerceroDTO(tercero);

                terceroDTOs.add(terceroDTO);
            }

            return terceroDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Tercero> listTerceroDTOToListTercero(
        List<TerceroDTO> listTerceroDTO) throws Exception {
        try {
            List<Tercero> listTercero = new ArrayList<Tercero>();

            for (TerceroDTO terceroDTO : listTerceroDTO) {
                Tercero tercero = terceroDTOToTercero(terceroDTO);

                listTercero.add(tercero);
            }

            return listTercero;
        } catch (Exception e) {
            throw e;
        }
    }
}
