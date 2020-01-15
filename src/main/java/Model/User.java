package Model;

import lombok.*;

@ToString
@EqualsAndHashCode
public class User {

    private String login;
    private String password;
    private String roleName;

    public User( String login, String password, String roleName) {
        this.login = login;
        this.password = password;
        this.roleName=roleName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}