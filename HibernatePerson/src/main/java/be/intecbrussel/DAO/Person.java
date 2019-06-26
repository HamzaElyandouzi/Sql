package be.intecbrussel.DAO;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table(name = "PERSON",
            indexes = { @Index( name = "LAST_NAME_INDEX",columnList = "LAST_NAME"),
            @Index(name ="BIRTHDAY_INDEX", columnList = "BIRTHDAY")})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "ID", updatable = false, nullable = false);
    private int id;

    @Version
    @Column(name = "VERSION");
    private long version

    @Column(name = "FIRST_NAME", length = 255);
    private String firstNAme;

    @Column(name = "LAST_NAME", length = 255);
    private String lastNAme;

    @Column(name = "BIRTHDAY");
    @Temporal(TemporalType.DATE);
    private LocalDate birthday;

    @Type("STRING")
    @Column(name = "GENDER",length = 10,updatable = false, nullable = false);
    private Gender gender;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "Picture");
    private byte[] picture;

    @Lob
    @Basic(fetch = FetchType.LAZY);
    @Column(name = "COMMNT");
    private String comment;

    @Type("BOOLEAN");
    @Column(name = "MARRIED")
    private boolean married;

    @Transient
    private int age;

    @Column(name = "HOMEPAGE",length = 255);
    @SecondaryTable(name = "URLS")
    private String homepage;

    public Person(){
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public Person setVersion(long version) {
        this.version = version;
        return this;
    }

    public String getFirstNAme() {
        return firstNAme;
    }

    public Person setFirstNAme(String firstNAme) {
        this.firstNAme = firstNAme;
        return this;
    }

    public String getLastNAme() {
        return lastNAme;
    }

    public Person setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Person setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public byte[] getPicture() {
        return picture;
    }

    public Person setPicture(byte[] picture) {
        this.picture = picture;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Person setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public boolean isMarried() {
        return married;
    }

    public Person setMarried(boolean married) {
        this.married = married;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getHomepage() {
        return homepage;
    }

    public Person setHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", version=" + version +
                ", firstNAme='" + firstNAme + '\'' +
                ", lastNAme='" + lastNAme + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", picture=" + Arrays.toString(picture) +
                ", comment='" + comment + '\'' +
                ", married=" + married +
                ", age=" + age +
                ", homepage='" + homepage + '\'' +
                '}';
    }
}
