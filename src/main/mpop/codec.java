package mpop;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

public class codec
{
	public static class specials{
		public static final String reverse(String str){
			String a = "";
			for(int b = str.length() - 1; b >= 0; b--){
				a += str.charAt(b);
			}
			return a;
		}
		public static final String jejemon(String str){
			String a = "";
			for(String b : str.split("")){
				Random c = new Random();
				int d = c.nextInt(3);
				if(d > 0){
					b = b.toUpperCase();
				}else{
					b = b.toLowerCase();
				}
				a += b;
			}
			return a;
		}
	}
	public static class encryption{
		public static final String toMD5(String str){
			return enc("MD5",str);
		}
		public static final String toSha1(String str){
			return enc("SHA-1",str);
		}
		public static final String toSha256(String str){
			return enc("SHA-256",str);
		}
		static final String enc(String encType,String str){
			try{
				MessageDigest a = MessageDigest.getInstance(encType);
				byte[] b = a.digest(str.getBytes());
				BigInteger c = new BigInteger(1,b);
				String d = c.toString(16);
				while(d.length() < 32){
					d = "0" + d;
				}
				return d;
			}catch(NoSuchAlgorithmException a){
				throw new RuntimeException(a);
			}
		}
	}
	public static class base32{
		public static final String toString(String str){
			StringBuffer a = new StringBuffer();
			for(int b = 0; b < str.length() - 1; b += 2){
				a.append((char)Integer.parseInt(str.substring(b,b + 2),16));
			}
			return new String(a);
		}
		public static final String toBase32(String str){
			byte[] a = new Base32().encode(str.getBytes(),0,0);
			//String b = new Base32().encodeAsString(a);
			
			return new String(a);
		}
	}
	public static class base64{
		public static final String toBase64(String base64){
			byte[] a = new byte[0];
			a = Base64.encode(base64.getBytes(),0);
			return new String(a);
		}
		public static final String toString(String str){
			byte[] a = new byte[0];
			try
			{
				a = Base64.decode(str.getBytes("UTF-8"), 0);
			}
			catch (UnsupportedEncodingException e)
			{
				Log.d("Error",e.getMessage());
			}
			return new String(a);
		}
	}
	public static class binary{
		public static final String toBinary(String str){
			byte[] a = str.getBytes();
			StringBuilder b = new StringBuilder();
			for(byte c : a){
				b.append(new StringBuffer().append(Integer.toBinaryString(c)).append(" ").toString());
			}
			return new String(b);
		}
		public static final String toString(String str){
			StringBuilder a = new StringBuilder();
			String[] b = str.split(" ");
			for(String c : b){
				a.append((char)Integer.parseInt(c,2));
			}
			return new String(a);
		}
	}
	public static class hex{
		public static final String toString(String hex){
			StringBuffer a = new StringBuffer();
			for(int b = 0; b < hex.length() - 1; b += 2){
				a.append((char) Integer.parseInt(hex.substring(b, b + 2), 16));
			}
			return new String(a);
		}
		public static final String toHex(String str){
			byte[] a = str.getBytes();
			String b = Arrays.toString(Hex.encodeHex(a)).replace(" ","").replace("[","").replace("]","").replace(",","").toUpperCase();
			return new String(b);
		}
	}
	public static class morse{
		static final String[] a = new String[]{
			".-",
			"-...",
			"-.-.",
			"-..",
			".",
			"..-.",
			"--.",
			"....",
			"..",
			".---",
			"-.-",
			".-..",
			"--",
			"-.",
			"---",
			".--.",
			"--.-",
			".-.",
			"...",
			"-",
			"..-",
			"...-",
			".--",
			"-..-",
			"-.--",
			"--..",
			"/",
			".----",
			"..---",
			"...--",
			"....-",
			".....",
			"-....",
			"--...",
			"---..",
			"----.",
			"-----"
		};
		static final char[] b = new char[]{
			'a','b','c','d','e',
			'f','g','h','i','j',
			'k','l','m','n','o',
			'p','q','r','s','t',
			'u','v','w','x','y',
			'z',' ','1','2','3','4',
			'5','6','7','8','9','0'
		};
		public static final String toMorse(String str){
			String e = str.toLowerCase();
			char[] f = e.toCharArray();
			for(int g = 0; g < f.length; g++){
				for(int h = 0; h < b.length; h++){
					if(f[g] == b[h]){
						e += a[h] + " ";
					}
				}
			}
			return new String(e.replace(str.toLowerCase(),""));
		}
	}
	public static class ascii{
		public static final String toAscii(String str){
			byte[] a = str.getBytes();
			return Arrays.toString(a).replace("[","").replace("]","");
		}
		public static final String toString(String str){
			
			
			return "";
		}
		public static final String str(int... intArr){
			int[] a = intArr;
			String b = "";
			for(int c : intArr){
				b += Character.toString((char)c);
			}
			return b;
		}
	}
}
