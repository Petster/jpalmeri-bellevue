package com.example.module10;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class MainController extends MainApp {
    @FXML
    private TextField createID;
    @FXML
    private TextField createFname;
    @FXML
    private TextField createLname;
    @FXML
    private TextField createTeam;
    @FXML
    private TextField viewID;
    @FXML
    private TextField updateID;
    @FXML
    private TextField updateFname;
    @FXML
    private TextField updateLname;
    @FXML
    private TextField updateTeam;
    @FXML
    private Label createError;
    @FXML
    private Label viewError;
    @FXML
    private Label updateError;
    @FXML
    protected void insertButton() {
        try {
            int ID = Integer.parseInt(createID.getText());
            String fname = createFname.getText();
            String lname = createLname.getText();
            String team = createTeam.getText();

            try {
                insertData(ID, fname, lname, team);
                createError.setText("Data Inserted Successfully");
            } catch(SQLException e) {
                createError.setText("Error: Inserting Data. Duplicate ID?");
            }
        } catch(Exception e) {
            createError.setText("Error");
        }
    }

    @FXML
    protected void viewButton() {
        try {
            int ID = Integer.parseInt(viewID.getText());
            try {
                String results = selectData(ID);
                viewError.setText(results);
            } catch (SQLException e) {
                viewError.setText("Error: ID Does Not Exist");
            }
        } catch (Exception e) {
            viewError.setText("Error");
        }
    }

    @FXML
    protected void updateButton() {
        try {
            int ID = Integer.parseInt(updateID.getText());
            String fname = updateFname.getText();
            String lname = updateLname.getText();
            String team = updateTeam.getText();

            try {
                String test = selectData(ID);
                try {
                    updateData(ID, fname, lname, team);
                    updateError.setText("User " + ID + " Updated");
                } catch (SQLException e) {
                    updateError.setText("Error: Updating Data. ID Exists?");
                }
            } catch (SQLException e) {
                updateError.setText("Error: ID Does Not Exist");
            }


        } catch (Exception e) {
            updateError.setText("Error");
        }
    }
}