package com.example.prisonmangementsystem3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class prisonsystemdatabase {
    protected static final String DB_Connection = "jdbc:mysql://localhost:3306/prison";
    protected static final String DBUSer = "root";
    protected static final String DBPass = "Password123";
    private static final String sendVisitorInfo = "INSERT INTO personalinfo (personname, personaddress, personphonenum) VALUES (?,?,?)";
    private static final String editVisitorInfo = "UPDATE personalinfo SET personname = ?, personaddress = ?, personphonenum = ? WHERE (personname = ?)";
    public void insertVisitor(String visitorName, String address,String phone) {
        try (Connection connection = DriverManager.getConnection(DB_Connection, DBUSer, DBPass);
             PreparedStatement preparedStatement = connection.prepareStatement(sendVisitorInfo))
        {
            preparedStatement.setString(1, visitorName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }
    public void editVisitor(String visitorName, String address,String phone,String visitor) {
        try (Connection connection = DriverManager.getConnection(DB_Connection, DBUSer, DBPass);
             PreparedStatement preparedStatement = connection.prepareStatement(editVisitorInfo))
        {
            preparedStatement.setString(1, visitorName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, visitor);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public static void printSQLException(SQLException ex) {     //sql exception
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
