package Model;
import lombok.*;

@ToString
@EqualsAndHashCode
 public class Client {
     private Integer id;
     private String firstName;
     private String lastName;

    private Client(ClientBuilder clientBuilder) {
        this.id = clientBuilder.id;
        this.firstName = clientBuilder.firstName;
        this.lastName = clientBuilder.lastName;
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


    public static class ClientBuilder{
        private Integer id;
        private String firstName;
        private String lastName;

        public ClientBuilder(Integer id) {
            this.id = id;
        }

        public ClientBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ClientBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Client build(){

            return new Client(this);
        }
    }

}
