import Domain.Customer;
import Domain.Order;
import Infrastructure.Context.ApplicationContext;
import Infrastructure.Context.Context;
import Infrastructure.Config.JavaConfig;
import Repository.PizzaRepository;
import Services.OrderService;

public class PizzaApp {

    public static void main(String[] args) {
                System.out.println("Pizza Service");
        Context context = new ApplicationContext(new JavaConfig());

        Customer customer = new Customer();
        OrderService orderService = context.getBean("orderService");
        Order order = orderService.placeNewOrder(customer, 1L, 2L, 3L);
        System.out.println(order);
    }
}
