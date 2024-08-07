package bank.Banking.controllerTests;

import bank.Banking.controller.CustomerController;
import bank.Banking.entity.Customer;
import bank.Banking.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        when(customerService.createCustomer(any(Customer.class))).thenReturn(new ResponseEntity<>("Customer created", HttpStatus.OK));

        ResponseEntity<String> response = customerController.createCustomer(customer);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Customer created", response.getBody());
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer();
        when(customerService.getCustomerById(1)).thenReturn(Optional.of(customer));

        Optional<Customer> response = customerController.getCustomerById(1);
        assertEquals(customer, response.orElse(null));
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = Arrays.asList(new Customer(), new Customer());
        when(customerService.getAllCustomers()).thenReturn(new ResponseEntity<>(customers, HttpStatus.OK));

        ResponseEntity<List<Customer>> response = customerController.getAllCustomers();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers, response.getBody());
    }


    @Test
    public void testUpdateCustomerDetails() {
        Customer customer = new Customer();
        when(customerService.updateCustomerDetails(any(Customer.class))).thenReturn(new ResponseEntity<>("Customer updated", HttpStatus.OK));

        ResponseEntity<String> response = customerController.updateCustomerDetails(customer);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Customer updated", response.getBody());
    }
}
