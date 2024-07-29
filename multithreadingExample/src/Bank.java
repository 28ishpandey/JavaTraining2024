import java.util.Objects;

public class Bank {

    private long accountNo;
    private double accountBalance;

    public Bank(long accountNo, double accountBalance) {
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return accountNo == bank.accountNo && Double.compare(accountBalance, bank.accountBalance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo, accountBalance);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "accountNo=" + accountNo +
                ", accountBalance=" + accountBalance +
                '}';
    }
    public synchronized void deposit(double amount){
        if(amount>0){
            accountBalance += amount;
            System.out.println("depositing: " + amount);
            System.out.println("new balance after deposit: " + accountBalance);
        }
    }
    public synchronized void withdraw(double amount) throws InsufficientBalanceException{
        if(accountBalance>=amount){
            accountBalance -= amount;
            System.out.println("withdrawing: " + amount);
            System.out.println("new balance after withdrawal "+ accountBalance);
        }else {
            throw new InsufficientBalanceException();
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank(1,2000);
        Thread credit = new Thread(new Credit(bank));
        Thread debit = new Thread(new Debit(bank));
        credit.start();
        debit.start();

    }

}
