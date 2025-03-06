package edu.matc.persistence;

import edu.matc.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserData {
    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<User> getAllUsers() {

        String sql = "SELECT * FROM user";
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
            System.out.println("UserData.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("UserData.getAllUsers()...Exception: " + e);
        }
        return users;

    }

    private User createUserFromResults(ResultSet results) throws SQLException {

        User user = new User();
        user.setLast_name(results.getString("last_name"));
        user.setFirst_name(results.getString("first_name"));
        user.setUsername(results.getString("username"));

        return user;
    }
}
