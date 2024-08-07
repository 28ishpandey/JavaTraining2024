package bank.Banking.Account;

import bank.Banking.entity.Account;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;

@Component
public class Current extends Account {
    @Override
    public void withdraw(Long amount) {
        this.setBalance(this.getBalance() - amount);
        this.setWithdrawalCount(this.getWithdrawalCount() + 1);
    }

    @Override
    public void deposit(Long amount) {
        this.setBalance(this.getBalance() + amount);
        this.setDepositCount(this.getDepositCount() + 1);
    }
}
