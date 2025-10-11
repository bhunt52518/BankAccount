public class BankTest {
    public static void main(String[] args) {

        // TEST 1: Default Constructor and Overdraft Scenario

        System.out.println("--- Test 1: Default Checking Account (ID: 1001) ---");

        // 1. Create a new account using the default constructor
        CheckingAccount defaultAccount = new CheckingAccount();
        defaultAccount.setFirstName("Alice");
        defaultAccount.setLastName("Smith");
        defaultAccount.setAccountID(1001);

        // 2. Initial deposit
        defaultAccount.deposit(100.00);
        defaultAccount.displayAccount();

        // 3. Overdraft attempt (Withdrawal greater than balance)
        System.out.println("\nAttempting withdrawal of $120.00...");
        defaultAccount.withdrawal(120.00); 
        defaultAccount.displayAccount(); 

        // TEST 2: Parameterized Constructor and Regular Withdrawal

        System.out.println("\n--- Test 2: Parameterized Account (ID: 2002) ---");
        // 1. Create a new account with initial values
        CheckingAccount parameterizedAccount = new CheckingAccount(
            "Bob", "Jones", 2002, 500.00, 0.05, 40);

        parameterizedAccount.displayAccount();

        // 2. Regular withdrawal (no overdraft)
        System.out.println("\nAttempting regular withdrawal of $50.00...");
        parameterizedAccount.withdrawal(50.00);
        parameterizedAccount.displayAccount();

        // 3. Test parameterization by applying another overdraft
        System.out.println("\nAttempting large withdrawal of $500.00 to test custom fee ($40)...");
        parameterizedAccount.withdrawal(500.00);
        parameterizedAccount.displayAccount();
    }
}
