package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.Canalizacion;
import co.edu.usbcali.clum.dto.CanalizacionDTO;
import co.edu.usbcali.clum.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class CanalizacionMapperImpl implements CanalizacionMapper {
    private static final Logger log = LoggerFactory.getLogger(CanalizacionMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    /**
    * Service injected by Spring that manages Lampara entities
    *
    */
    @Autowired
    LamparaService serviceLampara2;

    /**
    * Service injected by Spring that manages TipoSoporte entities
    *
    */
    @Autowired
    TipoSoporteService serviceTipoSoporte3;

    /**
    * Service injected by Spring that manages TipoZona entities
    *
    */
    @Autowired
    TipoZonaService serviceTipoZona4;

    @Transactional(readOnly = true)
    public CanalizacionDTO canalizacionToCanalizacionDTO(
        Canalizacion canalizacion) throws Exception {
        try {
            CanalizacionDTO canalizacionDTO = new CanalizacionDTO();

            canalizacionDTO.setCanalizacionId(canalizacion.getCanalizacionId());
            canalizacionDTO.setCajaInspeccion((canalizacion.getCajaInspeccion() != null)
                ? canalizacion.getCajaInspeccion() : null);
            canalizacionDTO.setDucteria((canalizacion.getDucteria() != null)
                ? canalizacion.getDucteria() : null);
            canalizacionDTO.setIdEstado_Estado((canalizacion.getEstado()
                                                            .getIdEstado() != null)
                ? canalizacion.getEstado().getIdEstado() : null);
            canalizacionDTO.setLamparaId_Lampara((canalizacion.getLampara()
                                                              .getLamparaId() != null)
                ? canalizacion.getLampara().getLamparaId() : null);
            canalizacionDTO.setTipoSoporteId_TipoSoporte((canalizacion.getTipoSoporte()
                                                                      .getTipoSoporteId() != null)
                ? canalizacion.getTipoSoporte().getTipoSoporteId() : null);
            canalizacionDTO.setTipoZonaId_TipoZona((canalizacion.getTipoZona()
                                                                .getTipoZonaId() != null)
                ? canalizacion.getTipoZona().getTipoZonaId() : null);

            return canalizacionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Canalizacion canalizacionDTOToCanalizacion(
        CanalizacionDTO canalizacionDTO) throws Exception {
        try {
            Canalizacion canalizacion = new Canalizacion();

            canalizacion.setCanalizacionId(canalizacionDTO.getCanalizacionId());
            canalizacion.setCajaInspeccion((canalizacionDTO.getCajaInspeccion() != null)
                ? canalizacionDTO.getCajaInspeccion() : null);
            canalizacion.setDucteria((canalizacionDTO.getDucteria() != null)
                ? canalizacionDTO.getDucteria() : null);

            Estado estado = new Estado();

            if (canalizacionDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(canalizacionDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                canalizacion.setEstado(estado);
            }

            Lampara lampara = new Lampara();

            if (canalizacionDTO.getLamparaId_Lampara() != null) {
                lampara = serviceLampara2.getLampara(canalizacionDTO.getLamparaId_Lampara());
            }

            if (lampara != null) {
                canalizacion.setLampara(lampara);
            }

            TipoSoporte tipoSoporte = new TipoSoporte();

            if (canalizacionDTO.getTipoSoporteId_TipoSoporte() != null) {
                tipoSoporte = serviceTipoSoporte3.getTipoSoporte(canalizacionDTO.getTipoSoporteId_TipoSoporte());
            }

            if (tipoSoporte != null) {
                canalizacion.setTipoSoporte(tipoSoporte);
            }

            TipoZona tipoZona = new TipoZona();

            if (canalizacionDTO.getTipoZonaId_TipoZona() != null) {
                tipoZona = serviceTipoZona4.getTipoZona(canalizacionDTO.getTipoZonaId_TipoZona());
            }

            if (tipoZona != null) {
                canalizacion.setTipoZona(tipoZona);
            }

            return canalizacion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CanalizacionDTO> listCanalizacionToListCanalizacionDTO(
        List<Canalizacion> listCanalizacion) throws Exception {
        try {
            List<CanalizacionDTO> canalizacionDTOs = new ArrayList<CanalizacionDTO>();

            for (Canalizacion canalizacion : listCanalizacion) {
                CanalizacionDTO canalizacionDTO = canalizacionToCanalizacionDTO(canalizacion);

                canalizacionDTOs.add(canalizacionDTO);
            }

            return canalizacionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Canalizacion> listCanalizacionDTOToListCanalizacion(
        List<CanalizacionDTO> listCanalizacionDTO) throws Exception {
        try {
            List<Canalizacion> listCanalizacion = new ArrayList<Canalizacion>();

            for (CanalizacionDTO canalizacionDTO : listCanalizacionDTO) {
                Canalizacion canalizacion = canalizacionDTOToCanalizacion(canalizacionDTO);

                listCanalizacion.add(canalizacion);
            }

            return listCanalizacion;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public CanalizacionDTO canalizacionFirebaseToCanalizacionDTO(Map<String, Object> data) throws Exception{
    	try {
    		Integer lamparaId = (int)(long) data.get("lamparaId_Lampara");
    		Integer tipoZonaId = (int)(long) data.get("tipoZonaId_TipoZona");
    		Integer tipoSoporteId = (int)(long) data.get("tipoSoporteId_TipoSoporte");
			String ducteria = (String) data.get("ducteria");
			Integer canalizacionId = (int) (long) data.get("canalizacionId");
			String cajaInspeccion = (String) data.get("cajaInspeccion");
			Integer idEstado = (int)(long) data.get("idEstado_Estado");
			
			CanalizacionDTO canalizacionDTO = new CanalizacionDTO();

            canalizacionDTO.setCanalizacionId(canalizacionId);
            canalizacionDTO.setCajaInspeccion((cajaInspeccion != null)
                ? cajaInspeccion : null);
            canalizacionDTO.setDucteria((ducteria != null)
                ? ducteria : null);
            canalizacionDTO.setIdEstado_Estado((idEstado != null)
                ? idEstado : null);
            canalizacionDTO.setLamparaId_Lampara((lamparaId != null)
                ? lamparaId : null);
            canalizacionDTO.setTipoSoporteId_TipoSoporte((tipoSoporteId != null)
                ? tipoSoporteId : null);
            canalizacionDTO.setTipoZonaId_TipoZona((tipoZonaId != null)
                ? tipoZonaId : null);

            return canalizacionDTO;
		} catch (Exception e) {
			throw e;
		}
    }
}
