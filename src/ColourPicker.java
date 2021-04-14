package ca.bcit.comp2522.assignments.A3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Dimension Picker GUI class for creating JavaFX controls related to dimensions and tiling.
 * @author Alberto Iglesias
 * @author Andrea So
 * @version 1
 */
public class ColourPicker {

    /**
     * Colour message displayed above the set of colour pickers.
     */
    public static final String COLOUR_MESSAGE = "Colour Selector";

    /**
     * Double to control spacing of items in the colour menu.
     */
    public static final double MENU_SPACING = 10.0;

    private VBox colourMenu;
    private ColorPicker colourPickerA;
    private ColorPicker colourPickerB;
    private ColorPicker colourPickerC;
    private ColorPicker colourPickerD;
    private Button applyButton;

    /**
     * Colour picker constructor. Creates menu as a Vertical Box and populates it with menu elements.
     */
    public ColourPicker() {
        colourMenu = new VBox();
        colourMenu.setPadding(new Insets(10, 10, 50, 50));
        colourMenu.setSpacing(MENU_SPACING);
        colourMenu.setAlignment(Pos.CENTER_LEFT);

        Text message = new Text(COLOUR_MESSAGE);
        message.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 12));
        Separator separator = new Separator();
        Text pickerAMessage = new Text("Colour 1:");
        pickerAMessage.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        colourPickerA = new ColorPicker(Color.RED);
        Text pickerBMessage = new Text("Colour 2:");
        pickerBMessage.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        colourPickerB = new ColorPicker(Color.BLUE);
        Text pickerCMessage = new Text("Colour 3:");
        pickerCMessage.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        colourPickerC = new ColorPicker(Color.GREEN);
        Text pickerDMessage = new Text("Colour 4:");
        pickerDMessage.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        colourPickerD = new ColorPicker(Color.YELLOW);
        applyButton = new Button("Apply");

        colourMenu.getChildren().addAll(message, separator, pickerAMessage, colourPickerA, pickerBMessage,
                                        colourPickerB, pickerCMessage, colourPickerC, pickerDMessage,
                                        colourPickerD, applyButton);
    }

    /**
     * Gets the root colour menu as a JavaFX VBox (Vertical box).
     * @return the colour menu as a VBox.
     */
    public VBox getColourMenu() {
        return colourMenu;
    }

    /**
     * Gets the first colour picker element.
     * @return the first colour picker.
     */
    public ColorPicker getColourPickerA() {
        return colourPickerA;
    }

    /**
     * Gets the second colour picker element.
     * @return the second colour picker.
     */
    public ColorPicker getColourPickerB() {
        return colourPickerB;
    }

    /**
     * Gets the third colour picker element.
     * @return the third colour picker.
     */
    public ColorPicker getColourPickerC() {
        return colourPickerC;
    }

    /**
     * Gets the fourth colour picker element.
     * @return the fourth colour picker.
     */
    public ColorPicker getColourPickerD() {
        return colourPickerD;
    }

    /**
     * Gets the apply button element.
     * @return the apply button.
     */
    public Button getApplyButton() {
        return applyButton;
    }

}
