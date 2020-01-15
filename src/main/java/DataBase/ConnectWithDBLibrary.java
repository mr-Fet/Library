package DataBase;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

import java.sql.*;
import java.util.Properties;

public class ConnectWithDBLibrary {

//   private final static String url = "jdbc:mysql://localhost:3306/library?useUnicode=true&serverTimezone=UTC";
//   private final static String user = "root";
//   private final static String password = "fetOlegovich134911996";


    public static Connection getConnection() throws SQLException{

//        Properties props = new Properties();
//
//        FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
//        props.load(fileInputStream);
//
//        String url = props.getProperty("url");
//        String username = props.getProperty("username");
//        String password = props.getProperty("password");
        DriverManager.registerDriver( new com.mysql.jdbc.Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useUnicode=true&serverTimezone=UTC",
                "root", "fetOlegovich134911996");
    }
}

