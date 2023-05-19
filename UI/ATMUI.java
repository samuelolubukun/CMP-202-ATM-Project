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
}