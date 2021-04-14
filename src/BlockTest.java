package ca.bcit.comp2522.assignments.A3;

import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BlockTest {

    private Block testBlock;

    @Before
    public void setUp() throws Exception {
        ArrayList<Color> testColours = new ArrayList<>();
        testColours.add(Color.RED);
        testColours.add(Color.BLUE);
        testColours.add(Color.GREEN);
        testColours.add(Color.YELLOW);
        testBlock = new Block(0, 0, 10, new SimpleDesign(),
                                    testColours, 0, 1);
    }

    @Test
    public void getLocationXCorrectValue() {
        assertEquals(0, testBlock.getLocationX(), 0);
    }

    @Test
    public void getLocationYCorrectValue() {
        assertEquals(0, testBlock.getLocationY(), 0);
    }

    @Test
    public void getSideLengthCorrectValue() {
        assertEquals(10.0, testBlock.getSideLength(), 0);
    }

    @Test
    public void getDesignRotationCorrectValue() {
        assertEquals(0, testBlock.getDesignRotation(), 0);
    }

    @Test
    public void getDesignTileDimensionCorrectValue() {
        assertEquals(1, testBlock.getDesignTileDimension(), 0);
    }

    @Test
    public void designRotationChangeAppliedCorrectly() {
        testBlock.setDesignRotation(180);
        assertEquals(180, testBlock.getDesignRotation(), 0);
    }

    @Test
    public void designRotationChangeRejectsIllegalValues() {
        testBlock.setDesignRotation(156);
        assertEquals(0, testBlock.getDesignRotation(), 0);
        testBlock.setDesignRotation(-128);
        assertEquals(0, testBlock.getDesignRotation(), 0);
    }

    @Test
    public void colourListHasCorrectValues() {
        Color colour2 = testBlock.getColourList().get(2);
        assertEquals(Color.GREEN, colour2);
    }

    @Test
    public void newColourListWithWrongLengthRejected() {
        ArrayList<Color> badColours = new ArrayList<>();
        badColours.add(Color.RED);
        badColours.add(Color.BLUE);
        badColours.add(Color.GREEN);
        testBlock.setColourList(badColours);
        assertEquals(Color.YELLOW, testBlock.getColourList().get(3));
    }

    @Test
    public void setDesignTileDimensionCorrectValue() {
        testBlock.setDesignTileDimension(3);
        assertEquals(3, testBlock.getDesignTileDimension(), 0);
    }

    @Test
    public void setDesignTileDimensionRejectsIllegalValues() {
        testBlock.setDesignTileDimension(0);
        assertEquals(1, testBlock.getDesignTileDimension(), 0);
        testBlock.setDesignTileDimension(-412);
        assertEquals(1, testBlock.getDesignTileDimension(), 0);
    }

}