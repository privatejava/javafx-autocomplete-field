/* 
 * The MIT License
 *
 * Copyright 2016 Narayan G. Maharjan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package np.com.ngopal.control;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import np.com.ngopal.control.AutoFillTextBox;

/**
 *
 * @author WEBNEP
 */
public class Test extends Application {
    ObservableList<String> data = FXCollections.observableArrayList("Kathmandu", "Alabama", "Alaska", "Andaman", "Berut", "Boston", "Tokyo");

    @Override
    public void start(Stage stage) throws Exception {
        AutoFillTextBox tbox = new AutoFillTextBox(data);
        tbox.setPrefHeight(50);
        tbox.setPrefWidth(140);
        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();

        Label l = new Label("Name");
        Label l1 = new Label("Address");
        Label l2 = new Label("DOB");
        Label l3 = new Label("Street");

        GridPane gridpane = new GridPane();
        gridpane.add(field1, 2, 1);
        gridpane.add(tbox, 2, 2);
        gridpane.add(field2, 2, 3);
        gridpane.add(field3, 2, 4);

        gridpane.add(l, 1, 1);
        gridpane.add(l1, 1, 2);
        gridpane.add(l2, 1, 3);
        gridpane.add(l3, 1, 4);

//        VBox box = new VBox();
//        box.getChildren().add(tbox);
        Scene scene = new Scene(gridpane);
        scene.getStylesheets().add("/css/main.css");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
