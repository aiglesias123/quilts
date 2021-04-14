package ca.bcit.comp2522.assignments.A3;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
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
public class DimensionPicker {

    /**
     * Double for the spacing in pixels between the menu items.
     */
    public static final double MENU_SPACING = 20.0;

    private HBox dimensionMenu;
    private Slider quiltXController;
    private Slider quiltYController;
    private Slider blockSizeController;
    private Button applyButton;

    /**
     * Dimension picker constructor. Creates menu as a Horizontal Box and populates it with menu elements.
     */
    public DimensionPicker() {
        dimensionMenu = new HBox();
        dimensionMenu.setAlignment(Pos.CENTER);
        dimensionMenu.setSpacing(MENU_SPACING);

        Text XControllerMessage = new Text("# of Blocks in X dimension:");
        XControllerMessage.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        quiltXController = new Slider();
        setSliderSettings(quiltXController, 1, 8, 2, 1,
                          0, 1);
        Text YControllerMessage = new Text("# of Blocks in Y dimension:");
        YControllerMessage.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        quiltYController = new Slider();
        setSliderSettings(quiltYController, 1, 8, 2, 1,
                          0, 1);

        Text sizeControllerMessage = new Text("Size of Blocks in pixels:");
        sizeControllerMessage.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        blockSizeController = new Slider();
        setSliderSettings(blockSizeController, 10, 200, 150, 50,
                          10, 10);
        Text cmControllerMessage = new Text("Size of Blocks in CM:");
        cmControllerMessage.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        Slider blockSizeCMController = new Slider();
        setSliderSettings(blockSizeCMController, 1, 1000, 1, 100,
                          10, 20);

        VBox quiltDimensionSliders = new VBox();
        quiltDimensionSliders.getChildren().addAll(XControllerMessage, quiltXController,
                                                   YControllerMessage, quiltYController);
        VBox quiltBlockSizeSliders = new VBox();
        quiltBlockSizeSliders.getChildren().addAll(sizeControllerMessage, blockSizeController,
                                                   cmControllerMessage, blockSizeCMController);

        Text warningMessage = new Text("Warning: Will reset quilt attributes to default!");
        warningMessage.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 12));
        applyButton = new Button("Apply");

        dimensionMenu.getChildren().addAll(quiltDimensionSliders, quiltBlockSizeSliders, warningMessage, applyButton);
    }

    private void setSliderSettings(Slider configSlider, double min, double max, double defaultValue,
                                   double majorUnit, int minorCount, double blockIncrement) {
        configSlider.setMin(min);
        configSlider.setMax(max);
        configSlider.setValue(defaultValue);
        configSlider.setShowTickLabels(true);
        configSlider.setShowTickMarks(true);
        configSlider.setMajorTickUnit(majorUnit);
        configSlider.setMinorTickCount(minorCount);
        configSlider.setBlockIncrement(blockIncrement);
        configSlider.setSnapToTicks(true);
    }

    /**
     * Gets the root dimension menu as a JavaFX HBox (horizontal box).
     * @return the dimension slider menu.
     */
    public HBox getDimensionMenu() {
        return dimensionMenu;
    }

    /**
     * Gets the slider that controls the number of blocks in the X dimension of the QuiltTop.
     * @return a Slider object.
     */
    public Slider getQuiltXController() {
        return quiltXController;
    }

    /**
     * Gets the slider that controls the number of blocks in the Y dimension of the QuiltTop.
     * @return a Slider object.
     */
    public Slider getQuiltYController() {
        return quiltYController;
    }

    /**
     * Gets the slider that controls the size of the blocks in the QuiltTop.
     * @return a Slider object.
     */
    public Slider getBlockSizeController() {
        return blockSizeController;
    }

    /**
     * Gets the button that will apply the slider's settings.
     * @return a Button object.
     */
    public Button getApplyButton() {
        return applyButton;
    }
}
