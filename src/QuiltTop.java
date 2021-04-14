package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * QuiltTop class for quilt tops.
 * @author Alberto Iglesias
 * @author Andrea So
 * @version 1
 */
public class QuiltTop {

    /**
     * Default X and Y dimensions in Blocks for a new QuiltTop. (2 creates a 2x2 grid of blocks)
     */
    public static final int DEFAULT_QUILT_SIZE = 2;

    /**
     * Default side length of a new Block, in pixels.
     */
    public static final double DEFAULT_SIDE_LENGTH = 150.0;

    /**
     * Default colour for new Blocks.
     */
    public static final Color DEFAULT_COLOUR = Color.BLACK;

    private Block[][] blocksList;
    private HashMap<Group, Block> blocksMap;
    private ArrayList<Color> defaultColours;
    private int quiltDimensionX;
    private int quiltDimensionY;
    private double newBlockSideLength;

    /**
     * QuiltTop constructor. Automatically creates a new QuiltTop with default values.
     */
    public QuiltTop() {
        blocksMap = new HashMap<>();
        defaultColours = new ArrayList<Color>();
        quiltDimensionX = DEFAULT_QUILT_SIZE;
        quiltDimensionY = DEFAULT_QUILT_SIZE;
        newBlockSideLength = DEFAULT_SIDE_LENGTH;
        defaultColours.add(DEFAULT_COLOUR);
        defaultColours.add(DEFAULT_COLOUR);
        defaultColours.add(DEFAULT_COLOUR);
        defaultColours.add(DEFAULT_COLOUR);
        createBlocks();
    }

    /**
     * Creates a set of Blocks using local parameters.
     */
    public void createBlocks() {
        blocksList = new Block[quiltDimensionY][quiltDimensionX];
        double currentX = 0;
        double currentY = 0;
        for (int i = 0; i < quiltDimensionY; i++) {
            for (int j = 0; j < quiltDimensionX; j++) {
                blocksList[i][j] = new Block(currentX, currentY, newBlockSideLength, new SimpleDesign(), defaultColours,
                                             0, 1);
                currentX += newBlockSideLength;
            }
            currentX = 0;
            currentY += newBlockSideLength;
        }
    }

    /**
     * Causes all Blocks owned by the QuiltTop to draw themselves, then returns the results as an ArrayList of Group.
     * @return an ArrayList of all the Groups created by the Blocks in the QuiltTop.
     */
    public ArrayList<Group> drawAllBlocks() {
        ArrayList<Group> fullQuilt = new ArrayList<>();
        for (Block[] blocks : blocksList) {
            for (Block block : blocks) {
                Group newGroup = block.draw();
                blocksMap.put(newGroup, block);
                fullQuilt.add(newGroup);
            }
        }
        return fullQuilt;
    }

    /**
     * Sets the horizontal dimension of a new set of Blocks, as an int. Rejects 0 or negative values.
     * @param quiltDimensionX an int, representing the number of Blocks to tile leftwards.
     */
    public void setQuiltDimensionX(int quiltDimensionX) {
        if (quiltDimensionX > 0)
            this.quiltDimensionX = quiltDimensionX;
    }

    /**
     * Sets the vertical dimension of a new set of Blocks, as an int. Rejects 0 or negative values.
     * @param quiltDimensionY an int, representing the number of Blocks to tile downwards.
     */
    public void setQuiltDimensionY(int quiltDimensionY) {
        if (quiltDimensionY > 0)
            this.quiltDimensionY = quiltDimensionY;
    }

    /**
     * Sets the size of each new Block created, as a double, relating to pixels. Rejects 0 or negative values.
     * @param newBlockSideLength a double representing the pixel length of new Blocks.
     */
    public void setNewBlockSideLength(double newBlockSideLength) {
        if (newBlockSideLength > 0.0)
            this.newBlockSideLength = newBlockSideLength;
    }

    /**
     * Gets the current list of Blocks held by the QuiltTop.
     * @return a 2 dimensional array of Blocks.
     */
    public Block[][] getBlocksList() {
        return blocksList;
    }

    /**
     * Gets the HashMap of Group/Block pairs, where a Group is a key to the Block which drew it.
     * @return a HashMap consisting of Group keys and Block values.
     */
    public HashMap<Group, Block> getBlocksMap() {
        return blocksMap;
    }

}
