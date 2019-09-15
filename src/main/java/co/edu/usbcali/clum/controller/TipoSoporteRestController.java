package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoSoporteDTO;
import co.edu.usbcali.clum.mapper.TipoSoporteMapper;
import co.edu.usbcali.clum.service.TipoSoporteService;

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
@RequestMapping("/tipoSoporte")
public class TipoSoporteRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoSoporteRestController.class);
    @Autowired
    private TipoSoporteService tipoSoporteService;
    @Autowired
    private TipoSoporteMapper tipoSoporteMapper;

    @PostMapping(value = "/saveTipoSoporte")
    public void saveTipoSoporte(@RequestBody
    TipoSoporteDTO tipoSoporteDTO) throws Exception {
        try {
            TipoSoporte tipoSoporte = tipoSoporteMapper.tipoSoporteDTOToTipoSoporte(tipoSoporteDTO);

            tipoSoporteService.saveTipoSoporte(tipoSoporte);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoSoporte/{tipoSoporteId}")
    public void deleteTipoSoporte(
        @PathVariable("tipoSoporteId")
    Integer tipoSoporteId) throws Exception {
        try {
            TipoSoporte tipoSoporte = tipoSoporteService.getTipoSoporte(tipoSoporteId);

            tipoSoporteService.deleteTipoSoporte(tipoSoporte);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoSoporte/")
    public void updateTipoSoporte(@RequestBody
    TipoSoporteDTO tipoSoporteDTO) throws Exception {
        try {
            TipoSoporte tipoSoporte = tipoSoporteMapper.tipoSoporteDTOToTipoSoporte(tipoSoporteDTO);

            tipoSoporteService.updateTipoSoporte(tipoSoporte);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoSoporte")
    public List<TipoSoporteDTO> getDataTipoSoporte() throws Exception {
        try {
            return tipoSoporteService.getDataTipoSoporte();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoSoporte/{tipoSoporteId}")
    public TipoSoporteDTO getTipoSoporte(
        @PathVariable("tipoSoporteId")
    Integer tipoSoporteId) throws Exception {
        try {
            TipoSoporte tipoSoporte = tipoSoporteService.getTipoSoporte(tipoSoporteId);

            return tipoSoporteMapper.tipoSoporteToTipoSoporteDTO(tipoSoporte);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
