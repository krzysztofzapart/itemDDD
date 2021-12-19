package pl.kzapart.item.query.api.service;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import pl.kzapart.item.command.api.data.Item;
import pl.kzapart.item.query.api.queries.FindItemByIdGUID;
import pl.kzapart.item.query.api.repository.ItemQueryRepository;
@Service
public class ItemService {

    private final ItemQueryRepository itemQueryRepository;

    public ItemService(ItemQueryRepository itemQueryRepository) {
        this.itemQueryRepository = itemQueryRepository;
    }

    @QueryHandler
    public Item handle(FindItemByIdGUID query) {
        Item item = itemQueryRepository
                .findById(query.getID_GUID()).orElse(null);

        return item;
    }
}
