package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoLamparaDTO;
import co.edu.usbcali.clum.mapper.TipoLamparaMapper;
import co.edu.usbcali.clum.service.TipoLamparaService;

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
@RequestMapping("/tipoLampara")
public class TipoLamparaRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoLamparaRestController.class);
    @Autowired
    private TipoLamparaService tipoLamparaService;
    @Autowired
    private TipoLamparaMapper tipoLamparaMapper;

    @PostMapping(value = "/saveTipoLampara")
    public void saveTipoLampara(@RequestBody
    TipoLamparaDTO tipoLamparaDTO) throws Exception {
        try {
            TipoLampara tipoLampara = tipoLamparaMapper.tipoLamparaDTOToTipoLampara(tipoLamparaDTO);

            tipoLamparaService.saveTipoLampara(tipoLampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoLampara/{tipoLamparaId}")
    public void deleteTipoLampara(
        @PathVariable("tipoLamparaId")
    Integer tipoLamparaId) throws Exception {
        try {
            TipoLampara tipoLampara = tipoLamparaService.getTipoLampara(tipoLamparaId);

            tipoLamparaService.deleteTipoLampara(tipoLampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoLampara/")
    public void updateTipoLampara(@RequestBody
    TipoLamparaDTO tipoLamparaDTO) throws Exception {
        try {
            TipoLampara tipoLampara = tipoLamparaMapper.tipoLamparaDTOToTipoLampara(tipoLamparaDTO);

            tipoLamparaService.updateTipoLampara(tipoLampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoLampara")
    public List<TipoLamparaDTO> getDataTipoLampara() throws Exception {
        try {
            return tipoLamparaService.getDataTipoLampara();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoLampara/{tipoLamparaId}")
    public TipoLamparaDTO getTipoLampara(
        @PathVariable("tipoLamparaId")
    Integer tipoLamparaId) throws Exception {
        try {
            TipoLampara tipoLampara = tipoLamparaService.getTipoLampara(tipoLamparaId);

            return tipoLamparaMapper.tipoLamparaToTipoLamparaDTO(tipoLampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
