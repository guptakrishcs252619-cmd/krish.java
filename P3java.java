class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}


class InvalidDepositException extends Exception {
    public InvalidDepositException(String message) {
        super(message);
    }
}


class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            balance = 0;
        } else {
            balance = initialBalance;
        }
    }


    public void deposit(double amount) throws InvalidDepositException {
        if (amount <= 0) {
            throw new InvalidDepositException("Deposit amount must be greater than zero.");
        }

        balance += amount;
        System.out.println("Successfully deposited: " + amount);
    }


    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }

        balance -= amount;
        System.out.println("Successfully withdrawn: " + amount);
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
        
    }
}

// Main class
public class P3java {
    public static void main(String[] args) {
        System.out.println("krish gupta S085");

        BankAccount account = new BankAccount(85000);

        try {
            account.displayBalance();

            account.deposit(2000);

            account.withdraw(8000); // Throws exception

        } catch (InvalidDepositException e) {
            System.out.println("Deposit Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal Error: " + e.getMessage());
        }

        try {
            account.deposit(-500); // Throws exception

        } catch (InvalidDepositException e) {
            System.out.println("Deposit Error: " + e.getMessage());
        }

        account.displayBalance();
    }
}