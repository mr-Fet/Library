package Repository;

import ConnectWithBD.ConnectWithBD;
import Model.Authors;

import java.sql.*;

public class AuthorsRepositoryIMPL  implements  AuthorsRepository{

    private Statement stmt;
    private ResultSet rs;
    private Authors selectAuthor;

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
        }
        catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Автор с таким ID уже существует");
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteAuthor(Integer authorId) {
        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = ("select * FROM authors where authorId = ?");
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, authorId);
            rs = pst.executeQuery();
            if(rs.next()) {
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM authors where authorId = ?");
                pstmt.setInt(1, authorId);
                pstmt.executeUpdate();
            }
            else{
                System.out.println("Автора с таким ID не существует");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyAuthor(Integer authorId, String updateAuthorFirstname, String updateAuthorLastname) {
        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query1 = ("select * FROM authors where authorId = ?");
            PreparedStatement pst = con.prepareStatement(query1);
            pst.setInt(1, authorId);
            rs = pst.executeQuery();
            if(rs.next()) {
                String query = "update authors set firstname = ?, lastname = ? where authorId = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, updateAuthorFirstname);
                preparedStmt.setString(2, updateAuthorLastname);
                preparedStmt.setInt(3, authorId);
                preparedStmt.executeUpdate();
            }
            else{
                System.out.println("Автора с таким ID не существует");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public Authors searchTheAuthors(int authorId) {
        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from authors where authorId = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, authorId);
            rs = preparedStmt.executeQuery();
            boolean z = rs.next();
            if(z) {
                while (z) {
                    int id = rs.getInt(1);
                    String firstname = rs.getString(2);
                    String lastname = rs.getString(3);
                    selectAuthor = new Authors.AuthorsBuilder(id).setFirstName(firstname).setLastName(lastname).build();
                    z = false;
                }
            }
            else {
                System.out.println("Автора с таким ID не существует");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return selectAuthor;
    }
}
