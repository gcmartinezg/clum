package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoDocumentoDTO;
import co.edu.usbcali.clum.mapper.TipoDocumentoMapper;
import co.edu.usbcali.clum.service.TipoDocumentoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/tipoDocumento")
public class TipoDocumentoRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoDocumentoRestController.class);
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    @Autowired
    private TipoDocumentoMapper tipoDocumentoMapper;

    @PostMapping(value = "/saveTipoDocumento")
    public void saveTipoDocumento(@RequestBody
    TipoDocumentoDTO tipoDocumentoDTO) throws Exception {
        try {
            TipoDocumento tipoDocumento = tipoDocumentoMapper.tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);

            tipoDocumentoService.saveTipoDocumento(tipoDocumento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoDocumento/{tipoDocumentoId}")
    public void deleteTipoDocumento(
        @PathVariable("tipoDocumentoId")
    Integer tipoDocumentoId) throws Exception {
        try {
            TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumento(tipoDocumentoId);

            tipoDocumentoService.deleteTipoDocumento(tipoDocumento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoDocumento/")
    public void updateTipoDocumento(
        @RequestBody
    TipoDocumentoDTO tipoDocumentoDTO) throws Exception {
        try {
            TipoDocumento tipoDocumento = tipoDocumentoMapper.tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);

            tipoDocumentoService.updateTipoDocumento(tipoDocumento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoDocumento")
    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception {
        try {
            return tipoDocumentoService.getDataTipoDocumento();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoDocumento/{tipoDocumentoId}")
    public TipoDocumentoDTO getTipoDocumento(
        @PathVariable("tipoDocumentoId")
    Integer tipoDocumentoId) throws Exception {
        try {
            TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumento(tipoDocumentoId);

            return tipoDocumentoMapper.tipoDocumentoToTipoDocumentoDTO(tipoDocumento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
