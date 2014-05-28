package sample.utility;

import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

public class CipherUtils {

private static final String CIPHER_PROVIDER = "BC";
private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";
private static final String KEY_ALGORITHM = "AES";

private Cipher encrypter;
private Cipher decrypter;

	public CipherUtils(String keyString) {
	
		if (Security.getProvider(CIPHER_PROVIDER) == null) {
			Security.addProvider(new BouncyCastleProvider());
		}
	
		//byte[] key = asHex(keyString.getBytes()).getBytes();
		SecretKeySpec sks = new SecretKeySpec(keyString.getBytes(), KEY_ALGORITHM);
	
		try {
			encrypter = Cipher.getInstance(CIPHER_ALGORITHM, CIPHER_PROVIDER);
			encrypter.init(Cipher.ENCRYPT_MODE, sks);
	
			decrypter = Cipher.getInstance(CIPHER_ALGORITHM, CIPHER_PROVIDER);
			decrypter.init(Cipher.DECRYPT_MODE, sks);
		} catch (Exception e) {
			System.err.println("Caught an exception:" + e);
			throw new AssertionError(e);
		}

	}

	public String encrypt(String data) throws Exception {
		 if (data == null) {
			return null;
		}

		byte[] encryptedData = new byte[1024];
		try {
			encryptedData = encrypter.doFinal(data.getBytes());
		} catch (Exception e) {
			throw new Exception(e);
		}
		return new String(Base64.encode(encryptedData));
	}

	public String decrypt(String encryptedData) throws Exception {
		if (encryptedData == null) {
			return null;
		}
	
		byte[] decryptedData = Base64.decode(encryptedData);
		try {
			return new String(decrypter.doFinal(decryptedData));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}