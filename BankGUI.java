import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankGUI implements ActionListener{

    private CheckingAccount userAccount;
    private JFrame myAccount;
    private JPanel inputPanel;

    private JLabel nameLabel;
    private JLabel balanceLabel;
    private JButton depositButton;
    private JButton withdrawalButton;
    private JTextField amountText;

    private static final int F_WIDTH = 1000;
    private static final int F_HEIGHT = 500;

    // --- CONSTRUCTOR ---
    public BankGUI() {
        userAccount = new CheckingAccount("John", "Doe", 1001, 500.00, 0.02, 30);
        myAccount = new JFrame();
        inputPanel = new JPanel(new GridLayout(1, 3));

        // --- Labels and Buttons ---
        nameLabel = new JLabel("Account Holder: " + userAccount.getFirstName() + " " + userAccount.getLastName());
        balanceLabel = new JLabel("Current Balance: $" + userAccount.getBalance());
        depositButton = new JButton("Deposit");
        withdrawalButton = new JButton("Withdrawal");
        amountText = new JTextField(10);


        // --- Input Panel Assembly ---
        
        inputPanel.add(amountText);
        inputPanel.add(depositButton);
        inputPanel.add(withdrawalButton);

        // --- Frame Configuration --- 
        myAccount.setSize(F_WIDTH, F_HEIGHT);
        myAccount.setTitle("Account Information");
        myAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myAccount.setLayout(new BorderLayout());

        // --- Frame Assembly ---
        myAccount.add(nameLabel, BorderLayout.NORTH);
        myAccount.add(balanceLabel, BorderLayout.CENTER);
        myAccount.add(inputPanel, BorderLayout.SOUTH);
      
        myAccount.pack();

        depositButton.addActionListener(this);
        withdrawalButton.addActionListener(this);
        amountText.addActionListener(this);

        myAccount.setVisible(true);
    }
    // --- Main Method ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankGUI();
        });
    }
    // --- Update Balance ---
    private void updateBalanceDisplay() {
        balanceLabel.setText("Current Balance: $" + userAccount.getBalance());
        amountText.setText("");
    }

    // --- displayError Method ---
    private void displayError(String message) {
        JOptionPane.showMessageDialog(myAccount, message, "Transaction Error", JOptionPane.ERROR_MESSAGE);
    }

    // --- Action Handler Method ---
    @Override
    public void actionPerformed(ActionEvent e) {
        String amountStr = amountText.getText();
        try {
            if (amountStr.trim().isEmpty()) {
                displayError("Please enter an amount.");
                return;
            }
            
            double amount = Double.parseDouble(amountStr);
            boolean success = false;
            
            if (e.getSource() == depositButton) {
                userAccount.deposit(amount);
                success = true;
            } else if (e.getSource() == withdrawalButton) {
                success = userAccount.processWithdrawal(amount);
                
                if (!success) {
                    displayError("Transaction Failed: Insufficient funds or exceeds overdraft limit.");
                }
            } 
            
            if (success) {
                updateBalanceDisplay();
            }

        } catch (NumberFormatException ex) {
            displayError("Invalid Input: Please enter a valid numerical amount.");
        }
    }

    
}
