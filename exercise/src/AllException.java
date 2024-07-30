public class AllException {

    public static class AccountNotFoundException extends Exception{
        public AccountNotFoundException(){
            super("account not found");
        }
    }

    public static class InvalidAmountException extends Exception{
        public InvalidAmountException(){
            super("Invalid Amount");
        }
    }
}
