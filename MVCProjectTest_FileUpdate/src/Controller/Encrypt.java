package Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
	static MessageDigest md;
	static StringBuffer sb;
	public static String getEncryption(String userPw) {
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        md.update(userPw.getBytes());
        byte byteData[] = md.digest();
        sb = new StringBuffer(); 
        for(int i = 0 ; i < byteData.length ; i++){
           sb.append(
        		   Integer.toString(
        				   (byteData[i]&0xff) + 0x100, 16).substring(1));
        }
		return sb.toString();
	}
}
