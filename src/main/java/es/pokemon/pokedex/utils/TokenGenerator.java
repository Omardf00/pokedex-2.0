package es.pokemon.pokedex.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class TokenGenerator {

	public static void main(String[] args) {
		
		System.out.println(generateNewToken());

	}
	
	private static final SecureRandom secureRandom = new SecureRandom();
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

	public static String generateNewToken() {
	    byte[] randomBytes = new byte[24];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}

}
