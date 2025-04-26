import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BankAccountWithTest {
    static class BankAccount {
        private double balance;
        public BankAccount(double initialBalance)
        {
            this.balance = initialBalance;
        }
        public void deposit(double amount)
        {
            if (amount > 0)
                balance += amount;
            else
                throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        public void withdraw(double amount)
        {
            if (amount > balance)
                throw new IllegalArgumentException("Insufficient funds.");
            else if (amount <= 0)
                throw new IllegalArgumentException("Withdrawal amount must be positive.");
            else
                balance -= amount;
        }
        public double getBalance()
        {
            return balance;
        }
    }
    @Test
    public void testDeposit()
    {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance(), 0.001);
    }
    @Test
    public void testWithdraw()
    {
        BankAccount account = new BankAccount(200);
        account.withdraw(70);
        assertEquals(130, account.getBalance(), 0.001);
    }
    @Test
    public void testWithdrawInsufficientFunds()
    {
        BankAccount account = new BankAccount(50);
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable()
        {
            public void execute() throws Throwable
            {
                account.withdraw(100);
            }
        });
        assertEquals("Insufficient funds.", exception.getMessage());
    }
    @Test
    public void testDepositNegativeAmount()
    {
        BankAccount account = new BankAccount(100);
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable()
        {
            public void execute() throws Throwable
            {
                account.deposit(-20);
            }
        });
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }
    @Test
    public void testWithdrawNegativeAmount()
    {
        BankAccount account = new BankAccount(100);
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable()
        {
            public void execute() throws Throwable
            {
                account.withdraw(-30);
            }
        });
        assertEquals("Withdrawal amount must be positive.", exception.getMessage());
    }
    interface Executable extends org.junit.jupiter.api.function.Executable {}
}
