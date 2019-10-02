/**
 * Gonçalo Candeias Amaro 17440 - TestClass
 */

package pt.ipbeja.estig.chess;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipbeja.estig.chess.model.Model;
import pt.ipbeja.estig.chess.model.Position;
import pt.ipbeja.estig.chess.model.pieces.*;

class TestClass {

    private Model modelTest;
    private JFXPanel mockPanel;

    @BeforeEach
    void setUpBeforeClass() throws Exception {
        this.mockPanel = new JFXPanel();
    }

    @Test
    void rookMovementTest() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Rook(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.selectPiece(4, 5); //rook at a8
        Pieces testPiece = modelTest.getSelected();
        modelTest.movePiece(4, 6);

        Assertions.assertEquals(testPiece, modelTest.getPiece(4, 6));
        Assertions.assertEquals(modelTest.empty, modelTest.getPiece(4, 5));
        Assertions.assertNotEquals(testPiece, modelTest.getPiece(4, 5));

    }

    @Test
    void queenMovementTest() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Queen(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.selectPiece(4, 5); //rook at a8
        Pieces testPiece = modelTest.getSelected();
        modelTest.movePiece(4, 6);

        Assertions.assertEquals(testPiece, modelTest.getPiece(4, 6));
        Assertions.assertEquals(modelTest.empty, modelTest.getPiece(4, 5));
        Assertions.assertNotEquals(testPiece, modelTest.getPiece(4, 5));

    }

    @Test
    void kingMovementTest() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new King(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.selectPiece(4, 5); //rook at a8
        Pieces testPiece = modelTest.getSelected();
        modelTest.movePiece(4, 6);

        Assertions.assertEquals(testPiece, modelTest.getPiece(4, 6));
        Assertions.assertEquals(modelTest.empty, modelTest.getPiece(4, 5));
        Assertions.assertNotEquals(testPiece, modelTest.getPiece(4, 5));

    }

    @Test
    void bishopMovementTest() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Bishop(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.selectPiece(4, 5); //rook at a8
        Pieces testPiece = modelTest.getSelected();
        modelTest.movePiece(5, 6);

        Assertions.assertEquals(testPiece, modelTest.getPiece(5, 6));
        Assertions.assertEquals(modelTest.empty, modelTest.getPiece(4, 5));
        Assertions.assertNotEquals(testPiece, modelTest.getPiece(4, 5));

    }

