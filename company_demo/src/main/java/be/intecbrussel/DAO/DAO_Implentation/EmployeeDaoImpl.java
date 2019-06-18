package be.intecbrussel.DAO.DAO_Implentation;

import be.intecbrussel.DAO.ConnectionPovider;
import be.intecbrussel.DAO.DAO_Interface.EmployeeDAO;
import be.intecbrussel.model.Company;
import be.intecbrussel.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDAO {

    private Connection createConnection(){
        return ConnectionPovider.getInstance().getConnection();
    }

    @Override
    public void create(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = createConnection().prepareStatement(
                "insert into employee (firstName, lastName, department, companyId ) VALUES (?,?,?,?);");

        preparedStatement.setString(1,employee.getFirstName());
        preparedStatement.setString(2,employee.getLastname());
        preparedStatement.setString(3,employee.getDepartment());
        preparedStatement.setInt(4,employee.getCompanyID().getId());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public Employee read(int id) throws SQLException {
        PreparedStatement preparedStatement = createConnection().prepareStatement("select * from employee where id = ?");
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();

        Employee employee = new Employee();

        while(resultSet.next()){
            employee.setId(resultSet.getInt("id"));
            employee.setFirstName(resultSet.getString("firstName"));
            employee.setLastname(resultSet.getString("lastName"));
            employee.setDepartment(resultSet.getString("department"));
            employee.setCompanyID(new Company().setId(resultSet.getInt("companyId")));
        }
        return employee;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = createConnection().prepareStatement(
                "update employee set firstName = ?, lastName = ? , department = ?, companyId= ? where id = ?;");

        preparedStatement.setString(1,employee.getFirstName());
        preparedStatement.setString(2,employee.getLastname());
        preparedStatement.setString(3,employee.getDepartment());
        preparedStatement.setObject(4,employee.getCompanyID());
        preparedStatement.setInt(5,employee.getId());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = createConnection().prepareStatement(
                "delete from company where id = ?;");

        preparedStatement.setInt(1,employee.getId());
        preparedStatement.executeUpdate();
    }
}
