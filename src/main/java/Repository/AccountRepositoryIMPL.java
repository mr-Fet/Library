package Repository;

import DataBase.ConnectWithDBLibrary;
import Model.AcountingRecords;

import java.sql.*;
import java.util.Date;

public class AccountRepositoryIMPL implements AccountRepository {

    private Statement stmt;
    private ResultSet rs;
    private AcountingRecords selectAccount;

    @Override
    public void createNewAccount(Integer newAccountId, Integer clientId, Integer bookId, Date receiptDate, Date returnDate, String status) {

        try (Connection con = ConnectWithDBLibrary.getConnection()) {
            stmt = con.createStatement();
            String query = "insert into accountingrecords (accountId, clientId, bookId,receiptDate,returnDate,status)" + "VALUES (?,?,?,?,?,?);";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, newAccountId);
            preparedStmt.setInt(2, clientId);
            preparedStmt.setInt(3, bookId);
            preparedStmt.setDate(4, (java.sql.Date) receiptDate);
            preparedStmt.setDate(5, (java.sql.Date) returnDate);
            preparedStmt.setString(6, status);
            preparedStmt.execute();
        }
        catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("Аккаунт с таким ID уже существует");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try (Connection con = ConnectWithDBLibrary.getConnection()) {
            stmt = con.createStatement();
            String query = ("select * FROM accountingrecords where accountId = ?");
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, accountId);
            rs = pst.executeQuery();
            if(rs.next()) {
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM accountingrecords where accountId = ?");
                pstmt.setInt(1, accountId);
                pstmt.executeUpdate();
            }
            else{
                System.out.println("Аккаунта с таким ID не существует");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyAccount(Integer accountId, Integer updateClientId, Integer updateBookId, Date updateReceiptDate, Date updateReturnDate, String UpdateStatus) {
        try (Connection con = ConnectWithDBLibrary.getConnection()) {
            stmt = con.createStatement();
            String query1 = ("select * FROM accountingrecords where accountId = ?");
            PreparedStatement pst = con.prepareStatement(query1);
            pst.setInt(1, accountId);
            rs = pst.executeQuery();
            if(rs.next()) {
                String query = "update accountingrecords set clientId = ?, bookId = ?, returnDate = ?, status = ?  where accountId = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, updateClientId);
                preparedStmt.setInt(2, updateBookId);
                preparedStmt.setDate(3, (java.sql.Date) updateReturnDate);
                preparedStmt.setString(4, UpdateStatus);
                preparedStmt.setInt(5, accountId);
                preparedStmt.executeUpdate();
            }
            else{
                System.out.println("Аккаунта с таким ID не существует");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public AcountingRecords searchTheAccount(int accountId) {

        try (Connection con = ConnectWithDBLibrary.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from accountingrecords where accountId = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, accountId);
            rs = preparedStmt.executeQuery();
            boolean z = rs.next();
            if(z) {
                while (z) {
                    int id = rs.getInt(1);
                    int clientId = rs.getInt(2);
                    int bookId = rs.getInt(3);
                    Date date1 = rs.getDate(4);
                    Date date3 = rs.getDate(5);
                    String status = rs.getString(6);
                    selectAccount = new AcountingRecords.AccountBuilder(id).setClientId(clientId).setBookId(bookId).setReceiptDate(date1).setReturnDate(date3).setStatusId(status).build();
                    z = false;
                }
            }
            else {
                System.out.println("Аккаунта с таким ID не существует");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return selectAccount;
    }
}
