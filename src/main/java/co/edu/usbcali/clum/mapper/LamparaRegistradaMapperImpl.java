package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.LamparaRegistrada;
import co.edu.usbcali.clum.dto.LamparaRegistradaDTO;
import co.edu.usbcali.clum.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class LamparaRegistradaMapperImpl implements LamparaRegistradaMapper {
    private static final Logger log = LoggerFactory.getLogger(LamparaRegistradaMapperImpl.class);

    /**
    * Service injected by Spring that manages Lampara entities
    *
    */
    @Autowired
    LamparaService serviceLampara1;

    /**
    * Service injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    UsuarioService serviceUsuario2;

    @Transactional(readOnly = true)
    public LamparaRegistradaDTO lamparaRegistradaToLamparaRegistradaDTO(
        LamparaRegistrada lamparaRegistrada) throws Exception {
        try {
            LamparaRegistradaDTO lamparaRegistradaDTO = new LamparaRegistradaDTO();

            lamparaRegistradaDTO.setLamparaRegistradaId(lamparaRegistrada.getLamparaRegistradaId());
            lamparaRegistradaDTO.setFechaHora(lamparaRegistrada.getFechaHora());
            lamparaRegistradaDTO.setLatitudPosActualTecnico((lamparaRegistrada.getLatitudPosActualTecnico() != null)
                ? lamparaRegistrada.getLatitudPosActualTecnico() : null);
            lamparaRegistradaDTO.setLongitudPosActualTecnico((lamparaRegistrada.getLongitudPosActualTecnico() != null)
                ? lamparaRegistrada.getLongitudPosActualTecnico() : null);
            lamparaRegistradaDTO.setLamparaId_Lampara((lamparaRegistrada.getLampara()
                                                                        .getLamparaId() != null)
                ? lamparaRegistrada.getLampara().getLamparaId() : null);
            lamparaRegistradaDTO.setUsuarioId_Usuario((lamparaRegistrada.getUsuario()
                                                                        .getUsuarioId() != null)
                ? lamparaRegistrada.getUsuario().getUsuarioId() : null);

            return lamparaRegistradaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public LamparaRegistrada lamparaRegistradaDTOToLamparaRegistrada(
        LamparaRegistradaDTO lamparaRegistradaDTO) throws Exception {
        try {
            LamparaRegistrada lamparaRegistrada = new LamparaRegistrada();

            lamparaRegistrada.setLamparaRegistradaId(lamparaRegistradaDTO.getLamparaRegistradaId());
            lamparaRegistrada.setFechaHora(lamparaRegistradaDTO.getFechaHora());
            lamparaRegistrada.setLatitudPosActualTecnico((lamparaRegistradaDTO.getLatitudPosActualTecnico() != null)
                ? lamparaRegistradaDTO.getLatitudPosActualTecnico() : null);
            lamparaRegistrada.setLongitudPosActualTecnico((lamparaRegistradaDTO.getLongitudPosActualTecnico() != null)
                ? lamparaRegistradaDTO.getLongitudPosActualTecnico() : null);

            Lampara lampara = new Lampara();

            if (lamparaRegistradaDTO.getLamparaId_Lampara() != null) {
                lampara = serviceLampara1.getLampara(lamparaRegistradaDTO.getLamparaId_Lampara());
            }

            if (lampara != null) {
                lamparaRegistrada.setLampara(lampara);
            }

            Usuario usuario = new Usuario();

            if (lamparaRegistradaDTO.getUsuarioId_Usuario() != null) {
                usuario = serviceUsuario2.getUsuario(lamparaRegistradaDTO.getUsuarioId_Usuario());
            }

            if (usuario != null) {
                lamparaRegistrada.setUsuario(usuario);
            }

            return lamparaRegistrada;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<LamparaRegistradaDTO> listLamparaRegistradaToListLamparaRegistradaDTO(
        List<LamparaRegistrada> listLamparaRegistrada)
        throws Exception {
        try {
            List<LamparaRegistradaDTO> lamparaRegistradaDTOs = new ArrayList<LamparaRegistradaDTO>();

            for (LamparaRegistrada lamparaRegistrada : listLamparaRegistrada) {
                LamparaRegistradaDTO lamparaRegistradaDTO = lamparaRegistradaToLamparaRegistradaDTO(lamparaRegistrada);

                lamparaRegistradaDTOs.add(lamparaRegistradaDTO);
            }

            return lamparaRegistradaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<LamparaRegistrada> listLamparaRegistradaDTOToListLamparaRegistrada(
        List<LamparaRegistradaDTO> listLamparaRegistradaDTO)
        throws Exception {
        try {
            List<LamparaRegistrada> listLamparaRegistrada = new ArrayList<LamparaRegistrada>();

            for (LamparaRegistradaDTO lamparaRegistradaDTO : listLamparaRegistradaDTO) {
                LamparaRegistrada lamparaRegistrada = lamparaRegistradaDTOToLamparaRegistrada(lamparaRegistradaDTO);

                listLamparaRegistrada.add(lamparaRegistrada);
            }

            return listLamparaRegistrada;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public LamparaRegistradaDTO lamparaRegistradaFirebaseToLamparaRegistradaDTO(Map<String, Object> data) throws Exception{
    	try {
    		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    		StringBuilder diaBuilder = new StringBuilder();
    		StringBuilder fechaBuilder = new StringBuilder();
			String fecha = (String) data.get("fechaHora").toString();
			String[] fechaString = fecha.split("-");
			String anio = fechaString[0];
			String mes = fechaString[1];
			String dia = fechaString[2];
			diaBuilder.append(dia.charAt(0));
			diaBuilder.append(dia.charAt(1));
			fechaBuilder.append(diaBuilder);
			fechaBuilder.append("/");
			fechaBuilder.append(mes);
			fechaBuilder.append("/");
			fechaBuilder.append(anio);
			String fechaHoraString = fechaBuilder.toString();
			Date date = format.parse(fechaHoraString);
			
			Integer lamparaId = (int) (long) data.get("lamparaId_Lampara");
			Integer lamparaRegistradaId = (int) (long) data.get("lamparaRegistradaId");
			Double latitudTecnico = (Double) data.get("latitudPosActualTecnico");
			Double longitudTecnico = (Double) data.get("longitudPosActualTecnico");
			String usuarioId = (String) data.get("usuarioId_Usuario");
			LamparaRegistradaDTO lamparaRegistradaDTO = new LamparaRegistradaDTO();

            lamparaRegistradaDTO.setLamparaRegistradaId(lamparaRegistradaId);
            lamparaRegistradaDTO.setFechaHora(date);
            lamparaRegistradaDTO.setLatitudPosActualTecnico((latitudTecnico != null)
                ? latitudTecnico : null);
            lamparaRegistradaDTO.setLongitudPosActualTecnico((longitudTecnico != null)
                ? longitudTecnico : null);
            lamparaRegistradaDTO.setLamparaId_Lampara((lamparaId != null)
                ? lamparaId : null);
            lamparaRegistradaDTO.setUsuarioId_Usuario((usuarioId != null)
                ? usuarioId : null);

            return lamparaRegistradaDTO;
		} catch (Exception e) {
			throw e;
		}
    }
}
