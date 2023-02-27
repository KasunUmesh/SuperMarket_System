package bo.custom;

import bo.SuperBO;
import dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemBO extends SuperBO {
    
    ItemDTO searchItem(String itemId) throws SQLException, ClassNotFoundException;

    List<String> getAllItemCodes() throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    boolean addItem(ItemDTO i1) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO i1) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException;
}
