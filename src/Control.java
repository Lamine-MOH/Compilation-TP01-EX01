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
    private TextArea typesOutput;

    @FXML
    private Button clearBtn;

    @FXML
    void submitClick(ActionEvent event) {
        String text = inputText.getText();

        text = TP01_EX01.splitToWords_02(text);

        outputText.setText(text);

        String typesText = "";
        String word = "";

        int index = 0;

        while (index < text.length()) {
            word += text.charAt(index);

            if (text.charAt(index) == '#') {
                String type = TP01_EX01.typeOf(word);

                typesText += " " + word + "\t\t\t  => " + type + "\n";

                word = "";
            }

            index++;
        }

        typesOutput.setText(typesText);
    }


    

   

    @FXML
    void clear(ActionEvent event) {
        inputText.setText("");
    }
}
