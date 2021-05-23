package sample;

public class InsufficientBalanceException extends Exception {
	
    public InsufficientBalanceException(String messege){
        super(messege);
    }
    public InsufficientBalanceException(double amt){
        super("can't withdraw more than "+amt+"taka");
    }
}