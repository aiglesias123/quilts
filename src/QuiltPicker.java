package ca.bcit.comp2522.assignments.A3;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
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
public class QuiltPicker {

    /**
     * Double to control spacing of items in the quilt menu.
     */
    public static final double MENU_SPACING = 10.0;

    private VBox quiltMenu;
    private ChoiceBox<Design> quiltChoiceBox;
    private Design chosenDesign;
    private Slider rotationControl;
    private Slider tilingControl;
    private Button applyButton;

    /**
     * Quilt Picker constructor. Creates menu as a Vertical Box and populates it with elements.
     */
    public QuiltPicker() {
        quiltMenu = new VBox();
        quiltMenu.setPadding(new Insets(10, 10, 50, 50));
        quiltMenu.setSpacing(MENU_SPACING);
        quiltMenu.setAlignment(Pos.CENTER);

        chosenDesign = new SimpleDesign();

        Text designSelectorText = new Text("Select a design:");
        designSelectorText.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));

        quiltChoiceBox = new ChoiceBox<>();
        quiltChoiceBox.setItems(FXCollections.observableArrayList(new SimpleDesign(), new PinwheelDesign(),
                                                                  new HourglassDesign(), new FourStarDesign(),
                                                                  new CheckerDesign()));
        quiltChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (ov, last_design, new_design) -> { // lambda change listener!
                    chosenDesign = new_design;
                });

        Text rotationText = new Text("Choose the degrees of rotation for the design:");
        rotationText.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        rotationControl = new Slider();
        rotationControl.setSnapToTicks(true);
        rotationControl.setMin(0);
        rotationControl.setMax(360);
        rotationControl.setValue(0);
        rotationControl.setMajorTickUnit(90);
        rotationControl.setMinorTickCount(0);
        rotationControl.setShowTickLabels(true);
        rotationControl.setShowTickMarks(true);

        Text tilingText = new Text("Choose the amount of tiling to apply (NxN):");
        tilingText.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        tilingControl = new Slider();
        tilingControl.setSnapToTicks(true);
        tilingControl.setMin(1);
        tilingControl.setMax(8);
        tilingControl.setValue(1);
        tilingControl.setMajorTickUnit(1);
        tilingControl.setMinorTickCount(0);
        tilingControl.setShowTickLabels(true);
        tilingControl.setShowTickMarks(true);

        applyButton = new Button("Apply");

        quiltMenu.getChildren().addAll(designSelectorText, quiltChoiceBox, rotationText, rotationControl,
                                       tilingText, tilingControl, applyButton);
    }

    /**
     * Gets the Quilt Picker menu as a Vertical Box.
     * @return the Quilt Picker menu.
     */
    public VBox getQuiltMenu() {
        return quiltMenu;
    }

    /**
     * Gets the Design currently chosen by the ChoiceBox.
     * @return a Design object.
     */
    public Design getChosenDesign() {
        return chosenDesign;
    }

    /**
     * Gets the quilt picker as a ChoiceBox. Shouldn't be necessary thanks to lambda listener, but who knows.
     * @return the quilt picker as a ChoiceBox.
     */
    public ChoiceBox<Design> getQuiltChoiceBox() {
        return quiltChoiceBox;
    }

    /**
     * Gets the rotation control slider.
     * @return the rotation control slider.
     */
    public Slider getRotationControl() {
        return rotationControl;
    }

    /**
     * Gets the tiling control slider.
     * @return the tiling control slider.
     */
    public Slider getTilingControl() {
        return tilingControl;
    }

    /**
     * Gets the apply button.
     * @return the apply button.
     */
    public Button getApplyButton() {
        return applyButton;
    }
}
