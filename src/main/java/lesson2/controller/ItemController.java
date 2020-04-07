package lesson2.controller;

import lesson2.service.ItemService;
import lesson2.model.Item;

public class ItemController {

    private ItemService itemService = new ItemService();


    public Item save(Item item) throws Exception {
        return itemService.save(item);
    }

    public Item update(Item item) throws Exception{
        return itemService.update(item);
    }

    public Item delete(Long id) throws Exception{
        return itemService.delete(id);
    }

    public Item findById(Long id) throws Exception{
        return itemService.findById(id);
    }
}
