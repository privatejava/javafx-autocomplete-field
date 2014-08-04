/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.ngopal.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author msi
 */
public class FXMLTest extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/fxml/FXML.fxml"));
        Scene sc = new Scene(root, 500, 500);
        stage.setScene(sc);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
