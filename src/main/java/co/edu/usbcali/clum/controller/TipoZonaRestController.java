package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoZonaDTO;
import co.edu.usbcali.clum.mapper.TipoZonaMapper;
import co.edu.usbcali.clum.service.TipoZonaService;

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
@RequestMapping("/tipoZona")
public class TipoZonaRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoZonaRestController.class);
    @Autowired
    private TipoZonaService tipoZonaService;
    @Autowired
    private TipoZonaMapper tipoZonaMapper;

    @PostMapping(value = "/saveTipoZona")
    public void saveTipoZona(@RequestBody
    TipoZonaDTO tipoZonaDTO) throws Exception {
        try {
            TipoZona tipoZona = tipoZonaMapper.tipoZonaDTOToTipoZona(tipoZonaDTO);

            tipoZonaService.saveTipoZona(tipoZona);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoZona/{tipoZonaId}")
    public void deleteTipoZona(@PathVariable("tipoZonaId")
    Integer tipoZonaId) throws Exception {
        try {
            TipoZona tipoZona = tipoZonaService.getTipoZona(tipoZonaId);

            tipoZonaService.deleteTipoZona(tipoZona);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoZona/")
    public void updateTipoZona(@RequestBody
    TipoZonaDTO tipoZonaDTO) throws Exception {
        try {
            TipoZona tipoZona = tipoZonaMapper.tipoZonaDTOToTipoZona(tipoZonaDTO);

            tipoZonaService.updateTipoZona(tipoZona);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoZona")
    public List<TipoZonaDTO> getDataTipoZona() throws Exception {
        try {
            return tipoZonaService.getDataTipoZona();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoZona/{tipoZonaId}")
    public TipoZonaDTO getTipoZona(
        @PathVariable("tipoZonaId")
    Integer tipoZonaId) throws Exception {
        try {
            TipoZona tipoZona = tipoZonaService.getTipoZona(tipoZonaId);

            return tipoZonaMapper.tipoZonaToTipoZonaDTO(tipoZona);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
