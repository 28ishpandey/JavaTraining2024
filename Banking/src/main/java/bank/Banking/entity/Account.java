package bank.Banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aId;
    private Long aNumber;
    private Long balance;
    private AccountType aType;

    public Account(Integer aId, Long aNumber, Long balance, AccountType aType) {
        this.aId = aId;
        this.aNumber = aNumber;
        this.balance = balance;
        this.aType = aType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aId=" + aId +
                ", aNumber=" + aNumber +
                ", balance=" + balance +
                ", aType=" + aType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(aId, account.aId) && Objects.equals(aNumber, account.aNumber) && Objects.equals(balance, account.balance) && aType == account.aType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aId, aNumber, balance, aType);
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Long getaNumber() {
        return aNumber;
    }

    public void setaNumber(Long aNumber) {
        this.aNumber = aNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public AccountType getaType() {
        return aType;
    }

    public void setaType(AccountType aType) {
        this.aType = aType;
    }
}
