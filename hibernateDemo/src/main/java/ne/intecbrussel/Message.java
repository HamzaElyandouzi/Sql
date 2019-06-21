package ne.intecbrussel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity//make's the class a class Entity for database/hibernate
public class Message {

    @Id//shows what the primary key will be, Id
    @GeneratedValue//AutoIncrement
    private int id;
    private String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    /*
    *if you want that hibernate uses your geters and setters to fill
    *in the database and not your properties in case there is some
    *logic in the methode's them self that need to be accesed
    * you should place the tags above the corresponding methode's
    * and the the properties.
    *
    *shows what the primary key will be, Id
    * @Id
    *AutoIncrement with multiple different generatedType's
    *@GeneratedValue(generatedType's)
    */
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
