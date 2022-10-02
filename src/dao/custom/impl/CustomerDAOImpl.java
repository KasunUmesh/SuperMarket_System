package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import dto.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer c) throws SQLException, ClassNotFoundException {

        return CrudUtil.executeUpdate("INSERT INTO Customer VALUES (?,?,?,?,?,?,?)",

                c.getId(),
                c.getTitle(),
                c.getName(),
                c.getAddress(),
                c.getCity(),
                c.getProvince(),
                c.getPostalCode()

        );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return CrudUtil.executeUpdate("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public boolean update(Customer c) throws SQLException, ClassNotFoundException {

        return CrudUtil.executeUpdate("UPDATE Customer SET title=?, name=?, address=?, city=?, province=?, postalCode=? WHERE id=?",

                c.getTitle(),
                c.getName(),
                c.getAddress(),
                c.getCity(),
                c.getProvince(),
                c.getPostalCode(),
                c.getId()

        );
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer WHERE id=?", id);

        if (rst.next()){
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            );
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<Customer> customers = new ArrayList<>();

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer");

        while (rst.next()){
            customers.add(new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            ));
        }
        return customers;
    }



    @Override
    public List<String> getCustomerIds() throws SQLException, ClassNotFoundException {

        List<String> ids = new ArrayList<>();

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer");

        while (rst.next()){
            ids.add(rst.getString(1));
        }
        return ids;
    }

}
