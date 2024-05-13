package com.ra.baitapsession15_springmvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB
{
    private ConnectDB()
    {
    }

    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_employee", "root", "Blackpigsql666");
            return connection;
        } catch (ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection connection)
    {
        try
        {
            if (connection != null)
            {
                connection.close();
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
