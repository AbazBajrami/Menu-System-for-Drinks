package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddIngredient {
    //BUTTONS
    @FXML
    private Button map, addIngredient;
    @FXML
    private TextField iName, abv, iDescription, iOrigin, iUrl;

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../sample/Map.fxml")));
        Main.ps.setScene(mapping);
    }

    //ADD DRINK
    @FXML
    private void addTheIngredient(ActionEvent e) throws IOException {
        //if the abv if above 0 and below 60 add drinks
        if (Integer.parseInt(abv.getText()) >= 0 && Integer.parseInt(abv.getText()) <= 60) {
            //adds the ingredient to ingredients linked list
            Ingredient tempIngredient = (new Ingredient(
                    iName.getText(),
                    Integer.parseInt(abv.getText()),
                    iDescription.getText(),
                    iOrigin.getText(),
                    iUrl.getText()
            ));

            //adds ingredient to observable list in the ingredients controller
            IngredientsCon.data.add(new Ingredient(
                    iName.getText(),
                    Integer.parseInt(abv.getText()),
                    iDescription.getText(),
                    iOrigin.getText(),
                    iUrl.getText()
            ));

            //if the url has text in it then add the ingredient as a drink also
            if (iUrl.getText().hashCode() != 0) {
                Main.drinkLinkedList.add(new Drink(
                        iName.getText(),
                        Integer.parseInt(abv.getText()),
                        iDescription.getText(),
                        iOrigin.getText(),
                        iUrl.getText()
                ));

                //observable list
                DrinksCon.drinkData.add(new Drink(
                        iName.getText(),
                        Integer.parseInt(abv.getText()),
                        iDescription.getText(),
                        iOrigin.getText(),
                        iUrl.getText()
                ));
            }

            Main.ingredientLinkedList.add(tempIngredient);
            Main.fh1.add(tempIngredient, iName.getText().length());

            //goes to ingredients table
            Scene goToIngredient = new Scene(FXMLLoader.load(getClass().getResource("../sample/Ingredients.fxml")));
            Main.ps.setScene(goToIngredient);
        } else  //else show error
        {
            System.out.println("The ingredient must have an abv below 60% and above 0%");
        }

    }

    public void showIngred() {
        String ingred = iName.getText().toUpperCase();
        int numStored = ingred.length() % 5;
        LinkedList<Ingredient> ingredls = Main.fh1.getLinkedList(numStored); //taking the row of elements stored at index NumStored in the hashset and putting it into its own list ingredls, Baz will use ingredls to sort/search
    }
}
