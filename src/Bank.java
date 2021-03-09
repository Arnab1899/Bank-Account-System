import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Bank implements Serializable 
{
	String bankName;
	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	public Bank()
	{
		super();
		this.bankName = bankName;
	}
	private void addAccount(BankAccount acc) 
	{
		accounts.add(acc);
	}
	public void addAccount(String name, double balance, double tradeLicense) 
	{
		SavingsAccount b1= new SavingsAccount(name,balance,tradeLicense);
		addAccount(b1);
		JOptionPane.showMessageDialog(null, "Succesfully Added");
	}
	public void addAccount(String name, double balance, String tradeLicense) 
	{
		CurrentAccount b1= new CurrentAccount(name,balance,tradeLicense);
		addAccount(b1);
		JOptionPane.showMessageDialog(null, "Succesfully Added");
	}
	private BankAccount findAccount(String accNum)
	{
		for(int i=0; i<accounts.size(); i++)
		{
			BankAccount b=accounts.get(i);
			if(b.getAccNum().equals(accNum))
				return b;
		}
		return null;
	}
	public void deposit(String accNum, double depAmount)
	{
		BankAccount b=findAccount(accNum);
		if(b!=null)
		{
			b.deposit(depAmount);
			JOptionPane.showMessageDialog(null, "Amount Added!");		
		}
		else
			JOptionPane.showMessageDialog(null, "Account Not Found!");
	}
	
	public void withdraw(String accNum, double withAmount) 
	{
		BankAccount b=findAccount(accNum);
		if(b!=null)
		{
			try
			{
				b.withdraw(withAmount);
			}
			catch(InsufficientBalanceException e)
			{
				e.printStackTrace();	
			}
		}
			
		else
		{
			JOptionPane.showMessageDialog(null, "Account Not Found!");	
		}
	}
	
	
	public void display(String accNum)
	{
		BankAccount b=findAccount(accNum);
		if(b!=null)
		{
			b.display();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Account Not Found!");
		}
			
	}
	public double getBalance(String accNum)
	{
		BankAccount b=findAccount(accNum);
		if(b!=null)
		{
			if(b instanceof CurrentAccount)
			return b.getBalance();
			else
				return 0;
		}
		else
			{
			JOptionPane.showMessageDialog(null, "Account Not Found!");
			return 0;
			}
	}
	public void display()
	{
		System.out.println(bankName);
		for(int i=0; i<accounts.size(); i++)
		{
			BankAccount b=accounts.get(i);
			b.display();
		}
	}

}
