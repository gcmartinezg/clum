package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoZonaDTO;
import co.edu.usbcali.clum.mapper.TipoZonaMapper;
import co.edu.usbcali.clum.service.TipoZonaService;
import co.edu.usbcali.clum.utility.Respuesta;

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
@RequestMapping("/tipoZona")
@CrossOrigin("*")
public class TipoZonaRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoZonaRestController.class);
    @Autowired
    private TipoZonaService tipoZonaService;
    @Autowired
    private TipoZonaMapper tipoZonaMapper;
    
    private static final int ESTADO_ACTIVADO = 1;
    private static final int ESTADO_DESACTIVADO = 2;

    @PostMapping(value = "/saveTipoZona")
    public ResponseEntity<Respuesta> saveTipoZona(@RequestBody
    TipoZonaDTO tipoZonaDTO) throws Exception {
        try {
            TipoZona tipoZona = tipoZonaMapper.tipoZonaDTOToTipoZona(tipoZonaDTO);

            tipoZonaService.saveTipoZona(tipoZona);
            return ResponseEntity.ok().body(new Respuesta("El tipo de zona con" + 
					" id " + tipoZona.getTipoZonaId() + " ha sido guardado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @DeleteMapping(value = "/deleteTipoZona/{tipoZonaId}")
    @Deprecated
    public void deleteTipoZona(@PathVariable("tipoZonaId")
    Integer tipoZonaId) throws Exception {
        try {
            TipoZona tipoZona = tipoZonaService.getTipoZona(tipoZonaId);

            tipoZonaService.deleteTipoZona(tipoZona);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoZona/")
    public ResponseEntity<Respuesta> updateTipoZona(@RequestBody
    TipoZonaDTO tipoZonaDTO) throws Exception {
        try {
            TipoZona tipoZona = tipoZonaMapper.tipoZonaDTOToTipoZona(tipoZonaDTO);

            tipoZonaService.updateTipoZona(tipoZona);
            return ResponseEntity.ok().body(new Respuesta(
					"El tipo de zona con id "
					+ tipoZona.getTipoZonaId()
					+ " ha sido modificado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @GetMapping(value = "/getDataTipoZona")
    public List<TipoZonaDTO> getDataTipoZona() throws Exception {
        try {
            return tipoZonaService.getDataTipoZona();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoZona/{tipoZonaId}")
    public TipoZonaDTO getTipoZona(
        @PathVariable("tipoZonaId")
    Integer tipoZonaId) throws Exception {
        try {
            TipoZona tipoZona = tipoZonaService.getTipoZona(tipoZonaId);

            return tipoZonaMapper.tipoZonaToTipoZonaDTO(tipoZona);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @PutMapping("/deactivate")
	public ResponseEntity<Respuesta> 
		deactivate(@RequestBody TipoZonaDTO tipoZonaDTO)
				throws Exception{
		try {
			if(tipoZonaDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tipo de zona es nulo"));
			}
			
			log.info("intentando desactivar tipo de zona: " + 
					tipoZonaDTO.toString());
			
			TipoZona toBeFound = tipoZonaService
					.getTipoZona(tipoZonaDTO.getTipoZonaId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tipo de zona con id "
						+ tipoZonaDTO.getTipoZonaId()
						+ " no existe"));
			}
			
			tipoZonaDTO.setIdEstado_Estado(ESTADO_DESACTIVADO);
			
			TipoZona tipoZona = tipoZonaMapper
					.tipoZonaDTOToTipoZona(tipoZonaDTO);
			tipoZonaService.updateTipoZona(tipoZona);
			
			return ResponseEntity.ok().body(new Respuesta(
					"El tipo de zona con id "
					+ tipoZona.getTipoZonaId()
					+ " ha sido exitosamente desactivado"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
		
	}
	
	@PutMapping("/activate")
	public ResponseEntity<Respuesta> 
		activate(@RequestBody TipoZonaDTO tipoZonaDTO)
				throws Exception{
		try {
			if(tipoZonaDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tipo de zona es nulo"));
			}
			
			log.info("intentando activar tipo de zona: " + 
					tipoZonaDTO.toString());
			
			TipoZona toBeFound = tipoZonaService
					.getTipoZona(tipoZonaDTO.getTipoZonaId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tipo de zona con id "
						+ tipoZonaDTO.getTipoZonaId()
						+ " no existe"));
			}
			
			tipoZonaDTO.setIdEstado_Estado(ESTADO_ACTIVADO);
			
			TipoZona tipoZona = tipoZonaMapper
					.tipoZonaDTOToTipoZona(tipoZonaDTO);
			tipoZonaService.updateTipoZona(tipoZona);
			
			return ResponseEntity.ok().body(new Respuesta(
					"El tipo de zona con id "
					+ tipoZona.getTipoZonaId()
					+ " ha sido exitosamente activado"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
		
	}
}
