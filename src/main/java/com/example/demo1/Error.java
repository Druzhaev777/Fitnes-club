package com.example.demo1;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Error {

    @FXML
    private Button exit;

    @FXML
    private Button join;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Button reg;

     void initialize() {
        join.setOnAction(click -> {
            join.setText("success");
            System.out.println("login: " + login.getText());
            System.out.println("password: " + password.getText());
            join.getScene().getWindow().hide();

//Чтение пароля из файла Data2
            try {
                BufferedReader reader = new BufferedReader(new FileReader("D:\\Lesson\\labs\\demo1\\src\\main\\resources\\com\\example\\demo1\\Data2.txt")) {
                };
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(password.getText().trim())){
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("hello-view.fxml"));
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                            join.getScene().getWindow().hide();
                            stage.setTitle("Доставка молочных продуктов");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("password success");
                    }else {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("Home.fxml"));
                        loader.load();
                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                        join.getScene().getWindow().hide();
                        stage.setTitle("Доставка молочных продуктов");
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //Чтение логина из файла Data
            try {
                BufferedReader reader = new BufferedReader(new FileReader("D:\\Lesson\\labs\\demo1\\src\\main\\resources\\com\\example\\demo1\\Data.txt")) {
                };
                String line;
                while ((line = reader.readLine()) != null) {

                    if (line.equals(login.getText().trim())){
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("Hello.fxml"));
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                            stage.setTitle("Доставка молочных продуктов");
                        } catch (Exception e) {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("hello-view.fxml"));
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                            join.getScene().getWindow().hide();
                            stage.setTitle("Доставка молочных продуктов");
                            e.printStackTrace();
                        }

                        System.out.println("login success");
                    }else {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("Home.fxml"));
                        loader.load();
                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                        join.getScene().getWindow().hide();
                        stage.setTitle("Доставка молочных продуктов");
                    }

                }
            } catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        //Переход на окно регистрации
        reg.setOnAction(click -> {



            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Reg.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                reg.getScene().getWindow().hide();
            } catch (Exception e) {
                e.printStackTrace();
                String asd = login.getText().trim();
                password.setText(asd);

            }
        });



    }
}







