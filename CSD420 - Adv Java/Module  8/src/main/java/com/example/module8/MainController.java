package com.example.module8;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MainController extends JasonThreeThreads {
    @FXML
    private Text letterThreadLabel;
    @FXML
    private Text numberThreadLabel;
    @FXML
    private Text symbolThreadLabel;
    @FXML
    private Button letterButton;
    @FXML
    private Button numberButton;
    @FXML
    private Button symbolButton;

    @FXML
    protected void letterClick() {
        letterThreadLabel.setText(letterString);
        letterButton.setDisable(true);
    }
    @FXML
    protected void numberClick() {
        numberThreadLabel.setText(numberString);
        numberButton.setDisable(true);
    }
    @FXML
    protected void symbolClick() {
        symbolThreadLabel.setText(symbolString);
        symbolButton.setDisable(true);
    }
}