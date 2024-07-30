import java.util.ArrayList;
import java.util.List;

public class Bank {

    public static void creditOrDebit(Account account, int amount, String operation){
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if(operation.equals("+")){
            account.credit(amount);
        }
        else if(operation.equals("-")) {
            try{
                account.debit(amount);
            }
            catch (AllException.InvalidAmountException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void transferTo(Account account, int cId, int amount, List<Account> aList){
        try {
            account.transferTo(cId, amount, aList);
        }
        catch (Exception e){

        }
    }

    public static void main(String[] args) {

        Customer customer1 = new Customer(1, "Akansha", Gender.FEMALE);
        Customer customer2 = new Customer(1, "Aditya", Gender.MALE);
        Customer customer3 = new Customer(3, "Aditya", Gender.MALE);
        Customer customer4 = new Customer(4, "olivia", Gender.OTHER);

        List<Customer> cList = new ArrayList<>();
        cList.add(customer1);
        cList.add(customer2);
        cList.add(customer3);
        cList.add(customer4);

        Account account1 = new Account(101, 1, 1000.0);
        Account account2 = new Account(102, 2, 1500.0);
        Account account3 = new Account(103, 3, 5000.0);

        List<Account> aList = new ArrayList<>();
        aList.add(account1);
        aList.add(account2);
        aList.add(account3);

        creditOrDebit(account1,200,"+");

        creditOrDebit(account2,100,"-");

        transferTo(account3, 101, 300, aList);


        System.out.println("customer list : " + cList);
        System.out.println("account list: " + aList);

        if (customer1 != null) {
            customer1.getNumberOfCustomersByGender(cList);
        }

        List<String> genderNames = Customer.getAllGenderNames();
        if (genderNames != null) {
            System.out.println("Gender Names: " + genderNames);
        }

        if (account1 != null) {
            account1.getAllTransactionsOfCustomer(cList);
        }
    }

}
