package com.example.RideIt.controller;

import com.example.RideIt.dto.request.CustomerRequest;
import com.example.RideIt.dto.response.CustomerResponse;
import com.example.RideIt.model.Customer;
import com.example.RideIt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody CustomerRequest customerRequest){

        String response = customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity getCustomerById(@PathVariable("id") Integer Id){


        try{
            Customer customer = customerService.getCustomerById(Id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/info")
    public CustomerResponse getCustomerInfo(@RequestParam Integer Id){

        CustomerResponse customerResponse = customerService.getCustomerInfo(Id);
        return customerResponse;

    }

    @DeleteMapping("/{Id}")
    public String deletCustomerById(@PathVariable Integer Id){

        boolean isDelete = customerService.deletCustomerById(Id);

        if(isDelete){
            return "Customer with ID " + Id + " deleted successfully.";
        } else {
            return "Customer with ID " + Id + " not found.";
        }
    }

    // Update Customer record
    @PutMapping("/{Id}")
    public String updateCustomer(@PathVariable Integer Id, @RequestBody CustomerRequest customerRequest){

        boolean isUpdated = customerService.updateCustomer(Id, customerRequest);

        if(isUpdated){
            return "Customer with ID " + Id + " updated successfully.";
        } else {
            return "Customer with ID " + Id + " not found.";
        }
    }
}
