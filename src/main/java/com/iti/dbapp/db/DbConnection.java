package com.iti.dbapp.db;

import javafx.scene.control.skin.VirtualContainerBase;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

import static java.lang.Class.forName;


public class DbConnection {

    private Connection connection;
    private String dbName, dbHost, dbPort, dbUser, dbPass;

    public DbConnection() {
        dbName = "addressbook";
        dbHost = "localhost";
        dbPort = "5432";
        dbUser = "postgres";
        dbPass = "admin";
        connect();
    }

    private void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName,
                    dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vector<Contact> getContacts() {
        Vector<Contact> contacts = new Vector<>();

        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery("select * from contact");

          Contact contact;
            while (resultSet.next()) {
                resultSet.getInt("id");
                contact = new Contact();

                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("Name"));
                contact.setnName(resultSet.getString("nName"));
                contact.setAddress(resultSet.getString("address"));
                contact.sethPhone(resultSet.getString("hPhone"));
                contact.setwPhone(resultSet.getString("wPhone"));
                contact.setcPhone(resultSet.getString("cPhone"));
                contact.seteMail(resultSet.getString("eMail"));
                contact.setWebSite(resultSet.getString("webSite"));
                contact.setProf(resultSet.getString("prof"));
                contact.setbDate(resultSet.getDate("bDate"));
                contacts.add(contact);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacts;
    }





}
