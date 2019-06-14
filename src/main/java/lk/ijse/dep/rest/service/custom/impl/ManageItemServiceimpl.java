package lk.ijse.dep.rest.service.custom.impl;

import lk.ijse.dep.rest.dto.ItemDTO;
import lk.ijse.dep.rest.repository.ItemRepository;
import lk.ijse.dep.rest.service.Converter;
import lk.ijse.dep.rest.service.custom.ManageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
public class ManageItemServiceimpl implements ManageItemService {

    private ItemRepository itemDAO;

    @Autowired
    public ManageItemServiceimpl (ItemRepository itemDAO){this.itemDAO=itemDAO;}

    @Transactional
    public List<ItemDTO> getItems() {

        return Converter.getitemDTOList(itemDAO.findAll());
    }

    @Override
    public void createItem(ItemDTO dto) {

        itemDAO.save(Converter.getitemEntity(dto));
    }

    @Override
    public void updateItem(ItemDTO dto) {
        itemDAO.save(Converter.getitemEntity(dto));
    }

    @Override
    public void deleteItem(String ItemID) {

        itemDAO.deleteById(ItemID);

    }

    @Override
    public ItemDTO findItem(String id) {
        return itemDAO.findById(id).map(Converter::<ItemDTO>getitemDTO).orElse(null);
    }
}
