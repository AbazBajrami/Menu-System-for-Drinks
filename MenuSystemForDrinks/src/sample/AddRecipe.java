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

public class AddRecipe implements Initializable {
    //BUTTONS
    @FXML
    private Button map, addRecipe;
    @FXML
    private TextField rName, rOrigin, rUrl, rDescription, q1, q2, q3, q4, q5, q6;
    @FXML
    private ComboBox<String> d1, d2, d3, i1, i2, i3;

    //INITIALIZE
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Node tempI = (Node) Main.ingredientLinkedList.head; //ingredients node
        Node tempD = (Node) Main.drinkLinkedList.head; //drinks node

        while (tempI != null) {
            //if the ingredient is a drink(i.e. has an origin) then don't add it to the ingredients combo box
            //if it is just an ingredient then add it to the combo box
            if (((Ingredient) tempI.getData()).getIngredientOrigin().hashCode() == 0) {
                i1.getItems().add(((Ingredient) tempI.getData()).getIngredientName());
                i2.getItems().add(((Ingredient) tempI.getData()).getIngredientName());
                i3.getItems().add(((Ingredient) tempI.getData()).getIngredientName());
            }
            tempI = tempI.next;
        }

        //adds all drinks to the drinks combo box's
        while (tempD != null) {
            d1.getItems().add(((Drink) tempD.getData()).getDrinkName());
            d2.getItems().add(((Drink) tempD.getData()).getDrinkName());
            d3.getItems().add(((Drink) tempD.getData()).getDrinkName());
            tempD = tempD.next;
        }
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../sample/Map.fxml")));
        Main.ps.setScene(mapping);
    }

    //ADD DRINK
    @FXML
    private void addTheRecipe(ActionEvent e) throws IOException {
        //if the quantity of ml is above 1000 or below 0 then do not add the recipe
        if (Integer.parseInt(q1.getText()) <= 1000 && Integer.parseInt(q1.getText()) >= 0 &&
                Integer.parseInt(q2.getText()) <= 1000 && Integer.parseInt(q1.getText()) >= 0 &&
                Integer.parseInt(q3.getText()) <= 1000 && Integer.parseInt(q1.getText()) >= 0 &&
                Integer.parseInt(q4.getText()) <= 1000 && Integer.parseInt(q1.getText()) >= 0 &&
                Integer.parseInt(q5.getText()) <= 1000 && Integer.parseInt(q1.getText()) >= 0 &&
                Integer.parseInt(q6.getText()) <= 1000 && Integer.parseInt(q1.getText()) >= 0) {
            Main.drinkLinkedList.add(new Drink(
                    rName.getText(),
                    rOrigin.getText(),
                    rUrl.getText(),
                    rDescription.getText(),
                    d1.getValue(),
                    d2.getValue(),
                    d3.getValue(),
                    Integer.parseInt(q1.getText()),
                    Integer.parseInt(q2.getText()),
                    Integer.parseInt(q3.getText()),
                    i1.getValue(),
                    i2.getValue(),
                    i3.getValue(),
                    Integer.parseInt(q4.getText()),
                    Integer.parseInt(q5.getText()),
                    Integer.parseInt(q6.getText())
            ));

            //adds to observable list
            DrinksCon.drinkData.add(new Drink(
                    rName.getText(),
                    rOrigin.getText(),
                    rUrl.getText(),
                    rDescription.getText(),
                    d1.getValue(),
                    d2.getValue(),
                    d3.getValue(),
                    Integer.parseInt(q1.getText()),
                    Integer.parseInt(q2.getText()),
                    Integer.parseInt(q3.getText()),
                    i1.getValue(),
                    i2.getValue(),
                    i3.getValue(),
                    Integer.parseInt(q4.getText()),
                    Integer.parseInt(q5.getText()),
                    Integer.parseInt(q6.getText())
            ));
            //go to drinks table
            Scene goToDrinks = new Scene(FXMLLoader.load(getClass().getResource("../sample/Drinks.fxml")));
            Main.ps.setScene(goToDrinks);
        } else //else show error
        {
            System.out.println("All quantity values must be below 1000ml and above 0ml");
        }
    }
}
