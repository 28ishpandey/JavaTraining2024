import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private Integer accountId;
    private int customer;
    Double balance;
    List<String> transactionList = new ArrayList<>();

    public Account(Integer accountId, int customer, Double initialBalance) {
        this.accountId = accountId;
        this.customer = customer;
        this.balance = initialBalance;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<String> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<String> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", customer=" + customer +
                ", balance=" + balance +
                ", transactionList=" + transactionList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) && Objects.equals(customer, account.customer) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, customer, balance);
    }

    public void credit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("credited: "+ amount + " balance: " + balance);
            transactionList.add("credited: "+ amount + " balance: " + balance);
        } else {
            System.out.println("Amount to credit must be positive.");
        }
    }


    public void debit(double amount) throws AllException.InvalidAmountException {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("debited: "+ amount + " balance: " + balance);
            transactionList.add("debited: "+ amount + " balance: " + balance);
        } else {

            throw new AllException.InvalidAmountException();
        }
    }


    public void transferTo(Integer otherAccountId, double amount,List<Account> accountList) throws AllException.AccountNotFoundException {
        accountList.forEach(account -> {
            if (account.getAccountId().equals(otherAccountId)){
                try {
                    this.debit(amount);
                } catch (AllException.InvalidAmountException e) {
                    System.out.println(e.getMessage());
                }
                account.credit(amount);
                transactionList.add("from account: " + this.accountId+ " to account : " + otherAccountId);
                return;
            }
        });
        throw new AllException.AccountNotFoundException();

    }
    public void getCustomerName(List<Customer> cList){
        for(Customer c: cList){
            if(customer==c.getId()){
                System.out.println(c.getName());
                break;
            }
        }
    }
    public void getAllTransactionsOfCustomer(List<Customer> cList){
        System.out.println("account no: " + accountId );
        getCustomerName(cList);
        for(String transaction: transactionList){
            System.out.println(transaction);
        }
        transactionList.forEach(System.out::println);
    }

}
