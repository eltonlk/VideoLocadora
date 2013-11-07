package framework.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    
    Connection connection = null;
    Properties databaseProperties = new Properties();
    
    public DataBaseConnection() throws IOException, SQLException {
        try {
            databaseProperties.load(new FileInputStream("database.properties"));
            
            Class.forName(databaseProperties.getProperty("driver"));
            
            connection = DriverManager.getConnection(databaseProperties.getProperty("url"), 
                databaseProperties.getProperty("user"), 
                databaseProperties.getProperty("password"));
        } catch (ClassNotFoundException | FileNotFoundException e) {
            System.out.println("Não foi possivel conectar ao Banco de Dados.\n" + e.getMessage());
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
}
