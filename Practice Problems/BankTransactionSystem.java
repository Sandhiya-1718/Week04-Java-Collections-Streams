import java.util.Scanner;
class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String message)
	{
		super(message);
	}
}

class BankAccount{
	private double balance;
	public BankAccount(double balance)
	{
		this.balance=balance;
	}
	public void withdraw(double amount) throws InsufficientBalanceException
	{
		if(amount<0)
			throw new IllegalArgumentException("Invalid amount!");
		else if(amount>balance)
			throw new InsufficientBalanceException("Insufficient Balance!");
		else
		{
			balance-=amount;
			System.out.println("Withdrawal successful, new balance:Rs."+balance);
		}
	}
	public double getBalance()
	{
		return balance;
	}
}

public class BankTransactionSystem {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter initial balance:");
		BankAccount account=new BankAccount(scanner.nextDouble());
		char choice;
		do
		{
			System.out.print("Enter amount to withdraw:");
			double amount=scanner.nextDouble();
			try
			{
				account.withdraw(amount);
			}
			catch(IllegalArgumentException e)
			{
				System.out.println(e.getMessage());
			}
			catch(InsufficientBalanceException e)
			{
				System.out.println(e.getMessage());
			}
			System.out.print("Do you want to withdraw again?(y/n):");
			choice=scanner.next().toLowerCase().charAt(0);
		}while(choice=='y');
		System.out.println("Thank you for using the Bank Transaction System!");
		scanner.close();
	}
}
