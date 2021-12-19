package pl.kzapart.item.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
public class AddItemCommand {

    @TargetAggregateIdentifier
    private Long ID_GUID;
    private String name;
}
