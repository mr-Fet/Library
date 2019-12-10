package Repository;

import ConnectWithBD.ConnectWithBD;
import Model.Books;

import java.sql.*;

public class BooksRepositoryIMPL implements BooksRepository {

    private Statement stmt;
    private ResultSet rs;
    private  Books selectBook;

    @Override
    public void createBook(Integer newBookId, String newBookName, Integer newAuthorId, String newCategory) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "insert into books " + "VALUES (?,?,?,?);";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, newBookId);
            preparedStmt.setString(2, newBookName);
            preparedStmt.setInt(3, newAuthorId);
            preparedStmt.setString(4, newCategory);
            preparedStmt.execute();
        }
        catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Книга с таким ID уже существует");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteBook(Integer bookId) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = ("select * FROM books where idBook = ?");
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, bookId);
            rs = pst.executeQuery();
            if(rs.next()) {
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM books where idBook = ?");
                pstmt.setInt(1, bookId);
                pstmt.executeUpdate();
            }
            else{
                System.out.println("Книги с таким ID не существует");
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyBook(Integer bookId, String updateBookName, Integer updateAuthorId, String updateCategory) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query1 = ("select * FROM books where idBook = ?");
            PreparedStatement pst = con.prepareStatement(query1);
            pst.setInt(1, bookId);
            rs = pst.executeQuery();
            if(rs.next()) {
                String query = "update books set bookName = ?, authorId = ?, categoryOfBook = ? where idBook = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, updateBookName);
                preparedStmt.setInt(2, updateAuthorId);
                preparedStmt.setString(3, updateCategory);
                preparedStmt.setInt(4, bookId);
                preparedStmt.executeUpdate();
            }
            else{
                System.out.println("Книги с таким ID не существует");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Books searchTheBooks(int booksId) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from books where idBook = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, booksId);
            rs = preparedStmt.executeQuery();
            boolean z = rs.next();
            if(z) {
                while (z) {
                    int id = rs.getInt(1);
                    String firstname = rs.getString(2);
                    int idAuthor = rs.getInt(3);
                    String category = rs.getString(4);
                    selectBook = new Books.BooksBuilder(id).setName(firstname).setAuthorId(idAuthor).setCategory(category).build();
                    z = false;
                }
            }
            else {
                System.out.println("Книги с таким ID не существует");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return selectBook;
    }
}
