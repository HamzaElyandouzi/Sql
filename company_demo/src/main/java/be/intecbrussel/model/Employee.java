package be.intecbrussel.model;

public class Employee {
    private int id;
    private String firstName;
    private String lastname;
    private String department;
    private Company companyID;

    public Employee() {
    }

    public Employee(String firstName, String lastname, String department, Company companyID) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.department = department;
        this.companyID = companyID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Company getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", department='" + department + '\'' +
                ", companyID=" + companyID +
                '}';
    }
}
