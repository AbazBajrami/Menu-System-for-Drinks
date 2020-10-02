package sample;

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
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.function.Predicate;

public class DrinksCon implements Initializable {
    //BUTTONS
    // drink tables
    @FXML
    private TableView<Drink> tableView;
    @FXML
    private Button map, delete, seeMoreInfo;
    @FXML
    private TableColumn<Drink, String> tableName, tableOrigin, tableDescription, tableUrl;
    @FXML
    private TextField deleteThisDrink, searchBox;

    //OBSERVABLE LIST
    public static ObservableList<Drink> drinkData = FXCollections.observableArrayList();

    //INITIALIZE
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        tableName.setCellValueFactory(new PropertyValueFactory<Drink, String>("drinkName"));
        tableOrigin.setCellValueFactory(new PropertyValueFactory<Drink, String>("placeOfOrigin"));
        tableDescription.setCellValueFactory(new PropertyValueFactory<Drink, String>("description"));
        tableUrl.setCellValueFactory(new PropertyValueFactory<Drink, String>("url"));

        Node temp = (Node) Main.drinkLinkedList.head; //drinks node
        while (temp != null) {
            tableView.getItems().add((Drink) temp.getData()); //add data to table
            temp = temp.next;
        }
    }

    //GO TO DRINK INFO
    @FXML
    private void goToMoreInfo(ActionEvent e) throws IOException {
        Scene goToTheInfo = new Scene(FXMLLoader.load(getClass().getResource("../sample/DrinkInfo.fxml")));
        Main.ps.setScene(goToTheInfo);
    }

    @FXML
    private void drinkSearch(KeyEvent ke) {
        //wraping the observable list in a filtered list
        FilteredList<Drink> filteredData = new FilteredList<>(drinkData, e -> true);
        //set the filter predicate whenever the filter changes
        searchBox.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredData.setPredicate((Predicate<? super Drink>) drink ->
            {
                //if filter text is empty -> display all ingredients
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                //compares ingredient name of every ingredient with filter text
                String lowerCaseFilter = newValue.toLowerCase();

                if (drink.getDrinkName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false; //does not match
            });
        });

        //wrapping the filtered list in a sorted list
        SortedList<Drink> sortedData = new SortedList<>(filteredData);

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

    //DELETE THE DRINK
    @FXML
    private void deleteTheDrink(ActionEvent e) throws IOException {
        int i = 0;
        Node temp = (Node) Main.drinkLinkedList.head; //drinks node

        while (temp != null) {
            //if the drink name is the same as the one put in -> delete drink
            if (deleteThisDrink.getText().equals(((Drink) temp.getData()).getDrinkName())) {
                //delete node i
                Main.drinkLinkedList.delete(i);
                //goes to drinks table again to see that it has been deleted
                Scene drinksPage = new Scene(FXMLLoader.load(getClass().getResource("../sample/Drinks.fxml")));
                Main.ps.setScene(drinksPage);
                //text showing what drink has been deleted
                System.out.println("The drink " + deleteThisDrink.getText() + " has been deleted");
                break;
            } else {
                temp = temp.next;
                i++;
            }
        }

        //deletes drink in the observable list
        for (int j = 0; j <= drinkData.size(); j++) {
            if (drinkData.get(j).getDrinkName().equals(deleteThisDrink.getText())) {
                drinkData.remove(j);
            }
        }
    }
}
