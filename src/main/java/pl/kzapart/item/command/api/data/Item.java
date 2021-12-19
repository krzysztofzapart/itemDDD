package pl.kzapart.item.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Item {

    @Id
    private Long ID_GUID;
    private String name;
}
