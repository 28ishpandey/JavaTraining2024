package bank.Banking.Account;

import bank.Banking.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class Savings extends Account {
    private static final int MAX_WITHDRAWALS = 10;
    private static final int MIN_BALANCE = 500;

    @Override
    public void withdraw(Long amount) throws Exception {
        if (this.getWithdrawalCount() >= MAX_WITHDRAWALS) {
            throw new Exception("Withdrawal limit exceeded");
        }
        if (this.getBalance() - amount < MIN_BALANCE) {
            throw new Exception("Minimum balance limit breached");
        }
        this.setBalance(this.getBalance() - amount);
        this.setWithdrawalCount(this.getWithdrawalCount() + 1);
    }

    @Override
    public void deposit(Long amount) {
        this.setBalance(this.getBalance() + amount);
        this.setDepositCount(this.getDepositCount() + 1);
    }
}
