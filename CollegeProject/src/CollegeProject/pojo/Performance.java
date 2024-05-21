/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CollegeProject.pojo;

/**
 *
 * @author shiva
 */
public class Performance {
    private String userId;
    private String language;
    private String examId;
    private int right;
    private int wrong;
    private int unattempted;
    private double per;
    
    public Performance(){
    
    }
    public Performance(String examId, String language, String userId, int right, int wrong, int unattempted, double per) {
        this.examId = examId;
        this.language = language;
        this.userId = userId;
        this.right = right;
        this.wrong = wrong;
        this.unattempted = unattempted;
        this.per = per;
    }

    public String getUserId() {
        return userId;
    }

    public String getLanguage() {
        return language;
    }

    public String getExamId() {
        return examId;
    }

    public int getRight() {
        return right;
    }

    public int getWrong() {
        return wrong;
    }

    public int getUnattempted() {
        return unattempted;
    }

    public double getPer() {
        return per;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public void setUnattempted(int unattempted) {
        this.unattempted = unattempted;
    }

    public void setPer(double per) {
        this.per = per;
    }
    
}
