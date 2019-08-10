package stickynotes;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.Window;

public class Note extends Parent{
    
    GridPane grid=new GridPane();
    TextArea task=new TextArea();
    Window win=new Window("Note");
    CloseIcon close=new CloseIcon(win);
    
    public Note()
    {
        win.setId("window");
        close.setId("close");
        win.setPrefWidth(200);
        win.setPrefHeight(200);
        win.getRightIcons().add(close);
        
        task.setPrefWidth(300);
        task.setWrapText(true);
        task.setId("task");
        task.setStyle("-fx-font-family:  \"Comic Sans MS\";"+
                "-fx-font-size: 20 ;"+
                "-fx-cursor:move");
        
        task.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke)
            {
                if(ke.getCode()==KeyCode.ENTER)
                {
                    task.setEditable(false);
                    task.setStyle("-fx-cursor : move ;");
                }
            }
        });
             
        grid.getChildren().add(task);
        win.getContentPane().getChildren().add(grid);
        getChildren().add(win);
    }
}