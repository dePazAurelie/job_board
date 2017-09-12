package dataBaseInterface;
import java.sql.*;

public class DataBaseInterface {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public static void main (String [] arg) throws SQLException {
        DataBaseInterface dataInterface = new DataBaseInterface();
        dataInterface.connect();
        dataInterface.addTable();
        dataInterface.close();
    }

    public void addTable() {
        try {
            connect = this.connect();
            statement = connect.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("DROP TABLE IF EXISTS Learner");
            statement.executeUpdate("CREATE TABLE Learner (id INTEGER, name string, age INTEGER, city string)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        String url = "jdbc:sqlite:data.db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception ignored) {}
    }
}
