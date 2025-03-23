package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.utilities.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User data.
 */
public class UserData {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<User> getAllUsers() {

        String sql = "SELECT * FROM user ORDER BY username ASC";
        return executeQuery(sql);

    }

    /**
     * Execute query list.
     *
     * @param sql the sql
     * @return the list
     */
    public List<User> executeQuery(String sql) {

        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("UserData.getAllUsers()...SQLException: ", e);
        } catch (Exception e) {
            logger.error("UserData.getAllUsers()...Exception: ", e);
        }
        return users;

    }
    /**
     * Creates a User object from the given ResultSet.
     *
     * @param results the ResultSet containing user data from a database query
     * @return a User object populated with data from the ResultSet
     * @throws SQLException if a database access error occurs or the column labels are not found
     */
    private User createUserFromResults(ResultSet results) throws SQLException {

        User user = new User();
        user.setLast_name(results.getString("last_name"));
        user.setFirst_name(results.getString("first_name"));
        user.setUsername(results.getString("username"));

        return user;
    }

    public List<User> getUsersByPage(int page, int pageSize) {
        // Calculate the offset for the SQL query
        int offset = (page - 1) * pageSize;
        String sql = "SELECT * FROM user LIMIT " + pageSize + " OFFSET " + offset;
        return executeQuery(sql);
    }

}
