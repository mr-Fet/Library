package com.Library.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@ToString
@EqualsAndHashCode
@Entity
@Data
public class AccountingRecords {

     @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Integer accountId;
     private Integer clientId;
     private Integer bookId;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date receiptDate;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date returnDate;
     private String status;


}

