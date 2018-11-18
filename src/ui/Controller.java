
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;

public class Controller {

    @FXML
    private Button loadButton;
    @FXML
    private ChoiceBox<String> dataChoiceBox;

    private static final String PNG_SELECTOR_LABEL = "PNG FILE";
    private static final String TEXT_SELECTOR_LABEL = "ASCII TEXT FILE";


    public void initialize(){

        dataChoiceBox.setItems(FXCollections.observableArrayList(PNG_SELECTOR_LABEL, TEXT_SELECTOR_LABEL));
        dataChoiceBox.getSelectionModel().selectFirst();



        loadButton.setOnMouseClicked(actionEvent->{

            FileChooser fileChooser = new FileChooser();
            setFileExtension(dataChoiceBox, fileChooser);
            File file = fileChooser.showOpenDialog(((Node) actionEvent.getTarget()).getScene().getWindow());

            String dataSelectionValue = dataChoiceBox.getValue();
            if (dataSelectionValue.equalsIgnoreCase(PNG_SELECTOR_LABEL)) {


            } else if (dataSelectionValue.equalsIgnoreCase(TEXT_SELECTOR_LABEL)) {


            }
        });
    }

    private void setFileExtension(ChoiceBox dataChoiceBox, FileChooser fileChooser) {

        int selectedChoice = dataChoiceBox.getSelectionModel().getSelectedIndex() + 1;
        FileChooser.ExtensionFilter extFilter;

        switch (selectedChoice) {

            case 1:
                extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
                fileChooser.getExtensionFilters().add(extFilter);
                break;
            case 2:
                extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                break;
        }


    }

}
