package appRunners;


import domain.Customer;
import domain.Order;
import domain.Pizza;
import domain.enums.PizzaType;
import infrastructure.exceptions.PizzasOutOfBoundException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.OrderService;
import services.simple.SimpleOrderService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpringAppRunner {

    public static void main(String ... args){
        ConfigurableApplicationContext repoContext = new ClassPathXmlApplicationContext("repoContext.xml");
        System.out.println(Arrays.toString(repoContext.getBeanDefinitionNames()));
        //указываем, на основе какой конфигурации спринга работаем

        ConfigurableApplicationContext appContext =
                new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}, repoContext);



//        OrderService orderService = (OrderService) appContext.getBean("orderService");
//
//        orderService.addPizza("newone", 300.0, PizzaType.MEAT);
//        orderService.addCustomer("Vasya", "Kyiv", "K18a", true);
//
//        Order order1 = null;
//        try {
//            order1 = orderService.placeNewOrder(orderService.getCustomerById(1L), 1L, 1L, 1L, 1L, 1L);
//        } catch (PizzasOutOfBoundException e) {
//            e.printStackTrace();
//        }
////        order1.pay();
//        Order order2 = null;
//        try {
//            order2 = orderService.placeNewOrder(orderService.getCustomerById(1L), 1L, 1L);
//        } catch (PizzasOutOfBoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("TOTAL: " + order1.getTotalPrice());
//        System.out.println("TOTAL: " + order2.getTotalPrice());
//
//        System.out.println(order1);
//        System.out.println(order2);

        Customer customer = new Customer();
        Map<Pizza, Integer> pizzas = new HashMap<>();

        {
            Pizza pizza1 = new Pizza("Pizza #1", 30.00, PizzaType.MEAT);
            Pizza pizza2 = new Pizza("Pizza #2", 40.00, PizzaType.SEA);
            Pizza pizza3 = new Pizza("Pizza #3", 50.00, PizzaType.VEGETARIAN);

            pizzas.put(pizza1, 1);
            pizzas.put(pizza2, 2);
            pizzas.put(pizza3, 3);
        }


        SimpleOrderService simpleOrderService = new SimpleOrderService();
        try {
            simpleOrderService.placeNewOrder(customer, pizzas);
        } catch (PizzasOutOfBoundException e) {
            e.printStackTrace();
        }

        repoContext.close();
        appContext.close();

    }
}
