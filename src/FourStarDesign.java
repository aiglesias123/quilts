package ca.bcit.comp2522.assignments.A3;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class FourStarDesign extends Design {
    @Override
    protected ArrayList<Shape> createDesign(double x1, double y1, double sideLength) {
        ArrayList<Shape> finalFourStarBlock = new ArrayList<>();

        double side2 = sideLength / 2;
        double side4 = sideLength / 4;

        // Creating triangle objects
        Polygon tri1 = new Polygon(x1, y1, x1 + side4, y1 + side4, x1, y1 + side4);
        Polygon tri2 = new Polygon(x1 + side4, y1, x1 + side2, y1, x1 + side2, y1 + side4);
        Polygon tri3 = new Polygon(x1, y1 + side4, x1 + side4, y1 + side2, x1, y1 + side2);
        Polygon tri4 = new Polygon(x1 + side4, y1 + side4, x1 + side2, y1 + side4, x1 + side2, y1 + side2);

        Polygon tri5 = new Polygon(x1 + side2 + side4, y1, x1 + side4, y1, x1 + side2, y1 + side4);
        Polygon tri6 = new Polygon(x1 + side4 + side2, y1, x1 + sideLength, y1,
                x1 + side4 + side2, y1 + side4);
        Polygon tri7 = new Polygon(x1 + side4 + side2, y1 + side4, x1 + side2, y1 + side2,
                x1 + side4 + side2, y1 + side2);
        Polygon tri8 = new Polygon(x1 + sideLength, y1 + side4, x1 + side4 + side2, y1 + side2,
                x1 + sideLength, y1 + side2);

        Polygon tri9 = new Polygon(x1, y1 + side2, x1 + side4, y1 + side2, x1, y1 + side4 + side2);
        Polygon tri10 = new Polygon(x1 + side4, y1 + side2, x1 + side2, y1 + side2, x1 + side4,
                y1 + side4 + side2);
        Polygon tri11 = new Polygon(x1 + side4, y1 + side4 + side2, x1, y1 + sideLength, x1 + side4,
                y1 + sideLength);
        Polygon tri12 = new Polygon(x1 +  side2, y1 + side4 + side2, x1 + side4, y1 + sideLength, x1 + side2,
                y1 + sideLength);

        Polygon tri13 = new Polygon(x1 + side2, y1 + side2, x1 + side2, y1 + side4 + side2,
                x1 + side4 + side2, y1 + side4 + side2);
        Polygon tri14 = new Polygon(x1 + side4 + side2, y1 + side2, x1 + sideLength, y1 + side2,
                x1 + sideLength, y1 + side4 + side2);
        Polygon tri15 = new Polygon(x1 + side2, y1 + side4 + side2, x1 + side2, y1 + sideLength,
                x1 + side4 + side2, y1 + sideLength);
        Polygon tri16 = new Polygon(x1 + side4 + side2, y1 + side4 + side2, x1 + sideLength,
                y1 + side4 + side2, x1 + sideLength, y1 + sideLength);

        // Concatenating all triangles of the same colour
        Shape concat1 = Shape.union(tri1, tri2);
        Shape concat2 = Shape.union(concat1, tri3);
        Shape concat3 = Shape.union(concat2, tri5);
        Shape concat4 = Shape.union(concat3, tri6);
        Shape concat5 = Shape.union(concat4, tri8);
        Shape concat6 = Shape.union(concat5, tri9);
        Shape concat7 = Shape.union(concat6, tri11);
        Shape concat8 = Shape.union(concat7, tri12);
        Shape concat9 = Shape.union(concat8, tri14);
        Shape concat10 = Shape.union(concat9, tri15);
        Shape triBlockColourA = Shape.union(concat10, tri16);

        // Triangles 4, 7, 10 and 13 are triangles of the same colour so they are concatenated
        Shape concat1B = Shape.union(tri4, tri7);
        Shape concat2B = Shape.union(concat1B, tri10);
        Shape triBlockColourB = Shape.union(concat2B, tri13);

        // Creating 4 parallelogram objects of the same colour
        Polygon para1 = new Polygon(x1, y1, x1 + side4, y1, x1 + side2, y1 + side4, x1 + side4, y1 + side4);
        Polygon para2 = new Polygon(x1 + sideLength, y1, x1 + side4 + side2, y1 + side4,
                x1 + side4 + side2, y1 + side2, x1 + sideLength, y1 + side4);
        Polygon para3 = new Polygon(x1 + side4, y1 + side2, x1, y1 + side4 + side2, x1, y1 + sideLength,
                x1 + side4, y1 + side4 + side2);
        Polygon para4 = new Polygon(x1 + side2, y1 + side4 + side2, x1 + side4 + side2,
                y1 + side4 + side2, x1 + sideLength, y1 + sideLength, x1 + side4 + side2, y1 + sideLength);

        Shape concat11 = Shape.union(para1, para2);
        Shape concat12 = Shape.union(concat11, para3);
        Shape paraBlockColourC = Shape.union(concat12, para4);

        // Creating 4 parallelogram objects of the same colour
        Polygon para5 = new Polygon(x1, y1 + side4, x1 + side4, y1 + side4,
                x1 + side2, y1 + side2, x1 + side4, y1 + side2);
        Polygon para6 = new Polygon(x1 + side4 + side2, y1, x1 + side2, y1 + side4, x1 + side2, y1 + side2,
                x1 + side4 + side2, y1 + side4);
        Polygon para7 = new Polygon(x1 + side2, y1 + side2, x1 + side4, y1 + side4 + side2,
                x1 + side4, y1 + sideLength, x1 + side2, y1 + side4 + side2);
        Polygon para8 = new Polygon(x1 + side2, y1 + side2, x1 + side4 + side2, y1 + side2,
                x1 + sideLength, y1 + side2 + side4, x1 + side4 + side2, y1 + side4 + side2);

        Shape concat13 = Shape.union(para5, para6);
        Shape concat14 = Shape.union(concat13, para7);
        Shape paraBlockColourD = Shape.union(concat14, para8);

        finalFourStarBlock.add(triBlockColourA);
        finalFourStarBlock.add(triBlockColourB);
        finalFourStarBlock.add(paraBlockColourC);
        finalFourStarBlock.add(paraBlockColourD);
        return finalFourStarBlock;
    }
    @Override
    public String toString() {
        return "Four Star Design";
    }
}
