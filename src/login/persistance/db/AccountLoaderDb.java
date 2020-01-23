package login.persistance.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import login.model.Account;
import login.persistance.AccountLoader;

public class AccountLoaderDb implements AccountLoader {
    private Connection connect;

    public void connect() {
        String URL_BD_SQLite = "jdbc:sqlite:C:\\Users\\hp\\Documents\\NetBeansProjects"
                + "\\DB_SQLite\\cuentas.db";
        try {
            connect = DriverManager.getConnection(URL_BD_SQLite);
            if (connect!=null) {
                System.out.println("Conectado");
            }        
        } catch (SQLException ex) {
            System.out.println("mecago");
        }
    }
    
    public void close(){
        try {
            connect.close();
        } catch (SQLException ex) {
            System.out.println("adadasd");
        }
    }    

    @Override
    public Account[] read() {
        String SQL = "SELECT * FROM users";
        Map<String,String> aux = new HashMap<>();
        Account[] res;
        
        try {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()) {
                aux.put(resultSet.getString("user"),resultSet.getString("password"));
            }
            res = new Account[aux.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : aux.entrySet()) {
                res[i] = new Account(entry.getKey(),entry.getValue());
                i++;
            }
            return res;
        }
        catch (SQLException exception) {
            System.out.println("ERROR Login:: selectData_EMAIL (SQLException)" + exception.getMessage());            
            return null;
        }    
    }
        
}
