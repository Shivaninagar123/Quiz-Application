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
public class AnswerStore {
    ArrayList <Answer> answerList;
     
     
    @Override
    public String toString() {
        return "AnswerStore{" + "answerList=" + answerList + '}';
    }
    
  
    public AnswerStore()
    {
       answerList=new ArrayList<>();
    }
    public void addAnswer(Answer q){
        answerList.add(q);
    }
    public Answer getAnswer(int pos){
        return answerList.get(pos);
    }
    public Answer getAnswerByQno(int qno)
    {
        for(Answer answer: answerList){
            if(answer.getQno()==qno)
                return answer;
        }
        return null;
    }
    public void removeAnswer(int pos){
        answerList.remove(pos);
    }
    public void setAnswerAt(int pos,Answer q){
        answerList.add(pos, q);
    }
    public ArrayList<Answer> getAllAnswer(){
        return answerList;
    }
    public int getCount(){
        return answerList.size();
    }
    public int removeAnswer(Answer answer){
        int pos=answerList.indexOf(answer);
        answerList.remove(pos);
        return pos;
    }
}
