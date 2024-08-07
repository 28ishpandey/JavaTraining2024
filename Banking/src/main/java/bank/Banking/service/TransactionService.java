package bank.Banking.service;

import bank.Banking.entity.Transaction;
import bank.Banking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Integer aId,String operation,Long amount){
        Transaction transaction=new Transaction();
        transaction.setaId(aId);
        transaction.setAmount(amount);
        transaction.setDateTime(LocalDateTime.now());
        transaction.setOperation(operation);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> viewAllTransactionById(Integer aId) {
        return transactionRepository.findAllByAId(aId);
    }

    public List<Transaction> viewAllTransaction() {
        return transactionRepository.findAll();
    }
}
