package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    Ingredient i;

    @BeforeEach
    void setup() {
        i = new Ingredient("Vodka", 21, "Strong alcoholic beverage originating in Russia");
    }

    @Test
    void getIngredientName() {
        assertEquals("Vodka", i.getIngredientName());
    }

    @Test
    void getAbv() {
        assertEquals(21, i.getAbv());
    }

    @Test
    void getIDescription() {
        assertEquals("Strong alcoholic beverage originating in Russia", i.getIDescription());
    }

}