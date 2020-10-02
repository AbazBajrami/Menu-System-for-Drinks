package sample;

public class Drink {
    //INSTANCES
    private String drinkName, placeOfOrigin, url, description; //drink details
    private String d1, d2, d3; // drinks used in recipe
    private int q1, q2, q3; // qauntites of the drinks in the recipe
    private String i1, i2, i3; // ingredients used in the recipe
    private int q4, q5, q6; // quatities of the ingredients in the recipe
    private int drinkAbv;

    //CONSTRUCTORS
    //normal drinks
    public Drink(String drinkName, String placeOfOrigin, String url, String description) {
        this.drinkName = drinkName;
        this.placeOfOrigin = placeOfOrigin;
        this.url = url;
        this.description = description;
    }

    //drinks with recipes
    public Drink(String drinkName, String placeOfOrigin, String url, String description, String d1, String d2, String d3, int q1, int q2, int q3, String i1, String i2, String i3, int q4, int q5, int q6) {
        this.drinkName = drinkName;
        this.placeOfOrigin = placeOfOrigin;
        this.url = url;
        this.description = description;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
    }

    //ingredients that are also drinks
    public Drink(String drinkName, int drinkAbv, String description, String placeOfOrigin, String url) {
        this.drinkName = drinkName;
        this.drinkAbv = drinkAbv;
        this.placeOfOrigin = placeOfOrigin;
        this.url = url;
        this.description = description;
    }

    //GETTERS AND SETTER
    // drink name
    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    // place of origin
    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    // url
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // drink 1
    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    // drink 2
    public String getD2() {
        return d2;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    // drink 3
    public String getD3() {
        return d3;
    }

    public void setD3(String d3) {
        this.d3 = d3;
    }

    // qauntitiy 1
    public int getQ1() {
        return q1;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    // qauntitiy 2
    public int getQ2() {
        return q2;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    // qauntitiy 3
    public int getQ3() {
        return q3;
    }

    public void setQ3(int q3) {
        this.q3 = q3;
    }

    // ingedient 1
    public String getI1() {
        return i1;
    }

    public void setI1(String i1) {
        this.i1 = i1;
    }

    // ingedient 2
    public String getI2() {
        return i2;
    }

    public void setI2(String i2) {
        this.i2 = i2;
    }

    // ingedient 3
    public String getI3() {
        return i3;
    }

    public void setI3(String i3) {
        this.i3 = i3;
    }

    // qauntitiy 4
    public int getQ4() {
        return q4;
    }

    public void setQ4(int q4) {
        this.q4 = q4;
    }

    // qauntitiy 5
    public int getQ5() {
        return q5;
    }

    public void setQ5(int q5) {
        this.q5 = q5;
    }

    // qauntitiy 6
    public int getQ6() {
        return q6;
    }

    public void setQ6(int q6) {
        this.q6 = q6;
    }

    // drink abv
    public int getDrinkAbv() {
        return drinkAbv;
    }

    public void setDrinkAbv(int drinkAbv) {
        this.drinkAbv = drinkAbv;
    }
}
