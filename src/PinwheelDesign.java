package ca.bcit.comp2522.assignments.A3;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * PinwheelDesign abstract class extends Design.
 * @author Alberto Iglesias
 * @author Andrea So
 * @version 1
 */
public class PinwheelDesign extends Design {
    @Override
    protected ArrayList<Shape> createDesign(double x1, double y1, double sideLength) {
        ArrayList<Shape> finalPinwheelBlock = new ArrayList<>();

        double side = sideLength / 2;

        Polygon tri1 = new Polygon(x1, y1, x1, y1 + side, x1 + side, y1 + side);
        Polygon tri2 = new Polygon(x1 + side, y1, x1 + side, y1 + side, x1 + sideLength, y1);
        Polygon tri3 = new Polygon(x1, y1 + sideLength, x1 + side, y1 + side, x1 + side, y1 + sideLength);
        Polygon tri4 = new Polygon(x1 + side, y1 + side, x1 + sideLength, y1 + side, x1 + sideLength,
                y1 + sideLength);

        Shape concat1 = Shape.union(tri1, tri2);
        Shape concat2 = Shape.union(concat1, tri3);
        Shape pinwheelBlockColourA = Shape.union(concat2, tri4);

        Polygon tri5 = new Polygon(x1, y1, x1 + side, y1, x1 + side, y1 + side);
        Polygon tri6 = new Polygon(x1 + side, y1 + side, x1 + sideLength, y1, x1 + sideLength, y1 + side);
        Polygon tri7 = new Polygon(x1 + side, y1 + side, x1 + side, y1 + sideLength, x1 + sideLength,
                y1 + sideLength);
        Polygon tri8 = new Polygon(x1, y1 + side, x1 + side, y1 + side, x1, y1 + sideLength);

        Shape concat3 = Shape.union(tri5, tri6);
        Shape concat4 = Shape.union(concat3, tri7);
        Shape pinwheelBlockColourB = Shape.union(concat4, tri8);

        finalPinwheelBlock.add(pinwheelBlockColourA);
        finalPinwheelBlock.add(pinwheelBlockColourB);
        return finalPinwheelBlock;
    }
    @Override
    public String toString() {
        return "Pinwheel Design";
    }
}
