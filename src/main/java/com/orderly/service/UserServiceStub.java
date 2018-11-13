package com.orderly.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class UserServiceStub implements IUserService {

	public void createUser(String email, String name, String password) {
		try {
			InputStream serviceAccount = new FileInputStream("src/Orderly-de95d6dd2c5c.json");
			GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
			FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
			
			FirebaseApp.initializeApp(options);
			Firestore firestoreDb = FirestoreClient.getFirestore();
			
			Map<String, Object> user = new HashMap<>();
			user.put("email", email);
			user.put("name", name);
			user.put("password", password);
			ApiFuture<DocumentReference> addedDocRef = firestoreDb.collection("users").add(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
