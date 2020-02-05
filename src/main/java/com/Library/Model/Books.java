package com.Library.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@Table(name = "books")
@Entity
@Data
public class Books {
    @Id
    @Column(name = "bookId")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Integer bookId;
     private String bookName;
     private Integer authorId;
     private String category;

}
