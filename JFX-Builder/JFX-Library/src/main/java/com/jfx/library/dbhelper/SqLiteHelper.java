package com.jfx.library.dbhelper;

import com.jfx.library.util.RestUtil;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Reza
 */
public class SqLiteHelper extends RestUtil{
    
    public Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite::resource:" + this.getClass().getResource("/sqlite/database.db").toString());
            conn.setAutoCommit(false);
            return conn;
        }
        catch (HeadlessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Integer checkExistingToken(){
        Integer rowCount=0;
        try {
            String sql = "SELECT * FROM AuthToken";
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            rowCount = rs.getRow();
            statement.close();
            conn.close();
        }
        catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public void saveToken(String token) {
        try {
            String sql = "INSERT INTO AuthToken(token) VALUES(?)";
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, token);
            statement.executeUpdate();
            statement.close();
            conn.commit();
            conn.close();
        }
        catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateToken(String token){
        try {
            String sql = "UPDATE AuthToken SET token=? WHERE id=?";
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, token);
            statement.setInt(2, 1);
            statement.executeUpdate();
            statement.close();
            conn.commit();
            conn.close();
        }
        catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void logging(String userLogin, String date){
        try {
            String sql = "INSERT INTO Log(userLogin,date) VALUES(?,?)";
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userLogin);
            statement.setString(2, date);
            statement.executeUpdate();
            System.out.println("starting logging "+userLogin+" at "+ date);
            statement.close();
            conn.commit();
            conn.close();
        }
        catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getToken() {
        try {
            String sql = "SELECT token FROM AuthToken WHERE id=1";
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                super.setToken(rs.getString("token"));
            }
            statement.close();
            conn.close();
        }
        catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }
        return super.getToken();
    }

}