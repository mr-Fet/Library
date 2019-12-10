package Model;

import View.AuthorView;
import lombok.*;

@ToString
@EqualsAndHashCode
public class Authors {
     private Integer id;
     private String firstName;
     private String lastName;

     private Authors(AuthorsBuilder authorsBuilder) {
          this.id = authorsBuilder.id;
          this.firstName = authorsBuilder.firstName;
          this.lastName = authorsBuilder.lastName;
     }

     public Integer getId() {
          return id;
     }

     public String getFirstName() {
          return firstName;
     }

     public String getLastName() {
          return lastName;
     }

     public static class AuthorsBuilder{
          private Integer id;
          private String firstName;
          private String lastName;

          public AuthorsBuilder(Integer id) {
               this.id = id;

          }

          public AuthorsBuilder setFirstName(String firstName) {
               this.firstName = firstName;
               return this;
          }

          public AuthorsBuilder setLastName(String lastName) {
               this.lastName = lastName;
               return this;
          }
          public Authors build(){
               return new Authors(this);
          }
     }
}
