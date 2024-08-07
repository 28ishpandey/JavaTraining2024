package bank.Banking.controller;

import bank.Banking.entity.Transaction;
import bank.Banking.service.TransactionService;
import bank.Banking.util.BankConstants;
import bank.Banking.util.BankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/viewTransaction/{aId}")
    public ResponseEntity<?> viewAllTransaction(@PathVariable Integer aId){
        List<Transaction> transactionList=transactionService.viewAllTransactionById(aId);
        if(transactionList.isEmpty())
            return BankUtil.getResponseEntity(BankConstants.NOT_FOUND,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }
    @GetMapping("/viewAllTransaction")
    public ResponseEntity<?> viewAll(){
        List<Transaction> transactionList=transactionService.viewAllTransaction();
        if(transactionList.isEmpty())
            return BankUtil.getResponseEntity(BankConstants.NOT_FOUND,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transactionList,HttpStatus.OK);
    }
}
