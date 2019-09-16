package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoInstalacionDTO;
import co.edu.usbcali.clum.mapper.TipoInstalacionMapper;
import co.edu.usbcali.clum.service.TipoInstalacionService;
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
@RequestMapping("/tipoInstalacion")
@CrossOrigin("*")
public class TipoInstalacionRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoInstalacionRestController.class);
    @Autowired
    private TipoInstalacionService tipoInstalacionService;
    @Autowired
    private TipoInstalacionMapper tipoInstalacionMapper;
    
    private static final int ESTADO_ACTIVADO = 1;
    private static final int ESTADO_DESACTIVADO = 2;

    @PostMapping(value = "/saveTipoInstalacion")
    public ResponseEntity<Respuesta> saveTipoInstalacion(@RequestBody TipoInstalacionDTO tipoInstalacionDTO) throws Exception {
        try {
            TipoInstalacion tipoInstalacion = tipoInstalacionMapper.tipoInstalacionDTOToTipoInstalacion(tipoInstalacionDTO);

            tipoInstalacionService.saveTipoInstalacion(tipoInstalacion);
            return ResponseEntity.ok().body(new Respuesta("El tipo de instalacion con id "+tipoInstalacion.getTipoInstalacionId()+" se ha guardado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @DeleteMapping(value = "/deleteTipoInstalacion/{tipoInstalacionId}")
    public ResponseEntity<Respuesta>  deleteTipoInstalacion(@PathVariable("tipoInstalacionId") Integer tipoInstalacionId) throws Exception {
        try {
            TipoInstalacion tipoInstalacion = tipoInstalacionService.getTipoInstalacion(tipoInstalacionId);

            tipoInstalacionService.deleteTipoInstalacion(tipoInstalacion);
            return ResponseEntity.ok().body(new Respuesta("El tipo de instalacion con id "+tipoInstalacion.getTipoInstalacionId()+" se ha eliminado con exito"));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @PutMapping(value = "/updateTipoInstalacion/")
    public ResponseEntity<Respuesta> updateTipoInstalacion(
        @RequestBody
    TipoInstalacionDTO tipoInstalacionDTO) throws Exception {
        try {
            TipoInstalacion tipoInstalacion = tipoInstalacionMapper.tipoInstalacionDTOToTipoInstalacion(tipoInstalacionDTO);

            tipoInstalacionService.updateTipoInstalacion(tipoInstalacion);
            return ResponseEntity.ok().body(new Respuesta("El tipo de instalacion con id "+tipoInstalacion.getTipoInstalacionId()+" se ha modificado con exito"));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @GetMapping(value = "/getDataTipoInstalacion")
    public List<TipoInstalacionDTO> getDataTipoInstalacion()
        throws Exception {
        try {
            return tipoInstalacionService.getDataTipoInstalacion();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoInstalacion/{tipoInstalacionId}")
    public TipoInstalacionDTO getTipoInstalacion(
        @PathVariable("tipoInstalacionId")
    Integer tipoInstalacionId) throws Exception {
        try {
            TipoInstalacion tipoInstalacion = tipoInstalacionService.getTipoInstalacion(tipoInstalacionId);

            return tipoInstalacionMapper.tipoInstalacionToTipoInstalacionDTO(tipoInstalacion);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @PutMapping("/deactivate")
	public ResponseEntity<Respuesta> deactivate(@RequestBody TipoInstalacionDTO tipoInstalacionDTO)	throws Exception{
		try {
			if(tipoInstalacionDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta("El tipo de instalacion es nulo"));
			}
			
			log.info("intentando desactivar tipo de documento: " + 	tipoInstalacionDTO.toString());
			
			TipoInstalacion toBeFound = tipoInstalacionService.getTipoInstalacion(tipoInstalacionDTO.getTipoInstalacionId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tipo de instalacion con id "
						+ tipoInstalacionDTO.getTipoInstalacionId()
						+ " no existe"));
			}
			
			tipoInstalacionDTO.setIdEstado_Estado(ESTADO_DESACTIVADO);
			
			TipoInstalacion tipoInstalacion = tipoInstalacionMapper.tipoInstalacionDTOToTipoInstalacion(tipoInstalacionDTO);
			tipoInstalacionService.updateTipoInstalacion(tipoInstalacion);
			
			return ResponseEntity.ok().body(new Respuesta(
					"El tipo de instalacion con id "
					+ tipoInstalacion.getTipoInstalacionId()
					+ " ha sido desactivado exitosamente"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
	
	@PutMapping("/activate")
	public ResponseEntity<Respuesta> activate(@RequestBody TipoInstalacionDTO tipoInstalacionDTO)throws Exception{
		try {
			if(tipoInstalacionDTO == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de instalacion es nulo"));
			}
			
			log.info("intentando activar tipo de documento: " + tipoInstalacionDTO.toString());
			
			TipoInstalacion toBeFound = tipoInstalacionService.getTipoInstalacion(tipoInstalacionDTO.getTipoInstalacionId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de instalacion con id "
						+ tipoInstalacionDTO.getTipoInstalacionId()
						+ " no existe"));
			}
			
			tipoInstalacionDTO.setIdEstado_Estado(ESTADO_ACTIVADO);
			
			TipoInstalacion tipoInstalacion = tipoInstalacionMapper.tipoInstalacionDTOToTipoInstalacion(tipoInstalacionDTO);
			tipoInstalacionService.updateTipoInstalacion(tipoInstalacion);
			
			return ResponseEntity.ok().body(new co.edu.usbcali.clum.utility.Respuesta(
					"El tipo de instalacion con id "
					+ tipoInstalacion.getTipoInstalacionId()
					+ " ha sido activado exitosamente"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
}
