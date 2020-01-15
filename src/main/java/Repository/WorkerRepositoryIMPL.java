package Repository;

import DataBase.ConnectWithDBUser;
import Model.User;

import java.sql.*;

public class WorkerRepositoryIMPL implements WorkerRepository{
    private Statement stmt;
    private ResultSet rs;
    String userLogin;
    String userPassword;
    String roleName;

    @Override
    public User searchUser(String login, String password) {

        try (Connection con = ConnectWithDBUser.getConnection()) {
            stmt = con.createStatement();
            String query2 = "SELECT * FROM users join role on users.roleId = role.roleId where users.login = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query2);
            preparedStmt.setString(1, login);
            rs = preparedStmt.executeQuery();
            boolean z = rs.next();
            if(z){
                while (z) {
                    userLogin = rs.getString(3);
                    userPassword = rs.getString(4);
                    roleName = rs.getString(6);
                    z = false;
                }
            }
            else {
                return new User(null,null,null);

            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
        return new User(userLogin,userPassword,roleName);
    }

    @Override
    public void addWorker(int workerId, int roleId, String login, String password) {
        try (Connection con = ConnectWithDBUser.getConnection()) {
            stmt = con.createStatement();
            String query = "insert into users (userId,roleId, login, password)" + "VALUES (?,?,?,?);";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, workerId);
            preparedStmt.setInt(2, roleId);
            preparedStmt.setString(3, login);
            preparedStmt.setString(4, password);
            preparedStmt.execute();
        }
        catch (SQLIntegrityConstraintViolationException ex){
            System.out.println(" Сотрудник с таким ID уже существует");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateWorker(int workerId, int roleId, String login, String password) {
        try (Connection con = ConnectWithDBUser.getConnection()) {
            stmt = con.createStatement();
            String query1 = ("select * FROM users where userId = ?");
            PreparedStatement pst = con.prepareStatement(query1);
            pst.setInt(1, workerId);
            rs = pst.executeQuery();
            if(rs.next()) {
                String query = "update users set roleId = ?, login = ?, password = ? where userId = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, roleId);
                preparedStmt.setString(2, login);
                preparedStmt.setString(3, password);
                preparedStmt.setInt(4, workerId);
                preparedStmt.executeUpdate();
            }
            else{
                System.out.println("Сотрудника с таким ID не существует");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteWorker(int workerId) {
        try (Connection con = ConnectWithDBUser.getConnection()) {
            stmt = con.createStatement();
            String query = ("select * FROM users where userId = ?");
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, workerId);
            rs = pst.executeQuery();
            if(rs.next()){
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM users where userId = ?");
                pstmt.setInt(1, workerId);
                pstmt.executeUpdate();
            }
            else{
                System.out.println("Сотрудника с таким ID не существует");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
