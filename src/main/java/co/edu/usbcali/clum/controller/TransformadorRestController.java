package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TransformadorDTO;
import co.edu.usbcali.clum.mapper.TransformadorMapper;
import co.edu.usbcali.clum.service.TransformadorService;

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
@RequestMapping("/transformador")
public class TransformadorRestController {
    private static final Logger log = LoggerFactory.getLogger(TransformadorRestController.class);
    @Autowired
    private TransformadorService transformadorService;
    @Autowired
    private TransformadorMapper transformadorMapper;

    @PostMapping(value = "/saveTransformador")
    public void saveTransformador(@RequestBody
    TransformadorDTO transformadorDTO) throws Exception {
        try {
            Transformador transformador = transformadorMapper.transformadorDTOToTransformador(transformadorDTO);

            transformadorService.saveTransformador(transformador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTransformador/{transformadorId}")
    public void deleteTransformador(
        @PathVariable("transformadorId")
    Integer transformadorId) throws Exception {
        try {
            Transformador transformador = transformadorService.getTransformador(transformadorId);

            transformadorService.deleteTransformador(transformador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTransformador/")
    public void updateTransformador(
        @RequestBody
    TransformadorDTO transformadorDTO) throws Exception {
        try {
            Transformador transformador = transformadorMapper.transformadorDTOToTransformador(transformadorDTO);

            transformadorService.updateTransformador(transformador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTransformador")
    public List<TransformadorDTO> getDataTransformador()
        throws Exception {
        try {
            return transformadorService.getDataTransformador();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTransformador/{transformadorId}")
    public TransformadorDTO getTransformador(
        @PathVariable("transformadorId")
    Integer transformadorId) throws Exception {
        try {
            Transformador transformador = transformadorService.getTransformador(transformadorId);

            return transformadorMapper.transformadorToTransformadorDTO(transformador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
