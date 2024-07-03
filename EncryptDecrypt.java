import java.util.*;

public class EncryptDecrypt{
    public static String decrypt(String encryptedMessage){

        String[]  words = encryptedMessage.split(" ");
        Collections.reverse(Arrays.asList(words));

        // Initializing the Result String
        StringBuilder decryptedMessage = new StringBuilder();

        // Iterate over each word and expand it
        for(String word : words){
            StringBuilder expandedWord = new StringBuilder();
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                // if the present character is a digit then repeat the previous Character
                if(Character.isDigit(c)){
                    int count = Character.getNumericValue(c);
                    for(int j=0;j<count -1;j++){
                        expandedWord.append(word.charAt(i-1));
                    }
                }
                else{
                    // if it's a letter then appent it to the expandedWord
                    expandedWord.append(c);
                }
            }
            // Now add the expandedWord to the result
            decryptedMessage.append(expandedWord.toString()).append(" ");
        }
        return decryptedMessage.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextLine()){
            String encryptedMessage = scanner.nextLine();
            String result = decrypt(encryptedMessage);
            System.out.println(result);
        }
        scanner.close();
    }

}