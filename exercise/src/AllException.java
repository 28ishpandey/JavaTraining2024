public class AllException {

    public static class AccountNotFoundException extends Exception{
        public AccountNotFoundException(){
            super("account not found");
        }
    }
}
