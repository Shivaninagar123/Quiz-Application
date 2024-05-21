/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CollegeProject.Dao;
import CollegeProject.dbutil.DbConnection;
import CollegeProject.pojo.Question;
import CollegeProject.pojo.QuestionStore;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;


public class QuestionDao {
    public static void addQuestions(QuestionStore qstore)throws SQLException{
       Connection con= DbConnection.getConnection();
       PreparedStatement ps= con.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
       ArrayList<Question>questionList=qstore.getAllQuestion();
       for(Question q: questionList){
           ps.setString(1,q.getExamId());
           ps.setInt(2,q.getQno());
           ps.setString(3, q.getQuestion());
           ps.setString(4, q.getAnswer1());
           ps.setString(5, q.getAnswer2());
           ps.setString(6, q.getAnswer3());
           ps.setString(7, q.getAnswer4());
           ps.setString(8, q.getCorrectAnswer());
           ps.setString(9, q.getLanguage());
           ps.executeUpdate();
       }
       
        }
 public static ArrayList<Question>getQuestionsByExamId(String examId)throws SQLException{
     Connection con= DbConnection.getConnection();
     PreparedStatement ps=con.prepareStatement("Select * from questions where examid=?");
     ps.setString(1, examId);
     ResultSet rs=ps.executeQuery();
     ArrayList<Question>questionList=new ArrayList<>();
     while(rs.next()){
     int qno=rs.getInt(2);
     String question=rs.getString(3);
     String option1=rs.getString(4);
     String option2=rs.getString(5);
     String option3=rs.getString(6);
     String option4=rs.getString(7);
     String correctAnswer=rs.getString(8);
     String language=rs.getString(9);
     Question obj= new Question(examId,language,qno,question,option1,option2,option3,option4,correctAnswer);
     questionList.add(obj);
     
     
 }
     return questionList;
 }   
    
   public static void updateQuestions(QuestionStore qs) throws SQLException
    {
         Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("update questions set Question=?,Answer1=?,Answer2=?,Answer3=?,Answer4=?,Correct_Answer=? where examid=? and qno=?");
       ArrayList<Question> questionlist=qs.getAllQuestion();
       for(Question q: questionlist )
       {
           ps.setString(1,q.getQuestion());
           ps.setString(2,q.getAnswer1());
           ps.setString(3,q.getAnswer2());
           ps.setString(4, q.getAnswer3());
           ps.setString(5, q.getAnswer4());
           ps.setString(6, q.getCorrectAnswer());
           ps.setString(7, q.getExamId());
           ps.setInt(8, q.getQno());
           ps.executeUpdate();
       }
       
    } 
    
    
    
    
    
    
    
    
    
    
}
