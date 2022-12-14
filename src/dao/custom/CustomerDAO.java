package dao.custom;

import dao.CrudDAO;
import dto.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer, String> {

    public List<String> getCustomerIds() throws SQLException, ClassNotFoundException;

}
