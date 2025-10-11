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
    public void processWithdrawal(double amount) {
        // Check if withdrawal will lead to an overdraft
        if (this.balance - amount < 0) {
            System.out.println("Warning: Insufficient funds. Applying $" + overdraftFee + " overdraft fee.");
            super.withdrawal(amount); 
            this.balance -= overdraftFee;
        } else {
            super.withdrawal(amount);
        }
    }
    // Overrides the withdrawal method to use the processWithdrawal logic
    @Override
    public void withdrawal(double amount) {
        processWithdrawal(amount);
    }

    // Method to display all account details
    public void displayAccount() {
        super.accountSummary();
        double interestPercent = interestRate * 100;
        System.out.println("Interest Rate: " + String.format("%.2f", interestPercent) + "%");
        System.out.println("Overdraft Fee: $" + overdraftFee);
    }
}
