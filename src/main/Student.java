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
public class Student {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    public void stSubmit(String id, String firstName, String lastName, String gen, String dateOfBirth, String add, String cs, String adddate)
    {
       try{
           String sql = "Insert into student" + "(student_Id, first_Name, last_Name, gender, date_Of_Birth, address, class_standard, date_Of_Admission)"
                        +"Values(?,?,?,?,?,?,?,?)";
           
        Class.forName("oracle.jdbc.driver.OracleDriver");    
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
            pst=con.prepareStatement(sql);
               pst.setString(1, id);
               pst.setString(2, firstName);
               pst.setString(3, lastName);
               pst.setString(4, gen);
               pst.setString(5, dateOfBirth);
               pst.setString(6, add);
               pst.setString(7, cs);
               pst.setString(8, adddate);
               //pst.executeUpdate();
        
                 if(pst.executeUpdate()>0)
                    {
                        JOptionPane.showMessageDialog(null,"Student Inserted");
                    }
               
            }
        catch(SQLException | HeadlessException ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }   catch (ClassNotFoundException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }       
        
    }
    
    
    
    
    public void stView(JTable table, String val)
    {
        String selectStudent = "SELECT * FROM student where concat(first_Name, last_Name) like ?";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");    
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
            pst=con.prepareStatement(selectStudent);
            pst.setString(1,"%"+val+"%");
            rs=pst.executeQuery();
  
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            Object[] row;
            while(rs.next())
                 {
                 row = new Object [8];
                 row[0]=rs.getString(1);
                 row[1]=rs.getString(2);
                 row[2]=rs.getString(3);
                 row[3]=rs.getString(4);
                 row[4]=rs.getString(5);
                 row[5]=rs.getString(6);
                 row[6]=rs.getString(7);
                 row[7]=rs.getString(8);

                 model.addRow(row);
                 }
               //pst.executeUpdate();              
               
            }
        catch(SQLException | HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }   catch (ClassNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    
    
    
    
    public void stUpdate(String firstName, String lastName, String gen, String dateOfBirth, String add, String cs, String adddate,String id)
    {
       try{
           String sql = "Update student set first_Name=?, last_Name=?, gender=?, date_Of_Birth=?, address=?, class_standard=?, date_Of_Admission=? where student_ID=?";
                        
           
        Class.forName("oracle.jdbc.driver.OracleDriver");    
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
            pst=con.prepareStatement(sql);
               pst.setString(8, id);
               pst.setString(1, firstName);
               pst.setString(2, lastName);
               pst.setString(3, gen);
               pst.setString(4, dateOfBirth);
               pst.setString(5, add);
               pst.setString(6, cs);
               pst.setString(7, adddate);
               //pst.executeUpdate();
        
                 if(pst.executeUpdate()>0)
                    {
                        JOptionPane.showMessageDialog(null,"Student Updated");
                    }
               
            }
        catch(SQLException | HeadlessException ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }   catch (ClassNotFoundException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }       
        
    }
    
    
    
    public void stDelete(String id)
    {
       try{
           String sql = "Delete from student where student_ID = ?";
           
        Class.forName("oracle.jdbc.driver.OracleDriver");    
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
            pst=con.prepareStatement(sql);
               pst.setString(1, id);
                       
                 if(pst.executeUpdate()>0)
                    {
                        JOptionPane.showMessageDialog(null,"Student Deleted");
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
