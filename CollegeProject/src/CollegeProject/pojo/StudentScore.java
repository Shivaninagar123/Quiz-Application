/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CollegeProject.pojo;

/**
 *
 * @author shiva
 */
public class StudentScore {
    String subject;
    double percentage;

    public StudentScore(String subject, double percentage) {
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getSubject() {
        return subject;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

}
