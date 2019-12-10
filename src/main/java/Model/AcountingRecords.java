package Model;
import lombok.*;
import java.util.Date;

@ToString
@EqualsAndHashCode
public class AcountingRecords {

     private Integer accountId;
     private Integer clientId;
     private Integer bookId;
     private Date receiptDate;
     private Date returnDate;
     private String statusId;

     private AcountingRecords(AccountBuilder accountBuilder) {
          this.accountId = accountBuilder.accountId;
          this.clientId = accountBuilder.clientId;
          this.bookId = accountBuilder.bookId;
          this.receiptDate = accountBuilder.receiptDate;
          this.returnDate = accountBuilder.returnDate;
          this.statusId = accountBuilder.statusId;
     }

     public Integer getAccountId() {
          return accountId;
     }

     public Integer getClientId() {
          return clientId;
     }

     public Integer getBookId() {
          return bookId;
     }

     public Date getReceiptDate() {
          return receiptDate;
     }

     public Date getReturnDate() {
          return returnDate;
     }

     public String getStatusId() {
          return statusId;
     }

     public static class AccountBuilder{
          private Integer accountId;
          private Integer clientId;
          private Integer bookId;
          private Date receiptDate;
          private Date returnDate;
          private String statusId;

          public AccountBuilder(Integer accountId) {
               this.accountId = accountId;
          }

          public AccountBuilder setClientId(Integer clientId) {
               this.clientId = clientId;
               return this;
          }

          public AccountBuilder setBookId(Integer bookId) {
               this.bookId = bookId;
               return this;
          }

          public AccountBuilder setReceiptDate(Date receiptDate) {
               this.receiptDate = receiptDate;
               return this;
          }

          public AccountBuilder setReturnDate(Date returnDate) {
               this.returnDate = returnDate;
               return this;
          }

          public AccountBuilder setStatusId(String statusId) {
               this.statusId = statusId;
               return this;
          }
          public AcountingRecords build(){
               return new AcountingRecords(this);
          }
     }
}

