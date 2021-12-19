package pl.kzapart.item.command.api.aggregate;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kzapart.item.command.api.commands.AddItemCommand;
import pl.kzapart.item.command.api.data.Item;
import pl.kzapart.item.command.api.events.AddItemEvent;
import pl.kzapart.item.command.api.model.ItemModel;

import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemAggregateTest {

    private FixtureConfiguration<ItemAggregate> fixture;

    @BeforeEach
    void setUp() {
        fixture = new AggregateTestFixture<>(ItemAggregate.class);
    }

    @Test
    void shouldSaveItem() {
        Long ID_GUID = 12415151L;
        String name = "testItem";

        fixture.givenNoPriorActivity()
                .when(new AddItemCommand(ID_GUID,name))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new AddItemEvent(ID_GUID,name));

    }
}