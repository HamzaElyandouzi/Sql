package be.intecbrussel.model;

public class Company {
    private int id;
    private String name;
    private String vat;
    private String adress;
    private String city;

    public Company() {
    }

    public Company(String name, String vat, String adress, String city) {
        this.name = name;
        this.vat = vat;
        this.adress = adress;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public Company setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("Company{id=%d, name='%s', vat='%s', adress='%s', city='%s'}", id, name, vat, adress, city);
    }
}

