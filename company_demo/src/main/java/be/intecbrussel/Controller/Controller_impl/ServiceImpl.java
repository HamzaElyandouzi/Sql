package be.intecbrussel.Controller.Controller_impl;

import be.intecbrussel.Controller.Controller_interface.Service;
import be.intecbrussel.DAO.DAO_Implentation.CompanyDaoImpl;
import be.intecbrussel.model.Company;

import java.sql.SQLException;

public class ServiceImpl implements Service {

    private CompanyDaoImpl companyDao = new CompanyDaoImpl();


    @Override
    public void create(Company company) throws SQLException {
        companyDao.create(company);
    }

    @Override
    public Company read(int id) throws SQLException {
        return companyDao.read(id);
    }

    @Override
    public void update(Company company) throws SQLException {
        companyDao.update(company);
    }

    @Override
    public void delete(Company company) throws SQLException {
        companyDao.delete(company);
    }
}
