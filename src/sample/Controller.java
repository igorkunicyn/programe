package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField textfield;
    @FXML
    private TextArea textarea;
    @FXML
    public void clickBtn(ActionEvent actionEvent) {
        textarea.appendText(textfield.getText()+"\n");
        textfield.clear();
        textfield.requestFocus();
    }
    @FXML
    public void clickEnter(ActionEvent actionEvent) {
        textarea.appendText(textfield.getText()+"\n");
        textfield.clear();
        textfield.requestFocus();
    }
    @FXML
    public void ExitAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
