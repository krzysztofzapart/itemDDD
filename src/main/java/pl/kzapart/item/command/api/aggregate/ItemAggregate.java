package pl.kzapart.item.command.api.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import pl.kzapart.item.command.api.commands.AddItemCommand;
import pl.kzapart.item.command.api.events.AddItemEvent;


@Aggregate
public class ItemAggregate {

    @AggregateIdentifier
    private Long ID_GUID;
    private String name;


    @CommandHandler
    public ItemAggregate(AddItemCommand addItemCommand) {
        AddItemEvent addItemEvent =
                new AddItemEvent();

        BeanUtils.copyProperties(addItemCommand,addItemEvent);

        AggregateLifecycle.apply(addItemEvent);
    }

    public ItemAggregate() {
    }

    @EventSourcingHandler
    public void on(AddItemEvent addItemEvent) {
        this.ID_GUID = addItemEvent.getID_GUID();
        this.name = addItemEvent.getName();
    }
}
