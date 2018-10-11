package com.orderly;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;


@SpringBootApplication
public class OrderlyApplication {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		InputStream serviceAccount = new FileInputStream("src/Orderly-de95d6dd2c5c.json");
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirebaseOptions options = new FirebaseOptions.Builder()
		    .setCredentials(credentials)
		    .build();
		FirebaseApp.initializeApp(options);

		Firestore db = FirestoreClient.getFirestore();
		
		// asynchronously retrieve all users
		ApiFuture<QuerySnapshot> query = db.collection("users").get();
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
		  System.out.println("User ID: " + document.getId());
		  System.out.println("Name: " + document.getString("name"));
		  System.out.println("Email: " + document.getString("email"));
		}

		SpringApplication.run(OrderlyApplication.class, args);
	}
}
