/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CollegeProject.pojo;

import java.util.Objects;

/**
 *
 * @author shiva
 */
public class Answer {
    private String examId;
    private String subject;
    private String chosenAnswer;
    private String correctAnswer;
    private int qno;

    public Answer(String examId, String subject, String chosenAnswer, String correctAnswer, int qno) {
        this.examId = examId;
        this.subject = subject;
        this.chosenAnswer = chosenAnswer;
        this.correctAnswer = correctAnswer;
        this.qno = qno;
    }

    @Override
    public String toString() {
        return "Answer{" + "examId=" + examId + ", subject=" + subject + ", chosenAnswer=" + chosenAnswer + ", correctAnswer=" + correctAnswer + ", qno=" + qno + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Answer other = (Answer) obj;
        if (this.qno != other.qno) {
            return false;
        }
        if (!Objects.equals(this.examId, other.examId)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.chosenAnswer, other.chosenAnswer)) {
            return false;
        }
        if (!Objects.equals(this.correctAnswer, other.correctAnswer)) {
            return false;
        }
        return true;
    }

   
    
    

    public String getExamId() {
        return examId;
    }

    public String getSubject() {
        return subject;
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getQno() {
        return qno;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    int getAno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
