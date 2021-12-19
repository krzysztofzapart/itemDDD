package pl.kzapart.item.query.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kzapart.item.command.api.data.Item;

public interface ItemQueryRepository extends JpaRepository<Item, Long> {

}
