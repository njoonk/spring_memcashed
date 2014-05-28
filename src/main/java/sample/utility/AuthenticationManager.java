package sample.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthenticationManager {
	private static final String DEFAULT_ALGORITHM = "MD5";

	public static final String createDigestByIdentity(String identity, int length) throws NoSuchAlgorithmException{
		return createDigestByIdentity(identity, length, DEFAULT_ALGORITHM); 
	}

	public static final String createDigestByIdentity(String identity, int length, String algorithm) throws NoSuchAlgorithmException{
		String result = createDigestByIdentity(identity, algorithm);
		
		return result != null && result.length() > length ? 
				result.substring(0, length) : 
				result;
	}

	public static final String createDigestByIdentity(String identity) throws NoSuchAlgorithmException{
		return createDigestByIdentity(identity, DEFAULT_ALGORITHM);
	}

	private static final String bytesToHex(byte[] data){
		return bytesToHex(data, false);
	}

	private static final String bytesToHex(byte[] data, boolean upper) {
		StringBuffer result = new StringBuffer();		
		for(int index = 0 ; data.length > index ; index++){
			int n = data[index] & 0xff;
			String digest = null;
			if(upper) {
				digest = Integer.toHexString(n).toUpperCase();
			} else {
				digest = Integer.toHexString(n).toLowerCase();
			}
			if(digest.length() == 1)
				digest = "0" + digest;
			result.append(digest);
		}
		return result.toString();
	}

	public static final String createDigestByIdentity(String identity, String algorithm) throws NoSuchAlgorithmException{ 
		String result = null;

		MessageDigest md = MessageDigest.getInstance(algorithm);
		md.update(identity.getBytes());
		byte[] digest = md.digest();
		result = bytesToHex(digest);

		return result;
	}

	public static final String createDigest(String sessionid) {
		byte[] defaultBytes = sessionid.getBytes();

		try{
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(defaultBytes);
			byte messageDigest[] = algorithm.digest();
		            
			StringBuffer hexString = new StringBuffer();
			for (int i=0;i<messageDigest.length;i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			String foo = messageDigest.toString();
			System.out.println("sessionid "+sessionid+" md5 version is "+hexString.toString());
			sessionid=hexString+"";
		}catch(NoSuchAlgorithmException nsae){
		            
		}

		return sessionid;

	}
}
