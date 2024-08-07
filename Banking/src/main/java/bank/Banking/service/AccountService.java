package bank.Banking.service;

import bank.Banking.Account.AccountFactory;
import bank.Banking.dto.AccountDTO;
import bank.Banking.entity.Account;
import bank.Banking.entity.Transaction;
import bank.Banking.repository.AccountRepository;
import bank.Banking.util.BankConstants;
import bank.Banking.util.BankUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    private TransactionService transactionService;

    public ResponseEntity<String> createAccount(AccountDTO accountDTO) {
        Account createdAccount = AccountFactory.createAccount(accountDTO.getaType().toString());
        createdAccount.setaNumber(accountDTO.getaNumber());
        createdAccount.setBalance(accountDTO.getBalance());
        createdAccount.setaType(accountDTO.getaType());
        createdAccount.setcId(accountDTO.getcId());
        accountRepository.save(createdAccount);
        return BankUtil.getResponseEntity(BankConstants.CREATED_SUCCESSFULLY, HttpStatus.OK);

    }
    @Transactional
    public void withdraw(Integer id, Long amount) throws Exception {
        Account account = accountRepository.findById(id).orElseThrow(() -> new Exception("Account not found"));
        account.withdraw(amount);
        accountRepository.save(account);
        transactionService.createTransaction(id,"credit",amount);
    }

    @Transactional
    public void deposit(Integer id, Long amount) throws Exception {
        Account account = accountRepository.findById(id).orElseThrow(() -> new Exception("Account not found"));
        account.deposit(amount);
        accountRepository.save(account);
        transactionService.createTransaction(id,"debit",amount);
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public ResponseEntity<String> deleteAccount(Integer id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            accountRepository.deleteById(id);
            return BankUtil.getResponseEntity(BankConstants.DELETED_SUCCESSFULLY,HttpStatus.OK);
        }
       else{
           return BankUtil.getResponseEntity(BankConstants.NOT_FOUND,HttpStatus.NOT_FOUND);
        }
    }

}
