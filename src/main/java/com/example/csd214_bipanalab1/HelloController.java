package com.example.csd214_bipanalab1;

import com.example.csd214_bipanalab1.Language;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class HelloController implements Initializable {
    @FXML
    private TableView<Language> language;
    @FXML
    private TableColumn<Language,Integer > id;
    @FXML
    private TableColumn<Language, String> Instructor;
    @FXML
    private TableColumn<Language,String> Language;
    @FXML
    private TableColumn<Language,Integer> Session;
    ObservableList<Language> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new
                PropertyValueFactory<Language,Integer>("id"));
        Instructor .setCellValueFactory(new
                PropertyValueFactory<Language,String>("Instructor"));
        Language.setCellValueFactory(new
                PropertyValueFactory<Language,String>("Language"));
        Session.setCellValueFactory(new
                PropertyValueFactory<Language,Integer>("Session"));
       language.setItems(list);
    }
    @FXML
    protected void onHelloButtonClick() {
        populateTable();
    }
    public void populateTable() {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/bipanalab1";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM language";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String Instructor = resultSet.getString("Instructor");
                String Language = resultSet.getString("Language");
                int Session = resultSet.getInt("Session");
                language.getItems().add(new Language(id, Instructor, Language,
                        Session));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
