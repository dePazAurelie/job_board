package job_Board;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class newWindowController implements Initializable {
    private Model model = new Model();

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
    private Button createButton;
    @FXML
    private Button cancelButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        createButton.setOnAction(e -> {
            try {
                Advertisement advertisement = new Advertisement(titleTextField.getText(), companyTextField.getText(), textTextArea.getText(),
                        LocationTextField.getText(), contractTextField.getText(), experienceTextField.getText(), salaryTextField.getText(),
                        contactNameTextField.getText(), contactEmailTextField.getText());
                model.addAdvertisement(advertisement);

                Stage stage = (Stage) createButton.getScene().getWindow();
                stage.close();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        cancelButton.setOnAction(e -> {
            Stage stage = (Stage) createButton.getScene().getWindow();
            stage.close();
        });
    }
}