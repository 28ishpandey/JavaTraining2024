package bank.Banking.Account;

import bank.Banking.entity.Account;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;

@Component
public class FixedDeposit extends Account {
    @Override
    public void withdraw(Long amount) throws Exception{
        if (this.getWithdrawalCount() > 0) {
            throw new Exception("Only one withdrawal allowed");
        }
        this.setBalance(this.getBalance() - amount);
        this.setWithdrawalCount(this.getWithdrawalCount() + 1);
    }

    @Override
    public void deposit(Long amount) throws Exception {
        if (this.getDepositCount() > 0) {
            throw new Exception("Only one deposit allowed");
        }
        this.setBalance(this.getBalance() + amount);
        this.setDepositCount(this.getDepositCount() + 1);
    }
}
