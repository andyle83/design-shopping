import java.util.Map;

public class Catalogue {
    public final static int SHIPPING_RATE = 5;

    private static Map<String, Product> productMap = Map.of(
            "Electric Toothbrush", new DigitalProduct("Electric Toothbrush", 3550),
            "Baby Alarm", new PhysicalProduct("Baby Alarm", 499, 20)
    );

    public static Product getProduct(String productName) {
        return productMap.get(productName);
    }
}
