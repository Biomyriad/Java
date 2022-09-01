package JavaOOP.BankAccount;

public class BankAccount {
    static int numOfAccounts;
    static int totalAmount;

    private double checkingBalance;
    private double savingsBalance;    
    
    public BankAccount() {
        numOfAccounts++;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void deposit(double amount, String account) {
        switch (account) {
            case "checking":
                checkingBalance += amount;
                break;
            case "savings":
                savingsBalance += amount;
                break;
        }
        totalAmount += amount;
    }

    public void withDraw(double amount, String account) {
        switch (account) {
            case "checking":
                if(checkingBalance < amount) return;
                checkingBalance -= amount;
                break;
            case "savings":
                if(savingsBalance < amount) return;
                savingsBalance -= amount;
                break;
        }
        totalAmount -= amount;
    }

    public void displayTotals() {
        System.out.println(String.format("Checking: %.2f - Savings: %.2f", checkingBalance, savingsBalance));
    }
}
