package Repository;

import ConnectWithBD.ConnectWithBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AuthorsRepositoryIMPL  implements  AuthorsRepository{

    private Statement stmt;
    @Override
    public void createAuthor(Integer newAuthorId, String newAuthorFirstname, String newAuthorLastname) {
        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "insert into authors (authorId, firstname, lastname)" + "VALUES (?,?,?);";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, newAuthorId);
            preparedStmt.setString(2, newAuthorFirstname);
            preparedStmt.setString(3, newAuthorLastname);
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteAuthor(Integer authorId) {
        try (Connection con = ConnectWithBD.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM authors where authorId = ?");
            pstmt.setInt(1, authorId);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyAuthor(Integer authorId, String updateAuthorFirstname, String updateAuthorLastname) {
        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "update authors set firstname = ?, lastname = ? where authorId = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, updateAuthorFirstname);
            preparedStmt.setString(2, updateAuthorLastname);
            preparedStmt.setInt(3, authorId);
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
