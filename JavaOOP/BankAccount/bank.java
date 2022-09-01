package JavaOOP.BankAccount;

public class bank {
    public static void main(String[] args) { 
        BankAccount account1 = new BankAccount();
		account1.deposit(100, "checking");
		account1.deposit(100, "savings");
        System.out.println("account1");
		account1.displayTotals();

		account1.withDraw(20, "checking");
		account1.withDraw(20, "savings");
        System.out.println("account1");
		account1.displayTotals();

        BankAccount account2 = new BankAccount();
		account2.deposit(800, "checking");
		account2.deposit(800, "savings");
        System.out.println("account2");
		account2.displayTotals();

        account2.withDraw(400, "checking");
        account2.withDraw(400, "savings");
        System.out.println("account2");
        account2.displayTotals();
        
        System.out.println(BankAccount.totalAmount);
        System.out.println(BankAccount.numOfAccounts);
    }
}
