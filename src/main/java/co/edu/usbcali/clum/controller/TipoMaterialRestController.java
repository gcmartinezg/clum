package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoMaterialDTO;
import co.edu.usbcali.clum.mapper.TipoMaterialMapper;
import co.edu.usbcali.clum.service.TipoMaterialService;

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
@RequestMapping("/tipoMaterial")
public class TipoMaterialRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoMaterialRestController.class);
    @Autowired
    private TipoMaterialService tipoMaterialService;
    @Autowired
    private TipoMaterialMapper tipoMaterialMapper;

    @PostMapping(value = "/saveTipoMaterial")
    public void saveTipoMaterial(@RequestBody
    TipoMaterialDTO tipoMaterialDTO) throws Exception {
        try {
            TipoMaterial tipoMaterial = tipoMaterialMapper.tipoMaterialDTOToTipoMaterial(tipoMaterialDTO);

            tipoMaterialService.saveTipoMaterial(tipoMaterial);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoMaterial/{tipoMaterialId}")
    public void deleteTipoMaterial(
        @PathVariable("tipoMaterialId")
    Integer tipoMaterialId) throws Exception {
        try {
            TipoMaterial tipoMaterial = tipoMaterialService.getTipoMaterial(tipoMaterialId);

            tipoMaterialService.deleteTipoMaterial(tipoMaterial);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoMaterial/")
    public void updateTipoMaterial(@RequestBody
    TipoMaterialDTO tipoMaterialDTO) throws Exception {
        try {
            TipoMaterial tipoMaterial = tipoMaterialMapper.tipoMaterialDTOToTipoMaterial(tipoMaterialDTO);

            tipoMaterialService.updateTipoMaterial(tipoMaterial);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoMaterial")
    public List<TipoMaterialDTO> getDataTipoMaterial()
        throws Exception {
        try {
            return tipoMaterialService.getDataTipoMaterial();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoMaterial/{tipoMaterialId}")
    public TipoMaterialDTO getTipoMaterial(
        @PathVariable("tipoMaterialId")
    Integer tipoMaterialId) throws Exception {
        try {
            TipoMaterial tipoMaterial = tipoMaterialService.getTipoMaterial(tipoMaterialId);

            return tipoMaterialMapper.tipoMaterialToTipoMaterialDTO(tipoMaterial);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
