public class Debit implements  Runnable{
    private Bank bank;

    public Debit(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
    for(int i=0;i<4;i++){
        try {
            bank.withdraw(100);
        }
        catch(Exception e){
            System.out.println("Exception" + e.getMessage());
        }
    }
    }
}
