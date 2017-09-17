package job_Board;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private Model model = new Model();

    @FXML
    private Label AdvertisementLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Label companyLabel;
    @FXML
    private Label textLabel;
    @FXML
    private Label LocationLabel;
    @FXML
    private Label contractLabel;
    @FXML
    private Label experienceLabel;
    @FXML
    private Label salaryLabel;
    @FXML
    private Label contactNameLabel;
    @FXML
    private Label contactEmailLabel;

    @FXML
    private Button editButton;
    @FXML
    private Button newButton;
    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Advertisement> tableView;
    @FXML
    private TableColumn<Advertisement, String> titleColumn;
    @FXML
    private TableColumn<Advertisement, String> dateColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        loadTableView();

        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (tableView.getSelectionModel().getSelectedItem() != null) {
                fillLabels(tableView.getSelectionModel().getSelectedItem());
            }
        });

        editButton.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditWindow.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));

                Controller.editWindowController controller = fxmlLoader.getController();
                controller.initData(tableView.getSelectionModel().getSelectedItem());

                stage.show();

                stage.setOnHiding( event -> loadTableView());

            } catch (Exception er) {
                er.printStackTrace();
            }
        });

        newButton.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newWindow.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

                stage.setOnHiding( event -> loadTableView());

            } catch (Exception er) {
                er.printStackTrace();
            }
        });

        deleteButton.setOnAction(e -> {
            try {
                model.deleteAdvertisement(tableView.getSelectionModel().getSelectedItem().getId());
                loadTableView();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void fillLabels(Advertisement advertisement) {
        AdvertisementLabel.setText(advertisement.getTitle());
        companyLabel.setText(advertisement.getCompany());
        titleLabel.setText(advertisement.getTitle());
        textLabel.setText(advertisement.getText());
        LocationLabel.setText(advertisement.getLocation());
        contractLabel.setText(advertisement.getContract());
        experienceLabel.setText(advertisement.getExperience());
        salaryLabel.setText(advertisement.getSalary());
        contactNameLabel.setText(advertisement.getContactName());
        contactEmailLabel.setText(advertisement.getContactEmail());
    }

    private void loadTableView() {
        for ( int i = 0; i < tableView.getItems().size(); i++) {
            tableView.getItems().clear();
        }

        tableView.setItems(model.getAdvertisementArray());

        AdvertisementLabel.setText("");
        companyLabel.setText("");
        titleLabel.setText("");
        textLabel.setText("");
        LocationLabel.setText("");
        contractLabel.setText("");
        experienceLabel.setText("");
        salaryLabel.setText("");
        contactNameLabel.setText("");
        contactEmailLabel.setText("");

        if (tableView.getItems().size() > 0) {
            tableView.getSelectionModel().selectFirst();
            fillLabels(tableView.getSelectionModel().getSelectedItem());
        }
    }
}