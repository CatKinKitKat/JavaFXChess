/**
 * Gonçalo Candeias Amaro 17440 - Launcher
 */

package pt.ipbeja.estig.chess.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The type Launcher.
 */
public class Launcher extends Application {

    private Scene scene;
    private Stage stage;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stgMain) throws Exception {
        this.stage = stgMain;
        this.launchStage(this.stage);

    }

    private void launchStage(Stage stage) {
        this.createScene();
        stage.setTitle("Chess");
        stage.setMaxWidth(880);
        stage.setMaxHeight(840);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private void createScene() {
        scene = new Scene(new GUI(this));
    }

    /**
     * Reboot.
     */
    public void reboot() {
        this.stage.close();
        this.stage = new Stage();
        this.launchStage(this.stage);
    }

    /**
     * Player.
     *
     * @param title the title
     */
    public void player(String title) {
        stage.setTitle(title);
    }

    /**
     * Gets stage.
     *
     * @return the stage
     */
    public Stage getStage() {
        return this.stage;
    }
}
