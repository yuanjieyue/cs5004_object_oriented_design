package edu.neu.ccs.cs5004.problem_2;

public class OpenSeaCell extends AbstractWaterCell {

  /**
   * Create a open sea cell.
   *
   * @param ishit the state of being hit or not of the cell
   */
  public OpenSeaCell(Hitable ishit) {
    super(ishit);
  }

  /**
   * Check if a ship could be put on the cell.
   *
   * @return true if the ship could be put on the cell, false otherwise
   */
  @Override
  public Boolean isPlacable() {
    return true;
  }


  @Override
  protected AbstractCell cellCopyFactory() {
    return new OpenSeaCell(new BeingHit());
  }

  @Override
  public String toString() {
    return "OpenSeaCell" + super.toString();
  }
}
