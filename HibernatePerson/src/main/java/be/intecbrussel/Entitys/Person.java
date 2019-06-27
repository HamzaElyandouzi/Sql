package be.intecbrussel.Entitys;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

@Entity
@Table(name = "PERSON",
        //name is optional but columnList is required
        indexes = { @Index( name = "LAST_NAME_INDEX",columnList = "LAST_NAME"),
                @Index(name ="BIRTHDAY_INDEX", columnList = "BIRTHDAY")})
@SecondaryTable(name = "URLS")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private int id;

    //annotation for concurred programing 'Threading' to allow
    @Version
    @Column(name = "VERSION")
    private long version;


    @Column(name = "FIRST_NAME", length = 40, nullable = false)
    private String firstNAme;

    @Column(name = "LAST_NAME", length = 40, nullable = false)
    private String lastNAme;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @Column(name = "GENDER", length = 10, updatable = false, nullable = false)
    //This annotation will translate the ENUM Type to a String value instead of a number value
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Lob
    //this annotation will hold the value back and will only pull it in when you need it and before
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "PICTURE")
    private byte[] picture;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    //we call this columnName comnt because the comment word often already reserved in practice
    @Column(name = "COMMNT")
    private String comment;

    @Column(name = "MARRIED", columnDefinition = "BOOLEAN")
    private boolean married;

    //this will embedded into this Entity with another class that has the @Embedded annotation
    @Embedded
    private Adress adress;

    @Transient
    private int age;

    @Column(name = "HOMEPAGE", table = "URLS")
    private String homepage;

    public Person() {
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

    @Transient
    public int getAge() {
        return Period.between(birthday,LocalDate.now()).getYears();
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

    public Adress getAdress() {
        return adress;
    }

    public Person setAdress(Adress adress) {
        this.adress = adress;
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
                ", Gender=" + gender +
                ", picture=" + Arrays.toString(picture) +
                ", comment='" + comment + '\'' +
                ", married=" + married +
                ", age=" + age +
                ", homepage='" + homepage + '\'' +
                '}';
    }
}
