package com.orderly;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.cloud.FirestoreClient;

@Controller
public class controller {
	
	@RequestMapping("/start")
	public String start() {
		return "start";
	}
	@RequestMapping("/project")
	public String project() {
		return "project";
	}
	@RequestMapping("/signInForm")
	public String signin(@RequestParam(value="email", required=true, defaultValue="") String email, 
			@RequestParam(value="password", required=true, defaultValue="") String password) {
		return "start";
	}
	@RequestMapping("/signUpForm")
	public String signup(@RequestParam(value="email", required=true, defaultValue="") String email, 
			@RequestParam(value="name", required=true, defaultValue="") String name, 
			@RequestParam(value="password", required=true, defaultValue="") String password) {
		try {
			InputStream serviceAccount = new FileInputStream("src/Orderly-de95d6dd2c5c.json");
			GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
			FirebaseOptions options = new FirebaseOptions.Builder()
			    .setCredentials(credentials)
			    .build();
			
			FirebaseApp.initializeApp(options);
			Firestore db = FirestoreClient.getFirestore();
			Map<String, Object> usr = new HashMap<>();
			usr.put("email", email);
			usr.put("name", name);
			usr.put("password", password);
			ApiFuture<DocumentReference> addedDocRef = db.collection("users").add(usr);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "start";
	}
}
