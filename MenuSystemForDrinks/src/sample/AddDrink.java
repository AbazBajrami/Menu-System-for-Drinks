package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddDrink {
    //BUTTONS
    @FXML
    private Button map, addDrink;
    @FXML
    private TextField name, origin, url, description;

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../sample/Map.fxml")));
        Main.ps.setScene(mapping);
    }

    //ADD DRINK
    @FXML
    private void addTheDrink(ActionEvent e) throws IOException {
        //adds drink
        Drink tempDrink = (new Drink(
                name.getText(),
                origin.getText(),
                url.getText(),
                description.getText()
        ));

        //adds to observable list
        DrinksCon.drinkData.add(new Drink(
                name.getText(),
                origin.getText(),
                url.getText(),
                description.getText()
        ));

        Main.drinkLinkedList.add(tempDrink);
        Main.fh2.add(tempDrink, name.getText().length());

        //goes to drinks table
        Scene goToDrinks = new Scene(FXMLLoader.load(getClass().getResource("../sample/Drinks.fxml")));
        Main.ps.setScene(goToDrinks);

    }

    public void showdrin() {
        String drin = name.getText().toUpperCase();
        int numStoredD = drin.length() % 5;
        LinkedList<Drink> drinkls = Main.fh2.getLinkedList(numStoredD); //taking the row of elements stored at index NumStored in the hashset and putting it into its own list ingredls, Baz will use ingredls to sort/search
    }

}
