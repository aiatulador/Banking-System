package sample;

import javax.swing.*;

public class SavingAccount extends BankAccount{
	private double interest= 0.05;
	private double maxWithLimit;
	public SavingAccount(String memberName, double accoutBalance, double maxWithLimit) {
		super(memberName, accoutBalance,2000);
		this.maxWithLimit= maxWithLimit;
	}
	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getMaxWithLimit() {
		return maxWithLimit;
	}

	public void setMaxWithLimit(double maxWithLimit) {
		this.maxWithLimit = maxWithLimit;
	}

	private double calculateInterest() {
		return interest*getAccountBalance();
	}
	double getNetBalance() {
		return getAccountBalance()+calculateInterest();
	}

	void withdraw(double amt) throws InsufficientBalanceException {
		if(amt<maxWithLimit) {
			super.withdraw(amt);
		}
		else {
			JOptionPane.showMessageDialog(null,"Can not withdraw this amount ");
			//throw new InsufficientBalanceException(maxWithLimit);

		}
	}
	@Override
	public String toString() {
		return
				"\nAccount Holder Name    : " + getMemberName() +
				"\nAccount Number         : " + getAccountNumber() +
				"\nAccount Balance        : " + getAccountBalance() +
				"\nInterest               : " + calculateInterest() +
				"\nMaximum Withdraw Limit : " + maxWithLimit ;
	}
}
