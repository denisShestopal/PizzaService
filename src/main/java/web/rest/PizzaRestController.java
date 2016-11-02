package web.rest;

import domain.Pizza;
import domain.enums.PizzaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.PizzaService;


@RestController // adds @ResponseBody to all methods
public class PizzaRestController {
    @Autowired
    private PizzaService pizzaService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String[] hello(){
        return new String[]{"Hello from rest Controller"};
    }

    @RequestMapping(value = "pizza/{pizzaID}", method = RequestMethod.GET)
    public Pizza returnPizzaById(@PathVariable("pizzaID") Long pizzaId){
//        return new String[]{"Hello from rest Controller"};
        if(! (pizzaId == 1))
            pizzaId = 1L;
        if (pizzaService.getById(pizzaId) == null)
        return new Pizza("pizza", 33.00, PizzaType.MEAT);
        else return pizzaService.getById(pizzaId);
    }

}
