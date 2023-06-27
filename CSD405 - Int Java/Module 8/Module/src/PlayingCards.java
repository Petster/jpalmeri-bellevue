/*
    Jason Palmeri
    3/28/22
    Assignment8
    Display 4 Random Cards using JavaFX
*/

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.geometry.*;

public class PlayingCards extends Application {
    
    //Method creates 4 random cards and adds them to the flowpane
    static void createCards(FlowPane rootWindow) {
        for(int i = 0; i < 4; i++) {
            int rand = (int )(Math.random() * 52 + 1);
            Image image = new Image("./cards/"+rand+".png");
            ImageView view = new ImageView();
            view.setImage(image);
            view.setFitWidth(image.getWidth() * 2);
            view.setFitHeight(image.getHeight() * 2);

            rootWindow.getChildren().add(view); 
        }            
    }

    @Override public void start(Stage stage) {
        try {
            stage.setTitle("Random Playing Cards");

            //containers
            BorderPane root = new BorderPane();
            FlowPane flowRoot = new FlowPane(20.0, 20.0);

            //create items
            createCards(flowRoot);
            Button refresh = new Button("Refresh Cards");
            
            //populate containers with items
            root.setBottom(refresh); 
            root.setCenter(flowRoot); 
            root.setAlignment(refresh, Pos.CENTER);

            //create window
            Scene scene = new Scene(root, 626, 212);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            //on button click clear the flowpane and create new cards
            refresh.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    flowRoot.getChildren().clear();
                    createCards(flowRoot);
                    //refresh.setDisable(true);
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
       launch(args);
    }
}