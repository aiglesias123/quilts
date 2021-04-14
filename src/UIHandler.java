package ca.bcit.comp2522.assignments.A3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;

import java.util.ArrayList;

/**
 * UI Handler class for creating and drawing GUI and handling events. Is also in charge of creating the Quilt and
 * ensuring it is drawn properly.
 * @author Alberto Iglesias
 * @author Andrea So
 * @version 1
 */
public class UIHandler {

    /**
     * Colour of the selection indicator.
     */
    public static final Color SELECTION_COLOUR = Color.ORANGE;

    private QuiltTop quiltInUse;
    private Group groupsDrawn;
    private ArrayList<Block> selectedBlocks;
    private BorderPane uiWindow;
    private ColourPicker colourPicker;
    private DimensionPicker dimensionPicker;
    private QuiltPicker quiltPicker;

    /**
     * UI Handler constructor. Creates UI elements and a usable QuiltTop.
     */
    public UIHandler() {
        uiWindow = new BorderPane();
        quiltInUse = new QuiltTop();
        groupsDrawn = new Group();
        selectedBlocks = new ArrayList<>();
        redrawAndReset();

        colourPicker = new ColourPicker();
        colourPicker.getApplyButton().setOnMouseClicked(this::applyColours);

        dimensionPicker = new DimensionPicker();
        dimensionPicker.getApplyButton().setOnMouseClicked(this::applyDimensions);

        quiltPicker = new QuiltPicker();
        quiltPicker.getApplyButton().setOnMouseClicked(this::applyQuiltChange);

        HBox tutorialHolder = new HBox();
        tutorialHolder.setSpacing(10);
        Text tutorialMessage = new Text("Click on the blocks to select them, then click 'Apply' to add a *single*" +
                                           " menu's setting to your selection.");
        tutorialMessage.setFont(Font.font("Courier", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 20));
        Button selectAllButton = new Button("Select all Blocks");
        selectAllButton.setOnMouseClicked(this::selectAllBlocks);
        tutorialHolder.getChildren().addAll(tutorialMessage, selectAllButton);
        tutorialHolder.setAlignment(Pos.CENTER);
        tutorialHolder.setPadding(new Insets(10, 10, 50, 50));

        uiWindow.setCenter(groupsDrawn);
        uiWindow.setRight(colourPicker.getColourMenu());
        uiWindow.setBottom(dimensionPicker.getDimensionMenu());
        uiWindow.setLeft(quiltPicker.getQuiltMenu());
        uiWindow.setTop(tutorialHolder);
    }

    /**
     * Gets the UI window as a borderpane.
     * @return the UI window as a borderpane.
     */
    public BorderPane getUiWindow() {
        return uiWindow;
    }

    /**
     * Clears selection and redraws the QuiltTop to the screen. Also reassigns event listeners to the quilt.
     */
    public void redrawAndReset() {
        selectedBlocks.clear();
        groupsDrawn.getChildren().clear();
        for (Group newDrawn : quiltInUse.drawAllBlocks()) {
            newDrawn.setOnMouseClicked(this::processGroupClicked);
            groupsDrawn.getChildren().add(newDrawn);
        }
    }

    /**
     * Event handler for clicking on a group.
     * @param event JavaFX event.
     */
    public void processGroupClicked(MouseEvent event) {
        Block clickedBlock = quiltInUse.getBlocksMap().get(event.getSource()); // gets the block associated with click
        if (!selectedBlocks.contains(clickedBlock)) {
            addSelectedBlock(clickedBlock);
        }
    }

    /**
     * Event handler for clicking on "Select All Blocks" button.
     * @param event JavaFX event.
     */
    public void selectAllBlocks(MouseEvent event) {
        for (Block[] blocks : quiltInUse.getBlocksList()) {
            for (Block block : blocks) {
                if (!selectedBlocks.contains(block)) {
                    addSelectedBlock(block);
                }
            }
        }
    }

    /**
     * Adds a block to the collection of selected blocks, and draws a selection indicator.
     * @param block a Block object that was selected.
     */
    public void addSelectedBlock(Block block) {
        selectedBlocks.add(block);
        Rectangle selectIndicator = new Rectangle();
        selectIndicator.setX(block.getLocationX());
        selectIndicator.setY(block.getLocationY());
        selectIndicator.setHeight(block.getSideLength());
        selectIndicator.setWidth(block.getSideLength());
        selectIndicator.setFill(Color.TRANSPARENT);
        selectIndicator.setStroke(SELECTION_COLOUR);
        selectIndicator.setStrokeWidth(3);
        groupsDrawn.getChildren().add(selectIndicator);
    }

    /**
     * Event handler that applies the ColourPicker UI colours to the selected block(s).
     * @param event JavaFX event.
     */
    public void applyColours(MouseEvent event) {
        for (Block block : selectedBlocks) {
            ArrayList<Color> newColours = new ArrayList<>();
            newColours.add(colourPicker.getColourPickerA().getValue());
            newColours.add(colourPicker.getColourPickerB().getValue());
            newColours.add(colourPicker.getColourPickerC().getValue());
            newColours.add(colourPicker.getColourPickerD().getValue());
            block.setColourList(newColours);
        }
        redrawAndReset();
    }

    /**
     * Event handler for applying dimension controls. Clears into in QuiltTop and makes a new set of Blocks.
     * @param event JavaFX event.
     */
    public void applyDimensions(MouseEvent event) {
        quiltInUse.setQuiltDimensionX((int) dimensionPicker.getQuiltXController().getValue());
        quiltInUse.setQuiltDimensionY((int) dimensionPicker.getQuiltYController().getValue());
        quiltInUse.setNewBlockSideLength(dimensionPicker.getBlockSizeController().getValue());
        quiltInUse.createBlocks();
        redrawAndReset();
    }

    /**
     * Event handler for applying quilt changer controls. Sets the selected Block(s)' design, tiling and rotation.
     * @param event JavaFX event.
     */
    public void applyQuiltChange(MouseEvent event) {
        Design new_design = quiltPicker.getChosenDesign();
        int rotation = (int) quiltPicker.getRotationControl().getValue();
        int tiling = (int) quiltPicker.getTilingControl().getValue();
        for (Block block : selectedBlocks) {
            block.setCurrentDesign(new_design);
            block.setDesignRotation(rotation);
            block.setDesignTileDimension(tiling);
        }
        redrawAndReset();
    }

}
