package Services.Classes;

import DataBase.ConnectWithDBLibrary;
import Model.Books;
import Repository.BooksRepository;
import Repository.BooksRepositoryIMPL;
import Services.BooksService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BooksServiceImpl  implements BooksService {

    private BooksRepository booksRepository = new BooksRepositoryIMPL();
    private Statement stmt;
    private ResultSet rs;
    private List<Books> booksList;
    private Books selectBook;

    @Override
    public void createBook(Integer newBookId, String newBookName, Integer newAuthorId, String newCategory) {booksRepository.createBook(newBookId,newBookName,newAuthorId,newCategory);}
    @Override
    public void deleteBook(Integer bookId) {
        booksRepository.deleteBook(bookId);
    }
    @Override
    public void modifyBook(Integer bookId, String updateBookName, Integer updateAuthorId, String updateCategory) {booksRepository.modifyBook(bookId,updateBookName,updateAuthorId,updateCategory);}
    @Override
    public List<Books> returnAllBooks() {
        try (Connection con = ConnectWithDBLibrary.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from books";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            rs = preparedStmt.executeQuery();
            booksList = new ArrayList<>();
            while (rs.next()) {
                booksList.add(new Books.BooksBuilder(rs.getInt(1)).setName(rs.getString(2)).setAuthorId(rs.getInt(3)).setCategory(rs.getString(4)).build());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return booksList;
    }

    @Override
    public Books searchBookByAuthor(String authorLastName) {

        try (Connection con = ConnectWithDBLibrary.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from books where authorId = (select authorId from authors where lastname = ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, authorLastName);
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstname = rs.getString(2);
                int idAuthor = rs.getInt(3);
                String lastname = rs.getString(4);
                selectBook = new Books.BooksBuilder(rs.getInt(1)).setName(rs.getString(2)).setAuthorId(rs.getInt(3)).setCategory(rs.getString(4)).build();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return selectBook;
    }

    @Override
    public Books searchBookByName(String boookName) {
        try (Connection con = ConnectWithDBLibrary.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from books where bookName = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, boookName);
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstname = rs.getString(2);
                int idAuthor = rs.getInt(3);
                String lastname = rs.getString(4);
                selectBook = new Books.BooksBuilder(rs.getInt(1)).setName(rs.getString(2)).setAuthorId(rs.getInt(3)).setCategory(rs.getString(4)).build();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return selectBook;
    }

    @Override
    public Books searchBookById(Integer bookId) {
        return booksRepository.searchTheBooks(bookId);
    }


}
