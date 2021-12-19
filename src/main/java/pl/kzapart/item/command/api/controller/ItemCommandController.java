package pl.kzapart.item.command.api.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kzapart.item.command.api.commands.AddItemCommand;
import pl.kzapart.item.command.api.model.ItemModel;


@RestController
@RequestMapping("/items")
public class ItemCommandController {

    private CommandGateway commandGateway;

    public ItemCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public AddItemCommand addProduct(@RequestBody ItemModel itemModel) {

        AddItemCommand addItemCommand =
                AddItemCommand.builder()
                        .ID_GUID(itemModel.getID_GUID())
                        .name(itemModel.getName())
                        .build();
         commandGateway.sendAndWait(addItemCommand);
        return addItemCommand;
    }
}
