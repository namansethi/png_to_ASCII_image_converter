
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import static java.lang.Thread.currentThread;

public class Controller {

    @FXML
    private Pane red;
    @FXML
    private Pane blue;
    @FXML
    private Button button;



    public void initialize(){
        button.setOnMouseClicked(event->{
        
        });
    }

}
