package edu.neu.ccs.cs5004.assignment5.battleship.model.strategy;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.EnemyCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.ColumnIndex;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.RowIndex;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

import java.io.BufferedReader;
import java.util.Random;

/**
 * Smart Strategy for Ai.
 * The basic idea is create a 10*10 2D-matrix to record the score of of each cell.
 * Generate the cell with highest score which is most likely to be a potential ship.
 */

public class SmartStrategy extends AStrategy {
  private static final int TRIAL = 3;
  
  public SmartStrategy(BufferedReader reader, Player player) {
    super(reader, player);
  }
  
  /**
   * Generate an attack posn.
   * @return a posn the player will attack
   */
  public Posn generateAttackPosn() {

    int row = RowIndex.values().length;
    int column = ColumnIndex.values().length;
    int[][] guessMatrix = new int[row][column];
    Map guessMap = getPlayer().getGuessMap();
    initializeGuessMatrix(guessMatrix, guessMap);

    Posn[] guessPosns = autoGeneratePosn();
    Posn res = guessPosns[0];
    for (int i = 0; i < guessPosns.length; i++) {
      int maxValue = getValueFromMatrix(guessMatrix, res);
      int curValue = getValueFromMatrix(guessMatrix, guessPosns[i]);
      if (maxValue < curValue) {
        res = guessPosns[i];
      }
    }
    return res;
  }

  private int getValueFromMatrix(int[][] matrix, Posn posn) {
    int coordX = posn.getX();
    int coordY = posn.getY();
    return matrix[coordX - 1][coordY - 1];
  }

  private Posn[] autoGeneratePosn() {
    Posn[] posns = new Posn[TRIAL];
    Random rand = new Random();
    for (int i = 0; i < posns.length; i++) {
      int coordX = rand.nextInt(RowIndex.values().length) + 1;
      int coordY = rand.nextInt(ColumnIndex.values().length) + 1;
      posns[i] = new Posn(coordX, coordY);
    }
    return posns;
  }

  private void initializeGuessMatrix(int[][] guessMatrix, Map guessMap) {
    for (int i = 0; i < guessMatrix.length; i++) {
      for (int j = 0; j < guessMatrix[0].length; j++) {
        Cell curCell = guessMap.getCell(new Posn(i + 1, j + 1));
        if (curCell instanceof EnemyCell) {
          if (((EnemyCell) curCell).isSunk()) {
            guessMatrix[i][j] = -1;
          } else {
            guessMatrix[i][j] = 1;
          }
        } else {
          guessMatrix[i][j] = 0;
        }
      }
    }
  }
}
