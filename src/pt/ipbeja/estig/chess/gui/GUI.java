/**
 * Gonçalo Candeias Amaro 17440 - GUI
 */

package pt.ipbeja.estig.chess.gui;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import pt.ipbeja.estig.chess.model.Model;
import pt.ipbeja.estig.chess.model.Position;

import java.io.File;
import java.util.List;

/**
 * The type Gui.
 */
public class GUI extends GridPane implements View {

    private Model model;
    private int numbs[] = {1, 2, 3, 4, 5, 6, 7, 8};
    private char lett[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private Launcher launcher;
    private Board board;

    /**
     * Instantiates a new Gui.
     *
     * @param launcher the launcher
     */
    public GUI(Launcher launcher) {
        this.launcher = launcher;
        this.model = new Model(this);
        this.board = new Board(this.model);
        this.assembleFullBoard();
        this.makeMenu();
    }

    private void assembleFullBoard() {
        this.add(corner(), 0, 0);
        this.add(horizontal(), 1, 0);
        this.add(corner(), 2, 0);

        this.add(vertical(), 0, 1);
        this.add(this.board, 1, 1);
        this.add(vertical(), 2, 1);

        this.add(corner(), 0, 2);
        this.add(horizontal(), 1, 2);
        //this.add(corner(), 2, 2);
    }

    private Button corner() {
        Button ret = new Button("  ");
        ret.setPrefSize(25, 25);
        ret.setStyle("-fx-background-color:White; -fx-text-fill:Black; -fx-font-size:16");
        return ret;
    }

    private HBox horizontal() {
        HBox ret = new HBox();
        for (int h = 0; h < 8; h++) {
            Button button = new Button(String.valueOf(lett[h]));
            button.setPrefSize(110, 25);
            button.setStyle("-fx-background-color:White; -fx-text-fill:Black; -fx-font-size:16");
            ret.getChildren().add(button);
        }
        return ret;
    }

    private VBox vertical() {
        VBox ret = new VBox();
        for (int v = 0; v < 8; v++) {
            Button button = new Button(String.valueOf(numbs[v]));
            button.setPrefSize(25, 100);
            button.setStyle("-fx-background-color:White; -fx-text-fill:Black; -fx-font-size:16");
            ret.getChildren().add(button);
        }
        return ret;
    }

    private void makeMenu() {
        MenuBar menuBar = new MenuBar();
        menuBar.setStyle("-fx-background-color:White; -fx-text-fill:Black; -fx-font-size:16");
        Menu menu = new Menu();                              //this menu bar and menu are in the bottom left,
        //since there was no restriction or rule about it
        MenuItem reset = new MenuItem();
        reset.setText("Reset");
        reset.setOnAction(e -> {
            this.launcher.reboot();
        });

        MenuItem past = new MenuItem();
        past.setText("PastGame");
        past.setOnAction(e -> {
            this.model.timeTravel(this.openFileChooserAtStage());
            this.board.updateBoard();
        });

        menu.getItems().addAll(reset, past);
        menuBar.getMenus().add(menu);

        this.add(menuBar, 2, 2);        //big function but still under 30 semicolons, cheers
    }

    /**
     * Open file chooser at stage file.
     *
     * @return the file
     */
    public File openFileChooserAtStage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        return fileChooser.showOpenDialog(this.launcher.getStage());
    }

    @Override
    public void updateBoard() {
        //WTF
    }

    @Override
    public void highlightGreen(List<Position> possibleMoves, boolean set) {
        // WTF
    }

    @Override
    public void highlightYellow(List<Position> possibleTakes, boolean set) {
        // WTF
    }
}
