package sample;

public class CurrentAccount extends BankAccount {
	public String tradeLicenseNumber;
	public CurrentAccount(String memberName, double accountBalance, String tradeNumber) {
		super(memberName, accountBalance,5000);
		this.tradeLicenseNumber=tradeNumber;
	}
	@Override
	public String toString() {
		return
				"\nAccount Holder Name : " + getMemberName() +
				"\nAccount Number       : " + getAccountNumber() +
				"\nAccount Balance      : " + getAccountBalance()+
				"\nTrade License        : " + tradeLicenseNumber ;
	}
}
