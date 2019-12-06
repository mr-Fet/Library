package Repository;

import ConnectWithBD.ConnectWithBD;
import Model.AcountingRecords;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class AccountRepositoryIMPL implements AccountRepository {

    private Statement stmt;
    private ResultSet rs;
    private AcountingRecords selectAccount;

    @Override
    public void createNewAccount(Integer newAccountId, Integer clientId, Integer bookId, Date receiptDate, Date returnDate, String status) {
        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "insert into accountingrecords (accountId, clientId, bookId,receiptDate,returnDate,status)" + "VALUES (?,?,?,?,?,?);";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, newAccountId);
            preparedStmt.setInt(2, clientId);
            preparedStmt.setInt(3, bookId);
            preparedStmt.setString(4, receiptDate.toString());
            preparedStmt.setString(5, returnDate.toString());
            preparedStmt.setString(6, status);
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try (Connection con = ConnectWithBD.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM accountingrecords where accountId = ?");
            pstmt.setInt(1, accountId);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyAccount(Integer accountId, Integer updateClientId, Integer updateBookId, Date updateReceiptDate, Date updateReturnDate, String UpdateStatus) {
        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "update accountingrecords set clientId = ?, bookId = ?, returnDate = ?, status = ?  where accountId = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, updateClientId);
            preparedStmt.setInt(2, updateBookId);
            preparedStmt.setString(3, updateReturnDate.toString());
            preparedStmt.setString(4, UpdateStatus);
            preparedStmt.setInt(5, accountId);
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
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
