package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoMaterialDTO;
import co.edu.usbcali.clum.dto.TipoSoporteDTO;
import co.edu.usbcali.clum.mapper.TipoSoporteMapper;
import co.edu.usbcali.clum.service.TipoSoporteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/tipoSoporte")
@CrossOrigin("*")
public class TipoSoporteRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoSoporteRestController.class);
    @Autowired
    private TipoSoporteService tipoSoporteService;
    @Autowired
    private TipoSoporteMapper tipoSoporteMapper;
    
    private static final int ESTADO_ACTIVADO = 1;
    private static final int ESTADO_DESACTIVADO = 2;

    @PostMapping(value = "/saveTipoSoporte")
    public void saveTipoSoporte(@RequestBody
    TipoSoporteDTO tipoSoporteDTO) throws Exception {
        try {
            TipoSoporte tipoSoporte = tipoSoporteMapper.tipoSoporteDTOToTipoSoporte(tipoSoporteDTO);

            tipoSoporteService.saveTipoSoporte(tipoSoporte);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoSoporte/{tipoSoporteId}")
    public void deleteTipoSoporte(
        @PathVariable("tipoSoporteId")
    Integer tipoSoporteId) throws Exception {
        try {
            TipoSoporte tipoSoporte = tipoSoporteService.getTipoSoporte(tipoSoporteId);

            tipoSoporteService.deleteTipoSoporte(tipoSoporte);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoSoporte/")
    public void updateTipoSoporte(@RequestBody
    TipoSoporteDTO tipoSoporteDTO) throws Exception {
        try {
            TipoSoporte tipoSoporte = tipoSoporteMapper.tipoSoporteDTOToTipoSoporte(tipoSoporteDTO);

            tipoSoporteService.updateTipoSoporte(tipoSoporte);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoSoporte")
    public List<TipoSoporteDTO> getDataTipoSoporte() throws Exception {
        try {
            return tipoSoporteService.getDataTipoSoporte();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoSoporte/{tipoSoporteId}")
    public TipoSoporteDTO getTipoSoporte(
        @PathVariable("tipoSoporteId")
    Integer tipoSoporteId) throws Exception {
        try {
            TipoSoporte tipoSoporte = tipoSoporteService.getTipoSoporte(tipoSoporteId);

            return tipoSoporteMapper.tipoSoporteToTipoSoporteDTO(tipoSoporte);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @PutMapping("/deactivate")
	public ResponseEntity<co.edu.usbcali.clum.utility.Respuesta> 
		deactivate(@RequestBody TipoSoporteDTO tipoSoporteDTO)
				throws Exception{
		try {
			if(tipoSoporteDTO == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de soporte es nulo"));
			}
			
			log.info("intentando desactivar tipo de soporte: " + 
					tipoSoporteDTO.toString());
			
			TipoSoporte toBeFound = tipoSoporteService
					.getTipoSoporte(tipoSoporteDTO.getTipoSoporteId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo soporte con id "
						+ tipoSoporteDTO.getTipoSoporteId()
						+ " no existe"));
			}
			
			tipoSoporteDTO.setIdEstado_Estado(ESTADO_DESACTIVADO);
			
			TipoSoporte tipoSoporte = tipoSoporteMapper
					.tipoSoporteDTOToTipoSoporte(tipoSoporteDTO);
			tipoSoporteService.updateTipoSoporte(tipoSoporte);
			
			return ResponseEntity.ok().body(new co.edu.usbcali.clum.utility.Respuesta(
					"El tipo de soporte con id "
					+ tipoSoporte.getTipoSoporteId()
					+ " ha sido exitosamente desactivado"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
	
	@PutMapping("/activate")
	public ResponseEntity<co.edu.usbcali.clum.utility.Respuesta> 
		activate(@RequestBody TipoSoporteDTO tipoSoporteDTO)
				throws Exception{
		try {
			if(tipoSoporteDTO == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de soporte es nulo"));
			}
			
			log.info("intentando activar tipo de soporte: " + 
					tipoSoporteDTO.toString());
			
			TipoSoporte toBeFound = tipoSoporteService
					.getTipoSoporte(tipoSoporteDTO.getTipoSoporteId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo soporte con id "
						+ tipoSoporteDTO.getTipoSoporteId()
						+ " no existe"));
			}
			
			tipoSoporteDTO.setIdEstado_Estado(ESTADO_ACTIVADO);
			
			TipoSoporte tipoSoporte = tipoSoporteMapper
					.tipoSoporteDTOToTipoSoporte(tipoSoporteDTO);
			tipoSoporteService.updateTipoSoporte(tipoSoporte);
			
			return ResponseEntity.ok().body(new co.edu.usbcali.clum.utility.Respuesta(
					"El tipo de soporte con id "
					+ tipoSoporte.getTipoSoporteId()
					+ " ha sido exitosamente activado"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
}
