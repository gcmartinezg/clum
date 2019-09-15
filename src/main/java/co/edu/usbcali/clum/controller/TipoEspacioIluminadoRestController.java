package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoEspacioIluminadoDTO;
import co.edu.usbcali.clum.mapper.TipoEspacioIluminadoMapper;
import co.edu.usbcali.clum.service.TipoEspacioIluminadoService;

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
@RequestMapping("/tipoEspacioIluminado")
public class TipoEspacioIluminadoRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoEspacioIluminadoRestController.class);
    @Autowired
    private TipoEspacioIluminadoService tipoEspacioIluminadoService;
    @Autowired
    private TipoEspacioIluminadoMapper tipoEspacioIluminadoMapper;

    @PostMapping(value = "/saveTipoEspacioIluminado")
    public void saveTipoEspacioIluminado(
        @RequestBody
    TipoEspacioIluminadoDTO tipoEspacioIluminadoDTO) throws Exception {
        try {
            TipoEspacioIluminado tipoEspacioIluminado = tipoEspacioIluminadoMapper.tipoEspacioIluminadoDTOToTipoEspacioIluminado(tipoEspacioIluminadoDTO);

            tipoEspacioIluminadoService.saveTipoEspacioIluminado(tipoEspacioIluminado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoEspacioIluminado/{tipoEspacioIluminadoId}")
    public void deleteTipoEspacioIluminado(
        @PathVariable("tipoEspacioIluminadoId")
    Integer tipoEspacioIluminadoId) throws Exception {
        try {
            TipoEspacioIluminado tipoEspacioIluminado = tipoEspacioIluminadoService.getTipoEspacioIluminado(tipoEspacioIluminadoId);

            tipoEspacioIluminadoService.deleteTipoEspacioIluminado(tipoEspacioIluminado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoEspacioIluminado/")
    public void updateTipoEspacioIluminado(
        @RequestBody
    TipoEspacioIluminadoDTO tipoEspacioIluminadoDTO) throws Exception {
        try {
            TipoEspacioIluminado tipoEspacioIluminado = tipoEspacioIluminadoMapper.tipoEspacioIluminadoDTOToTipoEspacioIluminado(tipoEspacioIluminadoDTO);

            tipoEspacioIluminadoService.updateTipoEspacioIluminado(tipoEspacioIluminado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoEspacioIluminado")
    public List<TipoEspacioIluminadoDTO> getDataTipoEspacioIluminado()
        throws Exception {
        try {
            return tipoEspacioIluminadoService.getDataTipoEspacioIluminado();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoEspacioIluminado/{tipoEspacioIluminadoId}")
    public TipoEspacioIluminadoDTO getTipoEspacioIluminado(
        @PathVariable("tipoEspacioIluminadoId")
    Integer tipoEspacioIluminadoId) throws Exception {
        try {
            TipoEspacioIluminado tipoEspacioIluminado = tipoEspacioIluminadoService.getTipoEspacioIluminado(tipoEspacioIluminadoId);

            return tipoEspacioIluminadoMapper.tipoEspacioIluminadoToTipoEspacioIluminadoDTO(tipoEspacioIluminado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
