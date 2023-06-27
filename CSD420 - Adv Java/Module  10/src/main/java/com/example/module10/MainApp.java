package com.example.module10;

/*
    Jason Palmeri
    6/5/22
    Assignment 10
    create an app that allows you to create database row, view data via ID, update data from ID
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;

public class MainApp extends Application {

    static Connection con;

    static Statement stmt;

    public static void connectDB() {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3333/databasedb?";

            con = DriverManager.getConnection(url + "user=student1&password=pass");

            stmt = con.createStatement();
        }
        catch(Exception e){

            System.out.println(e);
            System.exit(0);
        }
    }
    public static void insertData(int ID, String fname, String lname, String team) throws SQLException {
        try{
            String SQL = "INSERT INTO fans VALUES(" + ID + ", '" + fname + "'" + ", '" + lname + "'" + ", '" + team + "')";
            stmt.executeUpdate(SQL);
        }
        catch(SQLException e){
            throw new SQLException("Insert Data Failed");
        }
    }
    public static String selectData(int ID) throws SQLException {
        String output = new String();
        ResultSet results;
        try{
            String SQL = "SELECT * FROM fans WHERE ID=" + ID;
            results = stmt.executeQuery(SQL);
        } catch(SQLException e){
            throw new SQLException("Data Retrieval Failed");
        }
        int i = results.getMetaData().getColumnCount();

        if(results.next()) {
            output = "ID: " + results.getString(1) + " | First Name: " + results.getString(2) + " | Last Name: " + results.getString(3) + " | Favorite Team: " + results.getString(4);
        } else {
            throw new SQLException("No Results");
        }
        return output;
    }
    public static void updateData(int ID, String fname, String lname, String team) throws SQLException {
        try{
            String SQL = "UPDATE fans SET firstname='"+ fname +"', lastname='"+ lname +"', favoriteteam='"+ team +"' WHERE ID=" + ID + "";
            stmt.executeUpdate(SQL);
        }
        catch(SQLException e){
            throw new SQLException("Insert Data Failed");
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Jason Palmeri - Module 10");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        connectDB();
        launch();
    }
}