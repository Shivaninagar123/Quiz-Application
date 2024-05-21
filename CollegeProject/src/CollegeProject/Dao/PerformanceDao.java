/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CollegeProject.Dao;

import CollegeProject.dbutil.DbConnection;
import CollegeProject.pojo.Performance;
import CollegeProject.pojo.StudentScore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author shiva
 */
public class PerformanceDao {
    public static void addPerformance(Performance p) throws SQLException
    {
         Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("insert into performance values(?,?,?,?,?,?,?)");
           ps.setString(1, p.getUserId());
           ps.setString(2,p.getExamId());
           ps.setInt(3,p.getRight());
           ps.setInt(4,p.getWrong());
           ps.setInt(5,p.getUnattempted());
           ps.setDouble(6, p.getPer());
           ps.setString(7, p.getLanguage());
           ps.executeUpdate();
       }
      public static ArrayList<String> getExamIdByUserId(String userId) throws SQLException
    {
         Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select examid from performance where userid=?");
           ps.setString(1,userId);
           ResultSet rs=ps.executeQuery();
       ArrayList<String> examidList=new ArrayList<>();
       while(rs.next()){
          examidList.add(rs.getString(1));
       }
       return examidList;
           
       }
      
      public static ArrayList<String> getAllUserId() throws SQLException
    {
         Connection conn=DbConnection.getConnection();
       Statement ps=conn.createStatement();
           ArrayList<String> userIdList=new ArrayList<>();
           ResultSet rs=ps.executeQuery("select distinct userid from performance");
       
       while(rs.next()){
          String id=rs.getString(1);
          userIdList.add(id);
       }
       return userIdList;
           
       }
      
     public static StudentScore getScore(String userId,String examId) throws SQLException
    {
         Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select language,per from performance where userid=? and examid=?");
           ps.setString(1,userId);
           ps.setString(2, examId);
           ResultSet rs=ps.executeQuery();
           rs.next();
           String subject=rs.getString(1);
           Double percent=rs.getDouble(2);
           StudentScore score=new StudentScore(subject,percent);
           return score;
          
}
     
     public static ArrayList<Performance> getAllData()throws SQLException{
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ArrayList<Performance> pList=new ArrayList<Performance>();
         ResultSet rs=st.executeQuery("select * from performance");
         while(rs.next()){
             String userId=rs.getString(1);
             String examId=rs.getString(2);
             int right=rs.getInt(3);
             int wrong=rs.getInt(4);
             int unattempted=rs.getInt(5);
             double per=rs.getDouble(6);
             String lang=rs.getString(7);
             Performance p=new Performance(examId,lang, userId, right, wrong, unattempted, per);
             
             pList.add(p);
         }
    return pList;
     }
    
}
