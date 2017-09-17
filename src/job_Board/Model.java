package job_Board;

import javafx.collections.ObservableList;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javafx.collections.FXCollections.observableArrayList;

class Model {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    private ObservableList<Advertisement> advertisementList = observableArrayList();

    private Connection connect() {
        String url = "jdbc:sqlite:data_test.db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private void setAdvertisementList() throws SQLException {
        try {
            connect = this.connect();
            statement = connect.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            rs = statement.executeQuery("SELECT * FROM Advertisements;");
            while (rs.next()) {
                Advertisement advertisement = new Advertisement(rs.getInt("id"), rs.getString("Title"),
                        rs.getString("companyName"), rs.getString("advertisementText"),
                        rs.getString("Location"), rs.getString("parutionDate"),
                        rs.getString("contractType"), rs.getString("experienceAsked"),
                        rs.getString("salary"), rs.getString("contactName"),
                        rs.getString("contactEmail"));
                advertisementList.add(advertisement);
            }
        } catch(SQLException e) {
                System.err.println(e.getMessage());
            }
        finally {
            close();
        }
    }

    ObservableList<Advertisement> getAdvertisementArray() {
        try {
            this.setAdvertisementList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advertisementList;
    }

    void modifyAdvertisement(Advertisement advertisement){
        String sql = "UPDATE Advertisements SET Title = ? , companyName = ?, advertisementText = ?, Location = ?, parutionDate = ?," +
                "contractType = ?, experienceAsked = ?, salary = ?, contactName = ?, contactEmail = ? WHERE id = ?;";

        try {
            connect = this.connect();
            preparedStatement = connect.prepareStatement(sql);
            modifyPreparation(advertisement);
            preparedStatement.executeUpdate();

        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            close();
        }
    }

    void deleteAdvertisement(int id) throws SQLException {
        String sql = "DELETE FROM Advertisements WHERE id = ?";

        try {
            connect = this.connect();
            preparedStatement = connect.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            close();
        }
    }


    void addAdvertisement(Advertisement advertisement) throws SQLException {
        String sql = "INSERT INTO Advertisements(Title, companyName, advertisementText, Location, parutionDate," +
                "contractType, experienceAsked, salary, contactName, contactEmail)" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connect = this.connect();
            preparedStatement = connect.prepareStatement(sql);
            addPreparation(advertisement);
            preparedStatement.executeUpdate();

        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            close();
        }
    }


    private void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception ignored) {}
    }

    private void addPreparation (Advertisement advertisement) throws SQLException {
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        preparedStatement.setString(1, advertisement.getTitle());
        preparedStatement.setString(2, advertisement.getCompany());
        preparedStatement.setString(3, advertisement.getText());
        preparedStatement.setString(4, advertisement.getLocation());
        preparedStatement.setString(5, date);
        preparedStatement.setString(6, advertisement.getContract());
        preparedStatement.setString(7, advertisement.getExperience());
        preparedStatement.setString(8, advertisement.getSalary());
        preparedStatement.setString(9, advertisement.getContactName());
        preparedStatement.setString(10, advertisement.getContactEmail());
    }

    private void modifyPreparation (Advertisement advertisement) throws SQLException {
        preparedStatement.setString(1, advertisement.getTitle());
        preparedStatement.setString(2, advertisement.getCompany());
        preparedStatement.setString(3, advertisement.getText());
        preparedStatement.setString(4, advertisement.getLocation());
        preparedStatement.setString(5, advertisement.getDate());
        preparedStatement.setString(6, advertisement.getContract());
        preparedStatement.setString(7, advertisement.getExperience());
        preparedStatement.setString(8, advertisement.getSalary());
        preparedStatement.setString(9, advertisement.getContactName());
        preparedStatement.setString(10, advertisement.getContactEmail());
        preparedStatement.setInt(11, advertisement.getId());
    }
}
