import java.util.Scanner;

import javax.swing.JOptionPane;

public class BankApp {

	public static void main(String[] args) 
	{
		Bank bank=new Bank();
		System.out.println("1. Create New Account\n2. Deposit\n3. Withdraw\n4. Display particular account info\n5. Display all account info\n6. Check balance\n0. Exit");
		Scanner scan=new Scanner(System.in);
		while(true)
		{
		int op=scan.nextInt();
		scan.nextLine();
		if(op==1)
		{
			System.out.println("1. Savings Acoount\n2. Current account");
			int op1=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Member Name:");
			String name=scan.nextLine();
			System.out.println("Enter Initial Balance:");
			
			int bal=scan.nextInt();	
			if(op1==1)
			{
				System.out.println("Enter Max Withdraw Limit:");
				double maxWithimit=scan.nextDouble();
				bank.addAccount(name, bal, maxWithimit);
			}			
			if(op1==2)
			{
				System.out.println("Enter Trade License Number:");
				double tradeLicense=scan.nextDouble();
				bank.addAccount(name, bal, tradeLicense);
			}			
		}
		else if(op==2)
		{
			System.out.println("Enter Account Number:");
			String accNum=scan.nextLine();
			System.out.println("Enter Amount");
			int bal=scan.nextInt();			
			bank.deposit(accNum, bal);
		}
		else if(op==3)
		{
			System.out.println("Enter Account Number:");
			String accNum=scan.nextLine();
			System.out.println("Enter Amount");
			int bal=scan.nextInt();			
			bank.withdraw(accNum, bal);
		}
		else if(op==4)
		{
			System.out.println("Enter Account Number:");
			String accNum=scan.nextLine();		
			bank.display(accNum);
		}
		else if(op==5)
		{
			bank.display();
		}
		else if(op==6)
		{
			System.out.println("Enter Account Number:");
			String accNum=scan.nextLine();		
			double a = bank.getBalance(accNum);
			JOptionPane.showMessageDialog(null,"Current Balance Is:"+a);
		}
		else if(op==0)
		{
			break;
		}
		}
	}

}
