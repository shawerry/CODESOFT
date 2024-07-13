import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (choice != 4);
    }

    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        return choice;
    }

    private void checkBalance() {
        System.out.println("Your balance is: $" + userAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
        System.out.println("$" + amount + " has been deposited into your account.");
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        boolean success = userAccount.withdraw(amount);
        if (success) {
            System.out.println("$" + amount + " has been withdrawn from your account.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public static void main(String[] args) {
    
        BankAccount account = new BankAccount(1000.0); 
        ATM atm = new ATM(account);
        atm.run();
    }
}
