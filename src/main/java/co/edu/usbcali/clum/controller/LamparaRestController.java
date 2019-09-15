package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.LamparaDTO;
import co.edu.usbcali.clum.mapper.LamparaMapper;
import co.edu.usbcali.clum.service.LamparaService;

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
@RequestMapping("/lampara")
public class LamparaRestController {
    private static final Logger log = LoggerFactory.getLogger(LamparaRestController.class);
    @Autowired
    private LamparaService lamparaService;
    @Autowired
    private LamparaMapper lamparaMapper;

    @PostMapping(value = "/saveLampara")
    public void saveLampara(@RequestBody
    LamparaDTO lamparaDTO) throws Exception {
        try {
            Lampara lampara = lamparaMapper.lamparaDTOToLampara(lamparaDTO);

            lamparaService.saveLampara(lampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteLampara/{lamparaId}")
    public void deleteLampara(@PathVariable("lamparaId")
    Integer lamparaId) throws Exception {
        try {
            Lampara lampara = lamparaService.getLampara(lamparaId);

            lamparaService.deleteLampara(lampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateLampara/")
    public void updateLampara(@RequestBody
    LamparaDTO lamparaDTO) throws Exception {
        try {
            Lampara lampara = lamparaMapper.lamparaDTOToLampara(lamparaDTO);

            lamparaService.updateLampara(lampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataLampara")
    public List<LamparaDTO> getDataLampara() throws Exception {
        try {
            return lamparaService.getDataLampara();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getLampara/{lamparaId}")
    public LamparaDTO getLampara(@PathVariable("lamparaId")
    Integer lamparaId) throws Exception {
        try {
            Lampara lampara = lamparaService.getLampara(lamparaId);

            return lamparaMapper.lamparaToLamparaDTO(lampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
