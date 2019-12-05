package Services.Classes;

import ConnectWithBD.ConnectWithBD;
import Model.Books;
import Services.ReturnAllBooksService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReturnAllBooksServiceImpl implements ReturnAllBooksService {
    private Statement stmt;
    private ResultSet rs;
    private List<Books> booksList = new ArrayList<>();
    @Override
    public List<Books> retornAllBooks() {
        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from books";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                booksList.add(new Books(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return booksList;
    }
}
