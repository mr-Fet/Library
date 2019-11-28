package Model;

import lombok.*;

@Data
@AllArgsConstructor
public class Books {
   private Integer id;
     private String name;
     private Integer authorId;
     private String category;

}
