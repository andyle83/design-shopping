public abstract class Product {
    private final String name;
    private int price;
    private int discount;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPrice() {
        int shippingCost = calculateShippingCost();
        int priceWithDiscount = (int) (price * (100 - discount) / 100.0);
        return priceWithDiscount + shippingCost;
    }

    public abstract int calculateShippingCost();

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
