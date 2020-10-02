package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IngredientInfo implements Initializable {
    //BUTTONS
    @FXML
    private TextField nameInfo, abvInfo, descriptionInfo, originInfo, urlInfo;
    @FXML
    private Button saveChanges, map, choose;
    @FXML
    private ComboBox<String> ingredientChoice;

    //INITIALIZE
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Node temp = (Node) Main.ingredientLinkedList.head;//ingredients node
        while (temp != null) {
            //Adds Ingredients to combo box
            ingredientChoice.getItems().add(((Ingredient) temp.getData()).getIngredientName());
            temp = temp.next;
        }
    }

    //DRINK CHOICE
    @FXML
    private void chosenIngredient(ActionEvent e) {
        //Fill in Ingredients Details
        Node temp = (Node) Main.ingredientLinkedList.head;// ingredients node

        while (temp != null) {
            //while the ingredients name in the combo box is the same as the ingredient in the list -> put in details
            while (((Ingredient) temp.getData()).getIngredientName().equals(ingredientChoice.getValue())) {
                //name
                nameInfo.setText(((Ingredient) temp.getData()).getIngredientName());
                //abv
                abvInfo.setText(String.valueOf(((Ingredient) temp.getData()).getAbv()));
                //description
                descriptionInfo.setText(((Ingredient) temp.getData()).getIDescription());
                //origin
                originInfo.setText(((Ingredient) temp.getData()).getIngredientOrigin());
                //url
                urlInfo.setText(((Ingredient) temp.getData()).getIngredientUrl());
                break;
            }
            temp = temp.next;
        }
    }

    //SAVE CHANGES
    @FXML
    private void saveTheChanges(ActionEvent e) throws IOException {
        Node temp = (Node) Main.ingredientLinkedList.head; //ingredients node
        while (temp != null) {
            //while the ingredients name in the combo box is the same as the ingredient in the list -> set new details
            while (((Ingredient) temp.getData()).getIngredientName().equals(ingredientChoice.getValue())) {
                ((Ingredient) temp.getData()).setIngredientName(nameInfo.getText());
                ((Ingredient) temp.getData()).setIngredientOrigin(originInfo.getText());
                ((Ingredient) temp.getData()).setIDescription(descriptionInfo.getText());
                ((Ingredient) temp.getData()).setAbv(Integer.parseInt(abvInfo.getText()));
                break;
            }
            temp = temp.next;
        }

        Node tempD = (Node) Main.drinkLinkedList.head; // drinks node
        while (tempD != null) {
            //while the ingredients name in the combo box is the same as the drink in the list -> set new details
            while (((Drink) tempD.getData()).getDrinkName().equals(ingredientChoice.getValue())) {
                ((Drink) tempD.getData()).setDrinkName(nameInfo.getText());
                ((Drink) tempD.getData()).setPlaceOfOrigin(originInfo.getText());
                ((Drink) tempD.getData()).setUrl(urlInfo.getText());
                ((Drink) tempD.getData()).setDescription(descriptionInfo.getText());
                ((Drink) tempD.getData()).setDrinkAbv(Integer.parseInt(abvInfo.getText()));
                break;
            }
            tempD = tempD.next;
        }
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../sample/Map.fxml")));
        Main.ps.setScene(mapping);
    }
}
