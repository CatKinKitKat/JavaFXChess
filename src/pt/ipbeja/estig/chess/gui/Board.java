/**
 * Gonçalo Candeias Amaro 17440 - Board
 */

package pt.ipbeja.estig.chess.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import pt.ipbeja.estig.chess.model.Model;
import pt.ipbeja.estig.chess.model.Position;

import java.util.List;


/**
 * The type Board.
 */
public class Board extends GridPane implements View {

    private Model model;
    private CellButton[][] buttons = new CellButton[Model.SIZE][Model.SIZE];

    public Board(Model model) {
        this.model = model;
        this.makeInnerBoard();
        this.updateBoard();
    }

    private void makeInnerBoard() {

        ButtonHandler handler = new ButtonHandler();

        for (int line = 0; line < Model.SIZE; line++) {
            for (int col = 0; col < Model.SIZE; col++) {
                CellButton button = new CellButton(new Position(line, col));
                button.setColor(((line + col) % 2) == 0);
                button.setOnAction(handler);
                buttons[line][col] = button;
                this.add(button, col, line);
            }
        }

    }

    @Override
    public void updateBoard() {
        for (int l = 0; l < Model.SIZE; l++) {
            for (int c = 0; c < Model.SIZE; c++) {
                System.out.print("[" + this.model.getPiece(l, c).getText() + "] ");
                this.buttons[l][c].setGraphic(this.model.getImage(l, c));
            }
            System.out.print("\n");
        }
    }

    @Override
    public void highlightGreen(List<Position> possibleMoves, boolean set) {
        for (int i = 0; i < possibleMoves.size(); i++) {
            this.buttons[possibleMoves.get(i).getLine()]
                    [possibleMoves.get(i).colTranslate(possibleMoves.get(i).getCol())].setGreen(set);
        }

    }

    @Override
    public void highlightYellow(List<Position> possibleTakes, boolean set) {
        for (int i = 0; i < possibleTakes.size(); i++) {
            this.buttons[possibleTakes.get(i).getLine()]
                    [possibleTakes.get(i).colTranslate(possibleTakes.get(i).getCol())].setYellow(set);
        }
    }


    private class ButtonHandler implements EventHandler<ActionEvent> {
        //reused from TP01, reworked for TP02
        @Override
        public void handle(ActionEvent event) {
            CellButton cell = (CellButton) event.getSource();

            int row = getRowIndex(cell);
            int col = getColumnIndex(cell);

            if (!Board.this.model.isSelected()) {
                Board.this.model.selectPiece(row, col);// select
                Board.this.model.triggerSelection(true);
                System.out.println("selected " + row + " " + col);
                Board.this.highlightGreen(
                        Board.this.model.getSelected().possibleMoves(), true
                );
                Board.this.highlightYellow(
                        Board.this.model.getSelected().possibleTakes(), true
                );
            } else {
                Board.this.highlightGreen(
                        Board.this.model.getSelected().possibleMoves(), false
                );
                Board.this.highlightYellow(
                        Board.this.model.getSelected().possibleTakes(), false
                );
                Board.this.model.movePiece(row, col); // move selected
                Board.this.model.triggerSelection(false);
                System.out.println("deselected or moved " + row + " " + col);
            }

            Board.this.updateBoard(); // update GUI

        }
    }
}