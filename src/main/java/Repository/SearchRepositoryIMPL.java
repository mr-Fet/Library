package Repository;

import ConnectWithBD.ConnectWithBD;
import Model.*;
import View.SearchView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Map;

public class SearchRepositoryIMPL implements SearchRepository {

    private Statement stmt;
    private ResultSet rs;
    private Client selectClient;
    private  Books selectBook;
    private Authors selectAuthor;
    private AcountingRecords selectAccount;


    @Override
    public Client searchTheClient(int clientId) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from clients where idClients = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, clientId);
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                selectClient = new Client(id,firstname,lastname);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return selectClient;
    }

    @Override
    public Books searchTheBooks(int booksId) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from books where idBook = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, booksId);
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstname = rs.getString(2);
                int idAuthor = rs.getInt(3);
                String lastname = rs.getString(4);
                selectBook = new Books(id,firstname,idAuthor,lastname);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return selectBook;
    }

    @Override
    public Authors searchTheAuthors(int authorId) {
        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from authors where authorId = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, authorId);
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                selectAuthor = new Authors(id,firstname,lastname);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return selectAuthor;
    }

    @Override
    public AcountingRecords searchTheAccount(int accountId) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from accountingrecords where accountId = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, accountId);
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int clientId = rs.getInt(2);
                int BookId = rs.getInt(3);
                Date date1 = rs.getDate(4);
                Date date3 = rs.getDate(5);
                String status = rs.getString(6);
                selectAccount = new AcountingRecords(id,clientId,BookId,date1, date3,status);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return selectAccount;
    }
}


