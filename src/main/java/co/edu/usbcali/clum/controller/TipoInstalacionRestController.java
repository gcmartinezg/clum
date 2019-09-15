package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoInstalacionDTO;
import co.edu.usbcali.clum.mapper.TipoInstalacionMapper;
import co.edu.usbcali.clum.service.TipoInstalacionService;

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
@RequestMapping("/tipoInstalacion")
public class TipoInstalacionRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoInstalacionRestController.class);
    @Autowired
    private TipoInstalacionService tipoInstalacionService;
    @Autowired
    private TipoInstalacionMapper tipoInstalacionMapper;

    @PostMapping(value = "/saveTipoInstalacion")
    public void saveTipoInstalacion(
        @RequestBody
    TipoInstalacionDTO tipoInstalacionDTO) throws Exception {
        try {
            TipoInstalacion tipoInstalacion = tipoInstalacionMapper.tipoInstalacionDTOToTipoInstalacion(tipoInstalacionDTO);

            tipoInstalacionService.saveTipoInstalacion(tipoInstalacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoInstalacion/{tipoInstalacionId}")
    public void deleteTipoInstalacion(
        @PathVariable("tipoInstalacionId")
    Integer tipoInstalacionId) throws Exception {
        try {
            TipoInstalacion tipoInstalacion = tipoInstalacionService.getTipoInstalacion(tipoInstalacionId);

            tipoInstalacionService.deleteTipoInstalacion(tipoInstalacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoInstalacion/")
    public void updateTipoInstalacion(
        @RequestBody
    TipoInstalacionDTO tipoInstalacionDTO) throws Exception {
        try {
            TipoInstalacion tipoInstalacion = tipoInstalacionMapper.tipoInstalacionDTOToTipoInstalacion(tipoInstalacionDTO);

            tipoInstalacionService.updateTipoInstalacion(tipoInstalacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoInstalacion")
    public List<TipoInstalacionDTO> getDataTipoInstalacion()
        throws Exception {
        try {
            return tipoInstalacionService.getDataTipoInstalacion();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoInstalacion/{tipoInstalacionId}")
    public TipoInstalacionDTO getTipoInstalacion(
        @PathVariable("tipoInstalacionId")
    Integer tipoInstalacionId) throws Exception {
        try {
            TipoInstalacion tipoInstalacion = tipoInstalacionService.getTipoInstalacion(tipoInstalacionId);

            return tipoInstalacionMapper.tipoInstalacionToTipoInstalacionDTO(tipoInstalacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
