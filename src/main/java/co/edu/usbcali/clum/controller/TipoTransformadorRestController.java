package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoTransformadorDTO;
import co.edu.usbcali.clum.mapper.TipoTransformadorMapper;
import co.edu.usbcali.clum.service.TipoTransformadorService;

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
@RequestMapping("/tipoTransformador")
public class TipoTransformadorRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoTransformadorRestController.class);
    @Autowired
    private TipoTransformadorService tipoTransformadorService;
    @Autowired
    private TipoTransformadorMapper tipoTransformadorMapper;

    @PostMapping(value = "/saveTipoTransformador")
    public void saveTipoTransformador(
        @RequestBody
    TipoTransformadorDTO tipoTransformadorDTO) throws Exception {
        try {
            TipoTransformador tipoTransformador = tipoTransformadorMapper.tipoTransformadorDTOToTipoTransformador(tipoTransformadorDTO);

            tipoTransformadorService.saveTipoTransformador(tipoTransformador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoTransformador/{tipoTransformadorId}")
    public void deleteTipoTransformador(
        @PathVariable("tipoTransformadorId")
    Integer tipoTransformadorId) throws Exception {
        try {
            TipoTransformador tipoTransformador = tipoTransformadorService.getTipoTransformador(tipoTransformadorId);

            tipoTransformadorService.deleteTipoTransformador(tipoTransformador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoTransformador/")
    public void updateTipoTransformador(
        @RequestBody
    TipoTransformadorDTO tipoTransformadorDTO) throws Exception {
        try {
            TipoTransformador tipoTransformador = tipoTransformadorMapper.tipoTransformadorDTOToTipoTransformador(tipoTransformadorDTO);

            tipoTransformadorService.updateTipoTransformador(tipoTransformador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoTransformador")
    public List<TipoTransformadorDTO> getDataTipoTransformador()
        throws Exception {
        try {
            return tipoTransformadorService.getDataTipoTransformador();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoTransformador/{tipoTransformadorId}")
    public TipoTransformadorDTO getTipoTransformador(
        @PathVariable("tipoTransformadorId")
    Integer tipoTransformadorId) throws Exception {
        try {
            TipoTransformador tipoTransformador = tipoTransformadorService.getTipoTransformador(tipoTransformadorId);

            return tipoTransformadorMapper.tipoTransformadorToTipoTransformadorDTO(tipoTransformador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
