package Database;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDao {
    private Connection Connection;

    public BaseDao(){}

    public Connection getConnection () throws SQLException {
        if (Connection == null || Connection.isClosed())
            Connection = DatabaseSingleton.getInstance().getConnection();
        return Connection;
    }
}


