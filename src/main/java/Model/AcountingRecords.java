package Model;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
public class AcountingRecords {

     private Integer id;
     private Integer accountId;
     private Integer bookId;
     private Date receiptDate;
     private Date returnDate;
     private String statusId;
}

