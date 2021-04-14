package ca.bcit.comp2522.assignments.A3;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class SimpleDesign extends Design {

    @Override
    protected ArrayList<Shape> createDesign(double x1, double y1, double sideLength) {
        Rectangle simpleShape = new Rectangle();
        simpleShape.setX(x1);
        simpleShape.setY(y1);
        simpleShape.setWidth(sideLength);
        simpleShape.setHeight(sideLength);
        ArrayList<Shape> finishedRect = new ArrayList<>();
        finishedRect.add(simpleShape);
        return finishedRect;
    }

    @Override
    public String toString() {
        return "Simple rectangle design";
    }

}
