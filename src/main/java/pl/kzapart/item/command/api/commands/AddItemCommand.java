package pl.kzapart.item.command.api.commands;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;


@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddItemCommand {

    @TargetAggregateIdentifier
    private Long ID_GUID;
    private String name;


}
