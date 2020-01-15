package DataBase;

import Model.Books;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class DataBaseListener implements ServletContextListener {

    private Statement stmt;
    private List<String> list = new ArrayList<>();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        String clientsTable = "create table if not exists clients (" +
                "idClients int(11) primary key not null unique, " +
                "firstname varchar(45)," +
                "lastname varchar(45));";
        list.add(clientsTable);

        String booksTable = "create table if not exists books (" +
                "idBook int(11) primary key not null unique, " +
                "bookName varchar(45)," +
                "authorId int(11)" +
                "categoryOfBook varchar(45));";
        list.add(booksTable);

        String authorTable = "create table if not exists authors (" +
                "authorId int(11) primary key not null unique, " +
                "firstname varchar(45)," +
                "lastname varchar(45));";
        list.add(authorTable);

        String accountsTable = "create table if not exists accountingrecords (" +
                "accountId int(11) primary key not null unique, " +
                "clientId int(11)" +
                "bookId int(11)" +
                "receiptDate DATE " +
                "returnDate DATE )" +
                "status varchar(45));";
        list.add(accountsTable);

        try (Connection con = ConnectWithDBLibrary.getConnection()) {
            stmt = con.createStatement();

            for (String x : list) {
                    PreparedStatement preparedStmt = con.prepareStatement(x);
                    preparedStmt.execute();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
