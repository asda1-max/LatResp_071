/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;

/**
 *
 * @author Rakha
 */
public class Connector {
    
    
    private static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private static String namaDb = "perpusdebes";
    private static String urlDb = "jdbc:mysql://localhost:3306/" + namaDb;
    private static String usernameDb = "root";
    private static String passwordDb = "";
    
    static Connection conn;
    
    
    public static Connection connect(){
        try{
        Class.forName(jdbcDriver);
        
        conn = DriverManager.getConnection(urlDb,usernameDb, passwordDb);
            System.out.println("MYSQL Connected Succesfully");
        }
        catch(ClassNotFoundException | SQLException exception){
            System.out.println("Connected failed" + exception.getLocalizedMessage());
        }
        
        return conn;
    }
    
}
