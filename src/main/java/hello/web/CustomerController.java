package hello.web;

import hello.Customer;
import hello.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public void createCustomer() {
        Customer customer = new Customer("Test", "IM");
        repository.save(customer);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Customer getCustomer() {
        return repository.findByLastName("IM").get(0);
    }
}
