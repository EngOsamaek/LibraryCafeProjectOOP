package Library;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class TextFieldConditions {
    public TextFieldConditions(TextField textField){

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*") && !newValue.matches("\\d{0,5}")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }
}
