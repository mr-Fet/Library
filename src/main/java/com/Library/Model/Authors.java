package com.Library.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@EqualsAndHashCode
@Entity
@Data
public class Authors {
     @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Integer authorId;
     private String firstName;
     private String lastName;

}
