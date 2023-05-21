package info2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CodeCracking {
    
    //
    // Reads text file into String.
    //
	
    public static String readFromFile(final String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            return null;
        }
    }
    
    public static String findKey(String cipher) {
    	
    	String[] wordsToFind = {"bedrooms", "bathrooms"};
    	String key = "";
    	
        // Durchlaufen aller moeglichen Startpositionen der Woerter
    	// Nur die Idee, weil es zu lange Zeit dauert
        for (int i = 0; i < XORCipher.CHAR_TABLE.length; i++) {
            for (int j = 0; j < XORCipher.CHAR_TABLE.length; j++) {
                for (int k = 0; k < XORCipher.CHAR_TABLE.length; k++) {
                    for (int l = 0; l < XORCipher.CHAR_TABLE.length; l++) {
                        for (int m = 0; m < XORCipher.CHAR_TABLE.length; m++) {
                            for (int n = 0; n < XORCipher.CHAR_TABLE.length; n++) {
                                for (int o = 0; o < XORCipher.CHAR_TABLE.length; o++) {
                                    for (int p = 0; p < XORCipher.CHAR_TABLE.length; p++) {
                                        String possibleKey = "" +
                                            XORCipher.CHAR_TABLE[i] +
                                            XORCipher.CHAR_TABLE[j] +
                                            XORCipher.CHAR_TABLE[k] +
                                            XORCipher.CHAR_TABLE[l] +
                                            XORCipher.CHAR_TABLE[m] +
                                            XORCipher.CHAR_TABLE[n] +
                                            XORCipher.CHAR_TABLE[o] +
                                            XORCipher.CHAR_TABLE[p];

                                        String decryptedText = XORCipher.encryptDecrypt(cipher, possibleKey);

                                        for (String word : wordsToFind) {
                                            if (decryptedText.contains(word)) {
                                                key = possibleKey;
                                                return key;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    	
    	return key;
    }
    
    public static void main(String[] args) {
        
        final String cipher = readFromFile("./cipher.txt");
        final String key = findKey(cipher);
        final String decrypted = XORCipher.encryptDecrypt(cipher, key);
        
        System.out.println(cipher);
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println(decrypted);

    }
}