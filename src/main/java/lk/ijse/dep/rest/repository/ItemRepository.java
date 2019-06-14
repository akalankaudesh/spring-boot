package lk.ijse.dep.rest.repository;

import lk.ijse.dep.rest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,String> {


}
