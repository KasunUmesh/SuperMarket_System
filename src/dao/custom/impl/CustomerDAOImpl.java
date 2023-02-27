package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer c) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(c);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

//        return CrudUtil.executeUpdate("DELETE FROM Customer WHERE id=?", id);
        return true;
    }

    @Override
    public boolean update(Customer c) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(c);

        transaction.commit();
        return true;
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {

        /*ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer WHERE id=?", id);

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
        }*/

        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {

        /*ArrayList<Customer> customers = new ArrayList<>();

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
        return customers;*/

        return null;
    }



    @Override
    public List<String> getCustomerIds() throws SQLException, ClassNotFoundException {

       /* List<String> ids = new ArrayList<>();

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer");

        while (rst.next()){
            ids.add(rst.getString(1));
        }
        return ids;*/

        return null;
    }

    @Override
    public String generateNewID() {
        return null;
    }

}
