package bank.Banking.Account;

import bank.Banking.entity.Account;

public class AccountFactory {

    public static Account createAccount(String accType){
        switch (accType){
            case "SAVINGS": return new Savings();

            case "CURRENT" : return new Current();

            case "FIXED_DEPOSIT" : return new FixedDeposit();

            default:
                throw new IllegalArgumentException("Invalid Account");
        }
    }
}
