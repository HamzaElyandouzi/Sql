package be.intecbrussel.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPovider {

    private Connection connection;

    private static ConnectionPovider instance = new ConnectionPovider();

    public static ConnectionPovider getInstance() {
        return instance;
    }

    public Connection getConnection() {
        if(connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignments", "root", "");
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }
        return connection ;
    }



}