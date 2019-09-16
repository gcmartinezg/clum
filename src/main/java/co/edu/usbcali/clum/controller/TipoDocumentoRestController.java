package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TerceroDTO;
import co.edu.usbcali.clum.dto.TipoDocumentoDTO;
import co.edu.usbcali.clum.mapper.TipoDocumentoMapper;
import co.edu.usbcali.clum.service.TipoDocumentoService;
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
@RequestMapping("/tipoDocumento")
@CrossOrigin("*")
public class TipoDocumentoRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoDocumentoRestController.class);
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    @Autowired
    private TipoDocumentoMapper tipoDocumentoMapper;
    
    private static final int ESTADO_ACTIVADO = 1;
    private static final int ESTADO_DESACTIVADO = 2;

    @PostMapping(value = "/saveTipoDocumento")
    public ResponseEntity<Respuesta> saveTipoDocumento(@RequestBody  TipoDocumentoDTO tipoDocumentoDTO) throws Exception {
        try {
            TipoDocumento tipoDocumento = tipoDocumentoMapper.tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);

            tipoDocumentoService.saveTipoDocumento(tipoDocumento);
            return ResponseEntity.ok().body(new Respuesta("El tipo de documento con id "+tipoDocumento.getTipoDocumentoId()+" se ha guardado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @DeleteMapping(value = "/deleteTipoDocumento/{tipoDocumentoId}")
    public ResponseEntity<Respuesta> deleteTipoDocumento(
        @PathVariable("tipoDocumentoId")
    Integer tipoDocumentoId) throws Exception {
        try {
            TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumento(tipoDocumentoId);

            tipoDocumentoService.deleteTipoDocumento(tipoDocumento);
            return ResponseEntity.ok().body(new Respuesta("El tipo de documento con id "+tipoDocumento.getTipoDocumentoId()+" se ha eliminado con exito"));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @PutMapping(value = "/updateTipoDocumento/")
    public ResponseEntity<Respuesta> updateTipoDocumento(
        @RequestBody
    TipoDocumentoDTO tipoDocumentoDTO) throws Exception {
        try {
            TipoDocumento tipoDocumento = tipoDocumentoMapper.tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);

            tipoDocumentoService.updateTipoDocumento(tipoDocumento);
            return ResponseEntity.ok().body(new Respuesta("El tipo de documento con id "+tipoDocumento.getTipoDocumentoId()+" se ha modificado con exito"));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @GetMapping(value = "/getDataTipoDocumento")
    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception {
        try {
            return tipoDocumentoService.getDataTipoDocumento();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoDocumento/{tipoDocumentoId}")
    public TipoDocumentoDTO getTipoDocumento(
        @PathVariable("tipoDocumentoId")
    Integer tipoDocumentoId) throws Exception {
        try {
            TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumento(tipoDocumentoId);

            return tipoDocumentoMapper.tipoDocumentoToTipoDocumentoDTO(tipoDocumento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @PutMapping("/deactivate")
	public ResponseEntity<Respuesta> deactivate(@RequestBody TipoDocumentoDTO tipoDocumentoDTO)	throws Exception{
		try {
			if(tipoDocumentoDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta("El tipo de documento es nulo"));
			}
			
			log.info("intentando desactivar tipo de documento: " + 	tipoDocumentoDTO.toString());
			
			TipoDocumento toBeFound = tipoDocumentoService.getTipoDocumento(tipoDocumentoDTO.getTipoDocumentoId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de documento con id "
						+ tipoDocumentoDTO.getTipoDocumentoId()
						+ " no existe"));
			}
			
			tipoDocumentoDTO.setIdEstado_Estado(ESTADO_DESACTIVADO);
			
			TipoDocumento tipoDocumento = tipoDocumentoMapper
					.tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);
			tipoDocumentoService.updateTipoDocumento(tipoDocumento);
			
			return ResponseEntity.ok().body(new co.edu.usbcali.clum.utility.Respuesta(
					"El tipo de documento con id "
					+ tipoDocumento.getTipoDocumentoId()
					+ " ha sido desactivado exitosamente"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
	
	@PutMapping("/activate")
	public ResponseEntity<Respuesta> activate(@RequestBody TipoDocumentoDTO tipoDocumentoDTO)throws Exception{
		try {
			if(tipoDocumentoDTO == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de documento es nulo"));
			}
			
			log.info("intentando activar tipo de documento: " + tipoDocumentoDTO.toString());
			
			TipoDocumento toBeFound = tipoDocumentoService.getTipoDocumento(tipoDocumentoDTO.getTipoDocumentoId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de documento con id "
						+ tipoDocumentoDTO.getTipoDocumentoId()
						+ " no existe"));
			}
			
			tipoDocumentoDTO.setIdEstado_Estado(ESTADO_ACTIVADO);
			
			TipoDocumento tipoDocumento = tipoDocumentoMapper.tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);
			tipoDocumentoService.updateTipoDocumento(tipoDocumento);
			
			return ResponseEntity.ok().body(new co.edu.usbcali.clum.utility.Respuesta(
					"El tipo de documento con id "
					+ tipoDocumento.getTipoDocumentoId()
					+ " ha sido activado exitosamente"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
}
