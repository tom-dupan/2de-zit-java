package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
    private static DatabaseSingleton instance = null;
    private Connection connection;

    public DatabaseSingleton(){}

    public static DatabaseSingleton getInstance(){
        if (instance == null)
            instance = new DatabaseSingleton();

        return instance;
    }
    public Connection getConnection() throws SQLException{
        if (connection == null||connection.isClosed());
        connection= DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/1920PROGESS076","1920PROGESS076","21489756");
        return connection;
    }
}
