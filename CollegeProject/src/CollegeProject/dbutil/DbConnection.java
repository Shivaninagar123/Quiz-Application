/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CollegeProject.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.swing.JOptionPane;



/**
 *
 * @author shiva 
 * 
 *                       
 */
public class DbConnection {
    private static Connection conn;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Collegeproject","root","shivani123");
        JOptionPane.showMessageDialog(null, "Connection successfully done ");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Connection not done ");
                ex.printStackTrace();
                System.exit(1);
        }
        
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            JOptionPane.showMessageDialog(null,"Connection successfully closed");
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"cannot close the connecttion");
            ex.printStackTrace();
        }
    }
    
    }
    
    
    
    
    

