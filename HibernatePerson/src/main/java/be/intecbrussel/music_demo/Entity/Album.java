package be.intecbrussel.music_demo.Entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    @Id
    private long id;

    private String title;
    private String author;

    @ElementCollection
    private List<String> arrayList = new ArrayList();

    public Album() {
    }

    public Album(long id, String title, String author, List<String> arrayList) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.arrayList = arrayList;
    }

    public long getId() {
        return id;
    }

    public Album setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Album setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Album setAuthor(String author) {
        this.author = author;
        return this;
    }

    public List<String> getArrayList() {
        return arrayList;
    }

    public Album setArrayList(List<String> arrayList) {
        this.arrayList = arrayList;
        return this;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", arrayList=" + arrayList +
                '}';
    }
}
