package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypter {

	private Encrypter() {
	}

	
	// sha256
	public static String Encrypt (String text){
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Ops");
		}
		
		if (digest == null){
			return text;
		}
		byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
		return new String(hash);
	}
	
	
}
