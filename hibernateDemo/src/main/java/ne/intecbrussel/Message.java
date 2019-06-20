package ne.intecbrussel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity//make's the class a class Entity for database/hibernate
public class Message {

    @Id//shows what the primary key will be, Id
   // @GeneratedValue//AutoIncrement
    private int id;
    private String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public Message setId(int id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
