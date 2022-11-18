package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class ControllerReg {
    @FXML
    private Button back;

    @FXML
    private Button done;

    @FXML
    private TextField login1;

    @FXML
    private TextField password1;

    @FXML
    void initialize() {

        done.setOnAction(click -> {
            done.getText().trim();
            System.out.println("Логин:" + login1.getText());
            System.out.println("Пароль:" + password1.getText());
            done.getScene().getWindow().hide();
            //data.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Lesson\\labs\\demo1\\src\\main\\resources\\com\\example\\demo1\\Data.txt"))) {
                writer.write(login1.getText());
                writer.newLine();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("31.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Lesson\\labs\\demo1\\src\\main\\resources\\com\\example\\demo1\\Data2.txt"))) {
                writer.write(password1.getText());
                writer.newLine();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("31.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
}