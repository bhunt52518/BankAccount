public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    protected double balance;

    // Default initialization of variables
    public BankAccount() {
        this("", "", 0, 0.00);
    }
    public BankAccount(String firstName, String lastName, int accountID, double balance) {
        setFirstName(firstName);
        setLastName(lastName);
        setAccountID(accountID);
    }
    // Setters and getters for account info
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAccountID() {
        return accountID;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    public double getBalance() {
        return balance;
    }
    // Deposits into account
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }
    // This withdrawals from the balance 
    public boolean withdrawal(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }
    // Displays account info
    protected void accountSummary() {
        System.out.println("---Account Summary---");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Account Number: " + accountID);
        System.out.println("Balance: $" + String.format("%.2f", balance));
    }
}
