package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOImpl;
import dto.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    private CustomerDAO customer = new CustomerDAOImpl();

    @Override
    public Customer searchCustomer(String customerId) throws SQLException, ClassNotFoundException {
        return customer.search(customerId);
    }

    @Override
    public List<String> getCustomerIds() throws SQLException, ClassNotFoundException {
        return customer.getCustomerIds();
    }

    @Override
    public ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customer.getAll();
    }

    @Override
    public boolean updateCustomer(Customer c1) throws SQLException, ClassNotFoundException {
        return customer.update(c1);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customer.delete(id);
    }

    @Override
    public boolean addCustomer(Customer c1) throws SQLException, ClassNotFoundException {
        return customer.add(c1);
    }
}
