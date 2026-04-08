


package com.chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/chat_app?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "Password";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver loaded!");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("✅ Database connected!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        return conn;
    }
}