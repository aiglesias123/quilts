package ca.bcit.comp2522.assignments.A3;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class CheckerDesign extends Design {
    @Override
    protected ArrayList<Shape> createDesign(double x1, double y1, double sideLength) {
        ArrayList<Shape> finalStripeDesign = new ArrayList<>();

        double side2 = sideLength / 2;

        Polygon rect1 = new Polygon(x1, y1, x1 + side2, y1, x1 + side2, y1 + side2, x1, y1 + side2);
        Polygon rect2 = new Polygon(x1 + side2, y1, x1 + sideLength, y1, x1 + sideLength, y1 + side2,
                x1 + side2, y1 + side2);
        Polygon rect3 = new Polygon(x1, y1 + side2, x1 + side2, y1 + side2,
                x1 + side2, y1 + sideLength, x1, y1 + sideLength);
        Polygon rect4 = new Polygon(x1 + side2, y1 + side2, x1 + sideLength, y1 + side2,
                x1 + sideLength, y1 + sideLength, x1 + side2, y1 + sideLength);

        Shape finalRectBlockColourA = Shape.union(rect1, rect4);
        Shape finalRectBlockColourB = Shape.union(rect2, rect3);
        finalStripeDesign.add(finalRectBlockColourA);
        finalStripeDesign.add(finalRectBlockColourB);
        return finalStripeDesign;
    }
    @Override
    public String toString() {
        return "Checker Design";
    }
}
