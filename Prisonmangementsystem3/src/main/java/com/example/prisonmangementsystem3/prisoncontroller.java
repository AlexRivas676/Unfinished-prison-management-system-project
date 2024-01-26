package com.example.prisonmangementsystem3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class prisoncontroller{
    @FXML
    private Button assigntask;
    @FXML
    private Button editvistor;
    @FXML
    private Button edittask;
    @FXML
    private Button editprisoner;
    @FXML
    private Button edithealthrecord;
    @FXML
    private Button addprisoner;
    @FXML
    private Button addvistor;
    @FXML
    private Button prisonersbutton;
    @FXML
    private Button vistorsbutton;
    @FXML
    private Button healthbutton;
    @FXML
    private Button taskbutton;
    @FXML
    private Button loginbutton;
    @FXML
    private TextField usernametext;
    @FXML
    private TextField passwordtext;
    @FXML
    private ComboBox visitorCombo;
    @FXML
    private Button backbutton;
    @FXML
    private Button addhealthrecord;
    private Button vistorssave;
    @FXML
    private TextField vnametext;
    @FXML
    private TextField vaddresstext;
    @FXML
    private TextField vphonetext;
    private TextField pfnametext;
    @FXML
    private TextField editvistortext;
    @FXML
    private TextField editvistoraddresstext;
    private TextField editvistorphonetext;
    private TextField pmnametext;
    private TextField plnametext;
    private PreparedStatement sendIt;
    private ObservableList comboBoxOptions= FXCollections.observableArrayList();
    protected static final String DatabaseURL = "jdbc:mysql://localhost:3306/prison?useSSL=false";
    protected static final String DatabaseUsername = "root";
    protected static final String DatabasePassword = "Password123";
    protected String editvistorname;
    protected String editvistoraddress;
    protected String editvistorphone;
    protected String vistor;
    private Scene scene;
    private Stage stage;
    

    @FXML
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    Image i = new Image(getClass().getResourceAsStream("addprisoners.png"));
    Image i2 = new Image(getClass().getResourceAsStream("prisonvistorsicon.jpg"));
    Image i3 = new Image(getClass().getResourceAsStream("medicalprisoners.png"));
    Image i4 = new Image(getClass().getResourceAsStream("prisonertask.jpg"));

    @FXML
    public void onloginbuttonclick() throws IOException{
        Stage stage;
        Parent root;
        String username1;
        String password1;
        username1 = this.usernametext.getText();
        password1 = this.passwordtext.getText();
        if(username1.equals("admin") && password1.equals("password")){
            stage = (Stage) loginbutton.getScene().getWindow();
            root = FXMLLoader.load(this.getClass().getResource("prisonsystemmain.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if(!username1.equals("admin") && !password1.equals("password") || username1.equals("")&& password1.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter a Valid Password or Username!");
            alert.show();

        }


    }

    protected void displayimages() {
        image1.setImage(i);
        image2.setImage(i2);
        image3.setImage(i3);
        image4.setImage(i4);
        image1.getImage();
        image2.getImage();
        image3.getImage();
        image4.getImage();
    }

   /* public void onsaveprisonersbutton() throws IOException {
            String vistorsname = vnametext.getText().trim();
            String vistoraddress = vaddresstext.getText().trim();
            String vistorphone = vphonetext.getText().trim();
            if (!vistorsname.equals("") && !vistoraddress.equals("") && !vistorphone.equals("")) {
                try {
                    prisonsystemdatabase insertDatabase = new prisonsystemdatabase();
                    insertDatabase.insertVisitor(vistorsname, vistoraddress, vistorphone);
                } catch (Exception e) {
                    System.out.println("Failed");
                }
            }
        }
        }*/
        public void onsavevistorsbutton() throws IOException {
            String vistorsname = vnametext.getText().trim();
            String vistoraddress = vaddresstext.getText().trim();
            String vistorphone = vphonetext.getText().trim();
            if (!vistorsname.equals("") && !vistoraddress.equals("") && !vistorphone.equals("")) {
                try {
                    prisonsystemdatabase insertDatabase = new prisonsystemdatabase();
                    insertDatabase.insertVisitor(vistorsname, vistoraddress, vistorphone);
                } catch (Exception e) {
                    System.out.println("Failed");
                }
            }
        }

    public void onprisonersbuttonclick()throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) prisonersbutton.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("prisoners.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void onvistorsbuttonclick() throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) vistorsbutton.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("vistors.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onaddprisonersclick()throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) addprisoner.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("prisonerinfo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     }
    public void editprisonersclick()throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) editprisoner.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("prisonerinfo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onbackbuton()throws IOException{
        Stage stage;
        Parent root;
        stage =(Stage)  backbutton.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("prisonsystemmain.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onhealthbuttonclick()throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) healthbutton.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("health.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void ontaskbuttonclick()throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) taskbutton.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("task.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onaddvistorbutton() throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) addvistor.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("vistorsinfo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void oneditvistorbutton() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("vistorsedit.fxml"));
        stage = (Stage) editvistor.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onaddhealthrecord()throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) addhealthrecord.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("health info.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onedithealthrecord()throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) edithealthrecord.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("health info.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onedittask()throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) edittask.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("task info.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onassigntask() throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) assigntask.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("task info.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    }
