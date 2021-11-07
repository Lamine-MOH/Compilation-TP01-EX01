import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Control {

    @FXML
    private TextArea inputText;

    @FXML
    private TextArea outputText;

    @FXML
    private Button submitBtn;

    @FXML
    void submitClick(ActionEvent event) {
        String text = inputText.getText();

        text = TP01_EX01.splitToWords(text);

        outputText.setText(text);
    }

}
