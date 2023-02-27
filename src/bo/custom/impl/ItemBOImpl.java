package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dao.custom.impl.ItemDAOImpl;
import dto.ItemDTO;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    private ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ItemDTO searchItem(String itemId) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getAllItemCodes() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        ArrayList<Item> all = itemDAO.getAll();
        for (Item item : all) {
            allItems.add(new ItemDTO(item.getItemCode(), item.getDescription(), item.getPackSize(), item.getUnitPrice(), item.getQtyOnHand()));
        }
        return allItems;
    }

    @Override
    public boolean addItem(ItemDTO i1) throws SQLException, ClassNotFoundException {
        return itemDAO.add(new Item(i1.getItemCode(), i1.getDescription(), i1.getPackSize(), i1.getUnitPrice(), i1.getQtyOnHand()));
    }

    @Override
    public boolean updateItem(ItemDTO i1) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(i1.getItemCode(), i1.getDescription(), i1.getPackSize(), i1.getUnitPrice(), i1.getQtyOnHand()));
    }

    @Override
    public boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(itemCode);
    }
}
