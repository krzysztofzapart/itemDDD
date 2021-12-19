package pl.kzapart.item.command.api.events;


import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pl.kzapart.item.command.api.data.Item;
import pl.kzapart.item.command.api.data.ItemRepository;

@Component
public class ItemEventHandler {

    private ItemRepository itemRepository;

    public ItemEventHandler(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @EventHandler
    public void on(AddItemEvent addItemEvent) throws Exception {
        Item item =
                new Item();
        BeanUtils.copyProperties(addItemEvent,item);
        itemRepository.save(item);
        throw new Exception("Exception Occurred");
    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
