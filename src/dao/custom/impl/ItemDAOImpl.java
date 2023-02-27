package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item i) throws SQLException, ClassNotFoundException {

       /* return CrudUtil.executeUpdate("INSERT INTO Item VALUES(?,?,?,?,?)",

                i.getItemCode(),
                i.getDescription(),
                i.getPackSize(),
                i.getUnitPrice(),
                i.getQtyOnHand()

        );*/

        return true;

    }

    @Override
    public boolean delete(String itemCode) throws SQLException, ClassNotFoundException {

//        return CrudUtil.executeUpdate("DELETE FROM Item WHERE itemCode=?", itemCode);

        return true;

    }

    @Override
    public boolean update(Item i) throws SQLException, ClassNotFoundException {

       /* return CrudUtil.executeUpdate("UPDATE Item SET description=?, packSize=?, unitPrice=?, qtyOnHand=? WHERE itemCode=?",

                i.getDescription(),
                i.getPackSize(),
                i.getUnitPrice(),
                i.getQtyOnHand(),
                i.getItemCode()

        );*/

        return true;

    }

    @Override
    public Item search(String itemCode) throws SQLException, ClassNotFoundException {

        /*ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item WHERE itemCode=?", itemCode);

        if(rst.next()){
            return new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    Double.parseDouble(rst.getString(4)),
                    Integer.parseInt(rst.getString(5))
            );
        }else {
            return null;
        }*/

        return null;

    }

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {

       /* ArrayList<Item> itemDTOS = new ArrayList<>();

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item");

        while (rst.next()){
            itemDTOS.add(new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    Double.parseDouble(rst.getString(4)),
                    Integer.parseInt(rst.getString(5))
            ));
        }
        return itemDTOS;*/

        return null;
    }

    @Override
    public List<String> getAllItemCodes() throws SQLException, ClassNotFoundException {

        /*List<String> ids = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item");

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
