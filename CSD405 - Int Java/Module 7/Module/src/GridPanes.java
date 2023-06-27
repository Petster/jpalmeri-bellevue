/*
    Jason Palmeri
    3/26/22
    Assignment7
    FlowPane
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import javafx.scene.web.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.*;

public class GridPanes extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("GridPane Demo");

        Label label = new Label("Title");
        Button button2 = new Button("Input 1");
        Button button3 = new Button("Input 2");
        Button button4 = new Button("Submit");

        GridPane gridPane = new GridPane();

        gridPane.add(label, 0, 0, 1, 1);
        gridPane.add(button2, 2, 1, 3, 1);
        gridPane.add(button3, 2, 2, 3, 1);
        gridPane.add(button4, 5, 3, 1, 1);

        Scene scene = new Scene(gridPane, 240, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
       launch(args);
    }
}
