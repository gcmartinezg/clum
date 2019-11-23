package co.edu.usbcali.clum.service;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentChange;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import co.edu.usbcali.clum.domain.Canalizacion;
import co.edu.usbcali.clum.domain.Lampara;
import co.edu.usbcali.clum.domain.LamparaRegistrada;
import co.edu.usbcali.clum.domain.RedAlimentacion;
import co.edu.usbcali.clum.domain.SoporteLampara;
import co.edu.usbcali.clum.domain.Transformador;
import co.edu.usbcali.clum.dto.CanalizacionDTO;
import co.edu.usbcali.clum.dto.LamparaDTO;
import co.edu.usbcali.clum.dto.LamparaRegistradaDTO;
import co.edu.usbcali.clum.dto.RedAlimentacionDTO;
import co.edu.usbcali.clum.dto.SoporteLamparaDTO;
import co.edu.usbcali.clum.dto.TransformadorDTO;
import co.edu.usbcali.clum.mapper.CanalizacionMapper;
import co.edu.usbcali.clum.mapper.LamparaMapper;
import co.edu.usbcali.clum.mapper.LamparaRegistradaMapper;
import co.edu.usbcali.clum.mapper.RedAlimentacionMapper;
import co.edu.usbcali.clum.mapper.SoporteLamparaMapper;
import co.edu.usbcali.clum.mapper.TransformadorMapper;

@Component
@Scope("singleton")
public class FirebaseEventListenerImpl implements FirebaseEventListener {

	private final static Logger log=LoggerFactory.getLogger(FirebaseEventListenerImpl.class);
	private final static String COLECCION_ITEMS_PRODUCTO = "transformador";
	private final static String COLECCION_ITEMS_CANALIZACION = "canalizacion";
	private final static String COLECCION_ITEMS_LAMPARA = "lampara";
	private final static String COLECCION_ITEMS_SOPORTE_LAMPARA = "soporteLampara";
	private final static String COLECCION_ITEMS_RED_ALIMENTACION = "redAlimentacion";
	private final static String COLECCION_ITEMS_LAMPARA_REGISTRADA = "lamparaRegistrada";
	
	private Firestore db=null;
	
	@Autowired
	private TransformadorMapper transformadorMapper;
	
	@Autowired
	private TransformadorService transformadorService;
	
	@Autowired
	private CanalizacionMapper canalizacionMapper;
	
	@Autowired
	private CanalizacionService canalizacionService;
	
	@Autowired
	private LamparaMapper lamparaMapper;

	@Autowired
	private LamparaService lamparaService;
	
	@Autowired
	private SoporteLamparaMapper soporteLamparaMapper;
	
	@Autowired
	private SoporteLamparaService soporteLamparaService;
	
	@Autowired
	private RedAlimentacionMapper redAlimentacionMapper;
	
	@Autowired
	private RedAlimentacionService redAlimentacionService;
	
	@Autowired
	private LamparaRegistradaMapper lamparaRegistradaMapper;
	
	@Autowired
	private LamparaRegistradaService lamparaRegistradaService;
	
	@PostConstruct
	public void initFirebase() {
		try {
			log.info("Inicializando FirebaseInitServlet...");

		
			String ruta = "/c-lum-f43ec-firebase-adminsdk-0uuvt-37b5a32a60.json";

			InputStream serviceAccount = FirebaseEventListenerImpl.class.getResourceAsStream(ruta);

			if (serviceAccount == null) {
				throw new Exception("No se pudo encontrar la llave de firebase en  classpath:" + ruta);
			}

			// Use a service account
			GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		    FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder().setCredentials(credentials).build();
		    Firestore db = firestoreOptions.getService();
		    this.db = db;
		    
			// Listener para clientes
			suscribirListenerItem(db, "clieId", COLECCION_ITEMS_PRODUCTO);
		    suscribirListenerItemLampara(db, "", COLECCION_ITEMS_LAMPARA);
		    suscribirListenerItemSoporteLampara(db, "", COLECCION_ITEMS_SOPORTE_LAMPARA);
		    suscribirListenerItemRedAlimentacion(db, "", COLECCION_ITEMS_RED_ALIMENTACION);
			suscribirListenerCanalizacion(db, "", COLECCION_ITEMS_CANALIZACION);
		    suscribirListenerItemLamparaRegistrada(db, "", COLECCION_ITEMS_LAMPARA_REGISTRADA);
		} catch (Exception e) {
			log.error("Error inicializando FirebaseInitServlet: ", e);
		}
	}
	
