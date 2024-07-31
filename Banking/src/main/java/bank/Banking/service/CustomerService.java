package bank.Banking.service;

import bank.Banking.entity.Customer;
import bank.Banking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {

        customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Integer id){
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void deleteCustomer(Integer id){
        customerRepository.deleteById(id);
    }

}
