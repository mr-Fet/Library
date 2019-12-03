package Main;

import ConnectWithBD.ConnectWithBD;
import Model.Client;
import Model.SpisokOfEntity;
import Repository.SearchRepositoryIMPL;
import View.AccountView;
import View.AuthorView;
import View.BooksView;
import View.ClientView;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static SearchRepositoryIMPL searchTheObject = new SearchRepositoryIMPL();
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) throws ParseException {
//        BooksView view = new BooksView();
//        view.addBook();
        //AuthorView authorView =new AuthorView();
       //authorView.addAuthor();

//        System.out.println("Введите дату возврата книги: ");
//        Scanner scanner2 = new Scanner(System.in);
//        String dataaaa = scanner2.next();
//        Date date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( dataaaa );
//        System.out.println(date);
        AccountView accountView = new AccountView();
        //accountView.addClient();

 try(Connection con = ConnectWithBD.getConnection()) {

     stmt = con.createStatement();

     rs = stmt.executeQuery("select * from accountingrecords ");
     while (rs.next())
        System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + " " + rs.getInt(3)+
                " " + rs.getDate(3)+ " " + rs.getDate(3)+ " " + rs.getString(3));

     //connectWithBD.closeConnect();
 }
 catch (Exception e) {
     System.out.println(e);
 }


    }
}
