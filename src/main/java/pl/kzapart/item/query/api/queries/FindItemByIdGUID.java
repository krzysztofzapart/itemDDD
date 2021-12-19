package pl.kzapart.item.query.api.queries;

import lombok.Data;

@Data
public class FindItemByIdGUID {
    private Long ID_GUID;

    public FindItemByIdGUID(Long ID_GUID) {
        this.ID_GUID = ID_GUID;
    }
}
