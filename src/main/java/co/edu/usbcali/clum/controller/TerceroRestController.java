package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TerceroDTO;
import co.edu.usbcali.clum.dto.UsuarioDTO;
import co.edu.usbcali.clum.mapper.TerceroMapper;
import co.edu.usbcali.clum.mapper.UsuarioMapper;
import co.edu.usbcali.clum.service.TerceroService;
import co.edu.usbcali.clum.service.UsuarioService;
import co.edu.usbcali.clum.utility.Respuesta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tercero")
@CrossOrigin("*")
public class TerceroRestController {
    private static final Logger log = LoggerFactory.getLogger(TerceroRestController.class);
    @Autowired
    private TerceroService terceroService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TerceroMapper terceroMapper;
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    private static final int ESTADO_ACTIVADO = 1;
    private static final int ESTADO_DESACTIVADO = 2;

    @PostMapping(value = "/saveTercero")
    public ResponseEntity<Respuesta> saveTercero(@RequestBody
    TerceroDTO terceroDTO) throws Exception {
        try {
            Tercero tercero = terceroMapper.terceroDTOToTercero(terceroDTO);

            terceroService.saveTercero(tercero);
            return ResponseEntity.ok().body(new Respuesta("El tercero con" + 
					" id " + tercero.getTerceroId() + " ha sido guardado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @DeleteMapping(value = "/deleteTercero/{terceroId}")
    @Deprecated
    public void deleteTercero(@PathVariable("terceroId")
    Integer terceroId) throws Exception {
        try {
            Tercero tercero = terceroService.getTercero(terceroId);

            terceroService.deleteTercero(tercero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTercero/")
    public ResponseEntity<Respuesta> updateTercero(@RequestBody
    TerceroDTO terceroDTO) throws Exception {
        try {
            Tercero tercero = terceroMapper.terceroDTOToTercero(terceroDTO);

            terceroService.updateTercero(tercero);
            return ResponseEntity.ok().body(new Respuesta(
					"El tercero con id "
					+ tercero.getTerceroId()
					+ " ha sido modificado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @GetMapping(value = "/getDataTercero")
    public List<TerceroDTO> getDataTercero() throws Exception {
        try {
            return terceroService.getDataTercero();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTercero/{terceroId}")
    public TerceroDTO getTercero(@PathVariable("terceroId")
    Integer terceroId) throws Exception {
        try {
            Tercero tercero = terceroService.getTercero(terceroId);

            return terceroMapper.terceroToTerceroDTO(tercero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @PutMapping("/deactivate")
	public ResponseEntity<Respuesta> 
		deactivate(@RequestBody TerceroDTO terceroDTO)
				throws Exception{
		try {
			if(terceroDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tercero es nulo"));
			}
			
			log.info("intentando desactivar tercero: " + 
					terceroDTO.toString());
			
			Tercero toBeFound = terceroService
					.getTercero(terceroDTO.getTerceroId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tercero con id "
						+ terceroDTO.getTerceroId()
						+ " no existe"));
			}
			
			terceroDTO.setIdEstado_Estado(ESTADO_DESACTIVADO);
			
			Tercero tercero = terceroMapper
					.terceroDTOToTercero(terceroDTO);
			terceroService.updateTercero(tercero);
			
			return ResponseEntity.ok().body(new Respuesta(
					"El tercero con id "
					+ tercero.getTerceroId()
					+ " ha sido desactivado exitosamente"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
		
	}
	
	@PutMapping("/activate")
	public ResponseEntity<Respuesta> 
		activate(@RequestBody TerceroDTO terceroDTO)
				throws Exception{
		try {
			if(terceroDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tercero es nulo"));
			}
			
			log.info("intentando activar tercero: " + 
					terceroDTO.toString());
			
			Tercero toBeFound = terceroService
					.getTercero(terceroDTO.getTerceroId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El tercero con id "
						+ terceroDTO.getTerceroId()
						+ " no existe"));
			}
			
			terceroDTO.setIdEstado_Estado(ESTADO_ACTIVADO);
			
			Tercero tercero = terceroMapper
					.terceroDTOToTercero(terceroDTO);
			terceroService.updateTercero(tercero);
			
			return ResponseEntity.ok().body(new Respuesta(
					"El tercero con id "
					+ tercero.getTerceroId()
					+ " ha sido activado exitosamente"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
		
	}
	
	@GetMapping(value = "/getUsuarioFromTerceroId/{terceroId}")
    public UsuarioDTO getUsuarioFromTerceroId(
    		@PathVariable("terceroId") Integer terceroId) throws Exception {
        try {
        	ArrayList<UsuarioDTO> usuarios = new ArrayList<>(usuarioService.getDataUsuario());
        	Usuario usuario = null;
        	usuarios.removeIf(u->{return !u.getTerceroId_Tercero().equals(terceroId);});
        	usuario = usuarioService.getUsuario(usuarios.get(0).getUsuarioId());
        	usuarios = null;
        	return usuarioMapper.usuarioToUsuarioDTO(usuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        
	}
}
