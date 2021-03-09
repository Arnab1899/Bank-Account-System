import java.io.Serializable;

class SavingsAccount extends BankAccount implements Serializable
{
	private double interest=0.05;
	private double maxWithLimit;
	public SavingsAccount(String memberName, double accountBalance, double maxWithLimit) 
	{
		super(memberName, accountBalance,5000);
		this.maxWithLimit=maxWithLimit;
	}
	private double calculateInterest()
	{
		return getBalance()*interest;
	}
	public double getNetBalance() 
	{
		return calculateInterest()+getBalance();
	}
	public void withdraw(double withAmount) throws InsufficientBalanceException
	{
		if(withAmount<=maxWithLimit)
		super.withdraw(withAmount);
		else
		{
			throw new InsufficientBalanceException(this.maxWithLimit); 
		}
	}
	public void display() 
	{
		super.display();
		System.out.println("; interest:" + calculateInterest() + "; maxWithdrawLimit:" + maxWithLimit);
	}
	public double getMaxWithLimit()
	{
		return maxWithLimit;
	}
	public void setmaxWithLimit(double val)
	{
		maxWithLimit=val;
	}
}
