package com.ai.bss.query.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ai.bss.query.api.customer.CustomerEntry;
import com.ai.bss.query.customer.repositories.CustomerQueryRepository;

@RestController
@RequestMapping("/customer")
public class CustomerQueryRestController {
	@Autowired
	private CustomerQueryRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CustomerEntry> get() {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public CustomerEntry details(@PathVariable String customerId) {
        return customerRepository.findOne(customerId);
    }
}
