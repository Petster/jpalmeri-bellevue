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

public class FlowPanes extends Application {
    
    public void start(Stage stage) {
        try {
            stage.setTitle("FlowPane Demo");
            Button label = new Button("Item 0");
            Button label1 = new Button("Item 1");
            Button label2 = new Button("Item 2");
            Button label3 = new Button("Item 3");
            Button label4 = new Button("Item 4");
            label.setStyle("-fx-border-color: blue; -fx-text-fill: red; -fx-border-width: 3px; -fx-font-size: 30px;");
            label2.setStyle("-fx-border-color: blue; -fx-text-fill: red; -fx-border-width: 3px; -fx-font-size: 30px;");
            label4.setStyle("-fx-border-color: blue; -fx-text-fill: red; -fx-border-width: 3px; -fx-font-size: 30px;");
            FlowPane myFlow = new FlowPane(20.0, 20.0, label, label1, label2, label3, label4);

            Scene scene = new Scene(myFlow, 400, 300);
  
            stage.setScene(scene);
  
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
       launch(args);
    }
}
