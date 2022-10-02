package bo.custom;

import dto.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemBO {
    
    Item searchItem(String itemId) throws SQLException, ClassNotFoundException;

    List<String> getAllItemCodes() throws SQLException, ClassNotFoundException;

    ArrayList<Item> getAllItem() throws SQLException, ClassNotFoundException;

    boolean addItem(Item i1) throws SQLException, ClassNotFoundException;

    boolean updateItem(Item i1) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException;
}
