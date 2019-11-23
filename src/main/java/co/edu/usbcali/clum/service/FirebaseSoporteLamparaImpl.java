package co.edu.usbcali.clum.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.aspectj.lang.annotation.Aspect;
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

import co.edu.usbcali.clum.domain.SoporteLampara;
import co.edu.usbcali.clum.dto.SoporteLamparaDTO;
import co.edu.usbcali.clum.mapper.SoporteLamparaMapper;

@Aspect
@Component
@Scope("singleton")
@Order(value = 3)
public class FirebaseSoporteLamparaImpl implements FirebaseSoporteLampara {
	
private final static Logger log=LoggerFactory.getLogger(FirebaseSoporteLamparaImpl.class);
	
private final static String COLECCION_ITEMS_SOPORTE_LAMPARA = "soporteLampara";
	
	private Firestore db=null;
	
	@Autowired
	private SoporteLamparaMapper soporteLamparaMapper;
	
	@Autowired
	private SoporteLamparaService soporteLamparaService;
	
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
		    suscribirListenerItemSoporteLampara(db, "", COLECCION_ITEMS_SOPORTE_LAMPARA);
		} catch (Exception e) {
			log.error("Error inicializando FirebaseInitServlet: ", e);
		}
	}
	
	private void suscribirListenerItemSoporteLampara(final Firestore db, final String keyName, final String nombreColeccion)throws Exception {
		db.collection(nombreColeccion).addSnapshotListener(new EventListener<QuerySnapshot>() {

			
			@Override
			public void onEvent(QuerySnapshot value, FirestoreException error) {
				
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
								log.info("paso 3");
								
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
