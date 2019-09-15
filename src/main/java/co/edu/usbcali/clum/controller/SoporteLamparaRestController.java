package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.SoporteLamparaDTO;
import co.edu.usbcali.clum.mapper.SoporteLamparaMapper;
import co.edu.usbcali.clum.service.SoporteLamparaService;

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
@RequestMapping("/soporteLampara")
public class SoporteLamparaRestController {
    private static final Logger log = LoggerFactory.getLogger(SoporteLamparaRestController.class);
    @Autowired
    private SoporteLamparaService soporteLamparaService;
    @Autowired
    private SoporteLamparaMapper soporteLamparaMapper;

    @PostMapping(value = "/saveSoporteLampara")
    public void saveSoporteLampara(
        @RequestBody
    SoporteLamparaDTO soporteLamparaDTO) throws Exception {
        try {
            SoporteLampara soporteLampara = soporteLamparaMapper.soporteLamparaDTOToSoporteLampara(soporteLamparaDTO);

            soporteLamparaService.saveSoporteLampara(soporteLampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteSoporteLampara/{soporteLamparaId}")
    public void deleteSoporteLampara(
        @PathVariable("soporteLamparaId")
    Integer soporteLamparaId) throws Exception {
        try {
            SoporteLampara soporteLampara = soporteLamparaService.getSoporteLampara(soporteLamparaId);

            soporteLamparaService.deleteSoporteLampara(soporteLampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateSoporteLampara/")
    public void updateSoporteLampara(
        @RequestBody
    SoporteLamparaDTO soporteLamparaDTO) throws Exception {
        try {
            SoporteLampara soporteLampara = soporteLamparaMapper.soporteLamparaDTOToSoporteLampara(soporteLamparaDTO);

            soporteLamparaService.updateSoporteLampara(soporteLampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataSoporteLampara")
    public List<SoporteLamparaDTO> getDataSoporteLampara()
        throws Exception {
        try {
            return soporteLamparaService.getDataSoporteLampara();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getSoporteLampara/{soporteLamparaId}")
    public SoporteLamparaDTO getSoporteLampara(
        @PathVariable("soporteLamparaId")
    Integer soporteLamparaId) throws Exception {
        try {
            SoporteLampara soporteLampara = soporteLamparaService.getSoporteLampara(soporteLamparaId);

            return soporteLamparaMapper.soporteLamparaToSoporteLamparaDTO(soporteLampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
