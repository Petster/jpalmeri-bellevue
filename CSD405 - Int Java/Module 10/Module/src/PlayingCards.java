/*
    Jason Palmeri
    4/02/22
    Assignment10
    Display 4 Random Cards using JavaFX + add a button that refreshes
    I already added the button when I was doing assignment 8 so for this project 
    I added a counter to see how many times you get all reds and all blacks
*/

import javafx.collections.ObservableList;
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
import javafx.scene.text.*;
import java.util.ArrayList;

public class PlayingCards extends Application {
    //global variables to be updated
    static int reds = 0;
    static int blacks = 0;
    static Label redTracker = new Label(reds + " Red Matches | ");
    static Label blackTracker = new Label(" | "+ blacks +" Black Matches");
    static Label matches = new Label();

    //Method creates 4 random cards and adds them to the flowpane
    static void createCards(FlowPane rootWindow) {
        //track which card numbers are being displayed and put them into an array
        ArrayList<Integer> cardNum = new ArrayList<Integer>();
        for(int i = 0; i < 4; i++) {
            int rand = (int )(Math.random() * 52 + 1);
            Image image = new Image("./cards/"+rand+".png");
            ImageView view = new ImageView();
            view.setImage(image);
            view.setFitWidth(image.getWidth() * 2);
            view.setFitHeight(image.getHeight() * 2);
            rootWindow.getChildren().add(view);
            cardNum.add(rand);
        }
        //see if they are all the same color
        int blackCounter = 0;
        int redCounter = 0;
        for(int i = 0; i < cardNum.size(); i++) {
            if(cardNum.get(i) >= 14 && cardNum.get(i) <= 39) {
                redCounter++;
            } else {
                blackCounter++;
            }
        }
        //if 4 of a kind display results and update counter
        if(blackCounter == 4) {
            matches.setText("All Black");
            blacks += 1;
            blackTracker.setText(" | "+ blacks +" Black Matches");
        } else if(redCounter == 4) {
            matches.setText("All Red");
            reds += 1;
            redTracker.setText(reds + " Red Matches | ");
        } else {
            matches.setText("No Color Matches!");
        }
    }

    @Override public void start(Stage stage) {
        try {
            stage.setTitle("A10: Random Playing Cards");

            //containers
            BorderPane root = new BorderPane();
            FlowPane flowRoot = new FlowPane(20.0, 20.0);
            FlowPane topPane = new FlowPane();

            //create items
            createCards(flowRoot);
            Button refresh = new Button("Refresh Cards");

            //style items
            matches.setFont(new Font("Ariel", 25));
            redTracker.setFont(new Font("Ariel", 25));
            blackTracker.setFont(new Font("Ariel", 25));
            
            //populate topPane
            ObservableList list = topPane.getChildren();
            list.addAll(redTracker, matches, blackTracker);
            topPane.setAlignment(Pos.CENTER);

            //populate containers with items
            root.setTop(topPane);
            root.setBottom(refresh); 
            root.setCenter(flowRoot); 
            root.setAlignment(refresh, Pos.CENTER);

            //create window
            Scene scene = new Scene(root, 626, 242);
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