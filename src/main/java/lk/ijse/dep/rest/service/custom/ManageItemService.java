package lk.ijse.dep.rest.service.custom;

import lk.ijse.dep.rest.dto.ItemDTO;
import lk.ijse.dep.rest.service.SuperService;

import java.util.List;

public interface ManageItemService extends SuperService {
    List<ItemDTO> getItems();

    void createItem(ItemDTO dto);

    void updateItem(ItemDTO dto);

    void deleteItem(String ItemID);

    ItemDTO findItem(String id);

//    List<ItemDTO> findCustomersByAddress(String address);

}
