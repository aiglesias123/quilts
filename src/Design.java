package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * Design abstract class for designs.
 * @author Alberto Iglesias
 * @author Andrea So
 * @version 1
 */
public abstract class Design {

    /**
     * Draws a Design with the given parameters, returning the resultant Group.
     * @param x1 the X coordinate of the design.
     * @param y1 the Y coordinate of the design.
     * @param sideLength the length of the design (always a square).
     * @param colourList the ArrayList of Colors to use.
     * @param tileRotation the amount of rotation to be applied to the design.
     * @param tileDimension the amount of tiling to be applied to the design, in an NxN sense.
     * @return a Group object to be displayed to the screen.
     */
    public Group draw(double x1, double y1, double sideLength, ArrayList<Color> colourList,
                               int tileRotation, int tileDimension) {
        ArrayList<Shape> newDesign;
        Group finishedDesign;
        newDesign = (tileDimension == 1) ? createDesign(x1, y1, sideLength) : createTiledDesign(x1, y1, sideLength,
                                                                                                tileDimension);
        finishedDesign = addColour(newDesign, colourList);
        finishedDesign.setRotate(tileRotation);
        return finishedDesign;
    }

    /**
     * Creates the design. Must be implemented by subclasses.
     * @param x1 the X coordinate of the design.
     * @param y1 the Y coordinate of the design.
     * @param sideLength the length of the design.
     * @return An ArrayList of shapes, organized by different colours.
     */
    protected abstract ArrayList<Shape> createDesign(double x1, double y1, double sideLength) ;

    /**
     * Adds required attributes to the result of createDesign: colour. Don't ask questions.
     * @param monochromeDesign the ArrayList of shapes produced by createDesign.
     * @param colourList the list of colours given to draw().
     * @return the complete group.
     */
    protected Group addColour(ArrayList<Shape> monochromeDesign, ArrayList<Color> colourList) {
        Group finishedDesign = new Group();
        for (int i = 0; i < monochromeDesign.size(); i++) {
            Shape monochromeShape = monochromeDesign.get(i);
            monochromeShape.setFill(colourList.get(i));
            finishedDesign.getChildren().add(monochromeShape);
        }
        return finishedDesign;
    }

    /**
     * Creates a tiled design by repeated calls to createDesign().
     * @param x1 the X coordinate of the design.
     * @param y1 the Y coordinate of the design.
     * @param sideLength the length of the sides of the design.
     * @param tileDimension the NxN int representing the amount of tiling.
     * @return an ArrayList of shapes, grouped by colour.
     */
    protected ArrayList<Shape> createTiledDesign(double x1, double y1, double sideLength, int tileDimension) {
        double realLength = sideLength / tileDimension;
        double currentX = x1 + realLength;
        double currentY = y1;
        ArrayList<Shape> tiledShape = createDesign(x1, y1, realLength);
        for (int i = 0; i < tileDimension; i++) {
            for (int j = (i == 0) ? 1 : 0; j < tileDimension; j++) {
                ArrayList<Shape> tempShapes = createDesign(currentX, currentY, realLength);
                for (int k = 0; k < tempShapes.size(); k++)
                    tiledShape.set(k, Shape.union(tiledShape.get(k), tempShapes.get(k)));
                currentX += realLength;
            }
            currentX = x1;
            currentY += realLength;
        }
        return tiledShape;
    }

    @Override
    public String toString() {
        return "Design";
    }

}
