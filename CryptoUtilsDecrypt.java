import java.io.File;

public class CryptoUtilsDecrypt {
    public static void main(String[] args) {
        System.out.println("6343412643c9f99b35ca18ef20903cfc");

        String password = "bYa8mOvRTQRaBAZp";
        File inputFile = new File("flag.enc");
        File outputFile = new File("output.txt");

        try {
            byte[] decryptedContent = CryptoUtils.decrypt(password, inputFile);
            String decryptedText = new String(decryptedContent);
            
            System.out.println("Decrypted Content: " + decryptedText);

            // Optionally, write the decrypted content to a file
            // Files.write(outputFile.toPath(), decryptedContent);
        } catch (CryptoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
