package be.intecbrussel.DAO.DAO_Implentation;

import be.intecbrussel.DAO.ConnectionPovider;
import be.intecbrussel.DAO.DAO_Interface.CompanyDAO;
import be.intecbrussel.model.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDaoImpl implements CompanyDAO {

    private Connection createConnection(){
        return ConnectionPovider.getInstance().getConnection();
    }


    @Override
    public void create(Company company) throws SQLException {
        PreparedStatement preparedStatement = createConnection().prepareStatement(
                "insert into company (name, vat, adress, city) VALUES (?,?,?,?);");

        preparedStatement.setString(1,company.getName());
        preparedStatement.setString(2,company.getVat());
        preparedStatement.setString(3,company.getAdress());
        preparedStatement.setString(4,company.getCity());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public Company read(int id) throws SQLException {
        PreparedStatement preparedStatement = createConnection().prepareStatement("select * from company where id = ?");
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();

        Company company = new Company();

        while(resultSet.next()){
            company.setId(resultSet.getInt("id"));
            company.setName(resultSet.getString("name"));
            company.setVat(resultSet.getString("vat"));
            company.setAdress(resultSet.getString("adress"));
            company.setCity(resultSet.getString("city"));
        }
        return company;
    }

    @Override
    public void update(Company company) throws SQLException {
        PreparedStatement preparedStatement = createConnection().prepareStatement(
                "update company set name = ?,vat = ? , adress = ?, city = ? where id = ?;");

        preparedStatement.setString(1,company.getName());
        preparedStatement.setString(2,company.getVat());
        preparedStatement.setString(3,company.getAdress());
        preparedStatement.setString(4,company.getCity());
        preparedStatement.setInt(5,company.getId());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(Company company) throws SQLException {
        PreparedStatement preparedStatement = createConnection().prepareStatement(
                "delete from company where id = ?;");

        preparedStatement.setInt(1,company.getId());
        preparedStatement.executeUpdate();
    }
}
