package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoLamparaDTO;
import co.edu.usbcali.clum.mapper.TipoLamparaMapper;
import co.edu.usbcali.clum.service.TipoLamparaService;
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
@RequestMapping("/tipoLampara")
@CrossOrigin("*")
public class TipoLamparaRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoLamparaRestController.class);
    @Autowired
    private TipoLamparaService tipoLamparaService;
    @Autowired
    private TipoLamparaMapper tipoLamparaMapper;

    private static final int ESTADO_ACTIVADO = 1;
    private static final int ESTADO_DESACTIVADO = 2;
    
    @PostMapping(value = "/saveTipoLampara")
    public ResponseEntity<Respuesta> saveTipoLampara(@RequestBody
    TipoLamparaDTO tipoLamparaDTO) throws Exception {
        try {
            TipoLampara tipoLampara = tipoLamparaMapper.tipoLamparaDTOToTipoLampara(tipoLamparaDTO);

            tipoLamparaService.saveTipoLampara(tipoLampara);
            return ResponseEntity.ok().body(new Respuesta("El tipo de documento con id "+tipoLampara.getNombreTipoLampara()+" se ha guardado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @DeleteMapping(value = "/deleteTipoLampara/{tipoLamparaId}")
    public ResponseEntity<Respuesta> deleteTipoLampara(
        @PathVariable("tipoLamparaId")
    Integer tipoLamparaId) throws Exception {
        try {
            TipoLampara tipoLampara = tipoLamparaService.getTipoLampara(tipoLamparaId);

            tipoLamparaService.deleteTipoLampara(tipoLampara);
            return ResponseEntity.ok().body(new Respuesta("El tipo de documento con id "+tipoLampara.getNombreTipoLampara()+" se ha borrado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @PutMapping(value = "/updateTipoLampara/")
    public ResponseEntity<Respuesta> updateTipoLampara(@RequestBody
    TipoLamparaDTO tipoLamparaDTO) throws Exception {
        try {
            TipoLampara tipoLampara = tipoLamparaMapper.tipoLamparaDTOToTipoLampara(tipoLamparaDTO);

            tipoLamparaService.updateTipoLampara(tipoLampara);
            return ResponseEntity.ok().body(new Respuesta("El tipo de documento con id "+tipoLampara.getNombreTipoLampara()+" se ha actualizado con exito"));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @GetMapping(value = "/getDataTipoLampara")
    public List<TipoLamparaDTO> getDataTipoLampara() throws Exception {
        try {
            return tipoLamparaService.getDataTipoLampara();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoLampara/{tipoLamparaId}")
    public TipoLamparaDTO getTipoLampara(
        @PathVariable("tipoLamparaId")
    Integer tipoLamparaId) throws Exception {
        try {
            TipoLampara tipoLampara = tipoLamparaService.getTipoLampara(tipoLamparaId);

            return tipoLamparaMapper.tipoLamparaToTipoLamparaDTO(tipoLampara);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @PutMapping("/deactivate")
	public ResponseEntity<Respuesta> deactivate(@RequestBody TipoLamparaDTO tipoLamparaDTO)	throws Exception{
		try {
			if(tipoLamparaDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta("El tipo de lampara es nulo"));
			}
			
			log.info("intentando desactivar tipo de documento: " + 	tipoLamparaDTO.toString());
			
			TipoLampara toBeFound = tipoLamparaService.getTipoLampara(tipoLamparaDTO.getTipoLamparaId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de lampara con id "
						+ tipoLamparaDTO.getTipoLamparaId()
						+ " no existe"));
			}
			
			tipoLamparaDTO.setIdEstado_Estado(ESTADO_DESACTIVADO);
			
			TipoLampara tipoLampara = tipoLamparaMapper.tipoLamparaDTOToTipoLampara(tipoLamparaDTO);
			tipoLamparaService.updateTipoLampara(tipoLampara);
			
			return ResponseEntity.ok().body(new co.edu.usbcali.clum.utility.Respuesta(
					"El tipo de lampara con id "
					+ tipoLampara.getTipoLamparaId()
					+ " ha sido desactivado exitosamente"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
	
	@PutMapping("/activate")
	public ResponseEntity<Respuesta> activate(@RequestBody TipoLamparaDTO tipoLamparaDTO)throws Exception{
		try {
			if(tipoLamparaDTO == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de lampara es nulo"));
			}
			
			log.info("intentando activar tipo de lampara: " + tipoLamparaDTO.toString());
			
			TipoLampara toBeFound = tipoLamparaService.getTipoLampara(tipoLamparaDTO.getTipoLamparaId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El tipo de documento con id "
						+ tipoLamparaDTO.getTipoLamparaId()
						+ " no existe"));
			}
			
			tipoLamparaDTO.setIdEstado_Estado(ESTADO_ACTIVADO);
			
			TipoLampara tipoLampara = tipoLamparaMapper.tipoLamparaDTOToTipoLampara(tipoLamparaDTO);
			tipoLamparaService.updateTipoLampara(tipoLampara);
			
			return ResponseEntity.ok().body(new co.edu.usbcali.clum.utility.Respuesta(
					"El tipo de documento con id "
					+ tipoLampara.getTipoLamparaId()
					+ " ha sido activado exitosamente"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(e.getMessage()));
		}
		
	}
}
