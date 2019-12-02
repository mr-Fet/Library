package Repository;

import ConnectWithBD.ConnectWithBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BooksRepositoryIMPL implements BooksRepository {

    private Statement stmt;

    @Override
    public void createBook(Integer newBookId, String newBookName, Integer newAuthorId, String newCategory) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "insert into books (idBook, bookName, authorId, categoryOfBook)" + "VALUES (?,?,?,?);";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, newBookId);
            preparedStmt.setString(2, newBookName);
            preparedStmt.setInt(3, newAuthorId);
            preparedStmt.setString(4, newCategory);
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteBook(Integer bookId) {

        try (Connection con = ConnectWithBD.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM books where idBook = ?");
            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyBook(Integer bookId, String updateBookName, Integer updateAuthorId, String updateCategory) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "update clients set bookName = ?, authorId = ?, categoryOfBook = ? where idBook = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, updateBookName);
            preparedStmt.setInt(2, updateAuthorId);
            preparedStmt.setString(3, updateCategory);
            preparedStmt.setInt(4, bookId);
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
