package be.intecbrussel;

import be.intecbrussel.Controller.Controller_impl.ServiceImpl;
import be.intecbrussel.Controller.Controller_interface.Service;
import be.intecbrussel.DAO.DAO_Implentation.CompanyDaoImpl;
import be.intecbrussel.DAO.DAO_Implentation.EmployeeDaoImpl;
import be.intecbrussel.DAO.DAO_Interface.CompanyDAO;
import be.intecbrussel.DAO.DAO_Interface.EmployeeDAO;
import be.intecbrussel.model.Company;
import be.intecbrussel.model.Employee;

import java.sql.SQLException;

public class CompanyApp {
    public static void main(String[] args) {

        //CompanyDAO companyDAO = new CompanyDaoImpl();

        //Service service =   new ServiceImpl();

        EmployeeDAO employeeDAO = new EmployeeDaoImpl();

        /*try{

            //companyDAO.create(new Company("intec", "BE123456789", "Rouppeplien 16", "Brussel"));
            //System.out.println(companyDAO.read(6));

            //companyDAO.update(new Company("ibm","be987654321","mier 205", "Antwerpen").setId(5));
            //System.out.println(companyDAO.read(5));

            //companyDAO.delete(new Company().setId(5));
            //System.out.println(companyDAO.read(5));

            //service.create(new Company("ibm","be987654321","mier 205", "Antwerpen"));
            //service.create(new Company("intec", "BE123456789", "Rouppeplien 16", "Brussel"));
            //service.read(new Company().setId(7));
            //service.update(Company);

            //employeeDAO.create(new Employee("Hamza", "elyandouzi", "Itec", new Company().setId(5)));
            //employeeDAO.create(new Employee("Daan", "Van Hout", "NewTec", new Company().setId(6)));
            //System.out.println(employeeDAO.read(3));

            //companyDAO.update(new Company("ibm","be987654321","mier 205", "Antwerpen").setId(5));
            //System.out.println(companyDAO.read(5));

            //companyDAO.delete(new Company().setId(5));
            //System.out.println(companyDAO.read(5));
            //service.delete(new Company().setId(7));
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

    }
         */
    }
}
