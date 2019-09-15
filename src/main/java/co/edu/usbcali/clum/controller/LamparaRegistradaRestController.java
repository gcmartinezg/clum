package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.LamparaRegistradaDTO;
import co.edu.usbcali.clum.mapper.LamparaRegistradaMapper;
import co.edu.usbcali.clum.service.LamparaRegistradaService;

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
@RequestMapping("/lamparaRegistrada")
public class LamparaRegistradaRestController {
    private static final Logger log = LoggerFactory.getLogger(LamparaRegistradaRestController.class);
    @Autowired
    private LamparaRegistradaService lamparaRegistradaService;
    @Autowired
    private LamparaRegistradaMapper lamparaRegistradaMapper;

    @PostMapping(value = "/saveLamparaRegistrada")
    public void saveLamparaRegistrada(
        @RequestBody
    LamparaRegistradaDTO lamparaRegistradaDTO) throws Exception {
        try {
            LamparaRegistrada lamparaRegistrada = lamparaRegistradaMapper.lamparaRegistradaDTOToLamparaRegistrada(lamparaRegistradaDTO);

            lamparaRegistradaService.saveLamparaRegistrada(lamparaRegistrada);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteLamparaRegistrada/{lamparaRegistradaId}")
    public void deleteLamparaRegistrada(
        @PathVariable("lamparaRegistradaId")
    Integer lamparaRegistradaId) throws Exception {
        try {
            LamparaRegistrada lamparaRegistrada = lamparaRegistradaService.getLamparaRegistrada(lamparaRegistradaId);

            lamparaRegistradaService.deleteLamparaRegistrada(lamparaRegistrada);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateLamparaRegistrada/")
    public void updateLamparaRegistrada(
        @RequestBody
    LamparaRegistradaDTO lamparaRegistradaDTO) throws Exception {
        try {
            LamparaRegistrada lamparaRegistrada = lamparaRegistradaMapper.lamparaRegistradaDTOToLamparaRegistrada(lamparaRegistradaDTO);

            lamparaRegistradaService.updateLamparaRegistrada(lamparaRegistrada);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataLamparaRegistrada")
    public List<LamparaRegistradaDTO> getDataLamparaRegistrada()
        throws Exception {
        try {
            return lamparaRegistradaService.getDataLamparaRegistrada();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getLamparaRegistrada/{lamparaRegistradaId}")
    public LamparaRegistradaDTO getLamparaRegistrada(
        @PathVariable("lamparaRegistradaId")
    Integer lamparaRegistradaId) throws Exception {
        try {
            LamparaRegistrada lamparaRegistrada = lamparaRegistradaService.getLamparaRegistrada(lamparaRegistradaId);

            return lamparaRegistradaMapper.lamparaRegistradaToLamparaRegistradaDTO(lamparaRegistrada);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
