package ca.bcit.comp2522.assignments.A3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuiltTopTest {

    private QuiltTop testTop;
    private int testXValue;
    private int testYValue;

    @Before
    public void setUp() throws Exception {
        testTop = new QuiltTop();
        testXValue = 3;
        testYValue = 5;
    }

    @Test
    public void containsConstantCalledDEFAULT_QUILT_SIZE() {
        assertEquals(QuiltTop.DEFAULT_QUILT_SIZE, QuiltTop.DEFAULT_QUILT_SIZE, 0);
    }

    @Test
    public void containsConstantCalledDEFAULT_SIDE_LENGTH() {
        assertEquals(QuiltTop.DEFAULT_SIDE_LENGTH, QuiltTop.DEFAULT_SIDE_LENGTH, 0);
    }

    @Test
    public void containsConstantCalledDEFAULT_COLOUR() {
        assertEquals(QuiltTop.DEFAULT_COLOUR, QuiltTop.DEFAULT_COLOUR);
    }

    @Test
    public void defaultValuesGenerateCorrectlySizedArrays() {
        assertEquals(QuiltTop.DEFAULT_QUILT_SIZE, testTop.getBlocksList().length, 0);
        assertEquals(QuiltTop.DEFAULT_QUILT_SIZE, testTop.getBlocksList()[0].length, 0);
    }

    @Test
    public void defaultValuesGenerateCorrectNumberOfGroups() {
        assertEquals(Math.pow(QuiltTop.DEFAULT_QUILT_SIZE, 2), testTop.drawAllBlocks().size(), 0);
    }

    @Test
    public void newSizeValuesGenerateCorrectlySizedArrays() {
        testTop.setQuiltDimensionX(testXValue);
        testTop.setQuiltDimensionY(testYValue);
        testTop.createBlocks();
        assertEquals(testYValue, testTop.getBlocksList().length, 0);
        assertEquals(testXValue, testTop.getBlocksList()[0].length, 0);
    }

    @Test
    public void newSizeValuesGenerateCorrectNumberOfGroups() {
        testTop.setQuiltDimensionX(testXValue);
        testTop.setQuiltDimensionY(testYValue);
        testTop.createBlocks();
        assertEquals(testXValue*testYValue, testTop.drawAllBlocks().size(), 0);
    }

    @Test
    public void illegalSizeValuesAreRejectedInArraySize() {
        testTop.setQuiltDimensionX(-42);
        testTop.setQuiltDimensionY(0);
        testTop.setNewBlockSideLength(-44.562);
        testTop.createBlocks();
        assertEquals(QuiltTop.DEFAULT_QUILT_SIZE, testTop.getBlocksList().length, 0);
        assertEquals(QuiltTop.DEFAULT_QUILT_SIZE, testTop.getBlocksList()[0].length, 0);
    }

    @Test
    public void illegalSizeValuesAreRejectedOnGroupCreation() {
        testTop.setQuiltDimensionX(0);
        testTop.setQuiltDimensionY(-77);
        testTop.setNewBlockSideLength(0.0);
        testTop.createBlocks();
        assertEquals(Math.pow(QuiltTop.DEFAULT_QUILT_SIZE, 2), testTop.drawAllBlocks().size(), 0);
    }

    @Test
    public void mapCorrectlyBindsBlocksAndGroups() {
        Object key = testTop.drawAllBlocks().get(0);
        assertEquals(testTop.getBlocksList()[0][0], testTop.getBlocksMap().get(key));
    }

}