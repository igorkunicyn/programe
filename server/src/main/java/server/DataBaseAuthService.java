package server;

import java.sql.*;
import java.util.Date;

public class DataBaseAuthService implements AuthService{
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;

    public DataBaseAuthService() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
        System.out.println("database connected");
    }

    public void readHistory(String message) throws SQLException {
        Date date = new Date();
        String data = date.toString();
        psInsert = connection.prepareStatement("INSERT INTO history (message, data) VALUES ( ? , ? );");
        psInsert.setString(1, message);
        psInsert.setString(2, data);
        psInsert.executeUpdate();
    }

    public void disconnect() {
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT login, pass, nick FROM users ;");
        while (rs.next()) {
            if(rs.getString("login").equals(login)&&rs.getString("pass").equals(password)){
                return rs.getString("nick");
            }
        }
        rs.close();
        return null;
    }

    @Override
    public boolean registration(String login, String password, String nickname) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT login, pass, nick FROM users ;");
        while (rs.next()) {
            if(rs.getString("login").equals(login)&&rs.getString("nick").equals(nickname)){
                return false;
            }
            if(rs.getString("login").equals(login)&&rs.getString("pass").equals(password)){
                if (!rs.getString("nick").equals(nickname)){
                    if (changeNic(login,nickname)){
                        return true;
                    }
                    return false;
                }
            }
        }
        psInsert = connection.prepareStatement("INSERT INTO users (login, pass, nick) VALUES ( ? , ?, ? );");
        psInsert.setString(1, login);
        psInsert.setString(2, password);
        psInsert.setString(3, nickname);
        psInsert.executeUpdate();
        rs.close();
        return true;
    }

    public boolean changeNic(String login, String nickname) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT nick FROM users ;");
        while (rs.next()) {
            if (rs.getString("nick").equals(nickname)) return false;
        }
            psInsert = connection.prepareStatement("UPDATE users SET nick = ? WHERE login = ?;");
            psInsert.setString(1, nickname);
            psInsert.setString(2, login);
            psInsert.executeUpdate();
            return true;
    }

}
