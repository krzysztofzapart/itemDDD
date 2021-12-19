package pl.kzapart.item.query.api.controller;

import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kzapart.item.command.api.data.Item;
import pl.kzapart.item.query.api.queries.FindItemByIdGUID;


@RestController
@RequestMapping("/items")
public class ItemQueryController {

    private QueryGateway queryGateway;

    public ItemQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{ID_GUID}")
    public ResponseEntity<Item> getAccount(@PathVariable Long ID_GUID) {
        Item item = queryGateway.query(
                new FindItemByIdGUID(ID_GUID), Item.class
        ).join();

        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}
