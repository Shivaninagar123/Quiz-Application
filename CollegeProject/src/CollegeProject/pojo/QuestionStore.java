/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CollegeProject.pojo;
import java.util.ArrayList;
/**
 *
 * @author shiva
 */
public class QuestionStore {

    @Override
    public String toString() {
        return "QuestionStore{" + "questionList=" + questionList + '}';
    }
    ArrayList<Question>questionList;
    public QuestionStore(){
        questionList= new ArrayList<>();
        
    }
    public void addQuestion(Question q){
        questionList.add(q);
        
    }
    public Question getQuestionByQno(int qno){
        for(Question quest:questionList){
            if(quest.getQno()==qno)
                return quest;
        }
            return null;
       
    }
    
    public Question getQuestion(int pos){
        return questionList.get(pos);
    }
    public void removeQuestion(int pos){
        questionList.remove(pos);
    }
    public void setQuestionAt(int pos,Question q){
        questionList.add(pos,q);
    }
    public ArrayList<Question>getAllQuestion(){
        return questionList;
    }
    public int getCount(){
        return questionList.size();
        
    }
    
}
