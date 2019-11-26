package co.edu.usbcali.clum.controller;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.LamparaRegistradaDTO;
import co.edu.usbcali.clum.dto.TerceroDTO;
import co.edu.usbcali.clum.dto.UsuarioDTO;
import co.edu.usbcali.clum.mapper.LamparaRegistradaMapper;
import co.edu.usbcali.clum.mapper.TerceroMapper;
import co.edu.usbcali.clum.mapper.UsuarioMapper;
import co.edu.usbcali.clum.service.EstadoService;
import co.edu.usbcali.clum.service.TipoUsuarioService;
import co.edu.usbcali.clum.service.UsuarioService;
import co.edu.usbcali.clum.service.EnviarCorreoService;
import co.edu.usbcali.clum.utility.QRManagement;
import co.edu.usbcali.clum.utility.Respuesta;
import co.edu.usbcali.clum.utility.Utilities;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioRestController {
    private static final Logger log = LoggerFactory.getLogger(UsuarioRestController.class);
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EstadoService estadoService;
    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private TerceroMapper terceroMapper;
    @Autowired
    private LamparaRegistradaMapper lamparaRegistradaMapper;
    @Autowired
    private EnviarCorreoService correo;
    
    private static final int ESTADO_ACTIVADO = 1;
    private static final int ESTADO_DESACTIVADO = 2;
    
    private static final int TIPO_USUARIO_TECNICO = 3;
    
    private static final int INICIO_HORA_LABORAL = 8;
    private static final int FIN_HORA_LABORAL = 17;
    private static final int MINIMO_LAMPARAS_REGISTRADAS = 15;
    
    private static final int TAMANO_QR_PX = 300;

    @PostMapping(value = "/saveUsuario")
    public ResponseEntity<Respuesta> saveUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        try {
        	if(usuarioDTO.getUsuarioId() == null) return ResponseEntity.badRequest().body(new Respuesta("Ingresa su id de usuario"));
        	if(usuarioDTO.getUsuarioId().trim().equals("")) return ResponseEntity.badRequest().body(new Respuesta("Ingresa su id de usuario"));
        	if(usuarioDTO.getContrasenia() == null) return ResponseEntity.badRequest().body(new Respuesta("Ingresa una clave"));
        	if(usuarioDTO.getContrasenia().trim().equals("")) return ResponseEntity.badRequest().body(new Respuesta("Ingresa una clave"));
        	if(usuarioDTO.getIdEstado_Estado() == null || usuarioDTO.getIdEstado_Estado() == 0) return ResponseEntity.badRequest().body(new Respuesta("Un estado es requerido"));
            if(usuarioDTO.getTipoUsuarioId_TipoUsuario() == null || usuarioDTO.getTipoUsuarioId_TipoUsuario() == 0) return ResponseEntity.badRequest().body(new Respuesta("Un tipo de usuario es requerido"));
        	if(usuarioDTO.getTerceroId_Tercero() == null || usuarioDTO.getTerceroId_Tercero() == 0) return ResponseEntity.badRequest().body(new Respuesta("Un tercero es requerido"));
            
            Usuario usuario = usuarioMapper.usuarioDTOToUsuario(usuarioDTO);
            correo.correoCreacion(usuario.getTercero().getEmail(), usuario.getContrasenia(), usuario.getUsuarioId());
            usuarioService.saveUsuario(usuario);
            return ResponseEntity.ok().body(new Respuesta("El usuario se ha guardado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteUsuario/{usuarioId}")
    @Deprecated
    public void deleteUsuario(@PathVariable("usuarioId")
    String usuarioId) throws Exception {
        try {
            Usuario usuario = usuarioService.getUsuario(usuarioId);

            usuarioService.deleteUsuario(usuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateUsuario/")
    public ResponseEntity<Respuesta> updateUsuario(@RequestBody
    UsuarioDTO usuarioDTO) throws Exception {
        try {
            Usuario usuario = usuarioMapper.usuarioDTOToUsuario(usuarioDTO);

            usuarioService.updateUsuario(usuario);
            return ResponseEntity.ok().body(new Respuesta(
					"El usuario con id "
					+ usuario.getUsuarioId()
					+ " ha sido modificado con exito"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
        }
    }

    @GetMapping(value = "/getDataUsuario")
    public List<UsuarioDTO> getDataUsuario() throws Exception {
        try {
            return usuarioService.getDataUsuario();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getUsuario/{usuarioId}")
    public UsuarioDTO getUsuario(@PathVariable("usuarioId")
    String usuarioId) throws Exception {
        try {
            Usuario usuario = usuarioService.getUsuario(usuarioId);

            return usuarioMapper.usuarioToUsuarioDTO(usuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    
    @PostMapping("/login")
    public ResponseEntity<Respuesta> loginUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception{
    	try {
			if(usuarioDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta("UsuarioDTO es nulo"));
			}
			usuarioService.verificarLoginUsuario(usuarioDTO.getUsuarioId(), usuarioDTO.getContrasenia());
			return ResponseEntity.ok().body(new Respuesta("Sesion iniciada exitosamente"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
    }
    
    @PostMapping("/loginMovil")
    public ResponseEntity<Respuesta> loginUsuarioMovil(@RequestBody UsuarioDTO usuarioDTO) throws Exception{
    	try {
			if(usuarioDTO == null) {
				return ResponseEntity.badRequest().body(new Respuesta("UsuarioDTO es nulo"));
			}
			usuarioService.verificarLoginUsuarioMovil(usuarioDTO.getUsuarioId(), usuarioDTO.getContrasenia());
			return ResponseEntity.ok().body(new Respuesta("Sesion iniciada exitosamente"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
    }
    
    @PutMapping("/deactivate")
	public ResponseEntity<Respuesta> 
		deactivate(@RequestBody UsuarioDTO usuarioDTO)
				throws Exception{
		try {
			if(usuarioDTO == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El usuario es nulo"));
			}
			
			log.info("intentando desactivar usuario: " + 
					usuarioDTO.toString());
			
			Usuario toBeFound = usuarioService
					.getUsuario(usuarioDTO.getUsuarioId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El usuario con id "
						+ usuarioDTO.getUsuarioId()
						+ " no existe"));
			}
			
			usuarioDTO.setIdEstado_Estado(ESTADO_DESACTIVADO);
			
			Usuario usuario = usuarioMapper
					.usuarioDTOToUsuario(usuarioDTO);
			usuarioService.updateUsuario(usuario);
			
			return ResponseEntity.ok().body(new Respuesta(
					"El usuario con id "
					+ usuario.getUsuarioId()
					+ " ha sido desactivado exitosamente"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
		
	}
	
	@PutMapping("/activate")
	public ResponseEntity<co.edu.usbcali.clum.utility.Respuesta> 
		activate(@RequestBody UsuarioDTO usuarioDTO)
				throws Exception{
		try {
			if(usuarioDTO == null) {
				return ResponseEntity.badRequest().body(new co.edu.usbcali.clum.utility.Respuesta(
						"El usuario es nulo"));
			}
			
			log.info("intentando activar usuario: " + 
					usuarioDTO.toString());
			
			Usuario toBeFound = usuarioService
					.getUsuario(usuarioDTO.getUsuarioId());
			
			if(toBeFound == null) {
				return ResponseEntity.badRequest().body(new Respuesta(
						"El usuario con id "
						+ usuarioDTO.getUsuarioId()
						+ " no existe"));
			}
			
			usuarioDTO.setIdEstado_Estado(ESTADO_ACTIVADO);
			
			Usuario usuario = usuarioMapper
					.usuarioDTOToUsuario(usuarioDTO);
			usuarioService.updateUsuario(usuario);
			
			return ResponseEntity.ok().body(new Respuesta(
					"El usuario con id "
					+ usuario.getUsuarioId()
					+ " ha sido activado exitosamente"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
		
	}
	
	private List<Tercero> getTercerosFromUsuarios(List<Usuario> usuarios){
		ArrayList<Tercero> terceros = new ArrayList<>(usuarios.size());
		usuarios.forEach(u->{terceros.add(u.getTercero());});
		return terceros;
	}
	
	@GetMapping(value = "/getListaTecnicos")
    public List<TerceroDTO> getTecnicosActivos() throws Exception {
        try {
        	ArrayList<UsuarioDTO> list = new ArrayList<>(usuarioService.getDataUsuario());
        	list.removeIf(u->{
        		return u.getTipoUsuarioId_TipoUsuario() != TIPO_USUARIO_TECNICO;
        	});
        	List<Tercero> listTercero = getTercerosFromUsuarios(
        			usuarioMapper.listUsuarioDTOToListUsuario(list));
            return terceroMapper.listTerceroToListTerceroDTO(listTercero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        
    }
	
	@GetMapping(value = "/getTecnicosActivos")
	public List<TerceroDTO> getListaTecnicos() throws Exception {
        try {
        	ArrayList<UsuarioDTO> list = new ArrayList<>(usuarioService.getDataUsuario());
        	list.removeIf(u->{
        		return u.getTipoUsuarioId_TipoUsuario() != TIPO_USUARIO_TECNICO ||
        				u.getIdEstado_Estado() != ESTADO_ACTIVADO;
        		});
        	List<Tercero> listTercero = getTercerosFromUsuarios(
        			usuarioMapper.listUsuarioDTOToListUsuario(list));
            return terceroMapper.listTerceroToListTerceroDTO(listTercero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        
    }
	
	@GetMapping(value = "/getTerceroFromUsuarioId/{usuarioId}")
	public TerceroDTO getTerceroFromUsuarioId(
    		@PathVariable("usuarioId") String usuarioId) throws Exception {
        try {
        	return terceroMapper.terceroToTerceroDTO(
        			usuarioService.getUsuario(usuarioId).getTercero());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        
	}
	
	@GetMapping(value = "/generateQR/{usuarioId}/{coordinadorId}")
	public Respuesta generateQR(@PathVariable("usuarioId") String usuarioId, 
    		@PathVariable("coordinadorId") String coordinadorId) throws Exception {
        try {
        	String dataQR = Utilities.getQRData(
        			INICIO_HORA_LABORAL, FIN_HORA_LABORAL, coordinadorId, usuarioId);
            return new Respuesta(Utilities.encodeQr(QRManagement.generarQR(dataQR, TAMANO_QR_PX)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
	
	@GetMapping(value = "/generateReport/")
	public Respuesta generateReport() throws Exception {
        try {
        	//TODO terminar metodo
        	return new Respuesta("");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        
	}
	
	@GetMapping(value = "/getEmailFromUsuarioId/{usuarioId}")
	public Respuesta getEmailFromUsuarioId(@PathVariable("usuarioId") String usuarioId) throws Exception{
		try {
			return new Respuesta(getTerceroFromUsuarioId(usuarioId).getEmail());
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return null;
	}
	
	@GetMapping(value = "/getListaLamparasRegistradas/{usuarioId}")
	public List<LamparaRegistradaDTO> getListaLamparasRegistradas(@PathVariable("usuarioId") String usuarioId) throws Exception{
		try {
			List<LamparaRegistradaDTO> lrDto = new ArrayList<>();
			List<LamparaRegistrada> lr = new ArrayList<>();
			lr.addAll(usuarioService.getUsuario(usuarioId).getLamparaRegistradas());
			lrDto.addAll(
				lamparaRegistradaMapper.listLamparaRegistradaToListLamparaRegistradaDTO(lr)
			);
			return lrDto;
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return null;
	}
	
	@GetMapping(value = "/getListaLamparasRegistradasHoyPorUsuario/{usuarioId}")
	public List<LamparaRegistradaDTO> getListaLamparasRegistradasHoyPorUsuario(@PathVariable("usuarioId") String usuarioId) throws Exception{
		try {
			List<LamparaRegistradaDTO> lrDto = new ArrayList<>();
			List<LamparaRegistrada> lr = new ArrayList<>();
			lr.addAll(usuarioService.getUsuario(usuarioId).getLamparaRegistradas());
			lr.removeIf((p)->{
				return !Utilities.isToday(p.getFechaHora());
			});
			lrDto.addAll(
				lamparaRegistradaMapper.listLamparaRegistradaToListLamparaRegistradaDTO(lr)
			);
			return lrDto;
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return null;
	}
	
	@GetMapping(value = "/getMensajeRSA")
	public Respuesta getMensajeRSA() throws Exception{
		try {
			String cifrado = Utilities.cifrado;
			return new Respuesta(cifrado);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
    
	@GetMapping(value = "/getMensajeOriginal")
	public Respuesta getMensajeOriginal() throws Exception{
		try {
			String cifrado = Utilities.cifrado;
			String descifrado = Utilities.descipher(cifrado);
			return new Respuesta(descifrado);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return null;
	}
}
