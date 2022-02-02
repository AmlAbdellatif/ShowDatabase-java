package com.iti.dbapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import com.iti.dbapp.db.*;

import java.util.Vector;


public class DbApp extends Application {

    //initialize the fields and buttons
    private Label msgLabel;
    private TextField id_field, name_field,
            nName_field, address_field,
            email_field, phone_field;

    private Button  first_button,
            previous_button, next_button,
            last_button;

    private GridPane fieldsPane;
    private HBox buttons_pane;
    private BorderPane root;

    private DbConnection dbConnection;
    private Vector<Contact> contacts;

    private int index;
    private Contact currentContact;

    public void init() throws Exception {
        super.init();

        //creating the textfields
        id_field = new TextField();
        name_field = new TextField();
        nName_field = new TextField();
        address_field = new TextField();
        email_field = new TextField();
        phone_field = new TextField();

        id_field.setEditable(false);

        //creating the buttons

        first_button = new Button("First");
        previous_button = new Button("Previous");
        next_button = new Button("Next");
        last_button = new Button("Last");

        fieldsPane = new GridPane();
        fieldsPane.setMinSize(400, 200);
        fieldsPane.setAlignment(Pos.CENTER);
        fieldsPane.setPadding(new Insets(30, 30, 30, 30));
        fieldsPane.setMaxSize(300, 300);
        fieldsPane.setHgap(20);
        fieldsPane.setVgap(2);
        fieldsPane.add(new Label("ID"), 1, 0);
        fieldsPane.add(id_field, 2, 0);
        fieldsPane.add(new Label("Name"), 1, 1);
        fieldsPane.add(name_field, 2, 1);
        fieldsPane.add(new Label("Nick Name"), 1, 2);
        fieldsPane.add(nName_field, 2, 2);
        fieldsPane.add(new Label("Address"), 1, 3);
        fieldsPane.add(address_field, 2, 3);
        fieldsPane.add(new Label("Email"), 1, 4);
        fieldsPane.add(email_field, 2, 4);
        fieldsPane.add(new Label("Phone"), 1, 5);
        fieldsPane.add(phone_field, 2, 5);

        //creating the pane of buttons
        buttons_pane = new HBox();
        buttons_pane.getChildren().addAll(
                first_button,
                previous_button, next_button,
                last_button);
        buttons_pane.setAlignment(Pos.CENTER);
        buttons_pane.setPadding(new Insets(20, 20, 20, 20));
        buttons_pane.setSpacing(5);

        //root pane
        root = new BorderPane();
        root.setCenter(fieldsPane);
        root.setBottom(buttons_pane);
        root.setTop(msgLabel);


        dbConnection = new DbConnection();
        index = 0;

        contacts = dbConnection.getContacts();
        fill(index);
    }

    void fill(int _index) {
        currentContact = contacts.get(_index);
       // System.out.println(contacts.size());

        id_field.setText(String.valueOf(currentContact.getId()));
        name_field.setText(currentContact.getName());
        nName_field.setText(currentContact.getnName());
        address_field.setText(currentContact.getAddress());
        phone_field.setText(currentContact.gethPhone());
        email_field.setText(currentContact.geteMail());
    }

    private void next() {
        if (index < contacts.size() - 1) {
            index++;
            fill(index);
        }
    }

    private void prev() {
        if (index > 0) {
            index--;
            fill(index);
        }
    }

    private void first() {
        index = 0;
        fill(index);
    }

    private void last() {
        index = contacts.size() - 1;
        fill(index);
    }




    public void start(Stage stage) {


        next_button.setOnAction(actionEvent -> next());
        previous_button.setOnAction(actionEvent -> prev());
        first_button.setOnAction(actionEvent -> first());
        last_button.setOnAction(actionEvent -> last());



        //creating the scene and attaching it to stage
        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("DataBase Helper Application");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}