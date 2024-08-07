package bank.Banking.controller;

import bank.Banking.dto.AccountDTO;
import bank.Banking.dto.AmountDTO;
import bank.Banking.entity.Account;
import bank.Banking.entity.AccountType;
import bank.Banking.entity.Customer;
import bank.Banking.service.AccountService;
import bank.Banking.util.BankConstants;
import bank.Banking.util.BankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody AccountDTO accountDTO){
        try{
            return accountService.createAccount(accountDTO);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return BankUtil.getResponseEntity(BankConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/withdraw/{id}")
    public ResponseEntity<String> withdraw(@PathVariable Integer id, @RequestBody AmountDTO amountDTO){
        try {
            accountService.withdraw(id, amountDTO.getAmount());
            return ResponseEntity.ok("Withdrawal successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/deposit/{id}")
    public ResponseEntity<String> deposit(@PathVariable Integer id, @RequestBody Long amount) {
        try {
            accountService.deposit(id, amount);
            return ResponseEntity.ok("Deposit successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAllAccount(){
        try {
            List<Account> accountList = accountService.getAllAccount();
            return new ResponseEntity<>(accountList,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Integer id){
        try{
            return accountService.deleteAccount(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return BankUtil.getResponseEntity(BankConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
