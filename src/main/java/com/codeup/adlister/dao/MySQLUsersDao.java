package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        User retVal = new User();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1,username);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            rs.next();
            retVal = new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error Finding User by Username.", e);
        }
        return retVal;
    }

    @Override
    public Long insert(User user) {
        Long retVal;
        try {
            String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            retVal = rs.getLong(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error Inserting User.", e);
        }
        return retVal;
    }
}
