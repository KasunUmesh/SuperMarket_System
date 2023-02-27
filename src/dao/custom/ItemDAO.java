package dao.custom;

import dao.CrudDAO;
import dto.ItemDTO;
import entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item, String> {

    public List<String> getAllItemCodes() throws SQLException, ClassNotFoundException;
    String generateNewID();

}
