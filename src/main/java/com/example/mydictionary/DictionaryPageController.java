package com.example.mydictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.HashMap;

public class DictionaryPageController {
    private DictionarySaver db;
    @FXML
    TextField Search;
    @FXML
    TextField newWord;
    @FXML
    TextField Meaning;
    @FXML
    TextField findWord;
    @FXML
    public void SearchButton(MouseEvent event) throws IOException, ClassNotFoundException {
        db=new DictionarySaver();
        db.deserialize();

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");

        if(Search.getText().equals("")){
            alert.setContentText("Please Enter A Word to Search");
            alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(Search.getText().toLowerCase())) {
            alert.setContentText("The Word is Available To the Dictionary");
            alert.showAndWait();
        }
        else{
            alert.setContentText("The Word is Not Available To the Dictionary");
            alert.showAndWait();
        }


    }
    public void Add(MouseEvent event) throws IOException, ClassNotFoundException {
        db=new DictionarySaver();
        db.deserialize();

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");

        if(newWord.getText().equals("") || Meaning.getText().equals("")){
            alert.setContentText("Please Enter/Meaning to Add  to the Dictionary ");
            alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(newWord.getText().toLowerCase())){
            alert.setContentText("The Word Is Already in the Dictionary ");
            alert.showAndWait();
        }
        else {
            db.getDictionaryList().put(newWord.getText().toLowerCase(), Meaning.getText().toLowerCase());
            db.serialize();
            alert.setContentText("New Word is Added to Dictionary");
            alert.showAndWait();
        }

    }
    public void Meaning(MouseEvent event) throws IOException, ClassNotFoundException {
        db=new DictionarySaver();
        db.deserialize();

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Meaning");

        if(findWord.getText().equals("")){
            alert.setContentText("Please Enter A Word to Find Meaning");
            alert.showAndWait();
        }
        if(db.getDictionaryList().containsKey(findWord.getText().toLowerCase())){

            alert.setContentText(db.getDictionaryList().get(findWord.getText().toLowerCase()));
            alert.showAndWait();
        }
        else{
            alert.setContentText("The Word is Not Available in the Dictionary");
            alert.showAndWait();
        }
    }
}
