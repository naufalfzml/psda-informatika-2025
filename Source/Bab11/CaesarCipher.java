public class CaesarCipher {
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char encryptedChar = (char) (ch + shift);
                if ((Character.isLowerCase(ch) && encryptedChar > 'z') || (Character.isUpperCase(ch) && encryptedChar > 'Z')) {
                    encryptedChar = (char) (ch - (26 - shift));
                }
                result.append(encryptedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static void main(String[] args) {
        String plaintext = "Fatisda 2024";
        int shift = 3;

        String ciphertext = encrypt(plaintext, shift);
        System.out.println("Encrypted Text: " + ciphertext);

        String decryptedText = decrypt(ciphertext, shift);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}