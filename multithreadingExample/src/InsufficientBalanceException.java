public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(){
        super("insufficient balance or invalid amount");
    }
}
