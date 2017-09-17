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
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private Model model = new Model();

    public void editButtonPushed() {

    }

    public void newButtonPushed() {

    }

    public void deleteButtonPushed() {

    }

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
        tableView.setItems(model.getAdvertisementArray());

        AdvertisementLabel.setText("Select a advertisement :");
        companyLabel.setText("");
        titleLabel.setText("");
        textLabel.setText("");
        LocationLabel.setText("");
        contractLabel.setText("");
        experienceLabel.setText("");
        salaryLabel.setText("");
        contactNameLabel.setText("");
        contactEmailLabel.setText("");

        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (tableView.getSelectionModel().getSelectedItem() != null) {
                AdvertisementLabel.setText(tableView.getSelectionModel().getSelectedItem().getTitle());
                companyLabel.setText(tableView.getSelectionModel().getSelectedItem().getCompany());
                titleLabel.setText(tableView.getSelectionModel().getSelectedItem().getTitle());
                textLabel.setText(tableView.getSelectionModel().getSelectedItem().getText());
                LocationLabel.setText(tableView.getSelectionModel().getSelectedItem().getLocation());
                contractLabel.setText(tableView.getSelectionModel().getSelectedItem().getContract());
                experienceLabel.setText(tableView.getSelectionModel().getSelectedItem().getExperience());
                salaryLabel.setText(tableView.getSelectionModel().getSelectedItem().getSalary());
                contactNameLabel.setText(tableView.getSelectionModel().getSelectedItem().getContactName());
                contactEmailLabel.setText(tableView.getSelectionModel().getSelectedItem().getContactEmail());
            }
        });

        editButton.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editWindow.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
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
            } catch (Exception er) {
                er.printStackTrace();
            }
        });
    }
}