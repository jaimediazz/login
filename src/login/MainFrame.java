package login;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;
import login.model.Account;
import login.view.swing.SwingLoginDialog;

public class MainFrame extends JFrame {
    private final Account[] accounts;

    public MainFrame(Account[] accounts) {
        this.accounts = accounts;
        this.setTitle("Log in");
        this.setSize(250, 175);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(loginDialog(),BorderLayout.NORTH);
        this.setVisible(true);
    }

    private Component loginDialog() {
        SwingLoginDialog dialog = new SwingLoginDialog(accounts);
        return dialog;
    }

}
