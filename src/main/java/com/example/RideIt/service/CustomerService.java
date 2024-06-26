package com.example.RideIt.service;

import com.example.RideIt.dto.request.CustomerRequest;
import com.example.RideIt.dto.response.CustomerResponse;
import com.example.RideIt.model.Customer;
import com.example.RideIt.repository.CustomerRepository;
import com.example.RideIt.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        // dto >> entity
//        Customer customer = new Customer();
//
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setEmailId(customerRequest.getEmailId());
//        customer.setAddress(customerRequest.getAddress());
//        customer.setGender(customerRequest.getGender());

        // Using Builder to create entity

//        Customer customer = Customer.builder()
//                .name(customerRequest.getName())
//                .age(customerRequest.getAge())
//                .emailId(customerRequest.getEmailId())
//                .address(customerRequest.getAddress())
//                .gender(customerRequest.getGender())
//                .build();

        // Using Transformer request
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        // Save the customer
        Customer savedCustomer = customerRepository.save(customer);

        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public Customer getCustomerById(Integer id) throws Exception{

        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if(!optionalCustomer.isPresent()){
            throw new Exception("Customer Id is invalid");
        }

        Customer customer = optionalCustomer.get();
        return customer;

    }

    public CustomerResponse getCustomerInfo(Integer id) {

        Customer customer = customerRepository.findById(id).get();

        CustomerResponse result = new CustomerResponse();

        result.setName(customer.getName());
        result.setEmailId(customer.getEmailId());
        result.setAddress(customer.getAddress());

        return result;
    }

    public boolean deletCustomerById(Integer id) {

        if(customerRepository.existsById(id)){

            customerRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean updateCustomer(Integer id, CustomerRequest customerRequest) {

        if (customerRepository.existsById(id)){

            Customer existCustomer = customerRepository.findById(id).get();

               existCustomer.setAddress(customerRequest.getAddress());
               existCustomer.setEmailId(customerRequest.getEmailId());

                customerRepository.save(existCustomer);
                return true;
            }
        return false;
    }
}
