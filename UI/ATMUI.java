package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import Files.FileWriterMain;
import accounts.Account;
import accounts.SavingsAccount;
import accounts.CurrentAccount;


public class ATMUI {
    private Account account;
    public float balance = 100000;
    private float accumulatedWithdrawal = 0;

    public static void main(String[] args) {
        ATMUI atmUI = new ATMUI();
        atmUI.drawWelcomeUI();
    }

    JFrame frame = new JFrame("BHU Bank");
    JLabel welcomeLabel = new JLabel("Welcome to BHU Bank");
    JLabel pinLabel = new JLabel("Enter PIN:");
    JTextField pinTextField = new JTextField();
    JButton loginBtn = new JButton("Login");

    public void drawWelcomeUI() {
        frame.setLayout(new GridLayout(4, 1));
        frame.setSize(300, 150);

        frame.add(welcomeLabel);
        frame.add(pinLabel);
        frame.add(pinTextField);
        frame.add(loginBtn);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawAccountTypeUI();
            }
        });
        frame.setVisible(true);

    }
    JFrame accountTypeFrame = new JFrame("Choose Account Type");
    JLabel accountTypeLabel = new JLabel("Choose Account Type:");
    JButton savingsBtn = new JButton("Savings");
    JButton currentBtn = new JButton("Current");

    public void drawAccountTypeUI() {

        String enteredPIN = pinTextField.getText();
        pinTextField.setText("");


        if (!enteredPIN.equals("5555")) {
            JOptionPane.showMessageDialog(null, "Incorrect PIN. Please try again.");
            return;
        }

        accountTypeFrame.setLayout(new GridLayout(3, 1));
        accountTypeFrame.setSize(300, 150);


        accountTypeFrame.add(accountTypeLabel);
        accountTypeFrame.add(savingsBtn);
        accountTypeFrame.add(currentBtn);

        savingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { account = new SavingsAccount(100000);
                drawTransactionUI("Savings");
            }
        });

        currentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {account = new CurrentAccount(100000);
                drawTransactionUI("Current");
            }
        });
        accountTypeFrame.setVisible(true);
        accountTypeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JFrame transactionFrame = new JFrame("What do you want to do?");
    JLabel transactionLabel = new JLabel("");
    JLabel transactionLabelx= new JLabel("What do you want to do");
    JButton depositBtn = new JButton("Deposit");
    JButton withdrawBtn = new JButton("Withdraw");

    public void drawTransactionUI(String accountType) {
        transactionFrame.setLayout(new GridLayout(3, 1));
        transactionFrame.setSize(300, 150);


        transactionFrame.add(transactionLabelx);

        transactionFrame.add(transactionLabel);
        transactionFrame.add(depositBtn);
        transactionFrame.add(withdrawBtn);

        depositBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawDepositUI(accountType);
            }
        });

        withdrawBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawWithdrawUI(accountType);
            }
        });

        transactionFrame.setVisible(true);
        transactionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JFrame depositFrame = new JFrame("Deposit");
    JLabel depositLabel = new JLabel("Enter deposit amount:");
    JTextField depositTextField = new JTextField();
    JButton depositAmountBtn = new JButton("Deposit");

    public void drawDepositUI(String accountType) {
        depositFrame.setLayout(new GridLayout(3, 1));
        depositFrame.setSize(300, 150);

        depositFrame.add(depositLabel);
        depositFrame.add(depositTextField);
        depositFrame.add(depositAmountBtn);

        depositAmountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    float amount = Float.parseFloat(depositTextField.getText());
                    JOptionPane.showMessageDialog(null, "Deposited: " + amount);
                    FileWriterMain.appendData("Account Type: " + accountType + "--Deposit: " + amount);

                } catch (NumberFormatException | IOException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });

        depositFrame.setVisible(true);
        depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}