	@Order(1)
	private void suscribirListenerItem(final Firestore db, final String keyName, final String nombreColeccion)throws Exception {
		db.collection(nombreColeccion).addSnapshotListener(new EventListener<QuerySnapshot>() {

			
			@Override
			public void onEvent(QuerySnapshot value, FirestoreException error) {
				
				log.info(transformadorMapper.toString());
				List<DocumentChange> dcs = value.getDocumentChanges();
				for (DocumentChange dc : dcs) {

					QueryDocumentSnapshot queryDocumentSnapshot = dc.getDocument();
					Map<String, Object> data = queryDocumentSnapshot.getData();
					
					String tipoEvento = dc.getType().name();
					String datos = data.toString();

					log.info(tipoEvento + ": " + datos);

					try {
						// ADDED, MODIFIED, REMOVED
						if (tipoEvento.equals("ADDED")) {
							log.info("ADDED");
							//*
							 try {
								
								TransformadorDTO transformadorDTO = transformadorMapper.transformadorFirebaseToTransformadorDTO(data);
								Transformador transformador = transformadorMapper.transformadorDTOToTransformador(transformadorDTO);
								/*log.info("idtransformador "+transformador.getTransformadorId()+" idestado "+
										transformador.getEstado().getIdEstado()+" idtiposoporte "+transformador.getTipoSoporte().getTipoSoporteId()+
										" tipotransformadorid "+transformador.getTipoTransformador().getTipoTransformadorId());*/
								transformadorService.saveTransformador(transformador);
								
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}							
							log.info(datos);

						}else if (tipoEvento.equals("MODIFIED")) {
							log.info("MODIFIED");
							log.info(datos);
						}else if (tipoEvento.equals("REMOVED")) {
							log.info("REMOVED");
							log.info(datos);
						}
					}catch (Exception e) {
						log.error("Error", e);
					}
				
				}
				
			}
			
			
		});
		
	}
	
	@Order(2)
	private void suscribirListenerItemLampara(final Firestore db, final String keyName, final String nombreColeccion)throws Exception {
		db.collection(nombreColeccion).addSnapshotListener(new EventListener<QuerySnapshot>() {

			
			@Override
			public void onEvent(QuerySnapshot value, FirestoreException error) {
				
				log.info(transformadorMapper.toString());
				List<DocumentChange> dcs = value.getDocumentChanges();
				for (DocumentChange dc : dcs) {

					QueryDocumentSnapshot queryDocumentSnapshot = dc.getDocument();
					Map<String, Object> data = queryDocumentSnapshot.getData();
					
					String tipoEvento = dc.getType().name();
					String datos = data.toString();

					log.info(tipoEvento + ": " + datos);

					try {
						// ADDED, MODIFIED, REMOVED
						if (tipoEvento.equals("ADDED")) {
							log.info("ADDED");
							//*
							 try {
								
								LamparaDTO lamparaDTO = lamparaMapper.lamparaFirebaseToLampara(data);
								Lampara lampara = lamparaMapper.lamparaDTOToLampara(lamparaDTO);
								
								/*log.info("**********"+lampara.getControlEncendido()+" "+lampara.getFuncionamiento()+" "+lampara.getUrlImagen()+
										" "+lampara.getLamparaId()+" "+lampara.getLatitudLampara()+" "+lampara.getLongitudLampara()+
										" "+lampara.getNivelTension()+" "+lampara.getPotencia()+" "+lampara.getValorPerdidas()+" "+lampara.getEstado().getIdEstado()+
										" "+lampara.getRedAlimentacion().getRedAlimentacionId()+" "+lampara.getSoporteLampara().getSoporteLamparaId()+
										" "+lampara.getTipoBalasto().getTipoBalastoId()+" "+lampara.getTipoEspacioIluminado().getTipoEspacioIluminadoId()+
										" "+lampara.getTipoLampara().getTipoLamparaId()+" "+lampara.getTransformador().getTransformadorId());*/
								lamparaService.saveLampara(lampara);
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}							
							log.info(datos);

						}else if (tipoEvento.equals("MODIFIED")) {
							log.info("MODIFIED");
							log.info(datos);
						}else if (tipoEvento.equals("REMOVED")) {
							log.info("REMOVED");
							log.info(datos);
						}
					}catch (Exception e) {
						log.error("Error", e);
					}
				
				}
				
			}
			
			
		});
		
	}
	
