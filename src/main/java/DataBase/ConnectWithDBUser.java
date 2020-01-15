package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectWithDBUser {
    // private static final String PATH_TO_PROPERTIES = "data.properties";

    public static Connection getConnection() throws SQLException {

//        Properties props = new Properties();
//
//        FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
//        props.load(fileInputStream);
//
//        String url = props.getProperty("url");
//        String username = props.getProperty("username");
//        String password = props.getProperty("password");
        DriverManager.registerDriver( new com.mysql.jdbc.Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useUnicode=true&serverTimezone=UTC",
                "root", "fetOlegovich134911996");
    }
}
