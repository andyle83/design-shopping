import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Customer {
    private final String name;
    private Map<String, PaymentMethod> paymentMethods = new HashMap<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addPaymentMethod(String nickname, PaymentMethod paymentMethod) {
        paymentMethods.put(nickname, paymentMethod);
    }

    public Optional<Order> checkout(ShoppingCart shoppingCart, String paymentMethodNickname) {
        Optional<PaymentMethod> paymentMethod = Optional.ofNullable(paymentMethods.get(paymentMethodNickname));
        Optional<Payment> payment = paymentMethod.flatMap(pm -> pm.mkPayment(shoppingCart.getTotalCost()));
        return payment.map(value -> new Order(this, shoppingCart, value));
    }

    public int calculateDiscount() {
        return 0;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", paymentMethods=" + paymentMethods +
                '}';
    }
}
