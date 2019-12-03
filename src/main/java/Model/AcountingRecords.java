package Model;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
public class AcountingRecords {

     private Integer accountId;
     private Integer clientId;
     private Integer bookId;
     private Date receiptDate;
     private Date returnDate;
     private String statusId;
}

