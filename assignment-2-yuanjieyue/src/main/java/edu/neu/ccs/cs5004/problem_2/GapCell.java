package edu.neu.ccs.cs5004.problem_2;

public class GapCell extends AbstractWaterCell {

  /**
   * Check if a ship could be put on the cell.
   *
   * @return true if the ship could be put on the cell, false otherwise
   */
  @Override
  public Boolean isPlacable() {
    return false;
  }

  @Override
  protected AbstractCell cellCopyFactory() {
    return new GapCell(new BeingHit());
  }

  /**
   * Create a gap cell.
   *
   * @param ishit the state of being hit or not of the cell
   */
  public GapCell(Hitable ishit) {
    super(ishit);
  }

  @Override
  public String toString() {
    return "GapCell" + super.toString();
  }
}
