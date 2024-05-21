/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CollegeProject.Dao;
import CollegeProject.dbutil.DbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import CollegeProject.pojo.User;




/**
 *
 * @author shiva
 */
public class UserDao {
    public static boolean validateUser(User user)throws SQLException{
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("Select * from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserid());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUsertype());
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    public static boolean addUser(User user)throws SQLException{
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?)");
       ps.setString(1,user.getUserid());
       ps.setString(2,user.getPassword());
       ps.setString(3,user.getUsertype());
      return ps.execute();
      
       
    }
    public static boolean passwordUpdate(String userId,String password)throws SQLException{
        Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("update users set password=? where userid=?");
        ps.setString(1,password);
       ps.setString(2,userId);
       int rs=ps.executeUpdate();
       if(rs==1)
           return true;
       return false;
    }
    public static boolean isRegistered(String userId,String userType)throws SQLException{
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from users where userid=? and usertype=?");
       ps.setString(1,userId);
        ps.setString(2,userType);
       ResultSet s=ps.executeQuery();
       return s.next();
    }
}
