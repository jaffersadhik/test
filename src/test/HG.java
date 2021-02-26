package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.naming.ldap.HasControls;

public class HG {

	public static void main(String args[]){
		
		new HG().hashGenerator("username", "senderId", "content", "secureKey");
	}
	
	public String hashGenerator(String userName, String senderId, String content, String secureKey) {
		// TODO Auto-generated method stub
		StringBuffer finalString=new StringBuffer();
		finalString.append(userName.trim()).append(senderId.trim()).append(content.trim()).append(secureKey.trim());
		// logger.info("Parameters for SHA-512 : "+finalString);
		String hashGen=finalString.toString();		
		System.out.println(hashGen);
		StringBuffer sb=new StringBuffer();
		MessageDigest md;
		MessageDigest md1;

		try {
		md = MessageDigest.getInstance("SHA-512");
		md.update(hashGen.getBytes());
		byte byteData[] = md.digest();
		//convert the byte to hex format method 1
		sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
		sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		System.out.println(sb.toString());

		
		try {
			md1 = MessageDigest.getInstance("SHA-512");
			
			byte byteData[]=md1.digest(sb.toString().getBytes());
			System.out.println(new String(byteData));
			} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return sb.toString();
		}
}
