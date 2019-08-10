/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stickynotes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StickyNotes extends Application {
    
    Group root=new Group();
    ImageView close;
    HBox hbox=new HBox();
 
    @Override
    public void start(final Stage primaryStage) {
        
        close=new ImageView(new Image(getClass().getResourceAsStream("no.png")));
        close.setId("close");
        
        Tooltip closeTool=new Tooltip();
        closeTool.setText("Close");
                        
        close.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent me)
            {
                primaryStage.close();
            }
        });
        
        Button btn = new Button();
        btn.setText("Create Note");
        
        Tooltip tooltip=new Tooltip();
        tooltip.setText("Create new note");
        btn.setTooltip(tooltip);
        
        btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ae)
            {
                Note note=new Note();
                root.getChildren().add(note);
            }        
        });
                    
        hbox.getChildren().add(btn);
        hbox.getChildren().add(close);
        
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(20);
        hbox.setLayoutX(650);
        hbox.setLayoutY(20);
        root.getChildren().add(hbox);
        //hbox.setAlignment(Pos.CENTER);
       
        Scene scene = new Scene(root, 800, 600);
        scene.setFill(Color.LIGHTGREEN);
        
        primaryStage.setTitle("Sticky Notes");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        //primaryStage.setStyle().TRANSPARENT;
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}