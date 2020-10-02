package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.List;

public class Main extends Application {
    //LINKED LISTS
    public static LinkedList<Drink> drinkLinkedList = new LinkedList<>();
    public static LinkedList<Ingredient> ingredientLinkedList = new LinkedList<>();
    //HASH TABLES
    public static FastHashSC<Ingredient> fh1 = new FastHashSC<>(5); //creates a new hashset for ingred
    public static FastHashSC<Drink> fh2 = new FastHashSC<>(5);

    public static Stage ps;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../sample/Map.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        ps = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    //SAVE
    @SuppressWarnings("unchecked")
    public static void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());

        //drinks
        //linked list
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("drinks.xml"));
        out.writeObject(drinkLinkedList);
        out.close();

        //hash list
        out = xstream.createObjectOutputStream(new FileWriter("fh2.xml"));
        out.writeObject(fh2);
        out.close();

        //ingredients
        //linked list
        out = xstream.createObjectOutputStream(new FileWriter("ingredients.xml"));
        out.writeObject(ingredientLinkedList);
        out.close();

        //has list
        out = xstream.createObjectOutputStream(new FileWriter("fh1.xml"));
        out.writeObject(fh1);
        out.close();
    }

    //LOAD
    @SuppressWarnings("unchecked")
    public static void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());

        //Drinks
        //linked list
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("drinks.xml"));
        drinkLinkedList = (LinkedList<Drink>) is.readObject();
        is.close();

        //hash list
        is = xstream.createObjectInputStream(new FileReader("fh2.xml"));
        fh2 = (FastHashSC<Drink>) is.readObject();
        is.close();


        //Ingredients
        //linked list
        is = xstream.createObjectInputStream(new FileReader("ingredients.xml"));
        ingredientLinkedList = (LinkedList<Ingredient>) is.readObject();
        is.close();

        //hash list
        is = xstream.createObjectInputStream(new FileReader("fh1.xml"));
        fh1 = (FastHashSC<Ingredient>) is.readObject();
        is.close();


        //Observable lists
        //adds data from drinks linked list and ingredients linked list to the observable lists of each
        //this is because you can't save an observable list in an xml file

        //drinks
        //this data is being added to the observable list so it doesnt matter which constructor from the drink class you use
        //i used the "recipe" one as it was the easiest
        Node temp = (Node) drinkLinkedList.head; //ingredients node
        while (temp != null) {
            DrinksCon.drinkData.add(new Drink(
                    (((Drink) temp.getData()).getDrinkName()),
                    (((Drink) temp.getData()).getPlaceOfOrigin()),
                    (((Drink) temp.getData()).getUrl()),
                    (((Drink) temp.getData()).getDescription()),
                    (((Drink) temp.getData()).getD1()),
                    (((Drink) temp.getData()).getD2()),
                    (((Drink) temp.getData()).getD3()),
                    (((Drink) temp.getData()).getQ1()),
                    (((Drink) temp.getData()).getQ2()),
                    (((Drink) temp.getData()).getQ3()),
                    (((Drink) temp.getData()).getI1()),
                    (((Drink) temp.getData()).getI2()),
                    (((Drink) temp.getData()).getI3()),
                    (((Drink) temp.getData()).getQ4()),
                    (((Drink) temp.getData()).getQ5()),
                    (((Drink) temp.getData()).getQ6())
            ));

            temp = temp.next;
        }

        //ingredients
        Node tempI = (Node) ingredientLinkedList.head; //ingredients node
        while (tempI != null) {
            IngredientsCon.data.add(new Ingredient(
                    (((Ingredient) tempI.getData()).getIngredientName()),
                    (((Ingredient) tempI.getData()).getAbv()),
                    (((Ingredient) tempI.getData()).getIDescription()),
                    (((Ingredient) tempI.getData()).getIngredientOrigin()),
                    (((Ingredient) tempI.getData()).getIngredientUrl())
            ));
            tempI = tempI.next;
        }
    }
}
