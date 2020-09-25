/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Karan
 */
public class DBConnection {
    static Connection conn=null;
    
    private DBConnection(){}
    public static Connection getDBConnection()
    {
       try{
           if(conn==null)
           {
        Class.forName("oracle.jdbc.driver.OracleDriver");    
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
}
       }
       catch(Exception e)
        {
           // JOptionPane.showMessageDialog(null,e) ;
            e.printStackTrace();
        }
       return conn;
    }
    
}
