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

import co.edu.usbcali.clum.domain.Canalizacion;
import co.edu.usbcali.clum.dto.CanalizacionDTO;
import co.edu.usbcali.clum.mapper.CanalizacionMapper;

@Aspect
@Component
@Scope("singleton")
@Order(value = 5)
public class FirebaseCanalizacionImpl implements FirebaseCanalizacion {
	
	private final static Logger log=LoggerFactory.getLogger(FirebaseCanalizacionImpl.class);
	
	private final static String COLECCION_ITEMS_CANALIZACION = "canalizacion";
	
	private Firestore db=null;
	
	@Autowired
	private CanalizacionMapper canalizacionMapper;
	
	@Autowired
	private CanalizacionService canalizacionService;
	
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
			//suscribirListenerItem(db, "clieId", COLECCION_ITEMS_PRODUCTO);
		    //suscribirListenerItemLampara(db, "", COLECCION_ITEMS_LAMPARA);
		    //suscribirListenerItemSoporteLampara(db, "", COLECCION_ITEMS_SOPORTE_LAMPARA);
		    //suscribirListenerItemRedAlimentacion(db, "", COLECCION_ITEMS_RED_ALIMENTACION);
			suscribirListenerCanalizacion(db, "", COLECCION_ITEMS_CANALIZACION);
		    //suscribirListenerItemLamparaRegistrada(db, "", COLECCION_ITEMS_LAMPARA_REGISTRADA);
		} catch (Exception e) {
			log.error("Error inicializando FirebaseInitServlet: ", e);
		}
	}
	
	private void suscribirListenerCanalizacion(final Firestore db, final String keyName, final String nombreColeccion)throws Exception {
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
							//*
							 try {
								
								CanalizacionDTO canalizacionDTO = canalizacionMapper.canalizacionFirebaseToCanalizacionDTO(data);
								Canalizacion canalizacion = canalizacionMapper.canalizacionDTOToCanalizacion(canalizacionDTO);
								canalizacionService.saveCanalizacion(canalizacion);
								log.info("paso 5");
								
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
