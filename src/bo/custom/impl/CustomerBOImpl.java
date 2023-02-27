package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {


    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public Customer searchCustomer(String customerId) throws SQLException, ClassNotFoundException {
        return customerDAO.search(customerId);
    }

    @Override
    public List<String> getCustomerIds() throws SQLException, ClassNotFoundException {
        return customerDAO.getCustomerIds();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll();
        for (Customer customer : all) {
            allCustomers.add(new CustomerDTO(customer.getId(), customer.getTitle(), customer.getName(), customer.getAddress(), customer.getCity(), customer.getProvince(), customer.getPostalCode()));
        }
        return allCustomers;
    }

    @Override
    public boolean updateCustomer(CustomerDTO c1) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(c1.getId(), c1.getTitle(), c1.getName(), c1.getAddress(), c1.getCity(), c1.getProvince(), c1.getPostalCode()));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public boolean addCustomer(CustomerDTO c1) throws SQLException, ClassNotFoundException {
        return customerDAO.add(new Customer(c1.getId(), c1.getTitle(), c1.getName(), c1.getAddress(), c1.getCity(), c1.getProvince(), c1.getPostalCode()));
    }
}
