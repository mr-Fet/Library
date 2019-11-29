package ConnectWithBD;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

import java.sql.*;
import java.util.Properties;

public class ConnectWithBD {
    Connection con;
    Statement stmt;
    private static final String PATH_TO_PROPERTIES = "src/main/resources/data.properties";

       public void connect() {
        try {
            con = getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from clients");
            while (rs.next())
             System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public  Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();

        FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
        props.load(fileInputStream);

        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
    public void closeConnect(){
        try{
        con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
