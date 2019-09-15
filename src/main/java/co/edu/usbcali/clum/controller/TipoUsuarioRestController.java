package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoTransformadorDTO;
import co.edu.usbcali.clum.dto.TipoUsuarioDTO;
import co.edu.usbcali.clum.mapper.TipoUsuarioMapper;
import co.edu.usbcali.clum.service.TipoUsuarioService;

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
@RequestMapping("/tipoUsuario")
@CrossOrigin("*")
public class TipoUsuarioRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoUsuarioRestController.class);
    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    @Autowired
    private TipoUsuarioMapper tipoUsuarioMapper;
    
    private static final int ESTADO_ACTIVADO = 1;
    private static final int ESTADO_DESACTIVADO = 2;

    @PostMapping(value = "/saveTipoUsuario")
    public void saveTipoUsuario(@RequestBody
    TipoUsuarioDTO tipoUsuarioDTO) throws Exception {
        try {
            TipoUsuario tipoUsuario = tipoUsuarioMapper.tipoUsuarioDTOToTipoUsuario(tipoUsuarioDTO);

            tipoUsuarioService.saveTipoUsuario(tipoUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoUsuario/{tipoUsuarioId}")
    public void deleteTipoUsuario(
        @PathVariable("tipoUsuarioId")
    Integer tipoUsuarioId) throws Exception {
        try {
            TipoUsuario tipoUsuario = tipoUsuarioService.getTipoUsuario(tipoUsuarioId);

            tipoUsuarioService.deleteTipoUsuario(tipoUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoUsuario/")
    public void updateTipoUsuario(@RequestBody
    TipoUsuarioDTO tipoUsuarioDTO) throws Exception {
        try {
            TipoUsuario tipoUsuario = tipoUsuarioMapper.tipoUsuarioDTOToTipoUsuario(tipoUsuarioDTO);

            tipoUsuarioService.updateTipoUsuario(tipoUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoUsuario")
    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception {
        try {
            return tipoUsuarioService.getDataTipoUsuario();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoUsuario/{tipoUsuarioId}")
    public TipoUsuarioDTO getTipoUsuario(
        @PathVariable("tipoUsuarioId")
    Integer tipoUsuarioId) throws Exception {
        try {
            TipoUsuario tipoUsuario = tipoUsuarioService.getTipoUsuario(tipoUsuarioId);

            return tipoUsuarioMapper.tipoUsuarioToTipoUsuarioDTO(tipoUsuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @PutMapping("/deactivate")
	public ResponseEntity<co.edu.usbcali.clum.utility.Respuesta> 
		deactivate(@RequestBody TipoUsuarioDTO tipoUsuarioDTO)
				throws Exception{
		try {
			if(tipoUsuarioDTO == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo usuario es nulo"));
			}
			
			log.info("intentando desactivar tipo usuario: " + 
					tipoUsuarioDTO.toString());
			
			TipoUsuario toBeFound = tipoUsuarioService
					.getTipoUsuario(tipoUsuarioDTO.getTipoUsuarioId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo usuario con id "
						+ tipoUsuarioDTO.getTipoUsuarioId()
						+ " no existe"));
			}
			
			tipoUsuarioDTO.setIdEstado_Estado(ESTADO_DESACTIVADO);
			
			TipoUsuario tipoUsuario = tipoUsuarioMapper
					.tipoUsuarioDTOToTipoUsuario(tipoUsuarioDTO);
			tipoUsuarioService.updateTipoUsuario(tipoUsuario);
			
			return ResponseEntity.ok().body(new co.edu.usbcali.clum.utility.Respuesta(
					"El tipo usuario con id "
					+ tipoUsuario.getTipoUsuarioId()
					+ " ha sido exitosamente desactivado"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
	
	@PutMapping("/activate")
	public ResponseEntity<co.edu.usbcali.clum.utility.Respuesta> 
		activate(@RequestBody TipoUsuarioDTO tipoUsuarioDTO)
				throws Exception{
		try {
			if(tipoUsuarioDTO == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo usuario es nulo"));
			}
			
			log.info("intentando activar tipo usuario: " + 
					tipoUsuarioDTO.toString());
			
			TipoUsuario toBeFound = tipoUsuarioService
					.getTipoUsuario(tipoUsuarioDTO.getTipoUsuarioId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo usuario con id "
						+ tipoUsuarioDTO.getTipoUsuarioId()
						+ " no existe"));
			}
			
			tipoUsuarioDTO.setIdEstado_Estado(ESTADO_ACTIVADO);
			
			TipoUsuario tipoUsuario = tipoUsuarioMapper
					.tipoUsuarioDTOToTipoUsuario(tipoUsuarioDTO);
			tipoUsuarioService.updateTipoUsuario(tipoUsuario);
			
			return ResponseEntity.ok().body(new co.edu.usbcali.clum.utility.Respuesta(
					"El tipo usuario con id "
					+ tipoUsuario.getTipoUsuarioId()
					+ " ha sido exitosamente activado"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
}
