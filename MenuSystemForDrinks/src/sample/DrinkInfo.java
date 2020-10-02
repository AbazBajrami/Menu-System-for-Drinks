package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DrinkInfo implements Initializable {
    //BUTTONS
    @FXML
    private TextField nameDI, originDI, urlDI, descriptionDI, q1DI, q2DI, q3DI, q4DI, q5DI, q6DI;
    @FXML
    private ComboBox<String> d1DI, d2DI, d3DI, drinkChoice, i1DI, i2DI, i3DI;
    @FXML
    private Button saveChanges, map, choose;

    //INITIALIZE
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Node tempD = (Node) Main.drinkLinkedList.head; //drinks node

        while (tempD != null) {
            //adds drinks to combo box
            drinkChoice.getItems().add(((Drink) tempD.getData()).getDrinkName());
            //adds drinks in the combo boxes
            d1DI.getItems().add(((Drink) tempD.getData()).getDrinkName());
            d2DI.getItems().add(((Drink) tempD.getData()).getDrinkName());
            d3DI.getItems().add(((Drink) tempD.getData()).getDrinkName());
            //adds ingredients to the combo boxes
            tempD = tempD.next;
        }

        Node tempI = (Node) Main.ingredientLinkedList.head; //ingredients node
        while (tempI != null) {
            if (((Ingredient) tempI.getData()).getIngredientOrigin().hashCode() == 0) { //adds ingredients to combo box
                i1DI.getItems().add(((Ingredient) tempI.getData()).getIngredientName());
                i2DI.getItems().add(((Ingredient) tempI.getData()).getIngredientName());
                i3DI.getItems().add(((Ingredient) tempI.getData()).getIngredientName());
            }
            tempI = tempI.next;
        }

    }

    //DRINK CHOICE
    @FXML
    private void chosenDrink(ActionEvent e) {
        Node temp = (Node) Main.drinkLinkedList.head; //drinks node

        while (temp != null) {
            //while the drink name in the combo box is the same as the drink in the list -> add all details
            while (((Drink) temp.getData()).getDrinkName().equals(drinkChoice.getValue())) {
                //name
                nameDI.setText(((Drink) temp.getData()).getDrinkName());
                //place of origin
                originDI.setText(((Drink) temp.getData()).getPlaceOfOrigin());
                //url
                urlDI.setText(((Drink) temp.getData()).getUrl());
                //description
                descriptionDI.setText(((Drink) temp.getData()).getDescription());
                //q1
                q1DI.setText(String.valueOf(((Drink) temp.getData()).getQ1()));
                //q2
                q2DI.setText(String.valueOf(((Drink) temp.getData()).getQ2()));
                //q3
                q3DI.setText(String.valueOf(((Drink) temp.getData()).getQ3()));
                //q4
                q4DI.setText(String.valueOf(((Drink) temp.getData()).getQ4()));
                //q5
                q5DI.setText(String.valueOf(((Drink) temp.getData()).getQ5()));
                //q6
                q6DI.setText(String.valueOf(((Drink) temp.getData()).getQ6()));


                //drink 1
                d1DI.setValue(((Drink) temp.getData()).getD1());
                //drink 2
                d2DI.setValue(((Drink) temp.getData()).getD3());
                //drink 3
                d3DI.setValue(((Drink) temp.getData()).getD3());
                //ingredient 1
                i1DI.setValue(((Drink) temp.getData()).getI1());
                //ingredient 2
                i2DI.setValue(((Drink) temp.getData()).getI2());
                //ingredient 3
                i3DI.setValue(((Drink) temp.getData()).getI2());
                break;
            }
            temp = temp.next;
        }
    }

    //SAVE CHANGES
    @FXML
    private void saveTheChanges(ActionEvent e) throws IOException {
        Node temp = (Node) Main.drinkLinkedList.head; // drinks node

        while (temp != null) {
            //while the drink name in the combo box is the same as the drink in the list -> set new details
            while (((Drink) temp.getData()).getDrinkName().equals(drinkChoice.getValue())) {
                ((Drink) temp.getData()).setDrinkName(nameDI.getText());
                ((Drink) temp.getData()).setPlaceOfOrigin(originDI.getText());
                ((Drink) temp.getData()).setUrl(urlDI.getText());
                ((Drink) temp.getData()).setDescription(descriptionDI.getText());
                ((Drink) temp.getData()).setD1(d1DI.getValue());
                ((Drink) temp.getData()).setD2(d2DI.getValue());
                ((Drink) temp.getData()).setD3(d3DI.getValue());
                ((Drink) temp.getData()).setI1(i1DI.getValue());
                ((Drink) temp.getData()).setI2(i2DI.getValue());
                ((Drink) temp.getData()).setI3(i3DI.getValue());
                ((Drink) temp.getData()).setQ1(Integer.parseInt(q1DI.getText()));
                ((Drink) temp.getData()).setQ2(Integer.parseInt(q2DI.getText()));
                ((Drink) temp.getData()).setQ3(Integer.parseInt(q3DI.getText()));
                ((Drink) temp.getData()).setQ4(Integer.parseInt(q4DI.getText()));
                ((Drink) temp.getData()).setQ5(Integer.parseInt(q5DI.getText()));
                ((Drink) temp.getData()).setQ6(Integer.parseInt(q6DI.getText()));
                break;
            }
            temp = temp.next;
        }
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../sample/Map.fxml")));
        Main.ps.setScene(mapping);
    }
}


