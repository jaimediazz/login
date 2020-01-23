package login;

import login.model.Account;
import login.persistance.db.AccountLoaderDb;

public class Main {

    public static void main(String[] args) {
        AccountLoaderDb accountLoaderDb = new AccountLoaderDb();
        accountLoaderDb.connect();
        Account[] accounts = accountLoaderDb.read();
        MainFrame mainFrame = new MainFrame(accounts);
    }
        
}
