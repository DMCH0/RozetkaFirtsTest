package RozetkaPageLogic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ProductInfoPageLogic {

   public void writeProductInfoToFile(String productTitle, String productPrice) throws IOException {

       HashMap<String, String> productInfo = new HashMap<>();
       productInfo.put(productTitle, productPrice);

       FileWriter fileWriter = new FileWriter("product.txt");
       fileWriter.write(String.valueOf(productInfo));
       fileWriter.close();

   }
}
