package org.example.doancoso1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    @FXML
    

    public void setStage(Stage stage) {
        this.stage = stage;
    }

//    @FXML
//    void nextScene(MouseEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(ChatApplication.class.getResource("Test.fxml"));
//        Parent root = fxmlLoader.load();
//        // Thiết lập đối tượng Stage cho Controller
//        Test controller = fxmlLoader.getController();
//        controller.setStage(stage);
//
//        // Thay đổi scene của stage sang scene thứ hai
//        Scene scene = new Scene(root, 500, 400);
//        stage.setTitle("Viet daubuoi");
//        stage.setScene(scene);
//        stage.show();
//    }
}