	@Order(3)
	private void suscribirListenerItemSoporteLampara(final Firestore db, final String keyName, final String nombreColeccion)throws Exception {
		db.collection(nombreColeccion).addSnapshotListener(new EventListener<QuerySnapshot>() {

			
			@Override
			public void onEvent(QuerySnapshot value, FirestoreException error) {
				
				log.info(transformadorMapper.toString());
				List<DocumentChange> dcs = value.getDocumentChanges();
				for (DocumentChange dc : dcs) {

					QueryDocumentSnapshot queryDocumentSnapshot = dc.getDocument();
					Map<String, Object> data = queryDocumentSnapshot.getData();
					
					String tipoEvento = dc.getType().name();
					String datos = data.toString();

					log.info(tipoEvento + ": " + datos);

					try {
						// ADDED, MODIFIED, REMOVED
						if (tipoEvento.equals("ADDED")) {
							log.info("ADDED");
							 try {
								
								SoporteLamparaDTO soporteLamparaDTO = soporteLamparaMapper.soporteLamparaFirebaseToSoporteLamparaDTO(data);
								SoporteLampara soporteLampara = soporteLamparaMapper.soporteLamparaDTOToSoporteLampara(soporteLamparaDTO);
								/*log.info("long "+soporteLampara.getLongitud()+" id "+soporteLampara.getSoporteLamparaId()+" estado "+soporteLampara.getEstado().getIdEstado()+
										" tipomaterial id "+soporteLampara.getTipoMaterial().getTipoMaterialId()+" tipo soporte id "+soporteLampara.getTipoSoporte().getTipoSoporteId());*/
								soporteLamparaService.saveSoporteLampara(soporteLampara);
								
							 } catch (Exception e1) {
								e1.printStackTrace();
							}							
							log.info(datos);

						}else if (tipoEvento.equals("MODIFIED")) {
							log.info("MODIFIED");
							log.info(datos);
						}else if (tipoEvento.equals("REMOVED")) {
							log.info("REMOVED");
							log.info(datos);
						}
					}catch (Exception e) {
						log.error("Error", e);
					}
				
				}
				
			}
			
			
		});
		
	}
	
	@Order(4)
	private void suscribirListenerItemRedAlimentacion(final Firestore db, final String keyName, final String nombreColeccion)throws Exception {
		db.collection(nombreColeccion).addSnapshotListener(new EventListener<QuerySnapshot>() {

			
			@Override
			public void onEvent(QuerySnapshot value, FirestoreException error) {
				
				log.info(transformadorMapper.toString());
				List<DocumentChange> dcs = value.getDocumentChanges();
				for (DocumentChange dc : dcs) {

					QueryDocumentSnapshot queryDocumentSnapshot = dc.getDocument();
					Map<String, Object> data = queryDocumentSnapshot.getData();
					
					String tipoEvento = dc.getType().name();
					String datos = data.toString();

					log.info(tipoEvento + ": " + datos);

					try {
						// ADDED, MODIFIED, REMOVED
						if (tipoEvento.equals("ADDED")) {
							log.info("ADDED");
							//*
							 try {
								
								RedAlimentacionDTO redAlimentacionDTO = redAlimentacionMapper.redAlimentacionFirebaseToRedAlimentacionDTO(data);
								RedAlimentacion redAlimentacion = redAlimentacionMapper.redAlimentacionDTOToRedAlimentacion(redAlimentacionDTO);
								/*log.info("calibre "+redAlimentacion.getCalibreConductorAwg()+" id "+redAlimentacion.getRedAlimentacionId()+
										" estadoid "+redAlimentacion.getEstado().getIdEstado()+" tipoinstalacion "+redAlimentacion.getTipoInstalacion().getTipoInstalacionId()+
										" tipomaterial "+redAlimentacion.getTipoMaterial()+" tiposoporte "+redAlimentacion.getTipoSoporte());
								*/
								redAlimentacionService.saveRedAlimentacion(redAlimentacion);
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}							
							log.info(datos);

						}else if (tipoEvento.equals("MODIFIED")) {
							log.info("MODIFIED");
							log.info(datos);
						}else if (tipoEvento.equals("REMOVED")) {
							log.info("REMOVED");
							log.info(datos);
						}
					}catch (Exception e) {
						log.error("Error", e);
					}
				
				}
				
			}
			
			
		});
		
	}
	
