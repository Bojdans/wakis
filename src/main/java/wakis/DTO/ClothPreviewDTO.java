package wakis.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ClothPreviewDTO {
    private String name;
    private List<String> images;
    private long cost;
    private long fakeCost;

}
