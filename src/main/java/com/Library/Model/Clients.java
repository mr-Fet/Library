package com.Library.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EqualsAndHashCode
@ToString
@Entity
@Data
 public class Clients {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Integer clientId;
     private String firstName;
     private String lastName;

}
