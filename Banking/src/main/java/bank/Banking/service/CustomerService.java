package bank.Banking.service;

import bank.Banking.entity.Account;
import bank.Banking.entity.Customer;
import bank.Banking.repository.AccountRepository;
import bank.Banking.repository.CustomerRepository;
import bank.Banking.util.BankConstants;
import bank.Banking.util.BankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<String> createCustomer(Customer customer) {
        customerRepository.save(customer);
        return BankUtil.getResponseEntity(BankConstants.CREATED_SUCCESSFULLY, HttpStatus.OK);
    }

    public Optional<Customer> getCustomerById(Integer id){
        return customerRepository.findById(id);
    }

    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<String> deleteCustomer(Integer id){
        List<Account> account = accountRepository.findbyCId(id);
        for(Account accounts : account) {
                 accountRepository.delete(accounts);
        }
        customerRepository.deleteById(id);

        return BankUtil.getResponseEntity("Customer Deleted Successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> updateCustomerDetails(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getcId());
        if(optionalCustomer.isPresent()){
            Customer cust = optionalCustomer.get();

            cust.setcName(customer.getcName());
            cust.setcAddress(customer.getcAddress());
            cust.setcPhone(customer.getcPhone());

            customerRepository.save(cust);
            return BankUtil.getResponseEntity("Customer Updated Successfully",HttpStatus.OK);
        }
        return BankUtil.getResponseEntity("Customer Not Found", HttpStatus.BAD_REQUEST);

    }
}
