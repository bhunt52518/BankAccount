public class CheckingAccount extends BankAccount {
    private double interestRate;
    private int overdraftFee;

    // Default Constructor
    public CheckingAccount() {
        super();
        this.interestRate = 0.02;
        this.overdraftFee = 30;
    }

    // Parameterized Constructor
    public CheckingAccount(String firstName, String lastName, int accountID, double initialBalance, double interestRate, int overdraftFee) {
        super(firstName, lastName, accountID, initialBalance);
        this.interestRate = interestRate;
        this.overdraftFee = overdraftFee;
    }
    // Getter and setter methods for checking account
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public int getOverdraftFee() {
        return overdraftFee;
    }
    public void setOverdraftFee(int overdraftFee) {
        this.overdraftFee = overdraftFee;
    }
    public boolean processWithdrawal(double amount) {
        if (amount <= 0) {
            return false; 
        }
        if (amount <= balance) {
            this.balance -= amount;
            return true;
        } else {
            this.balance = balance - (amount + overdraftFee);
            return true; 
        }
    }
    @Override
    public boolean withdrawal(double amount) {
        processWithdrawal(amount);
        return processWithdrawal(amount);
    }

    // Method to display all account details
    public void displayAccount() {
        super.accountSummary();
        double interestPercent = interestRate * 100;
        System.out.println("Interest Rate: " + String.format("%.2f", interestPercent) + "%");
        System.out.println("Overdraft Fee: $" + overdraftFee);
    }
}
