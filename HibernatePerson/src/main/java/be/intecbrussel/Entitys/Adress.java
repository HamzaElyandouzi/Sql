package be.intecbrussel.Entitys;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adress {
    @Column(name = "STREET")
    private String street;

    @Column(name = "NUMBER")
    private int number;

    @Column(name = "ZIPCODE")
    private int zipcode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "Country")
    private String country;

    public Adress() {
    }

    public Adress(String street, int number, int zipcode, String city, String country) {
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public Adress setStreet(String street) {
        this.street = street;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Adress setNumber(int number) {
        this.number = number;
        return this;
    }

    public int getZipcode() {
        return zipcode;
    }

    public Adress setZipcode(int zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Adress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Adress setCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", zipcode=" + zipcode +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
