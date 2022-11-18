package com.example.demo1;
import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    public class Customer {
        private String name;
        private int number;

        public Customer(String name, int number) {
            this.name = name;
            this.number = number;
        }


        public String getName() {
            return name ;
        }

        public void setName(String name ) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
    @FXML
    private TableView<Customer> tableView;
    @FXML
    private Button save;
    @FXML
    private TableColumn<Customer, String> nameColumn;
    @FXML
    private TableColumn<Customer, Integer> numberColumn;
    @FXML
    private TextField name;
    @FXML
    private TextField number;


    ObservableList<Customer> customers = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        save.setOnAction(cliсk -> {
            try {
                String line = ("-"+" "+name.getText()+" ");
                String line2=("Количество продуктов: "+number.getText()+" ");
                FileOutputStream fileOutputStream =new FileOutputStream("D:\\Lesson\\labs\\demo1\\src\\main\\resources\\com\\example\\demo1\\table.txt");
                byte[] buffer=line.getBytes();
                fileOutputStream.write(buffer);
                buffer=line2.getBytes();
                fileOutputStream.write(buffer);
                System.out.println("Успешное сохранение");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });

        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("number"));
    }

    @FXML
    public void add(ActionEvent event) {
        Customer customer = new Customer(name.getText(),
                Integer.parseInt(number.getText()));
        customers.add(customer);
        tableView.setItems(customers);
    }

    @FXML
    public void delete(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }
}


