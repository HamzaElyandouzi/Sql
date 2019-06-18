package be.intecbrussel.DAO.DAO_Interface;

import be.intecbrussel.model.Company;
import be.intecbrussel.model.Employee;

import java.sql.SQLException;

public interface EmployeeDAO {
    void create(Employee employee) throws SQLException;
    Employee read(int id) throws SQLException;
    void update(Employee employee) throws SQLException;
    void delete(Employee employee) throws SQLException;
}
