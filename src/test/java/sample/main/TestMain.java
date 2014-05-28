package sample.main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		String a = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append(a).append("abc");
		
		System.out.println(sb);
		
		long lngStart = 0;
		long lngEnd = 0;
		lngStart = System.currentTimeMillis();
/*
		String dailyQuestTalon = "i7kvlrLB9Qi9Pn3Y7lrBBDWyCac4uXcwAzv6vBCDFSA=";
		String dailyQuestBoard = "6lm4SFYAWLbkLZ/sMmp3coEV5Ca8L9NcnwKLLs+yB/k=";

		
		try {
			
			CipherUtils cipher = new CipherUtils("TlzWd$sj9qLdUjs0");

			System.out.println(cipher.decrypt(dailyQuestBoard));
			System.out.println(cipher.decrypt(dailyQuestTalon));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		lngEnd = System.currentTimeMillis();

		long lngResult = lngEnd - lngStart;

		System.out.println(">>>>>>>>>>" + lngResult);

	}

}
