package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;


import java.io.IOException;
import java.util.Collections;

public class MenuScreen {
    //BUTTONS
    @FXML
    private Button map, reset, save, load, goToAD, goToAI, goToAR, goToVD, goToVI;

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../sample/Map.fxml")));
        Main.ps.setScene(mapping);
    }

    //RESET EVERYTHING
    @FXML
    private void resetAll(ActionEvent e) throws IOException {
        Main.drinkLinkedList.deleteAll(1);
        Main.ingredientLinkedList.deleteAll(1);
        DrinksCon.drinkData.clear();
        IngredientsCon.data.clear();
        System.out.println("The data has been reset.");
    }

    //SAVE
    @FXML
    private void saveAll(ActionEvent e) throws IOException {
        try {
            Main.save();
            System.out.println("The data has been saved.");
        } catch (Exception f) {
            System.err.println("Error writing to file: " + f);
        }
    }

    //LOAD
    @FXML
    private void loadAll() {
        try {
            Main.load();
            System.out.println("The data has been loaded.");
        } catch (Exception f) {
            System.err.println("Error writing to file: " + f);
        }
    }

    //GO TO ADD DRINKS
    @FXML
    private void goToAddDrinks(ActionEvent e) throws IOException {
        Scene addD = new Scene(FXMLLoader.load(getClass().getResource("../sample/AddDrink.fxml")));
        Main.ps.setScene(addD);
    }

    //GO TO ADD RECIPES
    @FXML
    private void goToAddRecipes(ActionEvent e) throws IOException {
        Scene addR = new Scene(FXMLLoader.load(getClass().getResource("../sample/AddRecipe.fxml")));
        Main.ps.setScene(addR);
    }

    //GO TO ADD INGREDIENTS
    @FXML
    private void goToAddIngredients(ActionEvent e) throws IOException {
        Scene addI = new Scene(FXMLLoader.load(getClass().getResource("../sample/AddIngredient.fxml")));
        Main.ps.setScene(addI);
    }

    //VIEW DRINKS
    @FXML
    private void goToViewDrinks(ActionEvent e) throws IOException {
        Scene viewD = new Scene(FXMLLoader.load(getClass().getResource("../sample/Drinks.fxml")));
        Main.ps.setScene(viewD);
    }

    //VIEW INGREDIENTS
    @FXML
    private void goToViewIngredients(ActionEvent e) throws IOException {
        Scene viewI = new Scene(FXMLLoader.load(getClass().getResource("../sample/Ingredients.fxml")));
        Main.ps.setScene(viewI);
    }
}
