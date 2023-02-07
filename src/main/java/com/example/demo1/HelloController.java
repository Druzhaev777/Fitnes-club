package com.example.demo1;
import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    public class Customer {
        private String name;
        private String email;
        private String date;

        public Customer(String name, String email,String date) {
            this.name = name;
            this.email = email;
            this.date = date;
        }


        public String getName() {
            return name ;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email ;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        public String getDate() {
            return date ;
        }

        public void setDate(String date ) {
            this.date = date;
        }

    }
    @FXML
    private TableView<Customer> tableView;
    @FXML
    private Button save;
    @FXML
    private TableColumn<Customer, String> nameColumn;
    @FXML
    private TableColumn<Customer, String> numberColumn;
    @FXML
    private TableColumn<Customer, String> numberColumn1;
    @FXML
    private TextField name;
    @FXML
    private TextField email;

    @FXML
    private TextField date;

    ObservableList<Customer> customers = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        save.setOnAction(cliсk -> {
            try {
                String line = ("ФИО:"+" \n"+name.getText()+" \n");
                String line2=("Почта:\n "+email.getText()+"\n ");
                String line3=("До:\n "+date.getText()+"\n ");
                FileOutputStream fileOutputStream =new FileOutputStream("D:\\Lesson\\labs\\demo1\\src\\main\\resources\\com\\example\\demo1\\table.txt",true);
                byte[] buffer=line.getBytes();
                fileOutputStream.write(buffer);
                byte[] buffer2 =line2.getBytes();
                fileOutputStream.write(buffer2);
                byte[] buffer3 =line3.getBytes();
                fileOutputStream.write(buffer3);
                fileOutputStream.close();
                System.out.println("Успешное сохранение");
//сохранение данных таблицы в файл
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });

        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        numberColumn1.setCellValueFactory(new PropertyValueFactory<Customer,String >("date"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));

    }

    @FXML
    public void add(ActionEvent event) {
        Customer customer = new Customer(name.getText(),
                (date.getText()),
                (email.getText()));
        customers.add(customer);
        tableView.setItems(customers);
    }

    @FXML
    public void delete(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }
}


