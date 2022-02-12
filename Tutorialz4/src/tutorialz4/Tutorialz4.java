/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialz4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class Tutorialz4 extends Application {
    Stage window;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        window=primaryStage;
      // private TextField txtDescription;
        
        
        HBox topmenu=new HBox();
        Button A=new Button("A");
        Button B=new Button("B");
        Button C=new Button("C");
        topmenu.getChildren().addAll(A,B,C);
        VBox leftmenu=new VBox();
        Button D=new Button("D");
        Button E=new Button("E");
        Button F=new Button("F");
        leftmenu.getChildren().addAll(D,E,F);
        BorderPane layout = new BorderPane();
        layout.setLeft(leftmenu);
        layout.setTop(topmenu);
        Scene scene = new Scene(layout, 300, 250);
        
        window.setTitle("Hello World!");
        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
