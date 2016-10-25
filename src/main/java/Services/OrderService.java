package services;

import domain.Customer;
import domain.Order;
import domain.Pizza;
import infrastructure.exceptions.PizzasOutOfBoundException;
import repository.OrderRepository;
import org.springframework.context.ApplicationContext;
//import Test.infrastructure.ApplicationContext;

public interface OrderService {
    Order placeNewOrder(Customer customer, Long... pizzasId) throws PizzasOutOfBoundException;

    OrderRepository getInMemoryOrderRepository();

    PizzaService getPizzaService();

    Pizza getPizzaById(Long id);

    Pizza addPizzaToOrderById(Long orderId, Long pizzaId);

    Pizza removePizzaToOrderById(Long orderId, Long pizzaId);

    Customer getCustomerById(Long id);

    void saveOrder(Order newOrder);

    Integer getNumberOfOrders();

    void addPizza(String name, Double price, Pizza.PizzaType type);

    void addCustomer(String name, String city, String street, boolean hasCard);

    void payOrderById(Long id);

    void cancelOrderById(Long id);

    Double getTotalOrderPriceById(Long id);

}
