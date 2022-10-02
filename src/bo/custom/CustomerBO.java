package bo.custom;

import dto.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerBO {
    
    Customer searchCustomer(String customerId) throws SQLException, ClassNotFoundException;

    List<String> getCustomerIds() throws SQLException, ClassNotFoundException;

    ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException;

    boolean updateCustomer(Customer c1) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean addCustomer(Customer c1) throws SQLException, ClassNotFoundException;
}
