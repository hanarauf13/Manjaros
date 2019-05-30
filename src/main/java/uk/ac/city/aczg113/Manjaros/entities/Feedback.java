package uk.ac.city.aczg113.Manjaros.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {

    @Id
    private String email;
    private String feedback;

    public Feedback(){ }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
