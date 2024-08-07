package bank.Banking.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity

public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aId;
    private Long aNumber;
    private Long balance;
    private Integer cId;

    @Enumerated(EnumType.STRING)
    private AccountType aType;
    private Long withdrawalCount = 0L;
    private Long depositCount = 0L;


    public Account() {
    }

    public Account(Integer aId, Long aNumber, Long balance, Integer cId, AccountType aType, Long withdrawalCount, Long depositCount) {
        this.aId = aId;
        this.aNumber = aNumber;
        this.balance = balance;
        this.cId = cId;
        this.aType = aType;
        this.withdrawalCount = withdrawalCount;
        this.depositCount = depositCount;
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

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public AccountType getaType() {
        return aType;
    }

    public void setaType(AccountType aType) {
        this.aType = aType;
    }

    public Long getWithdrawalCount() {
        return withdrawalCount;
    }

    public void setWithdrawalCount(Long withdrawalCount) {
        this.withdrawalCount = withdrawalCount;
    }

    public Long getDepositCount() {
        return depositCount;
    }

    public void setDepositCount(Long depositCount) {
        this.depositCount = depositCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(aId, account.aId) && Objects.equals(aNumber, account.aNumber) && Objects.equals(balance, account.balance) && Objects.equals(cId, account.cId) && aType == account.aType && Objects.equals(withdrawalCount, account.withdrawalCount) && Objects.equals(depositCount, account.depositCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aId, aNumber, balance, cId, aType, withdrawalCount, depositCount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "aId=" + aId +
                ", aNumber=" + aNumber +
                ", balance=" + balance +
                ", cId=" + cId +
                ", aType=" + aType +
                ", withdrawalCount=" + withdrawalCount +
                ", depositCount=" + depositCount +
                '}';
    }

    public abstract void withdraw(Long amount) throws Exception;

    public abstract void deposit(Long amount) throws Exception;
}
