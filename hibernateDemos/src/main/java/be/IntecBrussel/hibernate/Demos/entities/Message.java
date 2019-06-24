package be.IntecBrussel.hibernate.Demos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private int id;
    private String text;
    private LocalDateTime timeStampCreated;

    public Message() {
        timeStampCreated = LocalDateTime.now();
    }

    public Message(String text) {
        //this this reference the default constructor
        this();
        this.text = text;
    }

    public LocalDateTime getTimeStampCreated() {
        return timeStampCreated;
    }

    public Message setTimeStampCreated(LocalDateTime timeStampSent) {
        this.timeStampCreated = timeStampSent;
        return this;
    }

    public int getId() {
        return id;
    }

    public Message setId(int id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public Message setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", timeStampSent=" + timeStampCreated +
                '}';
    }
}
