import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtils {
   private static final String ALGORITHM = "AES";
   private static final String TRANSFORMATION = "AES";

   public static void encrypt(String var0, File var1, File var2) throws CryptoException {
      doCrypto(1, var0, var1, var2);
   }

   public static void decrypt(String var0, File var1, File var2) throws CryptoException {
      doCrypto(2, var0, var1, var2);
   }

   private static void doCrypto(int var0, String var1, File var2, File var3) throws CryptoException {
      try {
         SecretKeySpec var4 = new SecretKeySpec(var1.getBytes(), "AES");
         Cipher var5 = Cipher.getInstance("AES");
         var5.init(var0, var4);
         FileInputStream var6 = new FileInputStream(var2);
         byte[] var7 = new byte[(int)var2.length()];
         var6.read(var7);
         byte[] var8 = var5.doFinal(var7);
         FileOutputStream var9 = new FileOutputStream(var3);
         var9.write(var8);
         var6.close();
         var9.close();
      } catch (NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | IOException | NoSuchPaddingException var10) {
         throw new CryptoException("Error encrypting/decrypting file", var10);
      }
   }
}