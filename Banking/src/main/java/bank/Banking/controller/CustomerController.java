package bank.Banking.controller;

import bank.Banking.entity.Customer;
import bank.Banking.service.CustomerService;
import bank.Banking.util.BankConstants;
import bank.Banking.util.BankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        try{
            customerService.createCustomer(customer);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return BankUtil.getResponseEntity(BankConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getCustomerById(@PathVariable Integer id ){
        try{
            customerService.getCustomerById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return BankUtil.getResponseEntity(BankConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        try{
            customerService.getAllCustomers();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> createCustomer(@PathVariable Integer id){
        try{
            customerService.deleteCustomer(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return BankUtil.getResponseEntity(BankConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
