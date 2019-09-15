package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.CanalizacionDTO;
import co.edu.usbcali.clum.mapper.CanalizacionMapper;
import co.edu.usbcali.clum.service.CanalizacionService;

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
@RequestMapping("/canalizacion")
public class CanalizacionRestController {
    private static final Logger log = LoggerFactory.getLogger(CanalizacionRestController.class);
    @Autowired
    private CanalizacionService canalizacionService;
    @Autowired
    private CanalizacionMapper canalizacionMapper;

    @PostMapping(value = "/saveCanalizacion")
    public void saveCanalizacion(@RequestBody
    CanalizacionDTO canalizacionDTO) throws Exception {
        try {
            Canalizacion canalizacion = canalizacionMapper.canalizacionDTOToCanalizacion(canalizacionDTO);

            canalizacionService.saveCanalizacion(canalizacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCanalizacion/{canalizacionId}")
    public void deleteCanalizacion(
        @PathVariable("canalizacionId")
    Integer canalizacionId) throws Exception {
        try {
            Canalizacion canalizacion = canalizacionService.getCanalizacion(canalizacionId);

            canalizacionService.deleteCanalizacion(canalizacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCanalizacion/")
    public void updateCanalizacion(@RequestBody
    CanalizacionDTO canalizacionDTO) throws Exception {
        try {
            Canalizacion canalizacion = canalizacionMapper.canalizacionDTOToCanalizacion(canalizacionDTO);

            canalizacionService.updateCanalizacion(canalizacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataCanalizacion")
    public List<CanalizacionDTO> getDataCanalizacion()
        throws Exception {
        try {
            return canalizacionService.getDataCanalizacion();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCanalizacion/{canalizacionId}")
    public CanalizacionDTO getCanalizacion(
        @PathVariable("canalizacionId")
    Integer canalizacionId) throws Exception {
        try {
            Canalizacion canalizacion = canalizacionService.getCanalizacion(canalizacionId);

            return canalizacionMapper.canalizacionToCanalizacionDTO(canalizacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
