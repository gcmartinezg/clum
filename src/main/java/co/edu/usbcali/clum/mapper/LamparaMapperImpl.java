package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.Lampara;
import co.edu.usbcali.clum.dto.LamparaDTO;
import co.edu.usbcali.clum.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class LamparaMapperImpl implements LamparaMapper {
    private static final Logger log = LoggerFactory.getLogger(LamparaMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    /**
    * Service injected by Spring that manages RedAlimentacion entities
    *
    */
    @Autowired
    RedAlimentacionService serviceRedAlimentacion2;

    /**
    * Service injected by Spring that manages SoporteLampara entities
    *
    */
    @Autowired
    SoporteLamparaService serviceSoporteLampara3;

    /**
    * Service injected by Spring that manages TipoBalasto entities
    *
    */
    @Autowired
    TipoBalastoService serviceTipoBalasto4;

    /**
    * Service injected by Spring that manages TipoEspacioIluminado entities
    *
    */
    @Autowired
    TipoEspacioIluminadoService serviceTipoEspacioIluminado5;

    /**
    * Service injected by Spring that manages TipoLampara entities
    *
    */
    @Autowired
    TipoLamparaService serviceTipoLampara6;

    /**
    * Service injected by Spring that manages Transformador entities
    *
    */
    @Autowired
    TransformadorService serviceTransformador7;

    @Transactional(readOnly = true)
    public LamparaDTO lamparaToLamparaDTO(Lampara lampara)
        throws Exception {
        try {
            LamparaDTO lamparaDTO = new LamparaDTO();

            lamparaDTO.setLamparaId(lampara.getLamparaId());
            lamparaDTO.setControlEncendido((lampara.getControlEncendido() != null)
                ? lampara.getControlEncendido() : null);
            lamparaDTO.setFuncionamiento((lampara.getFuncionamiento() != null)
                ? lampara.getFuncionamiento() : null);
            lamparaDTO.setLatitudLampara((lampara.getLatitudLampara() != null)
                ? lampara.getLatitudLampara() : null);
            lamparaDTO.setLongitudLampara((lampara.getLongitudLampara() != null)
                ? lampara.getLongitudLampara() : null);
            lamparaDTO.setNivelTension((lampara.getNivelTension() != null)
                ? lampara.getNivelTension() : null);
            lamparaDTO.setPotencia((lampara.getPotencia() != null)
                ? lampara.getPotencia() : null);
            lamparaDTO.setUrlImagen((lampara.getUrlImagen() != null)
                ? lampara.getUrlImagen() : null);
            lamparaDTO.setValorPerdidas((lampara.getValorPerdidas() != null)
                ? lampara.getValorPerdidas() : null);
            lamparaDTO.setIdEstado_Estado((lampara.getEstado().getIdEstado() != null)
                ? lampara.getEstado().getIdEstado() : null);
            lamparaDTO.setRedAlimentacionId_RedAlimentacion((lampara.getRedAlimentacion()
                                                                    .getRedAlimentacionId() != null)
                ? lampara.getRedAlimentacion().getRedAlimentacionId() : null);
            lamparaDTO.setSoporteLamparaId_SoporteLampara((lampara.getSoporteLampara()
                                                                  .getSoporteLamparaId() != null)
                ? lampara.getSoporteLampara().getSoporteLamparaId() : null);
            lamparaDTO.setTipoBalastoId_TipoBalasto((lampara.getTipoBalasto()
                                                            .getTipoBalastoId() != null)
                ? lampara.getTipoBalasto().getTipoBalastoId() : null);
            lamparaDTO.setTipoEspacioIluminadoId_TipoEspacioIluminado((lampara.getTipoEspacioIluminado()
                                                                              .getTipoEspacioIluminadoId() != null)
                ? lampara.getTipoEspacioIluminado().getTipoEspacioIluminadoId()
                : null);
            lamparaDTO.setTipoLamparaId_TipoLampara((lampara.getTipoLampara()
                                                            .getTipoLamparaId() != null)
                ? lampara.getTipoLampara().getTipoLamparaId() : null);
            lamparaDTO.setTransformadorId_Transformador((lampara.getTransformador()
                                                                .getTransformadorId() != null)
                ? lampara.getTransformador().getTransformadorId() : null);

            return lamparaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Lampara lamparaDTOToLampara(LamparaDTO lamparaDTO)
        throws Exception {
        try {
            Lampara lampara = new Lampara();

            lampara.setLamparaId(lamparaDTO.getLamparaId());
            lampara.setControlEncendido((lamparaDTO.getControlEncendido() != null)
                ? lamparaDTO.getControlEncendido() : null);
            lampara.setFuncionamiento((lamparaDTO.getFuncionamiento() != null)
                ? lamparaDTO.getFuncionamiento() : null);
            lampara.setLatitudLampara((lamparaDTO.getLatitudLampara() != null)
                ? lamparaDTO.getLatitudLampara() : null);
            lampara.setLongitudLampara((lamparaDTO.getLongitudLampara() != null)
                ? lamparaDTO.getLongitudLampara() : null);
            lampara.setNivelTension((lamparaDTO.getNivelTension() != null)
                ? lamparaDTO.getNivelTension() : null);
            lampara.setPotencia((lamparaDTO.getPotencia() != null)
                ? lamparaDTO.getPotencia() : null);
            lampara.setUrlImagen((lamparaDTO.getUrlImagen() != null)
                ? lamparaDTO.getUrlImagen() : null);
            lampara.setValorPerdidas((lamparaDTO.getValorPerdidas() != null)
                ? lamparaDTO.getValorPerdidas() : null);

            Estado estado = new Estado();

            if (lamparaDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(lamparaDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                lampara.setEstado(estado);
            }

            RedAlimentacion redAlimentacion = new RedAlimentacion();

            if (lamparaDTO.getRedAlimentacionId_RedAlimentacion() != null) {
                redAlimentacion = serviceRedAlimentacion2.getRedAlimentacion(lamparaDTO.getRedAlimentacionId_RedAlimentacion());
            }

            if (redAlimentacion != null) {
                lampara.setRedAlimentacion(redAlimentacion);
            }

            SoporteLampara soporteLampara = new SoporteLampara();

            if (lamparaDTO.getSoporteLamparaId_SoporteLampara() != null) {
                soporteLampara = serviceSoporteLampara3.getSoporteLampara(lamparaDTO.getSoporteLamparaId_SoporteLampara());
            }

            if (soporteLampara != null) {
                lampara.setSoporteLampara(soporteLampara);
            }

            TipoBalasto tipoBalasto = new TipoBalasto();

            if (lamparaDTO.getTipoBalastoId_TipoBalasto() != null) {
                tipoBalasto = serviceTipoBalasto4.getTipoBalasto(lamparaDTO.getTipoBalastoId_TipoBalasto());
            }

            if (tipoBalasto != null) {
                lampara.setTipoBalasto(tipoBalasto);
            }

            TipoEspacioIluminado tipoEspacioIluminado = new TipoEspacioIluminado();

            if (lamparaDTO.getTipoEspacioIluminadoId_TipoEspacioIluminado() != null) {
                tipoEspacioIluminado = serviceTipoEspacioIluminado5.getTipoEspacioIluminado(lamparaDTO.getTipoEspacioIluminadoId_TipoEspacioIluminado());
            }

            if (tipoEspacioIluminado != null) {
                lampara.setTipoEspacioIluminado(tipoEspacioIluminado);
            }

            TipoLampara tipoLampara = new TipoLampara();

            if (lamparaDTO.getTipoLamparaId_TipoLampara() != null) {
                tipoLampara = serviceTipoLampara6.getTipoLampara(lamparaDTO.getTipoLamparaId_TipoLampara());
            }

            if (tipoLampara != null) {
                lampara.setTipoLampara(tipoLampara);
            }

            Transformador transformador = new Transformador();

            if (lamparaDTO.getTransformadorId_Transformador() != null) {
                transformador = serviceTransformador7.getTransformador(lamparaDTO.getTransformadorId_Transformador());
            }

            if (transformador != null) {
                lampara.setTransformador(transformador);
            }

            return lampara;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<LamparaDTO> listLamparaToListLamparaDTO(
        List<Lampara> listLampara) throws Exception {
        try {
            List<LamparaDTO> lamparaDTOs = new ArrayList<LamparaDTO>();

            for (Lampara lampara : listLampara) {
                LamparaDTO lamparaDTO = lamparaToLamparaDTO(lampara);

                lamparaDTOs.add(lamparaDTO);
            }

            return lamparaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Lampara> listLamparaDTOToListLampara(
        List<LamparaDTO> listLamparaDTO) throws Exception {
        try {
            List<Lampara> listLampara = new ArrayList<Lampara>();

            for (LamparaDTO lamparaDTO : listLamparaDTO) {
                Lampara lampara = lamparaDTOToLampara(lamparaDTO);

                listLampara.add(lampara);
            }

            return listLampara;
        } catch (Exception e) {
            throw e;
        }
    }
}
