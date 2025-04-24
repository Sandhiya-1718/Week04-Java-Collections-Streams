import java.util.Scanner;
class TransactionException extends Exception
{
	public TransactionException(String message)
	{
		super(message);
	}
}

public class TransactionProcessor {
	public static void processTransaction(String userId, double amount) throws TransactionException
	{
		try
		{
			if(amount<=0)
				throw new TransactionException("Invalid amount:Rs."+amount);
			System.out.println("Transaction of Rs."+amount+" processed successfully for user "+userId+".");
		}
		catch(TransactionException e)
		{
			throw new TransactionException("Transaction failed for user "+userId);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter User Id:");
		String userId=scanner.nextLine();
		System.out.println("Enter Transaction Amount:");
		double amount=scanner.nextDouble();
		try
		{
			processTransaction(userId,amount);
		}
		catch(TransactionException e)
		{
			System.out.print(e.getMessage());
		}
		scanner.close();
	}
}