    @Test
    void rookPositionList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Rook(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.selectPiece(4, 5); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleMoves().size(), 7 + 7);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves(), null);

    }

    @Test
    void queenPositionList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Queen(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.selectPiece(4, 5); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleMoves().size(), 7 + 7 + 6 + 5);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves(), null);

    }

    @Test
    void KingPositionList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new King(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.selectPiece(4, 5); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleMoves().size(), 8);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves(), null);

    }

    @Test
    void bishopPositionList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Bishop(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.selectPiece(4, 5); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleMoves().size(), 6 + 5);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves(), null);

    }

    @Test
    void rookKillList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Rook(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.setPiece(4, 7, new Pawn(modelTest, new Position(4, 7), Model.PieceColour.BLACK));
        modelTest.setPiece(2, 5, new Pawn(modelTest, new Position(2, 5), Model.PieceColour.BLACK));
        modelTest.setPiece(4, 1, new Pawn(modelTest, new Position(4, 1), Model.PieceColour.BLACK));

        modelTest.selectPiece(4, 5); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleTakes().size(), 3);
        Assertions.assertNotEquals(modelTest.getSelected().possibleTakes().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleTakes(), null);

    }

    @Test
    void queenKillList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Queen(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.setPiece(4, 7, new Pawn(modelTest, new Position(4, 7), Model.PieceColour.BLACK));
        modelTest.setPiece(2, 5, new Pawn(modelTest, new Position(2, 5), Model.PieceColour.BLACK));
        modelTest.setPiece(5, 6, new Pawn(modelTest, new Position(5, 6), Model.PieceColour.BLACK));

        modelTest.selectPiece(4, 5); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleTakes().size(), 3);
        Assertions.assertNotEquals(modelTest.getSelected().possibleTakes().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleTakes(), null);

    }

    @Test
    void kingKillList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new King(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.setPiece(4, 7, new Pawn(modelTest, new Position(4, 7), Model.PieceColour.BLACK));
        modelTest.setPiece(2, 5, new Pawn(modelTest, new Position(2, 5), Model.PieceColour.BLACK));
        modelTest.setPiece(4, 1, new Pawn(modelTest, new Position(4, 1), Model.PieceColour.BLACK));

        modelTest.selectPiece(4, 5); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleTakes().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleTakes(), null);

    }

    @Test
    void bishopKillList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Bishop(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.setPiece(4, 7, new Pawn(modelTest, new Position(4, 7), Model.PieceColour.BLACK));
        modelTest.setPiece(5, 6, new Pawn(modelTest, new Position(5, 6), Model.PieceColour.BLACK));
        modelTest.setPiece(4, 1, new Pawn(modelTest, new Position(4, 1), Model.PieceColour.BLACK));

        modelTest.selectPiece(4, 5); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleTakes().size(), 1);
        Assertions.assertNotEquals(modelTest.getSelected().possibleTakes().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleTakes(), null);

    }

    //---

    @Test
    void pawnMovementTest() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Pawn(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.selectPiece(4, 5); //rook at a8
        Pieces testPiece = modelTest.getSelected();
        modelTest.movePiece(3, 5);

        Assertions.assertEquals(testPiece, modelTest.getPiece(3, 5));
        Assertions.assertEquals(modelTest.empty, modelTest.getPiece(4, 5));

    }

    @Test
    void knightMovementTest() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(7, 6, new Knight(modelTest, new Position(7, 6), Model.PieceColour.WHITE));

        modelTest.selectPiece(7, 6); //rook at a8
        Pieces testPiece = modelTest.getSelected();
        modelTest.movePiece(5, 7);

        Assertions.assertEquals(testPiece, modelTest.getPiece(5, 7));
        Assertions.assertEquals(modelTest.empty, modelTest.getPiece(7, 6));

    }

    @Test
    void pawnMovementList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Pawn(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.selectPiece(4, 5); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleMoves().size(), 1);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves(), null);

    }

    @Test
    void knightMovementList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Knight(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.selectPiece(4, 5); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleMoves().size(), 8);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleMoves(), null);

    }

    @Test
    void pawnKillList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(4, 5, new Pawn(modelTest, new Position(4, 5), Model.PieceColour.WHITE));

        modelTest.setPiece(4, 6, new Pawn(modelTest, new Position(4, 7), Model.PieceColour.BLACK));
        modelTest.setPiece(3, 6, new Pawn(modelTest, new Position(3, 6), Model.PieceColour.BLACK));
        modelTest.setPiece(4, 1, new Pawn(modelTest, new Position(4, 1), Model.PieceColour.BLACK));

        modelTest.selectPiece(4, 5); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleTakes().size(), 1);
        Assertions.assertNotEquals(modelTest.getSelected().possibleTakes().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleTakes(), null);

    }

    @Test
    void knightKillList() {

        this.modelTest = new Model(new DummyView());

        modelTest.clearBoardForTest();
        modelTest.setPiece(7, 6, new Knight(modelTest, new Position(7, 6), Model.PieceColour.WHITE));

        modelTest.setPiece(4, 7, new Pawn(modelTest, new Position(4, 7), Model.PieceColour.BLACK));
        modelTest.setPiece(5, 7, new Pawn(modelTest, new Position(5, 7), Model.PieceColour.BLACK));
        modelTest.setPiece(4, 1, new Pawn(modelTest, new Position(4, 1), Model.PieceColour.BLACK));

        modelTest.selectPiece(7, 6); //rook at a8

        Assertions.assertEquals(modelTest.getSelected().possibleTakes().size(), 1);
        Assertions.assertNotEquals(modelTest.getSelected().possibleTakes().size(), 0);
        Assertions.assertNotEquals(modelTest.getSelected().possibleTakes(), null);

    }

}
