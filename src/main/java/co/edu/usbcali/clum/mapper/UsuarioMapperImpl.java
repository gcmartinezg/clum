package co.edu.usbcali.clum.mapper;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.domain.Usuario;
import co.edu.usbcali.clum.dto.UsuarioDTO;
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
public class UsuarioMapperImpl implements UsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(UsuarioMapperImpl.class);

    /**
    * Service injected by Spring that manages Estado entities
    *
    */
    @Autowired
    EstadoService serviceEstado1;

    /**
    * Service injected by Spring that manages Tercero entities
    *
    */
    @Autowired
    TerceroService serviceTercero2;

    /**
    * Service injected by Spring that manages TipoUsuario entities
    *
    */
    @Autowired
    TipoUsuarioService serviceTipoUsuario3;

    @Transactional(readOnly = true)
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario)
        throws Exception {
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();

            usuarioDTO.setUsuarioId(usuario.getUsuarioId());
            usuarioDTO.setContrasenia((usuario.getContrasenia() != null)
                ? usuario.getContrasenia() : null);
            usuarioDTO.setIdEstado_Estado((usuario.getEstado().getIdEstado() != null)
                ? usuario.getEstado().getIdEstado() : null);
            usuarioDTO.setTerceroId_Tercero((usuario.getTercero().getTerceroId() != null)
                ? usuario.getTercero().getTerceroId() : null);
            usuarioDTO.setTipoUsuarioId_TipoUsuario((usuario.getTipoUsuario()
                                                            .getTipoUsuarioId() != null)
                ? usuario.getTipoUsuario().getTipoUsuarioId() : null);

            return usuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO)
        throws Exception {
        try {
            Usuario usuario = new Usuario();

            usuario.setUsuarioId(usuarioDTO.getUsuarioId());
            usuario.setContrasenia((usuarioDTO.getContrasenia() != null)
                ? usuarioDTO.getContrasenia() : null);

            Estado estado = new Estado();

            if (usuarioDTO.getIdEstado_Estado() != null) {
                estado = serviceEstado1.getEstado(usuarioDTO.getIdEstado_Estado());
            }

            if (estado != null) {
                usuario.setEstado(estado);
            }

            Tercero tercero = new Tercero();

            if (usuarioDTO.getTerceroId_Tercero() != null) {
                tercero = serviceTercero2.getTercero(usuarioDTO.getTerceroId_Tercero());
            }

            if (tercero != null) {
                usuario.setTercero(tercero);
            }

            TipoUsuario tipoUsuario = new TipoUsuario();

            if (usuarioDTO.getTipoUsuarioId_TipoUsuario() != null) {
                tipoUsuario = serviceTipoUsuario3.getTipoUsuario(usuarioDTO.getTipoUsuarioId_TipoUsuario());
            }

            if (tipoUsuario != null) {
                usuario.setTipoUsuario(tipoUsuario);
            }

            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> listUsuarioToListUsuarioDTO(
        List<Usuario> listUsuario) throws Exception {
        try {
            List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();

            for (Usuario usuario : listUsuario) {
                UsuarioDTO usuarioDTO = usuarioToUsuarioDTO(usuario);

                usuarioDTOs.add(usuarioDTO);
            }

            return usuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> listUsuarioDTOToListUsuario(
        List<UsuarioDTO> listUsuarioDTO) throws Exception {
        try {
            List<Usuario> listUsuario = new ArrayList<Usuario>();

            for (UsuarioDTO usuarioDTO : listUsuarioDTO) {
                Usuario usuario = usuarioDTOToUsuario(usuarioDTO);

                listUsuario.add(usuario);
            }

            return listUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
