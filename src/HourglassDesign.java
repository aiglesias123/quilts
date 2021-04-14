package ca.bcit.comp2522.assignments.A3;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class HourglassDesign extends Design {
    @Override
    protected ArrayList<Shape> createDesign(double x1, double y1, double sideLength) {
        ArrayList<Shape> finalHourglassBlock = new ArrayList<>();

        double side2 = sideLength / 2;
        double side4 = sideLength / 4;

        Polygon tri1 = new Polygon(x1, y1, x1 + side2, y1, x1, y1 + side2);
        Polygon tri2 = new Polygon(x1 + side2, y1, x1 + side4, y1 + side4, x1 + side2 + side4, y1 + side4);
        Polygon tri3 = new Polygon(x1 + side4, y1 + side4, x1 + side2, y1 + side2,
                x1 + side2 + side4, y1 + side4);
        Polygon tri4 = new Polygon(x1 + side2, y1 + side2, x1 + side4, y1 + side2 + side4,
                x1 + side2 + side4, y1 + side4 + side2);
        Polygon tri5 = new Polygon(x1 + side4, y1 + side2 + side4, x1 + side2, y1 + sideLength,
                x1 + side2 + side4, y1 + side2 + side4);
        Polygon tri6 = new Polygon(x1 + sideLength, y1 + side2, x1 + side2, y1 + sideLength,
                x1 + sideLength, y1 + sideLength);

        Shape concat1 = Shape.union(tri1, tri2);
        Shape concat2 = Shape.union(concat1, tri3);
        Shape concat3 = Shape.union(concat2, tri4);
        Shape concat4 = Shape.union(concat3, tri5);
        Shape triBlockColourA = Shape.union(concat4, tri6);

        Polygon tri7 = new Polygon(x1 + side2, y1, x1 + sideLength, y1,
                x1 + sideLength, y1 + side2);
        Polygon tri8 = new Polygon(x1 + side4 + side2, y1 + side4,
                x1 +sideLength, y1 + side2, x1 + side4 + side2, y1 + side2 + side4);
        Polygon tri9 = new Polygon(x1 + side4, y1 + side4,
                x1, y1 + side2, x1 + side4, y1 + side2 + side4);
        Polygon tri10 = new Polygon(x1, y1 + side2, x1, y1 + sideLength,
                x1 + side2, y1 + sideLength);

        Shape concat5 = Shape.union(tri7, tri8);
        Shape concat6 = Shape.union(concat5, tri9);
        Shape triBlockColourB = Shape.union(concat6, tri10);

        Polygon tri11 = new Polygon(x1 + side4, y1 + side4, x1 + side2, y1 + side2,
                x1 + side4, y1 + side2 + side4);
        Polygon tri12 = new Polygon(x1 + side2 + side4, y1 + side4,
                x1 + side2, y1 + side2, x1 + side2 + side4, y1 + side2 + side4);

        Shape triBlockColourC = Shape.union(tri11, tri12);

        finalHourglassBlock.add(triBlockColourA);
        finalHourglassBlock.add(triBlockColourB);
        finalHourglassBlock.add(triBlockColourC);
        return finalHourglassBlock;
    }
    @Override
    public String toString() {
        return "Hourglass Design";
    }
}
