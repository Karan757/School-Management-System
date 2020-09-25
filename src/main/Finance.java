/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Karan
 */
public class Finance {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    public void fSubmit(String jt, String sal)
    {
       try{
           String sql = "Insert into finance" + "(job_Title, salary)"+"Values(?,?)";
           
        Class.forName("oracle.jdbc.driver.OracleDriver");    
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
            pst=con.prepareStatement(sql);
               pst.setString(1, jt);
               pst.setString(2, sal);

                 if(pst.executeUpdate()>0)
                    {
                        JOptionPane.showMessageDialog(null,"Salary Inserted");
                    }
               
            }
        catch(SQLException | HeadlessException ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }   catch (ClassNotFoundException ex) {
                Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
                }       
        
    }
    
    
    
    
    public void fView(JTable table, String val)
    {
        String selectJobTitle = "SELECT * FROM finance where job_Title like ?";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");    
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
            pst=con.prepareStatement(selectJobTitle);
            pst.setString(1,"%"+val+"%");
            rs=pst.executeQuery();
  
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            Object[] row;
            while(rs.next())
                 {
                 row = new Object [2];
                 row[0]=rs.getString(1);
                 row[1]=rs.getString(2);

                 model.addRow(row);
                 }
               //pst.executeUpdate();              
               
            }
        catch(SQLException | HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }   catch (ClassNotFoundException ex) {
            Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    
    
    
    
    public void fUpdate(String sal, String jt)
    {
       try{
           String sql = "Update finance set salary=?,job_Title=?";
                        
           
        Class.forName("oracle.jdbc.driver.OracleDriver");    
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
            pst=con.prepareStatement(sql);
               pst.setString(2, jt);
               pst.setString(1, sal);
        
                 if(pst.executeUpdate()>0)
                    {
                        JOptionPane.showMessageDialog(null,"Salary Updated");
                    }
               
            }
        catch(SQLException | HeadlessException ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }   catch (ClassNotFoundException ex) {
                Logger.getLogger(Finance.class.getName()).log(Level.SEVERE, null, ex);
                }       
        
    }
    
    
    
    public void fDelete(String jt)
    {
       try{
           String sql = "Delete from finance where job_Title = ?";
           
        Class.forName("oracle.jdbc.driver.OracleDriver");    
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
            pst=con.prepareStatement(sql);
               pst.setString(1, jt);
                       
                 if(pst.executeUpdate()>0)
                    {
                        JOptionPane.showMessageDialog(null,"Salary Deleted");
                    }
               
            }
        catch(SQLException | HeadlessException ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }   catch (ClassNotFoundException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                }       
        
    }
    
        
}
