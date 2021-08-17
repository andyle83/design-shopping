import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        // simulate database access
        Product toothbrush = Catalogue.getProduct("Electric Toothbrush");
        Product babyAlarm = Catalogue.getProduct("Baby Alarm");

        shoppingCart.addLineItem(toothbrush, 2);
        shoppingCart.addLineItem(babyAlarm, 3);

        // single responsibility
        Customer customer = new Customer("Andy Le");
        customer.addPaymentMethod("Anh's Credit Card", new CreditCard(623468624L));
        Optional<Order> order = customer.checkout(shoppingCart, "Anh's Credit Card Failed");
        Optional<Order> retryOrder = customer.checkout(shoppingCart, "Anh's Credit Card");

        // demo for defensive by encapsulation
        System.out.println(order);
        order.ifPresent(Main::fulfil);
        System.out.println(order);

        System.out.println(retryOrder);
        retryOrder.ifPresent(Main::fulfil);
        System.out.println(retryOrder);

        // demo for inheritance with stream
        Customer janeDoe = new Customer("Jane Doe");
        janeDoe.addPaymentMethod("Jane's Credit Card", new CreditCard(6486486286482L));
        janeDoe.addPaymentMethod("Jane's Bank Account", new BankAccount(37837, 97979979L));
        Customer acme = new BusinessCustomer("Acme Products", BusinessCustomer.BusinessSize.LARGE);
        Customer globex = new BusinessCustomer("Globex Corp", BusinessCustomer.BusinessSize.LARGE);
        Customer saveTheWorld = new NonProfitCustomer("Save the World");

        // count how many customer are one each discount rate
        // with function style - declarative style
        List<Customer> customers = List.of(janeDoe, acme, globex, saveTheWorld);
        Map<Integer, Long> discountMap = customers.stream()
                .collect(Collectors.groupingBy(Customer::calculateDiscount, Collectors.counting()));
        System.out.println(discountMap);

        // alternative way
        discountMap = new HashMap<>();
        for (Customer c : customers) {
            discountMap.merge(c.calculateDiscount(), 1L, Long::sum);
        }
    }

    public static void fulfil(Order order) {
        ShoppingCart shoppingCart = order.getShoppingCard();
        boolean shippingUnfinished;

        // simulate fulfil process ( take item out of stock )
        do {
            shippingUnfinished = false;
            // using iterator since it allows us to remove item inside the loop
            for(Iterator<LineItem> it = shoppingCart.getLineItems().iterator(); it.hasNext();) {
                LineItem lineItem = it.next();

                if (Math.random() > 0.7) {
                    shippingUnfinished = true;
                    System.out.println(lineItem.getProduct() + " is out of stock");
                } else {
                    // fulfil and remove
                    it.remove();
                }
            }
        } while (shippingUnfinished);
    }
}
