package Main;

import ConnectWithBD.ConnectWithBD;
import Model.Books;
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
    static GeneralView generalView = new GeneralView();
    static BooksView booksView = new BooksView();
    static ClientView clientView = new ClientView();
    static AccountView accountView = new AccountView();

    public static void main(String[] args) throws ParseException {
 generalView.mainMenuSwithc();

    }

}


