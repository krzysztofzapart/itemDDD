package pl.kzapart.item.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddItemEvent {

    @TargetAggregateIdentifier
    private Long ID_GUID;
    private String name;
}
