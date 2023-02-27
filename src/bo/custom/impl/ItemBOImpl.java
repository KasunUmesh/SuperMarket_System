package bo.custom.impl;

import bo.custom.ItemBO;
import dao.custom.ItemDAO;
import dao.custom.impl.ItemDAOImpl;
import dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    private ItemDAO item = new ItemDAOImpl();

    @Override
    public ItemDTO searchItem(String itemId) throws SQLException, ClassNotFoundException {
        return item.search(itemId);
    }

    @Override
    public List<String> getAllItemCodes() throws SQLException, ClassNotFoundException {
        return item.getAllItemCodes();
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return item.getAll();
    }

    @Override
    public boolean addItem(ItemDTO i1) throws SQLException, ClassNotFoundException {
        return item.add(i1);
    }

    @Override
    public boolean updateItem(ItemDTO i1) throws SQLException, ClassNotFoundException {
        return item.update(i1);
    }

    @Override
    public boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException {
        return item.delete(itemCode);
    }
}
