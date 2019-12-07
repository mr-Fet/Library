package Main;

import ConnectWithBD.ConnectWithBD;
import Model.Client;
import Model.SpisokOfEntity;
//import Repository.SearchRepositoryIMPL;
import View.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Main {

        static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) throws ParseException {

      AccountView view = new AccountView();
      view.addAccount();

       //Date date = new Date();
       //System.out.println(date);
//        Scanner scanner3 = new Scanner(System.in);
//        String dataaaa = scanner3.next();
//        SimpleDateFormat returnDate = new SimpleDateFormat( "yyyy.MM.dd" );
//        Date str = (Date) returnDate.format(dataaaa);
//        System.out.println(returnDate.format());

//AcountingRecords(accountId=2, clientId=4, bookId=3, receiptDate=2019-12-05, returnDate=2020-01-20, statusId=Занята)
        //ReturnAllBooksView returnAllBooksView = new ReturnAllBooksView();
        //returnAllBooksView.returnAllBooks();
// try(Connection con = ConnectWithBD.getConnection()) {
//
//     stmt = con.createStatement();
//
//     rs = stmt.executeQuery("select * from accountingrecords");
//     while (rs.next())
//        System.out.println(rs.getInt(1) + "  " + rs.getString(2)  + rs.getInt(3) + "  " +
//                rs.getInt(1) + " " + rs.getString(3));
//
//    // System.out.println(rs);
//     //connectWithBD.closeConnect();
// }
// catch (Exception e) {
//     System.out.println(e);
// }


    }
}
