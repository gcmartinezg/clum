package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.RedAlimentacionDTO;
import co.edu.usbcali.clum.mapper.RedAlimentacionMapper;
import co.edu.usbcali.clum.service.RedAlimentacionService;

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
@RequestMapping("/redAlimentacion")
public class RedAlimentacionRestController {
    private static final Logger log = LoggerFactory.getLogger(RedAlimentacionRestController.class);
    @Autowired
    private RedAlimentacionService redAlimentacionService;
    @Autowired
    private RedAlimentacionMapper redAlimentacionMapper;

    @PostMapping(value = "/saveRedAlimentacion")
    public void saveRedAlimentacion(
        @RequestBody
    RedAlimentacionDTO redAlimentacionDTO) throws Exception {
        try {
            RedAlimentacion redAlimentacion = redAlimentacionMapper.redAlimentacionDTOToRedAlimentacion(redAlimentacionDTO);

            redAlimentacionService.saveRedAlimentacion(redAlimentacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteRedAlimentacion/{redAlimentacionId}")
    public void deleteRedAlimentacion(
        @PathVariable("redAlimentacionId")
    Integer redAlimentacionId) throws Exception {
        try {
            RedAlimentacion redAlimentacion = redAlimentacionService.getRedAlimentacion(redAlimentacionId);

            redAlimentacionService.deleteRedAlimentacion(redAlimentacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateRedAlimentacion/")
    public void updateRedAlimentacion(
        @RequestBody
    RedAlimentacionDTO redAlimentacionDTO) throws Exception {
        try {
            RedAlimentacion redAlimentacion = redAlimentacionMapper.redAlimentacionDTOToRedAlimentacion(redAlimentacionDTO);

            redAlimentacionService.updateRedAlimentacion(redAlimentacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataRedAlimentacion")
    public List<RedAlimentacionDTO> getDataRedAlimentacion()
        throws Exception {
        try {
            return redAlimentacionService.getDataRedAlimentacion();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getRedAlimentacion/{redAlimentacionId}")
    public RedAlimentacionDTO getRedAlimentacion(
        @PathVariable("redAlimentacionId")
    Integer redAlimentacionId) throws Exception {
        try {
            RedAlimentacion redAlimentacion = redAlimentacionService.getRedAlimentacion(redAlimentacionId);

            return redAlimentacionMapper.redAlimentacionToRedAlimentacionDTO(redAlimentacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
