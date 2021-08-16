package com.troy.rest_mysql_demo.repos;

import com.troy.rest_mysql_demo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
