package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Block class for representing portions of a quilt.
 * @author Alberto Iglesias
 * @author Andrea So
 * @version 1
 */
public class Block {

    private double locationX;
    private double locationY;
    private double sideLength;
    private Design currentDesign;
    private ArrayList<Color> colourList;
    private int designRotation;
    private int designTileDimension;

    /**
     * Block constructor. Constructs Blocks with the given parameters.
     * @param locationX the X coordinate of the top-left corner of the Block.
     * @param locationY the Y coordinate of the top-left corner of the Block.
     * @param sideLength the length of the Block's sides, in pixels.
     * @param newDesign the Design for the Block to use.
     * @param colourList the ArrayList of Color objects for the Block to use.
     * @param designRotation the degrees of rotation that the Block should undergo.
     * @param designTileDimension the NxN dimensions to use while tiling the block.
     */
    public Block(double locationX,
                 double locationY,
                 double sideLength,
                 Design newDesign,
                 ArrayList<Color> colourList,
                 int designRotation,
                 int designTileDimension) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.sideLength = sideLength;
        currentDesign = newDesign;
        this.colourList = colourList;
        this.designRotation = designRotation;
        this.designTileDimension = designTileDimension;
    }

    /**
     * Gets the X coordinate of the Block.
     * @return the X coordinate of the Block.
     */
    public double getLocationX() {
        return locationX;
    }

    /**
     * Gets the Y coordinate of the Block.
     * @return the Y coordinate of the Block.
     */
    public double getLocationY() {
        return locationY;
    }

    /**
     * Gets the length of the Block's sides, in pixels.
     * @return the length of the Block's sides, in pixels.
     */
    public double getSideLength() {
        return sideLength;
    }

    /**
     * Gets the current Design of the Block.
     * @return the current Design of the Block.
     */
    public Design getCurrentDesign() {
        return currentDesign;
    }

    /**
     * Gets the list of colours currently in use by the Block.
     * @return the Block's colours.
     */
    public ArrayList<Color> getColourList() {
        return colourList;
    }

    /**
     * Gets the rotation of the Block.
     * @return the rotation of the Block.
     */
    public int getDesignRotation() {
        return designRotation;
    }

    /**
     * Gets the amount of tiling applied to the Block, in an NxN format where N is an integer.
     * @return the amount of tiling applied to the Block.
     */
    public int getDesignTileDimension() {
        return designTileDimension;
    }

    /**
     * Sets the Design for the Block to use.
     * @param currentDesign a Design object.
     */
    public void setCurrentDesign(Design currentDesign) {
        this.currentDesign = currentDesign;
    }

    /**
     * Sets the colours for the Block to use. Must be a list of length 4.
     * @param colourList an ArrayList of Color objects.
     */
    public void setColourList(ArrayList<Color> colourList) {
        if (colourList.size() == 4)
            this.colourList = colourList;
    }

    /**
     * Sets the amount of rotation for the Block. Must be a multiple of 90.
     * @param designRotation the amount of rotation for the Block.
     */
    public void setDesignRotation(int designRotation) {
        if (designRotation % 90 == 0)
            this.designRotation = designRotation;
    }

    /**
     * Sets the amount of tiling that the Block should use, in an NxN sense. Must be greater than 0.
     * @param designTileDimension an int for how much tiling to use.
     */
    public void setDesignTileDimension(int designTileDimension) {
        if (designTileDimension > 0)
            this.designTileDimension = designTileDimension;
    }

    /**
     * Causes the Block to draw itself to a Group and returns the result.
     * @return a Group object of the Block's drawn result.
     */
    public Group draw() {
        return getCurrentDesign().draw(locationX, locationY, sideLength, colourList,
                                       designRotation, designTileDimension);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Double.compare(block.locationX, locationX) == 0 &&
                Double.compare(block.locationY, locationY) == 0 &&
                Double.compare(block.sideLength, sideLength) == 0 &&
                designRotation == block.designRotation &&
                designTileDimension == block.designTileDimension &&
                currentDesign.equals(block.currentDesign) &&
                colourList.equals(block.colourList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationX, locationY, sideLength, currentDesign, colourList, designRotation,
                designTileDimension);
    }
}
