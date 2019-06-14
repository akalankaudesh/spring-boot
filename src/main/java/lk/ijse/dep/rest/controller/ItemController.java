package lk.ijse.dep.rest.controller;


import lk.ijse.dep.rest.dto.ItemDTO;
import lk.ijse.dep.rest.service.custom.ManageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "api/v1/items")
@CrossOrigin
@RestController
public class ItemController {

    @Autowired
    ManageItemService itemService;

    @GetMapping
    public ResponseEntity <List<ItemDTO>> findAllItems(){
        List<ItemDTO> items = itemService.getItems();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count", items.size() + "");
        return new ResponseEntity<List<ItemDTO>>(items, httpHeaders, HttpStatus.OK);
    }


    @GetMapping("/{id:I\\d{3}}")
    public ResponseEntity<ItemDTO> findItem(@PathVariable("id") String itemId) {
        ItemDTO item = itemService.findItem(itemId);
        HttpStatus status = (item !=null)? HttpStatus.OK: HttpStatus.NOT_FOUND;
        return new ResponseEntity<ItemDTO>(item, status);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveItem(@RequestBody ItemDTO item) {
        itemService.createItem(item);
    }


    @DeleteMapping("/{id:I\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") String itemcode) {
        itemService.deleteItem(itemcode);
    }


    @PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateItem(@PathVariable("id") String itemcode,
                                         @RequestBody ItemDTO item) {
        if (itemcode.equals(item.getItem_code())) {
            itemService.updateItem(item);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
