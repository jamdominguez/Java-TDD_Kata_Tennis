import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerPoints {
     private int wins;
     private int points;
     private String messagePoints;
}