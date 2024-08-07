package bank.Banking.dto;

import bank.Banking.entity.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class AccountDTO {
    private Integer aId;
    private Long aNumber;
    private Long balance;
    private Integer cId;
    private AccountType aType;
    private Long withdrawalCount;
    private Long depositCount;

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
}
