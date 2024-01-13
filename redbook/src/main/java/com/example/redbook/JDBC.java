package com.example.redbook;

import com.example.redbook.entity.Post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/chuwa";  // Make sure to use the correct database name
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lizecheng";

    public Post getPostById(int id) {
        Post post = new Post();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load Driver
            Class.forName(DRIVER);
            // 2. Connect to Database
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // 3. Define SQL statement
            String sql = "SELECT * FROM posts WHERE id = " + id;  // Use the correct table name
            // 4. Create a statement object
            stmt = conn.createStatement();
            // 5. Use stmt object to execute SQL statement
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                // 6. Get ResultSet's data and set it in the Post object
                post.setId(rs.getLong("id"));
                post.setTitle(rs.getString("title"));
                post.setDescription(rs.getString("description"));
                post.setContent(rs.getString("content"));
                post.setCreateDateTime(rs.getTimestamp("createDateTime").toLocalDateTime());
                post.setUpdateDateTime(rs.getTimestamp("updateDateTime").toLocalDateTime());
            }

            return post;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
