public class DigitalProduct extends Product {
    public DigitalProduct(String productName, int price) {
        super(productName, price);
    }

    @Override
    public int calculateShippingCost() {
        return 0;
    }
}
