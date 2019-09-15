package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoBalastoDTO;
import co.edu.usbcali.clum.mapper.TipoBalastoMapper;
import co.edu.usbcali.clum.service.TipoBalastoService;
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
@RequestMapping("/tipoBalasto")
@CrossOrigin("*")
public class TipoBalastoRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoBalastoRestController.class);
    @Autowired
    private TipoBalastoService tipoBalastoService;
    @Autowired
    private TipoBalastoMapper tipoBalastoMapper;
    
    private static final int ESTADO_ACTIVADO = 1;
    private static final int ESTADO_DESACTIVADO = 2;

    @PostMapping(value = "/saveTipoBalasto")
    public void saveTipoBalasto(@RequestBody
    TipoBalastoDTO tipoBalastoDTO) throws Exception {
        try {
            TipoBalasto tipoBalasto = tipoBalastoMapper.tipoBalastoDTOToTipoBalasto(tipoBalastoDTO);

            tipoBalastoService.saveTipoBalasto(tipoBalasto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoBalasto/{tipoBalastoId}")
    public void deleteTipoBalasto(
        @PathVariable("tipoBalastoId")
    Integer tipoBalastoId) throws Exception {
        try {
            TipoBalasto tipoBalasto = tipoBalastoService.getTipoBalasto(tipoBalastoId);

            tipoBalastoService.deleteTipoBalasto(tipoBalasto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoBalasto/")
    public void updateTipoBalasto(@RequestBody
    TipoBalastoDTO tipoBalastoDTO) throws Exception {
        try {
            TipoBalasto tipoBalasto = tipoBalastoMapper.tipoBalastoDTOToTipoBalasto(tipoBalastoDTO);

            tipoBalastoService.updateTipoBalasto(tipoBalasto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoBalasto")
    public List<TipoBalastoDTO> getDataTipoBalasto() throws Exception {
        try {
            return tipoBalastoService.getDataTipoBalasto();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoBalasto/{tipoBalastoId}")
    public TipoBalastoDTO getTipoBalasto(
        @PathVariable("tipoBalastoId")
    Integer tipoBalastoId) throws Exception {
        try {
            TipoBalasto tipoBalasto = tipoBalastoService.getTipoBalasto(tipoBalastoId);

            return tipoBalastoMapper.tipoBalastoToTipoBalastoDTO(tipoBalasto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @PutMapping("/deactivate")
	public ResponseEntity<Respuesta> 
		deactivate(@RequestBody TipoBalastoDTO tipoBalastoDTO)
				throws Exception{
		try {
			if(tipoBalastoDTO == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de material es nulo"));
			}
			
			log.info("intentando desactivar tipo de material: " + 
					tipoBalastoDTO.toString());
			
			TipoBalasto toBeFound = tipoBalastoService.getTipoBalasto(tipoBalastoDTO.getTipoBalastoId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"The material type with id "
						+ tipoBalastoDTO.getTipoBalastoId()
						+ " does not exist"));
			}
			
			tipoBalastoDTO.setIdEstado_Estado(ESTADO_DESACTIVADO);
			
			TipoBalasto tipoBalasto = tipoBalastoMapper.tipoBalastoDTOToTipoBalasto(tipoBalastoDTO);
			tipoBalastoService.updateTipoBalasto(tipoBalasto);
			
			return ResponseEntity.ok().body(new co.edu.usbcali.clum.utility.Respuesta("The document type with id "+ tipoBalasto.getTipoBalastoId()
					+ " has been successfully deactivated"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
	
	@PutMapping("/activate")
	public ResponseEntity<Respuesta> activate(@RequestBody TipoBalastoDTO tipoBalastoDTO)
				throws Exception{
		try {
			if(tipoBalastoDTO == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de material es nulo"));
			}
			
			log.info("intentando activar tipo de material: " + 
					tipoBalastoDTO.toString());
			
			TipoBalasto toBeFound = tipoBalastoService
					.getTipoBalasto(tipoBalastoDTO.getTipoBalastoId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"The material type with id "
						+ tipoBalastoDTO.getTipoBalastoId()
						+ " does not exist"));
			}
			
			tipoBalastoDTO.setIdEstado_Estado(ESTADO_ACTIVADO);
			
			TipoBalasto tipoBalasto = tipoBalastoMapper
					.tipoBalastoDTOToTipoBalasto(tipoBalastoDTO);
			tipoBalastoService.updateTipoBalasto(tipoBalasto);
			
			return ResponseEntity.ok().body(new co.edu.usbcali.clum.utility.Respuesta(
					"The document type with id "
					+ tipoBalasto.getTipoBalastoId()
					+ " has been successfully activated"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
}
