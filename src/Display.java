package ca.bcit.comp2522.assignments.A3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Display class for instantiating and displaying the application.
 * @author Alberto Iglesias
 * @author Andrea So
 * @version 1
 */
public class Display extends Application {

    /**
     * App width for controlling the application's width in pixels.
     */
    public static final int appWidth = 1200;

    /**
     * App height for controlling the application's height in pixels.
     */
    public static final int appHeight = 800;

    /**
     * Runs the JavaFX application.
     * @param primaryStage the stage, supplied by JavaFX.
     */
    public void start(Stage primaryStage) {

        UIHandler appUI = new UIHandler();

        Scene scene = new Scene(appUI.getUiWindow(), appWidth, appHeight);

        primaryStage.setTitle("LTSQUILTSQUILTSQUILTSQUILTSQUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Runs the application from an external program.
     * @param args the command line argument.
     */
    public static void runQuiltProgram(String[] args) {
        launch(args);
    }

}
