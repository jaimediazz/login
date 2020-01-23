package login.view.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import login.model.Account;
import login.view.LoginDialog;

public class SwingLoginDialog extends JPanel implements LoginDialog {
    private final Account[] accounts;
    private String user;
    private String password;

    public SwingLoginDialog(Account[] accounts) {
        this.accounts = accounts;
        this.add(login());
    }

    private Component login() {
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        
        JPanel sup = new JPanel();
        sup.setLayout(new FlowLayout());
        sup.add(new JLabel("User Name: "));
        JTextField tf1 = new JTextField(20);
        tf1.setColumns(10);
        sup.add(tf1);
        main.add(sup,BorderLayout.NORTH);
        
        JPanel cen = new JPanel();
        cen.setLayout(new FlowLayout());
        cen.add(new JLabel("Password: "));
        JPasswordField tf2 = new JPasswordField(20);
        tf2.setColumns(10);
        cen.add(tf2);
        main.add(cen,BorderLayout.CENTER);
        
        JPanel inf = new JPanel();
        inf.setLayout(new FlowLayout());
        JButton logInButton = new JButton("Log in");
        inf.add(logInButton);
        JLabel info = new JLabel(" ");
        inf.add(info);
        main.add(inf,BorderLayout.SOUTH);
        
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = tf1.getText();
                password = tf2.getText();
                for(int i = 0; i < accounts.length; i++) {
                    if(user.equals(accounts[i].getUserName())) {
                        if(password.equals(accounts[i].getPassword())) {
                            info.setText("Datos correctos");
                            break;
                        } else {
                            info.setText("Datos incorrectos");
                            break;
                        }
                    } else {
                        info.setText("Datos incorrectos");
                    }
                }
            }
        });
        return main;
    }
    
    @Override
    public Account get() {
        return new Account(user,password);
    }
    
}
