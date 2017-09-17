package job_Board;

import javafx.collections.ObservableList;
import java.sql.*;
import static javafx.collections.FXCollections.observableArrayList;

public class Model {

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet rs = null;
    private ObservableList<Advertisement> advertisementList = observableArrayList();

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

    public void setAdvertisementList() throws SQLException {
        try {
            connect = this.connect();
            statement = connect.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            rs = statement.executeQuery("SELECT * FROM Advertisements;");
            while (rs.next()) {
                Advertisement advertisement = new Advertisement(rs.getString("Title"),
                        rs.getString("companyName"), rs.getString("advertisementText"),
                        rs.getString("Location"), rs.getString("parutionDate"),
                        rs.getString("contractType"), rs.getString("post"),
                        rs.getString("experienceAsked"), rs.getString("salary"),
                        rs.getString("contactName"), rs.getString("contactEmail"));
                advertisementList.add(advertisement);
            }
        } catch(SQLException e) {
                System.err.println(e.getMessage());
            }
        finally {
            connect.close();
        }
    }

    public ObservableList<Advertisement> getAdvertisementArray() {
        try {
            this.setAdvertisementList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advertisementList;
    }

    private void modifydvertisement(){

    }

    private void deletedvertisement() {

    }

    private void addAdvertisement() {

    }

    private void close() {
        try {
            if (rs != null) {
                rs.close();
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
