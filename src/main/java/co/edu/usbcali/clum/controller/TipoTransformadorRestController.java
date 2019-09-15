package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoTransformadorDTO;
import co.edu.usbcali.clum.mapper.TipoTransformadorMapper;
import co.edu.usbcali.clum.service.TipoTransformadorService;
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
@RequestMapping("/tipoTransformador")
@CrossOrigin("*")
public class TipoTransformadorRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoTransformadorRestController.class);
    @Autowired
    private TipoTransformadorService tipoTransformadorService;
    @Autowired
    private TipoTransformadorMapper tipoTransformadorMapper;
    
    private static final int ESTADO_ACTIVADO = 1;
    private static final int ESTADO_DESACTIVADO = 2;

    @PostMapping(value = "/saveTipoTransformador")
    public ResponseEntity<Respuesta> saveTipoTransformador(
        @RequestBody
    TipoTransformadorDTO tipoTransformadorDTO) throws Exception {
        try {
            TipoTransformador tipoTransformador = tipoTransformadorMapper.tipoTransformadorDTOToTipoTransformador(tipoTransformadorDTO);

            tipoTransformadorService.saveTipoTransformador(tipoTransformador);
            return ResponseEntity.ok().body(new Respuesta("El tipo de transformador con" + 
					" id " + tipoTransformador.getTipoTransformadorId() + " ha sido guardado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @DeleteMapping(value = "/deleteTipoTransformador/{tipoTransformadorId}")
    @Deprecated
    public void deleteTipoTransformador(
        @PathVariable("tipoTransformadorId")
    Integer tipoTransformadorId) throws Exception {
        try {
            TipoTransformador tipoTransformador = tipoTransformadorService.getTipoTransformador(tipoTransformadorId);

            tipoTransformadorService.deleteTipoTransformador(tipoTransformador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoTransformador/")
    public ResponseEntity<Respuesta> updateTipoTransformador(
        @RequestBody
    TipoTransformadorDTO tipoTransformadorDTO) throws Exception {
        try {
            TipoTransformador tipoTransformador = tipoTransformadorMapper.tipoTransformadorDTOToTipoTransformador(tipoTransformadorDTO);

            tipoTransformadorService.updateTipoTransformador(tipoTransformador);
            return ResponseEntity.ok().body(new Respuesta(
					"El tipo de transformador con id "
					+ tipoTransformador.getTipoTransformadorId()
					+ " ha sido modificado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @GetMapping(value = "/getDataTipoTransformador")
    public List<TipoTransformadorDTO> getDataTipoTransformador()
        throws Exception {
        try {
            return tipoTransformadorService.getDataTipoTransformador();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoTransformador/{tipoTransformadorId}")
    public TipoTransformadorDTO getTipoTransformador(
        @PathVariable("tipoTransformadorId")
    Integer tipoTransformadorId) throws Exception {
        try {
            TipoTransformador tipoTransformador = tipoTransformadorService.getTipoTransformador(tipoTransformadorId);

            return tipoTransformadorMapper.tipoTransformadorToTipoTransformadorDTO(tipoTransformador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @PutMapping("/deactivate")
	public ResponseEntity<Respuesta> 
		deactivate(@RequestBody TipoTransformadorDTO tipoTransformadorDTO)
				throws Exception{
		try {
			if(tipoTransformadorDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tipo de transformador es nulo"));
			}
			
			log.info("intentando desactivar tipo de transformador: " + 
					tipoTransformadorDTO.toString());
			
			TipoTransformador toBeFound = tipoTransformadorService
					.getTipoTransformador(tipoTransformadorDTO.getTipoTransformadorId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tipo de transformador con id "
						+ tipoTransformadorDTO.getTipoTransformadorId()
						+ " no existe"));
			}
			
			tipoTransformadorDTO.setIdEstado_Estado(ESTADO_DESACTIVADO);
			
			TipoTransformador tipoTransformador = tipoTransformadorMapper
					.tipoTransformadorDTOToTipoTransformador(tipoTransformadorDTO);
			tipoTransformadorService.updateTipoTransformador(tipoTransformador);
			
			return ResponseEntity.ok().body(new Respuesta(
					"El tipo de transformador con id "
					+ tipoTransformador.getTipoTransformadorId()
					+ " ha sido exitosamente desactivado"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
		
	}
	
	@PutMapping("/activate")
	public ResponseEntity<Respuesta> 
		activate(@RequestBody TipoTransformadorDTO tipoTransformadorDTO)
				throws Exception{
		try {
			if(tipoTransformadorDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tipo de transformador es nulo"));
			}
			
			log.info("intentando activar tipo de transformador: " + 
					tipoTransformadorDTO.toString());
			
			TipoTransformador toBeFound = tipoTransformadorService
					.getTipoTransformador(tipoTransformadorDTO.getTipoTransformadorId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tipo de transformador con id "
						+ tipoTransformadorDTO.getTipoTransformadorId()
						+ " no existe"));
			}
			
			tipoTransformadorDTO.setIdEstado_Estado(ESTADO_ACTIVADO);
			
			TipoTransformador tipoTransformador = tipoTransformadorMapper
					.tipoTransformadorDTOToTipoTransformador(tipoTransformadorDTO);
			tipoTransformadorService.updateTipoTransformador(tipoTransformador);
			
			return ResponseEntity.ok().body(new Respuesta(
					"El tipo de transformador con id "
					+ tipoTransformador.getTipoTransformadorId()
					+ " ha sido exitosamente activado"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
		
	}
}
