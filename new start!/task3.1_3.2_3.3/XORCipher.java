package info2;

public class XORCipher {
    
    //
    // This table contains 64 possible chars that are
    // used as alphabet for this encryption exercise.
    // We can use 6 bits (e.g. the most right 6 bits of an
    // int value) to uniquely encode a character.
    //
    public static char[] CHAR_TABLE = {
        ' ', '\n', ',', '.', '\'', '-', ':', ';', '?', '(', ')', '!',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z', 
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z'
    };
    
    // ----------------------------------------------------------------
    // Exercise 2 (a)
    // ----------------------------------------------------------------
    public static char valueToChar(int code) {
    	
    	if (code < 0 || code > 63) {
    		return ' ';
    	}
    	
    	return CHAR_TABLE[code];
    	
    }
    // TODO: implement valueToChar
    
    
    
    // ----------------------------------------------------------------
    // Exercise 2 (b) 
    // ----------------------------------------------------------------
    public static int charToValue(char chr) {
    	
    	int value = 0;
    	
    	int i = 0;
    	while (CHAR_TABLE[i] != chr) {
    		i++;
    		if (i > 63) {
    			return 0;
    		}
    		value = i;
    	}
    	
    	return value;
    }
    // TODO: implement charToValue
    
    
    
    // ----------------------------------------------------------------
    // Exercise 2 (c)
    // ----------------------------------------------------------------
    public static int[] stringToValues(String str) {
    	
    	if (str == null) {
    		int[] value = new int[0];
    		return value;
    	}
    	
    	int[] value = new int[str.length()];
    	for (int i = 0; i < str.length(); i++) {
    		value[i] = charToValue(str.charAt(i));
    	}
    	
    	return value;
    }
    // TODO: implement stringToValue
    
    
    
    // ----------------------------------------------------------------
    // Exercise 2 (d)
    // ----------------------------------------------------------------
    public static String valuesToString(int[] codes) {
    	
    	if (codes == null) {
    		return "";
    	}
    	
    	String str = "";
    	for (int i = 0; i < codes.length; i++) {
    		str += valueToChar(codes[i]);
    	}
    	
    	return str;
    }
    // TODO: implement valuesToString
    
    
    
    // ----------------------------------------------------------------
    // Exercise 2 (e)
    // ----------------------------------------------------------------
    public static int[] encryptDecrypt(int[] msg, int[] key) {
    	
    	if (msg == null || key == null) {
    		return msg;
    	}
    	
    	int[] cipher = new int[msg.length];
    	for (int i = 0; i < msg.length; i++) {
    		if (i < key.length) {
    			cipher[i] = msg[i] ^ key[i];
    		} else {
    			cipher[i] = msg[i] ^ key[i % key.length];
    		}
    	}
    	
    	return cipher;
    }
    // TODO: implement encryptDecrypt for type int[]


    
    // ----------------------------------------------------------------
    // Exercise 2 (f)
    // ----------------------------------------------------------------
    public static String encryptDecrypt(String msg, String key) {
    	
    	int[] intmsg = stringToValues(msg);
    	int[] intkey = stringToValues(key);
    	int[] cipher = encryptDecrypt(intmsg, intkey);
    	String str = valuesToString(cipher);
    	
    	return str;
    }
    // TODO: implement encryptDecryot for type String
        

    
    
    // ----------------------------------------------------------------
    
    public static void main(String[] args) {
        final String msg = "Dieser Text ist sehr geheim...";
        final String key = "keyword";
        
        final String cipher = encryptDecrypt(msg, key);
        final String decrypted = encryptDecrypt(cipher, key);
        
        //
        // Wenn alles richtig implementiert wurde, sollte
        // der String decrypted wieder genau dem String 
        // msg entsprechen, waehrend der String cipher fuer
        // uns nicht lesbar ist.
        //
        
        System.out.println(msg);
        System.out.println(cipher);
        System.out.println(decrypted);
        
        System.out.println();
        
    }
}