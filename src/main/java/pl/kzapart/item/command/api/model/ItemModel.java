package pl.kzapart.item.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ItemModel {

    private Long ID_GUID;
    private String name;
}
