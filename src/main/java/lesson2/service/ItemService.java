package lesson2.service;

import lesson2.HttpExсeption;
import lesson2.dao.ItemDAO;
import lesson2.model.Item;

import java.net.HttpRetryException;


public class ItemService {

    private ItemDAO itemDAO = new ItemDAO();

    public Item save(Item item) throws Exception {
        validateItem(item);
        return itemDAO.save(item);
    }

    public Item update(Item item) throws Exception {
        validateItem(item);
        return itemDAO.update(item);
    }

    public Item delete(Long id) throws Exception {
        Item item = itemDAO.findById(id);
        if(item == null)
            throw new Exception("There is no item with id: "+id);

        return itemDAO.delete(item);
    }

    public Item findById(Long id) throws Exception{
        return itemDAO.findById(id);
    }

    private void validateItem(Item item) throws Exception {
        if(item.getName().equals(""))
            throw new HttpExсeption(400,"Item name can not be empty");
        if(itemDAO.findByName(item.getName()) != null)
            throw new HttpExсeption(400,"Item with name: "+item.getName()+" already exists");
    }
}
