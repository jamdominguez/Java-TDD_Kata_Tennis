import lombok.AllArgsConstructor;
import lombok.Data;

@Data //generate getters, setters and toString() in compilation time
@AllArgsConstructor //generate constructor with arguments in compilation time
public class PlayerPoints {
     private int wins;
     private int points;
     private String messagePoints;
}