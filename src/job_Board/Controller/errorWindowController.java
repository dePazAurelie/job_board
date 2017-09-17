package job_Board.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class errorWindowController implements Initializable {

    @FXML
    private Button OKButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OKButton.setOnAction(e -> {
            Stage stage = (Stage) OKButton.getScene().getWindow();
            stage.close();
        });
    }
}