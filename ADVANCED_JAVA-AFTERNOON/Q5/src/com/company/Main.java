package com.company;

import java.sql.*;

public class Main {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/TEST";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "#Poi2016";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected");
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sqlQuery = "SELECT * FROM STUDENT LIMIT 10";
            ResultSet resultSet = stmt.executeQuery(sqlQuery);

            while(resultSet.next()){
                //Retrieve by column name
                int id  = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                Double cgpa = resultSet.getDouble("CGPA");
                boolean internShipDone = resultSet.getBoolean("INTERNSHIP_DONE");

                System.out.print("Id: " + id);
                System.out.print(" | Name: " + name);
                System.out.print(" | Cgpa: " + cgpa);
                System.out.println(" | InternShip Done: " + internShipDone);
            }
            resultSet.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException | ClassNotFoundException exc){
            exc.printStackTrace();
        }
        finally {
            try{
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            }
            catch(SQLException sqexc){
                sqexc.printStackTrace();
            }
            System.out.println("Read Successful");
            System.out.println("Connection Closed");
        }
    }
}
