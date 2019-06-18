package be.intecbrussel.Controller.Controller_interface;

import be.intecbrussel.model.Company;
import be.intecbrussel.model.Employee;

import java.sql.SQLException;

public interface Service {
    void create(Company company) throws SQLException;
    Company read(int id) throws SQLException;
    void update(Company company) throws SQLException;
    void delete(Company company) throws SQLException;
}
