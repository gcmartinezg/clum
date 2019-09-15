package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TerceroDTO;
import co.edu.usbcali.clum.mapper.TerceroMapper;
import co.edu.usbcali.clum.service.TerceroService;

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
@RequestMapping("/tercero")
public class TerceroRestController {
    private static final Logger log = LoggerFactory.getLogger(TerceroRestController.class);
    @Autowired
    private TerceroService terceroService;
    @Autowired
    private TerceroMapper terceroMapper;

    @PostMapping(value = "/saveTercero")
    public void saveTercero(@RequestBody
    TerceroDTO terceroDTO) throws Exception {
        try {
            Tercero tercero = terceroMapper.terceroDTOToTercero(terceroDTO);

            terceroService.saveTercero(tercero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTercero/{terceroId}")
    public void deleteTercero(@PathVariable("terceroId")
    Integer terceroId) throws Exception {
        try {
            Tercero tercero = terceroService.getTercero(terceroId);

            terceroService.deleteTercero(tercero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTercero/")
    public void updateTercero(@RequestBody
    TerceroDTO terceroDTO) throws Exception {
        try {
            Tercero tercero = terceroMapper.terceroDTOToTercero(terceroDTO);

            terceroService.updateTercero(tercero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTercero")
    public List<TerceroDTO> getDataTercero() throws Exception {
        try {
            return terceroService.getDataTercero();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTercero/{terceroId}")
    public TerceroDTO getTercero(@PathVariable("terceroId")
    Integer terceroId) throws Exception {
        try {
            Tercero tercero = terceroService.getTercero(terceroId);

            return terceroMapper.terceroToTerceroDTO(tercero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