	@Order(5)
	private void suscribirListenerCanalizacion(final Firestore db, final String keyName, final String nombreColeccion)throws Exception {
		db.collection(nombreColeccion).addSnapshotListener(new EventListener<QuerySnapshot>() {

			
			@Override
			public void onEvent(QuerySnapshot value, FirestoreException error) {
				
				log.info(transformadorMapper.toString());
				List<DocumentChange> dcs = value.getDocumentChanges();
				for (DocumentChange dc : dcs) {

					QueryDocumentSnapshot queryDocumentSnapshot = dc.getDocument();
					Map<String, Object> data = queryDocumentSnapshot.getData();
					
					String tipoEvento = dc.getType().name();
					String datos = data.toString();

					log.info(tipoEvento + ": " + datos);

					try {
						// ADDED, MODIFIED, REMOVED
						if (tipoEvento.equals("ADDED")) {
							log.info("ADDED");
							//*
							 try {
								
								CanalizacionDTO canalizacionDTO = canalizacionMapper.canalizacionFirebaseToCanalizacionDTO(data);
								Canalizacion canalizacion = canalizacionMapper.canalizacionDTOToCanalizacion(canalizacionDTO);
								canalizacionService.saveCanalizacion(canalizacion);
								
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}							
							log.info(datos);

						}else if (tipoEvento.equals("MODIFIED")) {
							log.info("MODIFIED");
							log.info(datos);
						}else if (tipoEvento.equals("REMOVED")) {
							log.info("REMOVED");
							log.info(datos);
						}
					}catch (Exception e) {
						log.error("Error", e);
					}
				
				}
				
			}
			
			
		});
		
	}
	
	@Order(6)
	private void suscribirListenerItemLamparaRegistrada(final Firestore db, final String keyName, final String nombreColeccion)throws Exception {
		db.collection(nombreColeccion).addSnapshotListener(new EventListener<QuerySnapshot>() {

			
			@Override
			public void onEvent(QuerySnapshot value, FirestoreException error) {
				
				log.info(transformadorMapper.toString());
				List<DocumentChange> dcs = value.getDocumentChanges();
				for (DocumentChange dc : dcs) {

					QueryDocumentSnapshot queryDocumentSnapshot = dc.getDocument();
					Map<String, Object> data = queryDocumentSnapshot.getData();
					
					String tipoEvento = dc.getType().name();
					String datos = data.toString();

					log.info(tipoEvento + ": " + datos);

					try {
						// ADDED, MODIFIED, REMOVED
						if (tipoEvento.equals("ADDED")) {
							log.info("ADDED");
							 try {
								
								LamparaRegistradaDTO lamparaRegistradaDTO = lamparaRegistradaMapper.lamparaRegistradaFirebaseToLamparaRegistradaDTO(data);
								LamparaRegistrada lamparaRegistrada = lamparaRegistradaMapper.lamparaRegistradaDTOToLamparaRegistrada(lamparaRegistradaDTO);
								/*log.info("id "+lamparaRegistrada.getLamparaRegistradaId()+" latitud "+lamparaRegistrada.getLatitudPosActualTecnico()+
										" longitud "+lamparaRegistrada.getLongitudPosActualTecnico()+" fecha "+lamparaRegistrada.getFechaHora()+" lamparaid "+
										lamparaRegistrada.getLampara().getLamparaId()+" usuarioId "+lamparaRegistrada.getUsuario().getUsuarioId());*/
								lamparaRegistradaService.saveLamparaRegistrada(lamparaRegistrada);
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}							
							log.info(datos);

						}else if (tipoEvento.equals("MODIFIED")) {
							log.info("MODIFIED");
							log.info(datos);
						}else if (tipoEvento.equals("REMOVED")) {
							log.info("REMOVED");
							log.info(datos);
						}
					}catch (Exception e) {
						log.error("Error", e);
					}
				
				}
				
			}
			
			
		});
		
	}
	
}
