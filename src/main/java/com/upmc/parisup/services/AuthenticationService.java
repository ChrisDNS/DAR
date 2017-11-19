package com.upmc.parisup.services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * 
 * Authentication service
 *
 */
public class AuthenticationService {

	/**
	 * Checks if triedPassword encrypted argument equals the given encryptedPassword
	 * argument
	 * 
	 * @param triedPassword
	 * @param encryptedPassword
	 * @param salt
	 * @return boolean
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public boolean authenticate(String triedPassword, byte[] encryptedPassword, byte[] salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] encryptedTriedPassword = getEncryptedPassword(triedPassword, salt);

		return Arrays.equals(encryptedPassword, encryptedTriedPassword);
	}

	/**
	 * Encrypts the given password with given salt by PBKDF2WithHmacSHA1 algorithm
	 * 
	 * @param password
	 * @param salt
	 * @return encrypted password
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public byte[] getEncryptedPassword(String password, byte[] salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		String algorithm = "PBKDF2WithHmacSHA1";
		final int derivedKeyLength = 160;
		final int iterations = 20000;

		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);

		SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

		return f.generateSecret(spec).getEncoded();
	}

	/**
	 * Generates secure random salt
	 * 
	 * @return salt
	 * @throws NoSuchAlgorithmException
	 */
	public byte[] generateSalt() throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[8];
		random.nextBytes(salt);

		return salt;
	}
}