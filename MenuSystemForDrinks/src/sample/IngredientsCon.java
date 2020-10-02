package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.function.Predicate;

import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.sort;

import javafx.collections.transformation.FilteredList;
import javafx.scene.input.KeyEvent;

public class IngredientsCon implements Initializable {
    //BUTTONS
    @FXML
    private Button map, deleteIngredient;
    @FXML
    private TableView<Ingredient> tableView;
    @FXML
    private TableColumn<Ingredient, String> iTableName, tableAbv, iTableDescription;
    @FXML
    private TextField deleteThisIngredient, search;

    //OBSERVABLE LIST
    public static ObservableList<Ingredient> data = FXCollections.observableArrayList();

    //INITIALIZE
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        iTableName.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("ingredientName"));
        tableAbv.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("abv"));
        iTableDescription.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("iDescription"));

        Node temp = (Node) Main.ingredientLinkedList.head; //ingredients node
        while (temp != null) {
            tableView.getItems().add((Ingredient) temp.getData()); //adds ingredients to table
            temp = temp.next;
        }

    }

    @FXML
    private void searchFilter(KeyEvent ke) {
        //wraping the observable list in a filtered list
        FilteredList<Ingredient> filteredData = new FilteredList<>(data, e -> true);
        //set the filter predicate whenever the filter changes
        search.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredData.setPredicate((Predicate<? super Ingredient>) ingredient ->
            {
                //if filter text is empty -> display all ingredients
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                //compares ingredient name of every ingredient with filter text
                String lowerCaseFilter = newValue.toLowerCase();

                if (ingredient.getIngredientName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false; //does not match
            });
        });

        //wrapping the filtered list in a sorted list
        SortedList<Ingredient> sortedData = new SortedList<>(filteredData);

        //bind the sorted list comparator to the tableview comparator
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        //add sorted (and filtered) data to the table
        tableView.setItems(sortedData);
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../sample/Map.fxml")));
        Main.ps.setScene(mapping);
    }

    //DELETE THE INGREDIENT
    @FXML
    private void deleteTheIngredient(ActionEvent e) throws IOException {
        int i = 0; //node number
        Node temp = (Node) Main.ingredientLinkedList.head; //ingredients node

        while (temp != null) {
            //if the ingredients name is the same as the one put in -> delete ingredient
            if (deleteThisIngredient.getText().equals(((Ingredient) temp.getData()).getIngredientName())) {
                Main.ingredientLinkedList.delete(i);
                //goes to ingredients table to show its been deleted
                Scene drinksPage = new Scene(FXMLLoader.load(getClass().getResource("../sample/Ingredients.fxml")));
                Main.ps.setScene(drinksPage);
                //text showing what ingredients been deleted
                System.out.println("The Ingredient " + deleteThisIngredient.getText() + " has been deleted");
                break;
            } else {
                temp = temp.next;
                i++;
            }
        }

        //deletes the ingredient in the observable list
        for (int j = 0; j <= data.size(); j++) {
            if (data.get(j).getIngredientName().equals(deleteThisIngredient.getText())) {
                data.remove(j);
            }
        }
    }

    //GO TO INGREDIENT INFO
    @FXML
    private void goToMoreInfo(ActionEvent e) throws IOException {
        Scene goToTheInfo = new Scene(FXMLLoader.load(getClass().getResource("../sample/IngredientInfo.fxml")));
        Main.ps.setScene(goToTheInfo);
    }

}
