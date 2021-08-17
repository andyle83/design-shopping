public class Order {
    private Customer customer;
    private ShoppingCart shoppingCard;
    private Payment payment;

    public Order(Customer customer, ShoppingCart shoppingCard, Payment payment) {
        this.customer = customer;
        this.shoppingCard = shoppingCard;
        this.payment = payment;
    }

    public ShoppingCart getShoppingCard() {
        return this.shoppingCard;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", shoppingCard=" + shoppingCard +
                ", payment=" + payment +
                '}';
    }
}
