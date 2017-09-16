package job_Board;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;


public class editWindowController implements Initializable {
    private Model model = new Model();
    Advertisement advertisement;

    @FXML
    private TextField titleTextField;
    @FXML
    private TextField companyTextField;
    @FXML
    private TextArea textTextArea;
    @FXML
    private TextField LocationTextField;
    @FXML
    private TextField contractTextField;
    @FXML
    private TextField experienceTextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private TextField contactNameTextField;
    @FXML
    private TextField contactEmailTextField;


    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveButton.setOnAction(e -> {

            model.modifyAdvertisement(advertisement);

            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();

        });

        cancelButton.setOnAction(e -> {
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();
        });
    }

    void initData(Advertisement advertisement) {
        companyTextField.setText(advertisement.getCompany());
        titleTextField.setText(advertisement.getTitle());
        textTextArea.setText(advertisement.getText());
        LocationTextField.setText(advertisement.getLocation());
        contractTextField.setText(advertisement.getContract());
        experienceTextField.setText(advertisement.getExperience());
        salaryTextField.setText(advertisement.getSalary());
        contactNameTextField.setText(advertisement.getContactName());
        contactEmailTextField.setText(advertisement.getContactEmail());
    }
}