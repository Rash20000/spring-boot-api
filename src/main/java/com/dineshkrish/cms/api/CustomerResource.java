package com.dineshkrish.cms.api;

import com.dineshkrish.cms.model.Customer;
import com.dineshkrish.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/customers") //brokerage-transaction-v2
public class CustomerResource {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/{route}")
    public void addCustomer(@PathVariable String route,@RequestBody String data) throws IOException {
        Map map = mapper.readValue(data, Map.class);

        System.out.println("route\t"+route+"\tdata\t:"+map);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
    }
}
