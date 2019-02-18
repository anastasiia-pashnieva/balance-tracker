package com.pashnieva.website.api.item.service;

import com.pashnieva.website.api.item.dto.Item;

import java.util.List;

public interface ItemService {

    Item getItem(Long id);
    List<Item> getAllItems();
    List<Item> getItemsByIds(List<Long> ids);
    Item createItem(Item item);
    Item updateItem(Item item);
    void deleteItem(Long id);
}
