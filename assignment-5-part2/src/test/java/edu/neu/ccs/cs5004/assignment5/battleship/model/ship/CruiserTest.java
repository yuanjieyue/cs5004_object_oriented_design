package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CruiserTest {
  private Integer numberOfHitCells1;
  private Integer numberOfHitCells2;

  private Cruiser ship1;
  private Cruiser ship2;
  private BattleShip ship3;
  private Cruiser sameRefShip;
  private Cruiser sameAsStateShip;
  private Cruiser yetAnotherShip;
  private Cruiser nullShip;

  @Before
  public void setUp() throws Exception {
    numberOfHitCells1 = new Integer(3);
    numberOfHitCells2 = new Integer(2);
    ship1 = new Cruiser(numberOfHitCells1);
    ship2 = new Cruiser(numberOfHitCells2);
    ship3 = new BattleShip(numberOfHitCells1);
    sameRefShip = ship1;
    sameAsStateShip = new Cruiser(numberOfHitCells1);
    yetAnotherShip = new Cruiser(numberOfHitCells1);
  }

  @Test
  public void testToString() {
    String str = ("Cruiser{size=3, numberOfHitCells=3}");
    Assert.assertEquals(ship1.toString(), str);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(ship1.equals(ship1));
    Assert.assertTrue(ship1.equals(sameRefShip));
    Assert.assertTrue(ship1.equals(sameAsStateShip));
    Assert.assertEquals(ship1.equals(sameAsStateShip) && sameAsStateShip.equals
        (yetAnotherShip), yetAnotherShip.equals(ship1));
    Assert.assertFalse(ship1.equals(ship2));
    Assert.assertFalse(ship1.equals(ship3));
    Assert.assertFalse(ship1.equals(nullShip));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(ship1.equals(sameAsStateShip), ship1.hashCode() == sameAsStateShip
        .hashCode());
    Assert.assertEquals(ship1.equals(ship2), ship1.hashCode() == ship2.hashCode());
    Assert.assertEquals(ship1.equals(ship3), ship1.hashCode() == ship3.hashCode());
  }

  @Test
  public void afterAttack() {
    ship1.afterAttack();
    Assert.assertEquals(ship1.getNumOfHitCells(), new Integer(3));
    ship2.afterAttack();
    Assert.assertEquals(ship2.getNumOfHitCells(), new Integer(2));
  }
}