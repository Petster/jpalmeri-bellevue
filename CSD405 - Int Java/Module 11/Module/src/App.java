/*
    Jason Palmeri
    4/03/22
    Assignment11
    Create an application with radio and checkboxes to display shapes with random colors
*/

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.scene.text.*;

public class App extends Application {

    static Circle currentCircle;
    static Rectangle currentRectangle;
    static Ellipse currentEllipse;
    static Text currentColor = new Text("");
    static String currentShape = "";

    static Circle createCircle(BorderPane shapes) {
        Circle circ = new Circle();
        circ.setRadius(75);
        return circ;
    }

    static Rectangle createRectangle(BorderPane shapes) {
        Rectangle rec = new Rectangle(400, 150);
        return rec;
    }

    static Ellipse createEllipse(BorderPane shapes) {
        Ellipse ell = new Ellipse();
        ell.setRadiusX(200);
        ell.setRadiusY(75);
        return ell;
    }

    static void setRandomColor() {
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);

        Color col = Color.rgb(r, g, b, .99);
        
        currentColor.setText("Current Color: " + col);

        switch(currentShape) {
            case "Circle":
                currentCircle.setFill(col);
                break;
            case "Rectangle":
                currentRectangle.setFill(col);
                break;
            case "Ellipse":
                currentEllipse.setFill(col);
                break;
        }
    }

    static void setColorBlack() {
        Color bk = Color.BLACK;
        switch(currentShape) {
            case "Circle":
                currentCircle.setFill(bk);
                break;
            case "Rectangle":
                currentRectangle.setFill(bk);
                break;
            case "Ellipse":
                currentEllipse.setFill(bk);
                break;
        }
        currentColor.setText("Current Color: " + bk);
    }

    static boolean checkFill(String currShape) {
        switch(currShape) {
            case "Circle":
                if(currentCircle.getFill().equals(Color.BLACK)) {
                    return false;
                } else { 
                    return true;
                }
            case "Rectangle":
                if(currentRectangle.getFill().equals(Color.BLACK)) {
                    return false;
                } else { 
                    return true;
                }
            case "Ellipse":
                if(currentEllipse.getFill().equals(Color.BLACK)) {
                    return false;
                } else { 
                    return true;
                }
            default:
                return false;
        }
    }

    @Override public void start(Stage stage) {
        try {
            stage.setTitle("A11: Shapes");

            //containers
            VBox root = new VBox();
            FlowPane buttonsList = new FlowPane();
            FlowPane checkList = new FlowPane();
            FlowPane colorPane = new FlowPane();
            BorderPane shapes = new BorderPane();

            //Create shapes
            currentCircle = createCircle(shapes);
            currentRectangle = createRectangle(shapes);
            currentEllipse = createEllipse(shapes);

            //add BorderPane as first in VBox
            root.getChildren().add(shapes);
            shapes.setMinHeight(200);

            //add Radio buttonsList as second in VBox
            root.getChildren().add(buttonsList);
            buttonsList.setHgap(25);
            ToggleGroup radioButtons = new ToggleGroup();
            String rl[] = {"Circle", "Rectangle", "Ellipse"};
            for(int i = 0; i < rl.length; i++) {
                RadioButton r = new RadioButton(rl[i]);
                r.setFont(new Font("Ariel", 15));
                r.setToggleGroup(radioButtons);
                buttonsList.getChildren().add(r);
            }
            buttonsList.setAlignment(Pos.CENTER);

            //add Checkbox buttons as third in VBox
            root.getChildren().add(checkList);
            checkList.setHgap(25);
            checkList.setPadding(new Insets(25, 0, 0, 0));
            CheckBox fillBox = new CheckBox("Fill with Color");
            fillBox.setFont(new Font("Ariel", 15));
            //checkbox event
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    if(fillBox.isSelected()) {
                        setRandomColor();
                    } else {
                        setColorBlack();
                    }
                }
            };
            fillBox.setOnAction(event);
            checkList.getChildren().add(fillBox);
            checkList.setAlignment(Pos.CENTER);

            currentColor.setFont(new Font("Ariel", 15));
            root.getChildren().add(colorPane);
            colorPane.getChildren().add(currentColor);
            colorPane.setAlignment(Pos.CENTER);
            colorPane.setPadding(new Insets(25, 0, 0, 0));
            
            //create window
            Scene scene = new Scene(root, 600, 500);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            //radio event
            radioButtons.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {
                    RadioButton rb = (RadioButton)radioButtons.getSelectedToggle();

                    if(rb != null) {
                        String s = rb.getText();
                        //fillBox.setSelected(false);
                        
                        shapes.getChildren().clear();
                        switch(s) {
                            case "Circle":
                                shapes.setCenter(currentCircle);
                                currentShape = s;
                                currentColor.setText("Current Color: " + currentCircle.getFill());
                                fillBox.setSelected(checkFill(s));
                                break;
                            case "Rectangle":
                                shapes.setCenter(currentRectangle);
                                currentShape = s;
                                currentColor.setText("Current Color: " + currentRectangle.getFill());
                                fillBox.setSelected(checkFill(s));
                                break;
                            case "Ellipse":
                                shapes.setCenter(currentEllipse);
                                currentShape = s;
                                currentColor.setText("Current Color: " + currentEllipse.getFill());
                                fillBox.setSelected(checkFill(s));
                                break;
                            default: 
                                shapes.getChildren().clear();
                                break;
                        }
                    }
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
