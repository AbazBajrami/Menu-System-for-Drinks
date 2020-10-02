package sample;

public class Ingredient {
    //INSTANCES
    private String ingredientName, iDescription, ingredientOrigin, ingredientUrl;
    private int abv;

    //CONSTRUCTORS
    //normal ingredient
    public Ingredient(String ingredientName, int abv, String iDescription) {
        this.ingredientName = ingredientName;
        this.abv = abv;
        this.iDescription = iDescription;
    }

    //ingredient that is also a drink
    public Ingredient(String ingredientName, int abv, String iDescription, String ingredientOrigin, String ingredientUrl) {
        this.ingredientName = ingredientName;
        this.abv = abv;
        this.iDescription = iDescription;
        this.ingredientOrigin = ingredientOrigin;
        this.ingredientUrl = ingredientUrl;
    }

    //GETTERS AND SETTERS
    //ingredient name
    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    //alcohol content
    public int getAbv() {
        return abv;
    }

    public void setAbv(int abv) {
        this.abv = abv;
    }

    //ingredient description
    public String getIDescription() {
        return iDescription;
    }

    public void setIDescription(String iDescription) {
        this.iDescription = iDescription;
    }

    //ingredient origin
    public String getIngredientOrigin() {
        return ingredientOrigin;
    }

    public void setIngredientOrigin(String ingredientOrigin) {
        this.ingredientOrigin = ingredientOrigin;
    }

    //ingredient url
    public String getIngredientUrl() {
        return ingredientUrl;
    }

    public void setIngredientUrl(String ingredientUrl) {
        this.ingredientUrl = ingredientUrl;
    }

}
