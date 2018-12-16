package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractShipTest {
  private Integer size1;
  private Integer size2;
  private Integer size3;
  private Integer size4;

  private Integer numberOfHitCells1;
  private Integer numberOfHitCells2;
  private Integer numberOfHitCells3;
  private Integer numberOfHitCells4;

  private Integer numberOfHitCellsdefault;

  private AbstractShip ship1;
  private AbstractShip ship2;
  private AbstractShip ship3;
  private AbstractShip ship4;
  private AbstractShip ship5;
  private AbstractShip ship6;
  private AbstractShip ship7;
  private AbstractShip shipSunk;
  private AbstractShip sameAsRefShip;
  private AbstractShip sameAsStateShip;
  private AbstractShip yetAnotherShip;
  private AbstractShip nullShip;
  private AbstractShip diffShip;

  @Before
  public void setUp() throws Exception {
    size1 = new Integer(4);
    size2 = new Integer(3);
    size3 = new Integer(2);
    size4 = new Integer(1);
    numberOfHitCells1 = new Integer(3);
    numberOfHitCells2 = new Integer(2);
    numberOfHitCells3 = new Integer(1);
    numberOfHitCells4 = new Integer(0);
    numberOfHitCellsdefault = new Integer(0);

    ship1 = new BattleShip(size1, numberOfHitCells1);
    ship2 = new Cruiser(size2, numberOfHitCells2);
    ship3 = new Submarine(size3, numberOfHitCells3);
    ship4 = new Destroyer(size4, numberOfHitCells4);
    ship5 = new BattleShip(size1, numberOfHitCellsdefault);
    ship6 = new BattleShip(size2, numberOfHitCells1);
    shipSunk = new Cruiser(size2, numberOfHitCells1);
    ship7 = new BattleShip(size1, numberOfHitCells2);
    sameAsRefShip = new BattleShip(size1, numberOfHitCells1);
    sameAsStateShip = new BattleShip(size1, numberOfHitCells1);
    yetAnotherShip = new BattleShip(size1, numberOfHitCells1);
    diffShip = new BattleShip(size2, numberOfHitCells2);
  }

  @Test
  public void getSize() {
    Assert.assertEquals(ship1.getSize(), new Integer(4));
    Assert.assertEquals(ship2.getSize(), new Integer(3));
  }

  @Test
  public void getNumberOfHitCells() {
    Assert.assertEquals(ship3.getNumberOfHitCells(), new Integer(1));
    Assert.assertEquals(ship4.getNumberOfHitCells(), new Integer(0));
  }

  @Test
  public void beingHit() {
    Assert.assertEquals(ship1.beingHit(), new BattleShip(4, 4));
    Assert.assertEquals(ship5.beingHit(), new BattleShip(4, 1));
  }

  @Test
  public void isSunk() {
    Assert.assertEquals(shipSunk.isSunk(), new Boolean(true));
    Assert.assertEquals(ship1.isSunk(), new Boolean(false));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(ship1.equals(ship1));
    Assert.assertTrue(ship1.equals(sameAsRefShip));
    Assert.assertTrue(ship1.equals(sameAsStateShip));
    Assert.assertNull(nullShip);
    Assert.assertFalse(ship1.equals(nullShip));
    Assert.assertFalse(ship1.equals(ship2));
    Assert.assertFalse(ship1.equals(ship6));
    Assert.assertFalse(ship1.equals(ship7));
    Assert.assertFalse(ship1.equals(diffShip));
    Assert.assertEquals(ship1.equals(sameAsStateShip) && sameAsStateShip.equals(yetAnotherShip)
        , yetAnotherShip.equals(ship1));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(ship1.equals(sameAsStateShip), ship1.hashCode() == sameAsStateShip
        .hashCode());
    Assert.assertEquals(ship1.equals(ship2), ship1.hashCode() == ship2.hashCode());
    Assert.assertEquals(ship1.equals(diffShip), ship1.hashCode() == diffShip.hashCode());
  }
}