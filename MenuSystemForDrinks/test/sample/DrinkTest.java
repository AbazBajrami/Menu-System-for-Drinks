package sample;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    Drink d;

    @BeforeEach
    void setUp() {
        d = new Drink("Coke", "France", "1223.com", "A cola flavoured drink");
    }

    @org.junit.jupiter.api.Test
    void getDrinkName() {
        assertEquals("Coke", d.getDrinkName());
    }


    @org.junit.jupiter.api.Test
    void getPlaceOfOrigin() {
        assertEquals("France", d.getPlaceOfOrigin());
    }


    @org.junit.jupiter.api.Test
    void getUrl() {
        assertEquals("1223.com", d.getUrl());
    }


    @org.junit.jupiter.api.Test
    void getDescription() {
        assertEquals("A cola flavoured drink", d.getDescription());
    }


}