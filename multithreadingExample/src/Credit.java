public class Credit implements Runnable{
    private Bank bank;

    public Credit(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
    for(int i=0;i<4;i++){
        bank.deposit(200);
    }
    }
}
