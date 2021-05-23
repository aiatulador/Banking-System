package sample;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class BankAccount {
   private String memberName;
	private String accountNumber;
	private double accountBalance;
	private double minimumBalance;
	public String getMemberName() {

		return memberName;
	}
	public void setMemberName(String memberName) {

		this.memberName = memberName;
	}
	public double getMinimumBalance() {

		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {

		this.minimumBalance = minimumBalance;
	}
	public String getAccountNumber() {

		return accountNumber;
	}
	public double getAccountBalance() {

		return accountBalance;
	}
	public BankAccount(String memberName, double accountBalance, double minimumBalance)
	{
		this.memberName=memberName;
		this.accountBalance=accountBalance;
		this.minimumBalance= minimumBalance;
		 accountNumber=10000+(int)(Math.random()*89999)+ "";
	}
	void deposite(double depAmount)
	{

		accountBalance= accountBalance+depAmount;
	}
	void withdraw(double withAmount) throws InsufficientBalanceException
	{
		if(accountBalance-withAmount>=minimumBalance)
		{
			accountBalance= accountBalance-withAmount;
			JOptionPane.showMessageDialog(null,"Withdraw amount"+withAmount+"successful");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"unsuccessful");
			 throw new InsufficientBalanceException(accountBalance-withAmount);

		}
	}
	void display() {
		System.out.println("memberName=" + memberName + ", accountNumber=" + accountNumber + ", accountBalance="
				+ accountBalance );
		}
	

	
	
}
