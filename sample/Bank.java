package sample;
import javax.swing.*;
import java.util.ArrayList;

public class Bank {
	ArrayList<BankAccount> accounts=new ArrayList<>();
	public String addNewAccount(BankAccount acc) {
		accounts.add(acc);
		return acc.getAccountNumber();
	}
	public String addNewAccount(String memberName, double accountBalance, double maxWithLimit) {
		SavingAccount a=new SavingAccount(memberName,accountBalance, maxWithLimit);
		String accNumber=addNewAccount(a);
		return accNumber;
	}
	public String addNewAccount(String memberName, double accountBalance,String tradeNumber ) {
		CurrentAccount a=new CurrentAccount(memberName,accountBalance, tradeNumber);
		String accNumber=addNewAccount(a);
		return accNumber;
	}
	private BankAccount findAccount(String accountNumber) {
		for(int i=0; i<accounts.size(); i++) {
			BankAccount a= accounts.get(i);
			if(a.getAccountNumber().equals(accountNumber)) {
				return a;
			}
		}
		JOptionPane.showMessageDialog(null,"Account doesn't exist");
		return null;
	}
	void deposite(String accountNumber, double amt) {
		BankAccount ac=findAccount(accountNumber);
		if(ac!=null) {
			ac.deposite(amt);
			JOptionPane.showMessageDialog(null,"Deposite amount" +amt+ "successful");
		}
		else {
			JOptionPane.showMessageDialog(null,"Account doesn't exist");
		}
	}
	void withdraw(String accountNumber, double amt)  throws InsufficientBalanceException {
		BankAccount ac=findAccount(accountNumber);
		if(ac!=null) {
			ac.withdraw(amt);
		}
		else {
			JOptionPane.showMessageDialog(null,"Account doesn't exist");
		}
	}
	public double getBalance(String accountNumber) {
		BankAccount ac= findAccount(accountNumber);
		if(ac!=null) {
		if(ac instanceof CurrentAccount) {
			return ac.getAccountBalance();
		}
		else {
			return ((SavingAccount)ac).getNetBalance();
		}
	}
		else {
			JOptionPane.showMessageDialog(null,"Account doesn't exist");
			return 0;
		}
	}
	public BankAccount display(String accountNumber) {
		BankAccount ac= findAccount(accountNumber);
		if(ac!=null) {
			return ac;
		}
		else{
			JOptionPane.showMessageDialog(null,"Account doesn't exist");
			return null;
		}
	}
	public BankAccount display(int i)
	{
		BankAccount bnk = findAccount(accounts.get(i).getAccountNumber());
		return bnk;
	}
	
}

