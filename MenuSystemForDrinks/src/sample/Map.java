package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

import java.io.IOException;

public class Map {
    //BUTTONS
    @FXML
    private Button menu, addDrink, addRecipe, addIngredient, viewDrinks, viewIngredients, drinkInfo, ingredientInfo;

    //MENU
    @FXML
    private void goToMenu(ActionEvent e) throws IOException {
        Scene menu = new Scene(FXMLLoader.load(getClass().getResource("../sample/MenuScreen.fxml")));
        Main.ps.setScene(menu);
    }

    //ADD A DRINK
    @FXML
    private void goToAddDrink(ActionEvent e) throws IOException {
        Scene addD = new Scene(FXMLLoader.load(getClass().getResource("../sample/AddDrink.fxml")));
        Main.ps.setScene(addD);
    }

    //ADD A RECIPE
    @FXML
    private void goToAddRecipe(ActionEvent e) throws IOException {
        Scene addR = new Scene(FXMLLoader.load(getClass().getResource("../sample/AddRecipe.fxml")));
        Main.ps.setScene(addR);
    }

    //ADD AN INGREDIENT
    @FXML
    private void goToAddIngredient(ActionEvent e) throws IOException {
        Scene addI = new Scene(FXMLLoader.load(getClass().getResource("../sample/AddIngredient.fxml")));
        Main.ps.setScene(addI);
    }

    //VIEW DRINKS
    @FXML
    private void goToViewDrinks(ActionEvent e) throws IOException {
        Scene d = new Scene(FXMLLoader.load(getClass().getResource("../sample/Drinks.fxml")));
        Main.ps.setScene(d);
    }

    //VIEW INGREDIENTS
    @FXML
    private void goToViewIngredients(ActionEvent e) throws IOException {
        Scene i = new Scene(FXMLLoader.load(getClass().getResource("../sample/Ingredients.fxml")));
        Main.ps.setScene(i);
    }

    //DRINK INFO
    @FXML
    private void goToDrinkInfo(ActionEvent e) throws IOException {
        Scene dI = new Scene(FXMLLoader.load(getClass().getResource("../sample/DrinkInfo.fxml")));
        Main.ps.setScene(dI);
    }

    //INGREDIENT INFO
    @FXML
    private void goToIngredientInfo(ActionEvent e) throws IOException {
        Scene iI = new Scene(FXMLLoader.load(getClass().getResource("../sample/IngredientInfo.fxml")));
        Main.ps.setScene(iI);
    }
}
