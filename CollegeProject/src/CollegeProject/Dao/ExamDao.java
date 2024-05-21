/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CollegeProject.Dao;

import CollegeProject.dbutil.DbConnection;
import CollegeProject.pojo.Exam;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author shiva
 */
public class ExamDao {
    public static String getExamID() throws SQLException{
        Connection con = DbConnection.getConnection();
        Statement st = con.createStatement();
        int count;
        ResultSet rs= st.executeQuery("Select count(*) from exam");
        rs.next();
        count=rs.getInt(1);
        String newId="Ex-"+(count+1);
        return newId;
        
        }
    public static boolean addExam(Exam exam)throws SQLException{
        Connection con= DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("Insert into exam values(?,?,?)");
        ps.setString(1,exam.getExamId());
        ps.setString(2, exam.getLanguage());
        ps.setInt(3,exam.getTotalQuestions());
        int ans= ps.executeUpdate();
        return ans==1;
        
        
    }
    public static boolean isPaperSet(String Subject)throws SQLException{
        Connection con= DbConnection.getConnection();
        PreparedStatement ps= con.prepareStatement("select 1 from exam where language=?");
        ps.setString(1, Subject);
        ResultSet rs=ps.executeQuery();
        return rs.next();
        
    }
    public static ArrayList<String> getExamIdBySubject(String userid,String subject)throws SQLException{
//        String qry=" select examid from exam where language= ? and examid not in ( select examid from performance where userid=?)";
         String qry="SELECT examid FROM exam WHERE language=? AND examid NOT IN(SELECT examid FROM performance WHERE userid=?) ";
        Connection con=DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(qry);
        ps.setString(1, subject);
        ps.setString(2, userid);
        ResultSet rs=ps.executeQuery();
        ArrayList<String>examIdList=new ArrayList<>();
        while(rs.next()){
            examIdList.add(rs.getString(1));
            
        }
        return examIdList;
        
    }
    public static ArrayList<String> getExamIdBySubject(String Subject)throws SQLException{
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("Select examid from exam where language=?");
        ps.setString(1, Subject);
        ResultSet rs= ps.executeQuery();
        ArrayList<String> examIdList=new ArrayList<>();
        while(rs.next()){
          examIdList.add(rs.getString(1));
         }
         return examIdList;
    }
    public static int getQuestionCountByExam(String examId)throws SQLException{
        Connection con=DbConnection.getConnection();
        PreparedStatement ps= con.prepareStatement("Select total_question from exam where examid=?");
        ps.setString(1, examId);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examIdList=new ArrayList<>();
        rs.next();
        return rs.getInt(1);
    }
    
   public static ArrayList<String> getSubject()throws SQLException{
       Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select distinct language from exam");
        ArrayList<String> subjectList=new ArrayList<>();
        while(rs.next()){
        String subject =rs.getString(1);
        subjectList.add(subject);
        }
        return subjectList;
    }
   public static int getNoOfQueByExamId(String id) throws SQLException
     {
          Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select TOTAL_QUESTION from exam where examid=?");
       ps.setString(1,id);
       ResultSet rs=ps.executeQuery();
        rs.next();
       return rs.getInt(1);
     }
   public static ArrayList<String> getRemainingExamId(String userId,String subject)throws SQLException{
//         String qry="select examid from exam where language=? minus select examid from performance where userid=?";
String qry="SELECT examid FROM exam WHERE language=? AND examid NOT IN(SELECT examid FROM performance WHERE userid=?) ";
         Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement(qry);
       ps.setString(1,subject);
        ps.setString(2,userId);
       ResultSet rs=ps.executeQuery();
       ArrayList<String> examIdList=new ArrayList<>();
       while(rs.next()){
           examIdList.add(rs.getString(1));
       }
       return examIdList; 
     }
}
