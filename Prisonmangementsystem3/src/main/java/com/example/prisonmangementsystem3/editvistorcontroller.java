package com.example.prisonmangementsystem3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class editvistorcontroller implements Initializable {
    @FXML
    private TextField editvistortext;
    @FXML
    private TextField editvistoraddresstext;
    @FXML
    private TextField editphonenumber;
    @FXML
    private ComboBox visitorCombo;
    @FXML
    private Button backbutton1;
    protected static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/prison";
    protected static final String DB_USER = "root";
    
    protected static final String DB_PASSWORD = "Password123";
    private PreparedStatement selectvistorquery;
    private ObservableList vistorcomboboxvalues= FXCollections.observableArrayList();
    protected String editvistorname;
    protected String editvistoraddress;
    protected String editvistorphone;
    protected String vistor;
    private Scene scene;
    private Stage stage;
    private void getttinguserfromcombobox()
    {
        vistorcomboboxvalues.removeAll(vistorcomboboxvalues);
        try {
            Connection connection = DriverManager.getConnection(DB_CONNECTION,DB_USER , DB_PASSWORD);
            selectvistorquery = connection.prepareStatement("SELECT personname FROM personalinfo");
            ResultSet queryresults = selectvistorquery.executeQuery();
            LinkedList<String> Ll = new LinkedList<>();
            while (queryresults.next())
            {
                try
                {
                    Ll.removeAll(Ll);
                    Ll.add(queryresults.getString("personname"));
                    //String changeVendorName;
                }

                catch (SQLException e)
                {
                    System.out.println(e.toString());
                }
                visitorCombo.getItems().addAll(Ll);
            }

        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
    @Override
    public void initialize(URL link, ResourceBundle rB)
    {
        getttinguserfromcombobox();
        visitorCombo.setOnAction(this::getvistors);
    }

    public void getvistors(Event event)
    {
        String  vistors = visitorCombo.getValue().toString();
        final String selectingvistorsquery = "SELECT personname FROM personalinfo WHERE personname = ?";
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION,DB_USER , DB_PASSWORD);
             PreparedStatement gettingvistor= connection.prepareStatement(selectingvistorsquery))
        {
            gettingvistor.setString(1, vistors);
            ResultSet queryresults = gettingvistor.executeQuery();

            if(queryresults.next())
            {
                String gettingvistorname = queryresults.getString("personname");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }


    }
    public void onvistorseditclick() {
        String editvistorname = editvistortext.getText();
        String editvistoraddress = editvistoraddresstext.getText();
        String editvistorphone = editphonenumber.getText();
        String vistor = visitorCombo.getValue().toString();
        try{
            prisonsystemdatabase database = new prisonsystemdatabase();
            database.editVisitor(editvistorname,editvistoraddress,editvistorphone,vistor);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void onbackbuton() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("vistors.fxml"));
        stage = (Stage) backbutton1.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
