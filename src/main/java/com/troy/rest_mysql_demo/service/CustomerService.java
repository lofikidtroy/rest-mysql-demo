package com.troy.rest_mysql_demo.service;

import com.troy.rest_mysql_demo.domain.Customer;
import com.troy.rest_mysql_demo.model.CustomerDTO;
import com.troy.rest_mysql_demo.repos.CustomerRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> mapToDTO(customer, new CustomerDTO()))
                .collect(Collectors.toList());
    }

    public CustomerDTO get(final Long id) {
        return customerRepository.findById(id)
                .map(customer -> mapToDTO(customer, new CustomerDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final CustomerDTO customerDTO) {
        final Customer customer = new Customer();
        mapToEntity(customerDTO, customer);
        return customerRepository.save(customer).getId();
    }

    public void update(final Long id, final CustomerDTO customerDTO) {
        final Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(customerDTO, customer);
        customerRepository.save(customer);
    }

    public void delete(final Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapToDTO(final Customer customer, final CustomerDTO customerDTO) {
        customerDTO.setId(customer.getId());
        customerDTO.setBan(customer.getBan());
        customerDTO.setCustomerName(customer.getCustomerName());
        customerDTO.setCustomerStanding(customer.getCustomerStanding());
        customerDTO.setActiveLines(customer.getActiveLines());
        customerDTO.setRemainingBalance(customer.getRemainingBalance());
        return customerDTO;
    }

    private Customer mapToEntity(final CustomerDTO customerDTO, final Customer customer) {
        customer.setBan(customerDTO.getBan());
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerStanding(customerDTO.getCustomerStanding());
        customer.setActiveLines(customerDTO.getActiveLines());
        customer.setRemainingBalance(customerDTO.getRemainingBalance());
        return customer;
    }

}
