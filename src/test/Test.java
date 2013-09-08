/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
public class Test extends Application{

    ObservableList<String> data = FXCollections.observableArrayList("abc","cde","hij","klm");
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
        gridpane.add(field1,2,1);
        gridpane.add(tbox, 2, 2);
        gridpane.add(field2,2,3);
        gridpane.add(field3,2,4);
        
        
        gridpane.add(l, 1, 1);
        gridpane.add(l1, 1, 2);
        gridpane.add(l2, 1, 3);
        gridpane.add(l3, 1, 4);
        
        
//        VBox box = new VBox();
//        box.getChildren().add(tbox); 
        Scene scene = new Scene(gridpane);        
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setScene(scene);   
        stage.show();
        
        
    }
    
    public static void main(String[] args) {
        Application.launch(args); 
        
    }
    
    
}
