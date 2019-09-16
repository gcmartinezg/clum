package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoEspacioIluminadoDTO;
import co.edu.usbcali.clum.mapper.TipoEspacioIluminadoMapper;
import co.edu.usbcali.clum.service.TipoEspacioIluminadoService;
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
@RequestMapping("/tipoEspacioIluminado")
@CrossOrigin("*")
public class TipoEspacioIluminadoRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoEspacioIluminadoRestController.class);
    @Autowired
    private TipoEspacioIluminadoService tipoEspacioIluminadoService;
    @Autowired
    private TipoEspacioIluminadoMapper tipoEspacioIluminadoMapper;
    
    private static final int ESTADO_ACTIVADO = 1;
    private static final int ESTADO_DESACTIVADO = 2;

    @PostMapping(value = "/saveTipoEspacioIluminado")
    public ResponseEntity<Respuesta> saveTipoEspacioIluminado(@RequestBody TipoEspacioIluminadoDTO tipoEspacioIluminadoDTO) throws Exception {
        try {
            TipoEspacioIluminado tipoEspacioIluminado = tipoEspacioIluminadoMapper.tipoEspacioIluminadoDTOToTipoEspacioIluminado(tipoEspacioIluminadoDTO);

            tipoEspacioIluminadoService.saveTipoEspacioIluminado(tipoEspacioIluminado);
            return ResponseEntity.ok().body(new Respuesta("El tipo de espacio iluminado con id "+tipoEspacioIluminado.getTipoEspacioIluminadoId()+" se ha creado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @DeleteMapping(value = "/deleteTipoEspacioIluminado/{tipoEspacioIluminadoId}")
    public ResponseEntity<Respuesta> deleteTipoEspacioIluminado(@PathVariable("tipoEspacioIluminadoId") Integer tipoEspacioIluminadoId) throws Exception {
        try {
            TipoEspacioIluminado tipoEspacioIluminado = tipoEspacioIluminadoService.getTipoEspacioIluminado(tipoEspacioIluminadoId);

            tipoEspacioIluminadoService.deleteTipoEspacioIluminado(tipoEspacioIluminado);
            return ResponseEntity.ok().body(new Respuesta("El tipo de espacio iluminado con id "+tipoEspacioIluminado.getTipoEspacioIluminadoId()+" se ha borrado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @PutMapping(value = "/updateTipoEspacioIluminado/")
    public ResponseEntity<Respuesta> updateTipoEspacioIluminado(@RequestBody TipoEspacioIluminadoDTO tipoEspacioIluminadoDTO) throws Exception {
        try {
            TipoEspacioIluminado tipoEspacioIluminado = tipoEspacioIluminadoMapper.tipoEspacioIluminadoDTOToTipoEspacioIluminado(tipoEspacioIluminadoDTO);

            tipoEspacioIluminadoService.updateTipoEspacioIluminado(tipoEspacioIluminado);
            return ResponseEntity.ok().body(new Respuesta("El tipo de espacio iluminado con id "+tipoEspacioIluminado.getTipoEspacioIluminadoId()+" se ha modificado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @GetMapping(value = "/getDataTipoEspacioIluminado")
    public List<TipoEspacioIluminadoDTO> getDataTipoEspacioIluminado()
        throws Exception {
        try {
            return tipoEspacioIluminadoService.getDataTipoEspacioIluminado();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoEspacioIluminado/{tipoEspacioIluminadoId}")
    public TipoEspacioIluminadoDTO getTipoEspacioIluminado(
        @PathVariable("tipoEspacioIluminadoId")
    Integer tipoEspacioIluminadoId) throws Exception {
        try {
            TipoEspacioIluminado tipoEspacioIluminado = tipoEspacioIluminadoService.getTipoEspacioIluminado(tipoEspacioIluminadoId);

            return tipoEspacioIluminadoMapper.tipoEspacioIluminadoToTipoEspacioIluminadoDTO(tipoEspacioIluminado);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @PutMapping("/deactivate")
	public ResponseEntity<Respuesta> deactivate(@RequestBody TipoEspacioIluminadoDTO tipoEspacioIluminadoDTO)	throws Exception{
		try {
			if(tipoEspacioIluminadoDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta("El tipo de espacio iluminado es nulo"));
			}
			
			log.info("intentando desactivar tipo de espacio iluminado: " + 	tipoEspacioIluminadoDTO.toString());
			
			TipoEspacioIluminado toBeFound = tipoEspacioIluminadoService.getTipoEspacioIluminado(tipoEspacioIluminadoDTO.getTipoEspacioIluminadoId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new Respuesta("El tipo espacio iluminado con id "+tipoEspacioIluminadoDTO.getTipoEspacioIluminadoId()+" no exite"));
			}
			
			tipoEspacioIluminadoDTO.setIdEstado_Estado(ESTADO_DESACTIVADO);
			
			TipoEspacioIluminado tipoEspacioIluminado = tipoEspacioIluminadoMapper.tipoEspacioIluminadoDTOToTipoEspacioIluminado(tipoEspacioIluminadoDTO);
			tipoEspacioIluminadoService.updateTipoEspacioIluminado(tipoEspacioIluminado);
		
			return ResponseEntity.ok().body(new Respuesta("El tipo de documento con id "+tipoEspacioIluminado.getTipoEspacioIluminadoId()+" ha sido desactivado exitosamente"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
	
	@PutMapping("/activate")
	public ResponseEntity<Respuesta> activate(@RequestBody TipoEspacioIluminadoDTO tipoEspacioIluminadoDTO)throws Exception{
		try {
			if(tipoEspacioIluminadoDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta("El tipo de espacio iluminado es nulo"));
			}
			
			log.info("intentando activar tipo de documento: " + tipoEspacioIluminadoDTO.toString());
			
			TipoEspacioIluminado toBeFound = tipoEspacioIluminadoService.getTipoEspacioIluminado(tipoEspacioIluminadoDTO.getTipoEspacioIluminadoId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new Respuesta("El tipo espacio iluminado con id "+tipoEspacioIluminadoDTO.getTipoEspacioIluminadoId()+" no exite"));
			}
			
			tipoEspacioIluminadoDTO.setIdEstado_Estado(ESTADO_ACTIVADO);
			
			TipoEspacioIluminado tipoEspacioIluminado = tipoEspacioIluminadoMapper.tipoEspacioIluminadoDTOToTipoEspacioIluminado(tipoEspacioIluminadoDTO);

			tipoEspacioIluminadoService.updateTipoEspacioIluminado(tipoEspacioIluminado);
			
			return ResponseEntity.ok().body(new Respuesta("El tipo de documento con id "+tipoEspacioIluminado.getTipoEspacioIluminadoId()+" ha sido activado exitosamente"));

			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}

}
